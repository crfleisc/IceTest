package implementation;

import java.util.ArrayList;
import java.util.List;

import framework.ObjectNotInTreeException;
import framework.Sorter;
import framework.Tree;

/*
 * An implementation of Tree to test my framework
 */
public class ConcreteTreeNode implements Tree {
	private ConcreteTreeNode root;
	private Object data;
	private List<ConcreteTreeNode> children = new ArrayList<ConcreteTreeNode>();
	private ConcreteTreeNode parent = null;
	
	public ConcreteTreeNode(Object data) {
		this.data = data;
	}	
	
	public ConcreteTreeNode(Object data, ConcreteTreeNode root) {
		this.root = root;
		this.data = data;
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
	
	public boolean hasParent() {	//TODO try and remove
		return !(this.parent == null);
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
	@Override
	public List<ConcreteTreeNode> getChildren(Object node) throws ObjectNotInTreeException {
		if(!isInTree(node))
			throw new ObjectNotInTreeException(node + " not found in tree");
		return children;
	}

	@Override
	public Object getParent(Object node) throws ObjectNotInTreeException {
		if(!isInTree(node))
			throw new ObjectNotInTreeException("Node: " + node + " not found in tree");
		return parent;
	}

	@Override
	public boolean isInTree(Object node) {
		if(node.equals(root))
			return true;
		
		Sorter sorter = new SorterDescendantsDepthFirst();
//		System.out.println(sorter.sort(root).contains(node));		
		
		
		
		
		
		return true;
	}

	

}
