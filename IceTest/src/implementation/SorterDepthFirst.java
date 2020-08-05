package implementation;

import java.util.ArrayList;
import java.util.Collection;

import framework.ObjectNotInTreeException;
import framework.Sorter;

public class SorterDepthFirst extends Sorter {
	ArrayList<ConcreteTreeNode> sorted = new ArrayList<ConcreteTreeNode>();
	
	@Override
	public Collection<?> sort(Object startNode) {
		search((ConcreteTreeNode) startNode);
		return sorted;
	}
	
	private void search(ConcreteTreeNode node) {
		if(!sorted.contains(node))
			sorted.add(node);
		
		try {
			for(Object aNode : node.getChildren(node)) {
				search((ConcreteTreeNode) aNode);
			}
		} catch (ObjectNotInTreeException e) {
			e.printStackTrace();
		}
			
	}

}
