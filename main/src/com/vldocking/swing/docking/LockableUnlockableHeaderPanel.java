package com.vldocking.swing.docking;

import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import com.vldocking.eventbus.EventBus;
import com.vldocking.eventbus.EventBusListener;
import com.vldocking.eventbus.events.DockingFrameworkEvent;
import com.vldocking.eventbus.events.LockAllWidgetsEvent;
import com.vldocking.eventbus.events.UnlockAllWidgetsEvent;

public abstract class LockableUnlockableHeaderPanel extends JPanel implements DockableContainer, EventBusListener {

	protected EventBus	eventbus	= EventBus.INSTANCE;

	public LockableUnlockableHeaderPanel(LayoutManager layout) {
		super(layout);
		eventbus.subscribe(this);
	}

	protected abstract Component getHeader();

	public void lockContainer(boolean lock) {
		getHeader().setVisible(!lock);
	}

	@Override
	public void notifyDockingFrameworkEvent(DockingFrameworkEvent event) {
		if (event instanceof UnlockAllWidgetsEvent) {
			lockContainer(false);
		} else if (event instanceof LockAllWidgetsEvent) {
			lockContainer(true);
		}
	}

	/** when removed from main panel, unregister from eventbus, otherwise we leak memory */
	@Override
	public void uninstallDocking(DockingDesktop desktop) {
		eventbus.unsubscribe(this);
	}

}
