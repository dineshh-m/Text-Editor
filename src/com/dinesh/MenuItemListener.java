package com.dinesh;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class MenuItemListener implements ActionListener{

	JFileChooser fileChooser;
	private File defaultDirectory;
	TextEditor textEditor;
	
	public MenuItemListener(TextEditor textEditor) {
		this.textEditor = textEditor;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		fileChooser = new JFileChooser();
		defaultDirectory = new File("C:\\");
		fileChooser.setCurrentDirectory(defaultDirectory);
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("Open")) {
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				Scanner fileIn = null;
				
				try {
					fileIn = new Scanner(file);
					if(file.isFile()) {
						while(fileIn.hasNextLine()) {
							String line = fileIn.nextLine() + "\n";
							textEditor.textArea.append(line);
						}
					}
				}catch(FileNotFoundException fe) {
					
				}finally {
					fileIn.close();
				}
			}
		}else if(actionCommand.equals("Save As")) {
			int response = fileChooser.showSaveDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file;
				PrintWriter fileWriter = null;
				
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				
				try {
					fileWriter = new PrintWriter(file);
					fileWriter.println(textEditor.textArea.getText());
				}catch(Exception ee) {
					
				}finally {
					fileWriter.close();
				}
			}
		}
	}

	

	
}
