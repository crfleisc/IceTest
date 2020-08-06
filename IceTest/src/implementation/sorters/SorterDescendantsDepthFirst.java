package implementation.sorters;

import java.util.ArrayList;
import java.util.Collection;

import framework.ObjectNotInTreeException;
import framework.Sorter;
import implementation.ConcreteTreeNode;

public class SorterDescendantsDepthFirst extends Sorter {
	ArrayList<ConcreteTreeNode> sorted = new ArrayList<ConcreteTreeNode>();
	ConcreteTreeNode startNode;
	
	@Override
	public Collection<?> sort(Object startNode) {
		this.startNode = (ConcreteTreeNode) startNode;
		sort((ConcreteTreeNode) startNode);
		return sorted;
	}
	
	// Does not include given node in search
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
