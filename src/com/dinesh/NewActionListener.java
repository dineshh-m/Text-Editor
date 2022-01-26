package com.dinesh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class NewActionListener implements ActionListener {
	
	TextEditor textEditor;
	
	public NewActionListener(TextEditor textEditor) {
		this.textEditor = textEditor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("New")) {
			textEditor.tabbedPane.addTab(Constants.NEWFILE, new CustomTextArea(new JTextArea()));
		}

	}

}
