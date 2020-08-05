package implementation;

import java.util.ArrayList;
import java.util.Collection;

import framework.ObjectNotInTreeException;
import framework.Sorter;

public class SorterDescendantsDepthFirst extends Sorter {
	ArrayList<ConcreteTreeNode> sorted = new ArrayList<ConcreteTreeNode>();
	ConcreteTreeNode startNode;
	
	@Override
	public Collection<?> sort(Object startNode) {
		this.startNode = (ConcreteTreeNode) startNode;
		sort((ConcreteTreeNode) startNode);
		return sorted;
	}
	
	private void sort(ConcreteTreeNode node) {
		if(!sorted.contains(node) && !node.equals(startNode))
			sorted.add(node);
		
		try {
			for(Object aNode : node.getChildren(node)) {
				sort((ConcreteTreeNode) aNode);
			}
		} catch (ObjectNotInTreeException e) {
			e.printStackTrace();
		}
			
	}

}
