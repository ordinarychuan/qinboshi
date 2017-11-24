package com.enyis.config;

import com.enyis.ctr.AddreController;
import com.enyis.ctr.IndexController;
import com.enyis.ctr.OrderController;
import com.enyis.ctr.ProductController;
import com.enyis.ctr.QrController;
import com.enyis.ctr.UserController;
import com.enyis.interce.GlobalInterceptor;
import com.enyis.model.User;
import com.enyis.model._MappingKit;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig{

	private static Prop prop=PropKit.use("jdbc.properties");
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);
		me.add("/qrcode", QrController.class);
		me.add("/order", OrderController.class);
		me.add("/adds", AddreController.class);
		me.add("/user", UserController.class);
		me.add("/product", ProductController.class);
	}

	@Override
	public void configEngine(Engine me) {
		me.addSharedFunction("/common/_layout.html");
	}

	@Override
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
				DruidPlugin druidPlugin = createDruidPlugin();
				me.add(druidPlugin);
				
				// 配置ActiveRecord插件
				ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
				// 所有映射在 MappingKit 中自动化搞定
				_MappingKit.mapping(arp);
				me.add(arp);
	}
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
	
	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new GlobalInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler());
	}

	
}
