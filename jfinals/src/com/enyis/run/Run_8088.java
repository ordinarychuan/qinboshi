package com.enyis.run;

import com.jfinal.core.JFinal;

public class Run_8088 {

	public static void main(String[] args) {
		JFinal.start("WebRoot", 8088, "/");
	}
}
