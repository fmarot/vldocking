package vldocking.graphictest.basicdockables;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyJTable extends BasicDockable {

	JTable	table	= new JTable();

	public MyJTable() {
		setLayout(new BorderLayout());
		table.setModel(new DefaultTableModel(5, 5));
		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200, 200));
		add(jsp, BorderLayout.CENTER);
	}
}