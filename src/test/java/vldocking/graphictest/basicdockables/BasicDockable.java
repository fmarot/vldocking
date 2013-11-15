package vldocking.graphictest.basicdockables;

import java.awt.Component;

import javax.swing.JPanel;

import lombok.Getter;

import com.vldocking.swing.docking.DockKey;
import com.vldocking.swing.docking.Dockable;

public class BasicDockable extends JPanel implements Dockable {

	@Getter
	private DockKey	dockKey	= new DockKey(this.getClass().getName());

	@Override
	public Component getComponent() {
		return this;
	}
}