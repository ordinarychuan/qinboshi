package com.enyis.kit;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jfinal.kit.StrKit;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

public class PhotoQrCode extends Render{

	private static MatrixToImageConfig DEFAULT_CONFIG = new MatrixToImageConfig();
	private String content;
	private int width;
	private int height;
	private ErrorCorrectionLevel errorCorrectionLevel;
 
	/**
	 * 构造方法，经测试不指定纠错参数时，默认使用的是 'L' 最低级别纠错参数
	 * 
	 * @param content
	 *            二维码携带内容
	 * @param width
	 *            二维码宽度
	 * @param height
	 *            二维码高度
	 */
	public PhotoQrCode(String content, int width, int height) {
		init(content, width, height, ErrorCorrectionLevel.H);
	}
 
	/**
	 * 黑白图标
	 * 
	 * @param content
	 * @param width
	 * @param height
	 * @param logoUrl
	 *            网络图标地址
	 */
	public PhotoQrCode(String content, int width, int height, String logoUrl) {
		init(content, width, height, ErrorCorrectionLevel.H);
		url = logoUrl;
	}
 
	/**
	 * 指定二维码颜色,白色背景
	 * 
	 * @param content
	 * @param width
	 * @param height
	 * @param logoUrl
	 *            网络图标地址
	 * @param onColor
	 *            二维码颜色
	 */
	public PhotoQrCode(String content, int width, int height, String logoUrl, int onColor) {
		init(content, width, height, ErrorCorrectionLevel.H);
		url = logoUrl;
		onColor = (((onColor >> 24) & 0xff) > 0) ? onColor : onColor | 0xff000000;
		DEFAULT_CONFIG = new MatrixToImageConfig(onColor, 0xffffff);
	}
 
	/**
	 * 指定前景 背景颜色
	 * 
	 * @param content
	 * @param width
	 * @param height
	 * @param logoUrl
	 * @param onColor
	 * @param offColor
	 */
	public PhotoQrCode(String content, int width, int height, String logoUrl, int onColor, int offColor) {
		init(content, width, height, ErrorCorrectionLevel.H);
		url = logoUrl;
		DEFAULT_CONFIG = new MatrixToImageConfig(onColor, offColor);
	}
 
	private String url;
 
	private void init(String content, int width, int height, ErrorCorrectionLevel errorCorrectionLevel) {
		if (StrKit.isBlank(content)) {
			throw new IllegalArgumentException("content 不能为空");
		}
		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("width 与 height 不能小于 0");
		}
		this.content = content;
		this.width = width;
		this.height = height;
		this.errorCorrectionLevel = errorCorrectionLevel;
	}
 
	@Override
	public void render() {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/png");
 
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 0); // 去掉白色边框，极度重要，否则二维码周围的白边会很宽
		if (errorCorrectionLevel != null) {
			hints.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
		}
 
		try {
			QRCodeWriter writer = new QRCodeWriter();
			BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
 
			// 经测试 200 X 200 大小的二维码使用 "png" 格式只有 412B，而 "jpg" 却达到 15KB
			// String path =
			// request.getSession().getServletContext().getRealPath("/static/QrCodeImg/logo.png");
			overlapImage(bitMatrix, "png", response.getOutputStream(), url);
		} catch (Exception e) {
			throw new RenderException(e);
		}
	}
 
	/**
	 * 将照片logo添加到二维码中间
	 * 
	 * @param matrix
	 * @param format
	 * @param stream
	 * @param logoPath
	 * @throws IOException
	 */
	public void overlapImage(BitMatrix matrix, String format, OutputStream stream, String logoPath) throws IOException {
		BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix, DEFAULT_CONFIG);
		if (logoPath != null) {
			BufferedImage logo = ImageIO.read(new URL(logoPath).openStream());// ImageIO.read(new
																				// File(logoPath));
			Graphics2D g = image.createGraphics();
			// 考虑到logo照片贴到二维码中，建议大小不要超过二维码的1/5;
			int width = image.getWidth() / 3;
			int height = image.getHeight() / 3;
			// logo起始位置，此目的是为logo居中显示
			int x = (image.getWidth() - width) / 2;
			int y = (image.getHeight() - height) / 2;
			// 绘制图
			g.drawImage(logo, x, y, width, height, null);
			g.dispose();// 清理内存中的图片，返还内存给系统
			// 输出二维码
		}
		ImageIO.write(image, format, stream);
	}

}
