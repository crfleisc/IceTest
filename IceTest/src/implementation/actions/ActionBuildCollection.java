package implementation.actions;

import java.util.ArrayList;

import framework.Action;
import implementation.ConcreteTreeNode;

public class ActionBuildCollection implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public Object performAction(Object newObj, Object work) {
		if(work == null) {
			work = new ArrayList<ConcreteTreeNode>();
			((ArrayList<ConcreteTreeNode>) work).add((ConcreteTreeNode) newObj);
			return work;
		}
		else
			((ArrayList<ConcreteTreeNode>) work).add((ConcreteTreeNode) newObj);
		return work;
	}

}
