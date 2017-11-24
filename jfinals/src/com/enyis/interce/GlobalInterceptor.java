package com.enyis.interce;

import com.enyis.kit.Contanst;
import com.enyis.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class GlobalInterceptor implements Interceptor{

	@Override
	public void intercept(Invocation inv) {
		String url=inv.getActionKey();
		Controller controller=inv.getController();
		User user=(User) controller.getSession().getAttribute(Contanst.curent_user);
		if(!url.endsWith("login") && user==null) {
				controller.render("/page/login.html");
				return;
		}
		if(user!=null) {
			controller.setAttr("user", user);
			controller.setAttr("phone", user.getPhone());
		}
		System.out.println(inv.getActionKey());
		inv.invoke();
	}

}
