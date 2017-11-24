package com.enyis.ctr;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.enyis.kit.Contanst;
import com.enyis.kit.ResponseKit;
import com.enyis.model.Addre;
import com.enyis.model.User;
import com.enyis.service.AddreService;
import com.jfinal.core.Controller;

public class AddreController extends Controller{

	public void index() {
		User user=getSessionAttr(Contanst.curent_user);
		List<Addre> list=AddreService.getByuserId(user.getUserId());
		setAttr("add", list);
		render("/page/address.html");
	}
	public void get() {
		String addId=getPara();
		Addre add=Addre.dao.findById(addId);
		setAttr("add",JSON.toJSONString(add));
		render("/page/address-change.html");
	}
	public void edit() {
		Addre addre=getModel(Addre.class, "addre");
		boolean success=addre.update();
		if(success) {
		renderJson(ResponseKit.createSuccess("保存成功", "/adds"));
		}else {
			renderJson(ResponseKit.createError("保存失败"));	
		}
	}
	public void addArea() {
		Addre addre=getModel(Addre.class, "addre");
		User user=getSessionAttr(Contanst.curent_user);
		addre.setUserId(user.getUserId());
		boolean success=addre.save();
		if(success) {
		renderJson(ResponseKit.createSuccess("保存成功", "/adds"));
		}else {
			renderJson(ResponseKit.createError("保存失败"));	
		}
	}
}
