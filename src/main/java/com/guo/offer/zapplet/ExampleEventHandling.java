package com.guo.offer.zapplet;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.applet.Applet;
import java.awt.Graphics;

public class ExampleEventHandling extends Applet implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StringBuffer strBuffer;

	@Override
    public void init() {
		addMouseListener(this);
		strBuffer = new StringBuffer();
		addItem("initializing the apple ");
	}

	@Override
    public void start() {
		addItem("starting the applet ");
	}

	@Override
    public void stop() {
		addItem("stopping the applet ");
	}

	@Override
    public void destroy() {
		addItem("unloading the applet");
	}

	void addItem(String word) {
		System.out.println(word);
		strBuffer.append(word);
		repaint();
	}

	@Override
    public void paint(Graphics g) {
		// Draw a Rectangle around the applet's display area.
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

		// display the string inside the rectangle.
		g.drawString(strBuffer.toString(), 10, 20);
	}

	@Override
    public void mouseEntered(MouseEvent event) {
	}

	@Override
    public void mouseExited(MouseEvent event) {
	}

	@Override
    public void mousePressed(MouseEvent event) {
	}

	@Override
    public void mouseReleased(MouseEvent event) {
	}

	@Override
    public void mouseClicked(MouseEvent event) {
		addItem("mouse clicked! ");
	}
}