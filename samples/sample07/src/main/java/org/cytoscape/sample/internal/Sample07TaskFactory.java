package org.cytoscape.sample.internal;

import org.cytoscape.task.AbstractNetworkTaskFactory;
import org.cytoscape.work.TaskIterator;

public class Sample07TaskFactory extends AbstractNetworkTaskFactory {

	public TaskIterator getTaskIterator() {
		return new TaskIterator(new MyTask(this.network));
	}
}