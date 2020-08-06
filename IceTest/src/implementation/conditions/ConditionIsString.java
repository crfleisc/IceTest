package implementation.conditions;

import framework.Condition;
import implementation.ConcreteTreeNode;

public class ConditionIsString implements Condition {

	@Override
	public boolean checkCondition(Object obj) {
		if(obj instanceof ConcreteTreeNode) 
			return ((ConcreteTreeNode) obj).getData() instanceof String;
		return false;
	}

}
