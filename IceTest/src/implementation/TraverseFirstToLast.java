package implementation;

import framework.Sorter;
import framework.Traverser;

public class TraverseFirstToLast extends Traverser {

	public TraverseFirstToLast(Sorter sorter, Object obj) {
		super(sorter, obj);
	}

	@Override
	public Object next() {
		currentObjectNum++;
		return orderedObjects.get(currentObjectNum);
	}

}