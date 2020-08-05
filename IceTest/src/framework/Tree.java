package framework;

import java.util.List;

public interface Tree {
	// Will return empty list if node has no children
	public List getChildren(Object node) throws ObjectNotInTreeException;
	
	// Will return null if node is the root of the tree
	public Object getParent(Object node) throws ObjectNotInTreeException;
	
	public boolean isInTree(Object node);
}
