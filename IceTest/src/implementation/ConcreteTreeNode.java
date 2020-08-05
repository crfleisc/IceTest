package implementation;

import java.util.ArrayList;
import java.util.List;

import framework.ObjectNotInTreeException;
import framework.Tree;

/*
 * A simple implementation of Tree to test my framework
 */
public class ConcreteTreeNode implements Tree {
	private Object data;
	private List<Object> children;
	private ConcreteTreeNode parent;
	
	public ConcreteTreeNode(Object data) {
		this.data = data;
		children = new ArrayList<Object>();
	}
	
	public Object getData() {
		return data;
	}
	
	public void addChild(ConcreteTreeNode child) {
		children.add(child);
		child.addParent(this);
	}
	
	public void addParent(ConcreteTreeNode parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return data.toString();
		
	}
	
	@Override
	public List<Object> getChildren(Object node) throws ObjectNotInTreeException {
		if(children == null)
			throw new ObjectNotInTreeException("No children found, node is a leaf.");
		return children;
	}

	@Override
	public Object getParent(Object node) throws ObjectNotInTreeException {
		if(parent == null)
			throw new ObjectNotInTreeException("No parent found, node is root of the tree.");
		return parent;
	}

	@Override
	public boolean isInTree(Object node) {
		// TODO Auto-generated method stub
		return false;
	}

}
