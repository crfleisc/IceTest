package implementation;

import framework.Action;

public class ActionToString implements Action {

	@Override
	public Object performAction(Object newObj, Object work) {
		if(work == null)
			return newObj.toString();
		else
			return (String) work + " " + newObj.toString();
	}

}
