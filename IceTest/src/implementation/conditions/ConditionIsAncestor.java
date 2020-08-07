package implementation.conditions;

import framework.Condition;

public class ConditionIsAncestor implements Condition {

	// Dummy class, ancestory is verified by 
	// definition of SorterAncestors 
	@Override
	public boolean checkCondition(Object obj) {
		return true;
	}

}
