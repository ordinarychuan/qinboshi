package com.enyis.ctr;


import java.util.List;

import com.enyis.kit.Contanst;
import com.enyis.kit.PhotoQrCode;
import com.enyis.kit.ResponseKit;
import com.enyis.model.Products;
import com.enyis.model.Qin_Order;
import com.enyis.model.User;
import com.enyis.service.UserService;
import com.jfinal.core.Controller;

public class IndexController extends Controller{

	public void index() {
		User user=getSessionAttr(Contanst.curent_user);
		List<Products> list=Products.dao.find("select * from products");
		setAttr("list", list);
		List<Qin_Order> order=Qin_Order.dao.find("select * from qin_order_view where userId=?",user.getUserId());
		setAttr("order", order);
		render("/page/index.html");
	}
	public void login() {
		System.out.println("login  loading.....");
		String phone=getPara("phone");
		String token=getPara("token");
		User user=UserService.UserLogin(phone, token);
		if(user!=null) {
			getSession().setAttribute(Contanst.curent_user, user);
			renderJson(ResponseKit.createSuccess("登陆成功", "/"));
			return;
		}
		renderJson(ResponseKit.createError("登陆失败"));
	}
	
	
}
