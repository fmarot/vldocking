package com.vldocking.eventbus;

import java.util.ArrayList;
import java.util.List;

import com.vldocking.eventbus.events.DockingFrameworkEvent;


public class EventBus {

	private List<EventBusListener>	listeners	= new ArrayList<EventBusListener>();

	public static EventBus			INSTANCE	= new EventBus();

	private EventBus() {
	}

	public void publishEvent(DockingFrameworkEvent event) {
		for (EventBusListener listener : listeners) {
			listener.notifyDockingFrameworkEvent(event);
		}
	}

	public void subscribe(EventBusListener listener) {
		listeners.add(listener);
	}

	public void unsubscribe(EventBusListener listener) {
		listeners.remove(listener);
	}
}
