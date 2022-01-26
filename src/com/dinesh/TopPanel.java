package com.dinesh;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TopPanel extends JPanel implements ActionListener, ChangeListener{

	JLabel fontLabel, fontTypeLabel;
	JSpinner fontSize;
	TextEditor textEditor, var;
	JComboBox<String> fontType;
	String fonts[];
	int sizeOfFont;
	JTabbedPane jtp;

	
	public TopPanel(TextEditor textEditorr) {
		this.textEditor = textEditorr;
		this.var = textEditorr;
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT / 9));
		setBackground(Color.gray);
		
		
		fontLabel = new JLabel("Font Size: ");
		fontSize = new JSpinner();
		fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontType = new JComboBox<>(fonts);
		fontType.addActionListener(this);
		fontTypeLabel = new JLabel("Font: ");
		
	/**	fontSize.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Font font = textEditor.textArea.getFont();
				textEditor.textArea.setFont(new Font(font.getFamily(), Font.PLAIN, (int)fontSize.getValue()));
				
				JScrollPane ct = (JScrollPane) textEditor.tabbedPane.getSelectedComponent();
				
			}

			
			
		}); **/
		fontSize.addChangeListener(this);
		fontSize.setValue(20);
		add(fontLabel);
		add(fontSize);
		add(fontTypeLabel);
		add(fontType);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String fontName =(String) fontType.getSelectedItem();
		int size =  textEditor.textArea.getFont().getSize();
		textEditor.textArea.setFont(new Font(fontName, Font.PLAIN, size));
		
		//modified code
		 CustomTextArea ct =(CustomTextArea) textEditor.tabbedPane.getSelectedComponent();
		 JTextArea ta = ct.getTextArea();
		 ta.setFont(new Font(fontName, Font.PLAIN, size));
		
		
	}
	
	//Change Listener
	@Override
	public void stateChanged(ChangeEvent e) {
		Font font = textEditor.textArea.getFont();
		textEditor.textArea.setFont(new Font(font.getFamily(), Font.PLAIN, (int)fontSize.getValue()));
		
		try {
			CustomTextArea ct = (CustomTextArea) textEditor.tabbedPane.getSelectedComponent();
			CustomTextArea [] textAreas = (CustomTextArea[]) textEditor.tabbedPane.getComponents();
			JTextArea ta = ct.getTextArea();
			ta.setFont(new Font( (String) fontType.getSelectedItem(), Font.PLAIN, (int) fontSize.getValue()));
			
			for(CustomTextArea cta : textAreas) {
				cta.setFont(new Font( (String) fontType.getSelectedItem(), Font.PLAIN, (int) fontSize.getValue()));
			}
		}catch(Exception cce) {
			System.out.println("Class Cast Exception");
		//	cce.printStackTrace();
		}
		
		
		
	}
	
	public void setTabbedPane(JTabbedPane jtp) {
		this.jtp = jtp;
	}
	
}
