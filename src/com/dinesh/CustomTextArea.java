package com.dinesh;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

public class CustomTextArea extends JScrollPane {

	JTextArea textArea;
	
	public CustomTextArea(JTextArea textArea) {
		super(textArea);
		this.textArea = textArea;
		
		textArea.setText(Constants.ABOUT);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	}
	
	public JTextArea getTextArea() {
		return this.textArea;
	}
	
}
