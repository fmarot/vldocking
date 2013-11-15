package vldocking.graphictest.basicdockables;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.vldocking.eventbus.EventBus;
import com.vldocking.eventbus.events.DockingFrameworkEvent;
import com.vldocking.eventbus.events.LockAllWidgetsEvent;
import com.vldocking.eventbus.events.UnlockAllWidgetsEvent;

public class MyGridOfButtons extends BasicDockable {

	public MyGridOfButtons() {
		setLayout(new FlowLayout(FlowLayout.TRAILING, 3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton comp = new JButton("Push me to unlock" + (i * 3 + j));
				comp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						boolean lock = false;
						DockingFrameworkEvent event = lock ? new LockAllWidgetsEvent() : new UnlockAllWidgetsEvent();
						EventBus.INSTANCE.publishEvent(event);
					}
				});
				add(comp);
			}
		}
		setPreferredSize(new Dimension(200, 300));
	}

}