package com.enyis.ctr;

import java.util.List;

import com.enyis.kit.Contanst;
import com.enyis.kit.ResponseKit;
import com.enyis.model.Products;
import com.enyis.model.Qin_Order;
import com.enyis.model.User;
import com.jfinal.core.Controller;

public class OrderController extends Controller{

	public void index() {
		User user=getSessionAttr(Contanst.curent_user);
		List<Qin_Order> order=Qin_Order.dao.find("select * from qin_order_view where userId=?",user.getUserId());
		setAttr("order", order);
	}
	public void addOrder() {
		Qin_Order order=getModel(Qin_Order.class,"order");
		User user=getSessionAttr(Contanst.curent_user);
		order.setUserId(user.getUserId());
		boolean success=order.save();
		if(success) {
			Products products=Products.dao.findById(order.getProId());
			String se=products.getSell();
			if(se!=null) {
					int i=Integer.valueOf(se);
				products.setSell(String.valueOf(i+1));
				products.update();
			}
			renderJson(ResponseKit.createSuccess("订购成功", "ss"));
			}else {
				renderJson(ResponseKit.createError("订购失败"));	
			}
	}
}
