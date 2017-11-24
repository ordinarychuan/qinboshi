package com.enyis.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("addre", "addId", Addre.class);
		arp.addMapping("products", "proId", Products.class);
		arp.addMapping("standard", "stId", Standard.class);
		arp.addMapping("user", "userId", User.class);
		arp.addMapping("qin_order", "oId",Qin_Order.class);
	}
}

