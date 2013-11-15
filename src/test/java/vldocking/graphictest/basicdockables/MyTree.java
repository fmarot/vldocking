package vldocking.graphictest.basicdockables;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTree;

public class MyTree extends BasicDockable {

	JTree	tree	= new JTree();

	public MyTree() {
		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(tree);
		jsp.setPreferredSize(new Dimension(200, 200));
		add(jsp, BorderLayout.CENTER);
	}
}