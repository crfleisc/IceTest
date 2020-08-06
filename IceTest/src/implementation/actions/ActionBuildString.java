package implementation.actions;

import framework.Action;

public class ActionBuildString implements Action {

	@Override
	public Object performAction(Object newObj, Object work) {
		if(work == null)
			return newObj.toString();
		else
			return (String) work + " " + newObj.toString();
	}

}
