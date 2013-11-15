package vldocking.graphictest;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import vldocking.graphictest.basicdockables.MyGridOfButtons;
import vldocking.graphictest.basicdockables.MyJTable;
import vldocking.graphictest.basicdockables.MyTextEditor;
import vldocking.graphictest.basicdockables.MyTree;

import com.vldocking.eventbus.EventBus;
import com.vldocking.eventbus.events.DockingFrameworkEvent;
import com.vldocking.eventbus.events.LockAllWidgetsEvent;
import com.vldocking.swing.docking.DockingConstants;
import com.vldocking.swing.docking.DockingDesktop;

public class MyFirstFrame extends JFrame {

	private MyTextEditor	editorPanel	= new MyTextEditor();
	private MyTree			treePanel	= new MyTree();
	private MyGridOfButtons	buttonGrid	= new MyGridOfButtons();
	private MyJTable		tablePanel	= new MyJTable();

	DockingDesktop			desk		= new DockingDesktop();

	public MyFirstFrame() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		desk.addDockable(editorPanel);
		desk.split(editorPanel, treePanel, DockingConstants.SPLIT_LEFT);
		desk.split(editorPanel, buttonGrid, DockingConstants.SPLIT_RIGHT);
		desk.split(buttonGrid, tablePanel, DockingConstants.SPLIT_BOTTOM);

		getContentPane().add(desk);

		// init as locked
		DockingFrameworkEvent event = new LockAllWidgetsEvent();
		EventBus.INSTANCE.publishEvent(event);
	}

	public static void main(String[] args) {
		final MyFirstFrame frame = new MyFirstFrame();
		frame.setSize(800, 600);
		frame.validate();
		SwingUtilities.invokeLater(new Runnable() {

			// in the event dispatch thread
			@Override
			public void run() {
				frame.setVisible(true);
			}
		});
	}
}
