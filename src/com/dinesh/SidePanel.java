package com.dinesh;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SidePanel extends JPanel{

	public SidePanel() {
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(Constants.WIDTH/10, Constants.HEIGHT));
		this.setBackground(Color.DARK_GRAY);
	}
}
