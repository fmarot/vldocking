package com.vldocking.eventbus;

import com.vldocking.eventbus.events.DockingFrameworkEvent;

public interface EventBusListener {

	void notifyDockingFrameworkEvent(DockingFrameworkEvent event);

}
