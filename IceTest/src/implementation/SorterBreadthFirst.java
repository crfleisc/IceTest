//package implementation;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.LinkedList;
//
//import framework.ObjectNotInTreeException;
//import framework.Sorter;
//
//public class SorterBreadthFirst extends Sorter {
//	ArrayList<ConcreteTreeNode> sorted = new ArrayList<ConcreteTreeNode>();
//	LinkedList<ConcreteTreeNode> working = new LinkedList<ConcreteTreeNode>();
//	
//	@Override
//	public Collection<?> sort(Object startNode) {
//		search((ConcreteTreeNode) startNode);
//		return sorted;
//	}
//	
//	private void search(ConcreteTreeNode node) {
//		if(!sorted.contains(node))
//			sorted.add(node);
//		
//		try {
//			for(Object aNode : node.getChildren(node)) {
//				working.add((ConcreteTreeNode) aNode);
//			}
//		} catch (ObjectNotInTreeException e) {
//			e.printStackTrace();
//		}
//			
//	}
//	
//	private void search(ConcreteTreeNode node, )
//
//}
