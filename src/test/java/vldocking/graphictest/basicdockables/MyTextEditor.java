package vldocking.graphictest.basicdockables;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyTextEditor extends BasicDockable {

	JTextArea	textArea	= new JTextArea("A Text Area");

	public MyTextEditor() {
		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setPreferredSize(new Dimension(200, 400));
		add(jsp, BorderLayout.CENTER);
	}

}