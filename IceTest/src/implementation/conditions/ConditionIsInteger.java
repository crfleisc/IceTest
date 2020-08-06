package implementation.conditions;

import framework.Condition;
import implementation.ConcreteTreeNode;

public class ConditionIsInteger implements Condition {

	@Override
	public boolean checkCondition(Object obj) {
		if(obj instanceof ConcreteTreeNode) 
			return ((ConcreteTreeNode) obj).getData() instanceof Integer;
		return false;
	}

}
