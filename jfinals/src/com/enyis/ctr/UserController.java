package com.enyis.ctr;

import com.jfinal.core.Controller;

public class UserController extends Controller{

	public void index() {
		render("/page/asset.html");
	}
}
