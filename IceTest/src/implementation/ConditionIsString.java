package implementation;

import framework.Condition;

public class ConditionIsString implements Condition {

	@Override
	public boolean checkCondition(Object obj) {
		if(obj instanceof ConcreteTreeNode) 
			return ((ConcreteTreeNode) obj).getData() instanceof String;
		return false;
	}

}
