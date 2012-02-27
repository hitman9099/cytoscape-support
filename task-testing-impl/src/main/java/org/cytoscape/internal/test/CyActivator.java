



package org.cytoscape.internal.test;

import org.cytoscape.work.TaskManager;

import org.cytoscape.internal.test.MultipleTaskFactory;
import org.cytoscape.internal.test.InfiniteTaskFactory;
import org.cytoscape.internal.test.MultiTunableAction;
import org.cytoscape.internal.test.tunables.TunablesTestTaskFactory2;
import org.cytoscape.internal.test.tunables.TunablesTestTaskFactory3;
import org.cytoscape.internal.test.WaitAction;
import org.cytoscape.internal.test.tunables.TunablesTestTaskFactory;
import org.cytoscape.internal.test.tunables.ScootersTunableTaskFactory;

import org.cytoscape.application.swing.CyAction;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.task.NetworkTaskFactory;
import org.cytoscape.model.subnetwork.CyRootNetworkManager;


import org.osgi.framework.BundleContext;

import org.cytoscape.service.util.AbstractCyActivator;

import java.util.Properties;



public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		TaskManager taskManagerServiceRef = getService(bc,TaskManager.class);
		CyRootNetworkManager rootNetworkManagerServiceRef = getService(bc,CyRootNetworkManager.class);
		
		WaitAction waitAction = new WaitAction(taskManagerServiceRef);
		MultiTunableAction multiTunableAction = new MultiTunableAction(taskManagerServiceRef);
		TunablesTestTaskFactory tunablesTestTaskFactory = new TunablesTestTaskFactory();
		TunablesTestTaskFactory2 tunablesTestTaskFactory2 = new TunablesTestTaskFactory2();
		TunablesTestTaskFactory3 tunablesTestTaskFactory3 = new TunablesTestTaskFactory3();
		InfiniteTaskFactory infiniteTaskFactory = new InfiniteTaskFactory();
		MultipleTaskFactory multipleTaskFactory = new MultipleTaskFactory();
		SharedTableTaskFactory sharedTableTaskFactory = new SharedTableTaskFactory(rootNetworkManagerServiceRef);
		ScootersTunableTaskFactory scootersTunableTaskFactory =  new ScootersTunableTaskFactory();
		
		registerService(bc,waitAction,CyAction.class, new Properties());
		registerService(bc,multiTunableAction,CyAction.class, new Properties());

		Properties tunablesTestTaskFactoryProps = new Properties();
		tunablesTestTaskFactoryProps.setProperty("preferredMenu","Help");
		tunablesTestTaskFactoryProps.setProperty("title","Tunable Task Test...");
		registerService(bc,tunablesTestTaskFactory,TaskFactory.class, tunablesTestTaskFactoryProps);

		Properties tunablesTestTaskFactory2Props = new Properties();
		tunablesTestTaskFactory2Props.setProperty("cytoPanelComponentTitle","Tunable Factory Test");
		tunablesTestTaskFactory2Props.setProperty("preferredMenu","Help");
		tunablesTestTaskFactory2Props.setProperty("title","Tunable Factory Test...");
		registerService(bc,tunablesTestTaskFactory2,TaskFactory.class, tunablesTestTaskFactory2Props);

		Properties tunablesTestTaskFactory3Props = new Properties();
		tunablesTestTaskFactory3Props.setProperty("cytoPanelComponentTitle","Complex Tunable Test");
		tunablesTestTaskFactory3Props.setProperty("preferredMenu","Help");
		tunablesTestTaskFactory3Props.setProperty("title","Complex Tunable Test...");
		registerService(bc,tunablesTestTaskFactory3,TaskFactory.class, tunablesTestTaskFactory3Props);

		Properties infiniteTaskFactoryProps = new Properties();
		infiniteTaskFactoryProps.setProperty("preferredMenu","Help");
		infiniteTaskFactoryProps.setProperty("title","Infinite Test...");
		registerService(bc,infiniteTaskFactory,TaskFactory.class, infiniteTaskFactoryProps);

		Properties multipleTaskFactoryProps = new Properties();
		multipleTaskFactoryProps.setProperty("preferredMenu","Help");
		multipleTaskFactoryProps.setProperty("title","Multiple Task Test...");
		registerService(bc,multipleTaskFactory,TaskFactory.class, multipleTaskFactoryProps);

		Properties sharedTableTaskFactoryProps = new Properties();
		sharedTableTaskFactoryProps.setProperty("preferredMenu","Help");
		sharedTableTaskFactoryProps.setProperty("title","Shared Table Test...");
		registerService(bc,sharedTableTaskFactory,NetworkTaskFactory.class, sharedTableTaskFactoryProps);

		Properties scootersTunableTaskFactoryProps = new Properties();
		scootersTunableTaskFactoryProps.setProperty("preferredMenu","Help");
		scootersTunableTaskFactoryProps.setProperty("title","Scooter's Tunable Test...");
		registerService(bc,scootersTunableTaskFactory,TaskFactory.class, scootersTunableTaskFactoryProps);
	}
}

