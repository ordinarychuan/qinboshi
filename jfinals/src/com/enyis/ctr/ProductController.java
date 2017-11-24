package com.enyis.ctr;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.enyis.kit.Contanst;
import com.enyis.model.Addre;
import com.enyis.model.Products;
import com.enyis.model.User;
import com.enyis.service.AddreService;
import com.jfinal.core.Controller;

public class ProductController extends Controller{

	public void index() {
		String proid=getPara();
		
			Products pro=Products.dao.findById(proid);
			User user=getSessionAttr(Contanst.curent_user);
			List<Addre> list=AddreService.getByuserId(user.getUserId());
			setAttr("add", JSON.toJSONString(list));
			setAttr("product", pro);
			render("/page/details.html");
	}
}
