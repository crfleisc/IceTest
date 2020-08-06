package assignmentTest;

import java.util.ArrayList;

import framework.Action;
import framework.Condition;
import framework.Sorter;
import framework.Traverser;
import framework.TreeWorker;
import implementation.ConcreteTreeNode;
import implementation.actions.ActionBuildCollection;
import implementation.actions.ActionBuildString;
import implementation.conditions.ConditionIsAncestor;
import implementation.conditions.ConditionIsInteger;
import implementation.conditions.ConditionIsString;
import implementation.sorters.SorterAncestors;
import implementation.sorters.SorterDescendantsDepthFirst;
import implementation.traversers.TraverseFirstToLast;

/*	Even = String 	
 *  Odd = Integer
 * 					   0 			<- root
 * 				1	   2	   3
 * 			   4 5	   7	   
 * 			  6	      8 9  	
 * 								    10 <- not connected to tree
 */

public class MainTest {

	public static void main(String[] args) {
		int start = 4;	// Choose 1-10 to test different startNodes
		ConcreteTreeNode startNode = createTestData(start);
		
		System.out.println("Assignment Tests with startNode: " + startNode);
		testCollectionStringDescendant(startNode); // Assignment B
		testPrintAllAncestors(startNode);		   // Assignment C
		
		System.out.println("\nOther Tests with startNode: " + startNode);
		
		testPrintStringDescendant(startNode);
		testPrintIntegerDescendant(startNode);
		testCollectionIntegerDescendant(startNode);
		
		testPrintStringAncestor(startNode);
		testPrintIntegerAncestor(startNode);
		testCollectionStringAncestor(startNode);
		testCollectionIntegerAncestor(startNode);
	}

	private static void testCollectionStringDescendant(ConcreteTreeNode startNode) {
		Action action = new ActionBuildCollection();
		Condition condition = new ConditionIsString();
		Sorter sorter = new SorterDescendantsDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testCollectionStringDescendant " + worker.doWork());
	}
	
	private static void testPrintAllAncestors(ConcreteTreeNode startNode) {
		Action action = new ActionBuildString();
		Condition condition = new ConditionIsAncestor();
		Sorter sorter = new SorterAncestors();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println("testPrintAllAncestors " + worker.doWork());
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
		
		test.get(0).root = test.get(0);
		
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
