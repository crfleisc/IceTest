package framework;

import java.util.ArrayList;

public abstract class Traverser {
	protected ArrayList<Object> orderedObjects = new ArrayList<Object>();
	protected int currentObjectNum = -1;
	
	@SuppressWarnings("unchecked")
	public Traverser(Sorter sorter, Object obj) {
		orderedObjects = (ArrayList<Object>) sorter.sort(obj);
	}

	public boolean hasNext() {
		return currentObjectNum < orderedObjects.size() - 1;
	}
	
	public abstract Object next();
}
