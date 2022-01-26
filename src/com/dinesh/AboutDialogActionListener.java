package com.dinesh;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutDialogActionListener  implements ActionListener {

	JDialog aboutDialog;
	TextEditor textEditor;
	JLabel aboutString;
	
	public AboutDialogActionListener(TextEditor textEditor) {
		this.textEditor = textEditor;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		aboutDialog = new JDialog(textEditor, "About", true);
		aboutDialog.setLayout(new FlowLayout());
		aboutDialog.setSize(new Dimension(400, 400));
		aboutDialog.setLocationRelativeTo(null);
		aboutString = new JLabel(Constants.ABOUT);
		aboutDialog.add(aboutString);
		aboutDialog.show();

	}

}
