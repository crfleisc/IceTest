package assignmentTest;
/*
 * isInTree only seems to make sense if the Tree has a reference to 
 * the root. I could find the root in that method, but then the node
 * in question would always be in that tree
 */

import java.util.ArrayList;

import framework.Action;
import framework.Condition;
import framework.Sorter;
import framework.Traverser;
import framework.TreeWorker;
import implementation.ActionBuildCollection;
import implementation.ActionBuildString;
import implementation.ConcreteTreeNode;
import implementation.ConditionIsInteger;
import implementation.ConditionIsString;
import implementation.SorterAncestors;
import implementation.SorterDescendantsDepthFirst;
import implementation.TraverseFirstToLast;

/*
 * 					   0 			<- root
 * 				1	   2	   3
 * 			   4 5	   7	   
 * 			  6	      8 9  	
 * 								    10 <- not connected to tree
 */

public class MainTest {

	public static void main(String[] args) {
		int start = 0;
		ConcreteTreeNode startNode = createTestData(start);
		
		testPrintStringDescendant(startNode);
		testPrintIntegerDescendant(startNode);
		testCollectionStringDescendant(startNode); // Assignment B
		testCollectionIntegerDescendant(startNode);
		
		testPrintStringAncestor(startNode);
		testPrintIntegerAncestor(startNode);
		testCollectionStringAncestor(startNode);
		testCollectionIntegerAncestor(startNode);
	}

	private static void testCollectionIntegerAncestor(ConcreteTreeNode startNode) {
		Action action = new ActionBuildCollection();
		Condition condition = new ConditionIsInteger();
		Sorter sorter = new SorterAncestors();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testCollectionIntegerAncestor " + worker.doWork());
	}

	private static void testCollectionStringAncestor(ConcreteTreeNode startNode) {
		Action action = new ActionBuildCollection();
		Condition condition = new ConditionIsString();
		Sorter sorter = new SorterAncestors();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testCollectionStringAncestor " + worker.doWork());
	}

	private static void testPrintIntegerAncestor(ConcreteTreeNode startNode) {
		Action action = new ActionBuildString();
		Condition condition = new ConditionIsInteger();
		Sorter sorter = new SorterAncestors();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testPrintIntegerAncestor " + worker.doWork());
	}

	private static void testPrintStringAncestor(ConcreteTreeNode startNode) {
		Action action = new ActionBuildString();
		Condition condition = new ConditionIsString();
		Sorter sorter = new SorterAncestors();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testPrintStringAncestor " + worker.doWork());
	}

	private static void testCollectionIntegerDescendant(ConcreteTreeNode startNode) {
		Action action = new ActionBuildCollection();
		Condition condition = new ConditionIsInteger();
		Sorter sorter = new SorterDescendantsDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testCollectionIntegerDescendant " + worker.doWork());
	}

	private static void testCollectionStringDescendant(ConcreteTreeNode startNode) {
		Action action = new ActionBuildCollection();
		Condition condition = new ConditionIsString();
		Sorter sorter = new SorterDescendantsDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testCollectionStringDescendant " + worker.doWork());
	}

	private static void testPrintIntegerDescendant(ConcreteTreeNode startNode) {
		Action action = new ActionBuildString();
		Condition condition = new ConditionIsInteger();
		Sorter sorter = new SorterDescendantsDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testPrintIntegerDescendant " + worker.doWork());
	}
	
	private static void testPrintStringDescendant(ConcreteTreeNode startNode) {
		Action action = new ActionBuildString();
		Condition condition = new ConditionIsString();
		Sorter sorter = new SorterDescendantsDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testPrintStringDescendant " + worker.doWork());
	}

	private static ConcreteTreeNode createTestData(int startNode) {
		// Even nodes contain String data
		// Odd contains Integer wrapper data
		ArrayList<ConcreteTreeNode> test = new ArrayList<ConcreteTreeNode>();
		test.add(new ConcreteTreeNode("0"));
		for(int i=1; i<=10; i++) {
			if( i%2 == 0)
				test.add(new ConcreteTreeNode(String.valueOf(i), test.get(0)));
			else
				test.add(new ConcreteTreeNode(Integer.valueOf(i), test.get(0)));
		}
		
		test.get(0).addChild(test.get(1));
		test.get(0).addChild(test.get(2));
		test.get(0).addChild(test.get(3));
		
		test.get(1).addChild(test.get(4));
		test.get(1).addChild(test.get(5));
		
		test.get(4).addChild(test.get(6));
		
		test.get(2).addChild(test.get(7));
		
		test.get(7).addChild(test.get(8));
		test.get(7).addChild(test.get(9));
		
		
		/*
		 * 					   0 			<- startNode
		 * 				1	   2	3
		 * 			   4 5	   7	   
		 * 			  6	      8 9  	
		 * 								 10 <- not connected to tree
		 */
		
		return test.get(startNode);
	}

}
