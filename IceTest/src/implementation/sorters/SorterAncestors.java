package implementation.sorters;

import java.util.ArrayList;
import java.util.Collection;

import framework.ObjectNotInTreeException;
import framework.Sorter;
import implementation.ConcreteTreeNode;

public class SorterAncestors extends Sorter {
	ArrayList<ConcreteTreeNode> sorted = new ArrayList<ConcreteTreeNode>();
	
	@Override
	public Collection<?> sort(Object startNode) {
		sort((ConcreteTreeNode) startNode);
		return sorted;
	}
	
	// Does not include given node in search
	private void sort(ConcreteTreeNode node) {
		ConcreteTreeNode parent;

		try {
			parent = (ConcreteTreeNode) node.getParent(node);
			if(parent != null) {
				while(parent.getParent(parent) != null) {
					sorted.add(parent);
					parent = (ConcreteTreeNode) parent.getParent(parent);
				}
				sorted.add(parent);
			}
		} catch (ObjectNotInTreeException e) {
			e.printStackTrace();
		}
	}
}
