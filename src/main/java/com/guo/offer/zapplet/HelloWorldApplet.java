package com.guo.offer.zapplet;

import java.applet.*;
import java.awt.*;

public class HelloWorldApplet extends Applet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void paint(Graphics g) {
		g.drawString("Hello World", 25, 50);
	}
}