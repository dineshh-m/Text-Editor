package com.dinesh;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class ViewActionListener implements ActionListener {

	JColorChooser colorChooser;
	TextEditor textEditor;
	
	public ViewActionListener(TextEditor textEditor) {
		this.textEditor = textEditor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		colorChooser = new JColorChooser();
		
		
		if(actionCommand.equals("Color")) {
			Color color = JColorChooser.showDialog(null, "Choose a Color", Color.black);
			textEditor.textArea.setForeground(color);
			
		}
			

	}

}
