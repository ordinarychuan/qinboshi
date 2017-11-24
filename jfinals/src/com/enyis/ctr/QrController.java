package com.enyis.ctr;

import com.enyis.kit.Contanst;
import com.enyis.kit.PhotoQrCode;
import com.enyis.model.Share;
import com.enyis.model.User;
import com.jfinal.core.Controller;

public class QrController extends Controller{

	public void index() {
		String sql="select * from user where userId in(select byuserId from share where userId=?)";
		User user=(User)getSessionAttr(Contanst.curent_user);
		setAttr("shar", User.dao.find(sql, user.getUserId()));
		render("/page/share.html");
	}
	public void qrcode() {
		render(new PhotoQrCode("http://www.baidu.com", 100, 100));
	}
}
