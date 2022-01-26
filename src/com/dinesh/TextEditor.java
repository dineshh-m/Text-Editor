package com.dinesh;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextEditor extends JFrame{

	JTextArea textArea;
	TopPanel topPanel;
	SidePanel sidePanel;
	JMenuBar menuBar;
	JMenu file, edit, view, help;
	JMenuItem newOne,open, save, saveAs, exit, cut, copy, paste, color, about;
	JScrollPane scrollPane;
	MenuItemListener menuItemListener;
	ViewActionListener viewActionListener;
	AboutDialogActionListener aboutDialog;
	JTabbedPane tabbedPane;
	NewActionListener newActionListener;
	
	public TextEditor() {
		setLayout(new BorderLayout());
		setTitle("D Text Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		this.setLocationRelativeTo(null);
		
		menuItemListener = new MenuItemListener(this);
		
		//TextArea 
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Sample", scrollPane);
		
		//Top Panel
		topPanel = new TopPanel(this);
		topPanel.setTabbedPane(tabbedPane);
		
		//side panel
		sidePanel = new SidePanel();
		
		//Menu bar
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//1.file menu
		file = new JMenu("File");
		newOne = new JMenuItem("New");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As");
		exit = new JMenuItem("Exit");
		file.add(newOne);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(exit);
		open.addActionListener(menuItemListener);
		saveAs.addActionListener(menuItemListener);
		newActionListener = new NewActionListener(this);
		newOne.addActionListener(newActionListener);
	
		//2.edit menu
		edit = new JMenu("Edit");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		
		//3.view menu
		view = new JMenu("View");
		color = new JMenuItem("Color");
		viewActionListener = new ViewActionListener(this);
		color.addActionListener(viewActionListener);
		view.add(color);
		
		//4.help menu
		help = new JMenu("Help");
		about = new JMenuItem("About");
		aboutDialog = new AboutDialogActionListener(this);
		about.addActionListener(aboutDialog);
		help.add(about);
		
		//adding menus to MenuBar
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(view);
		menuBar.add(help);
		
		//adding components to frame
		this.add(tabbedPane, BorderLayout.CENTER);
		this.add(topPanel, BorderLayout.NORTH);
		this.add(sidePanel, BorderLayout.WEST);
		
		this.setVisible(true);
	}
}
