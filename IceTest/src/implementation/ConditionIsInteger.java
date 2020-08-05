package implementation;

import framework.Condition;

public class ConditionIsInteger implements Condition {

	@Override
	public boolean checkCondition(Object obj) {
		if(obj instanceof ConcreteTreeNode) 
			return ((ConcreteTreeNode) obj).getData() instanceof Integer;
		return false;
	}

}
