package assignmentTest;


import java.util.ArrayList;

import framework.Action;
import framework.Condition;
import framework.Sorter;
import framework.Traverser;
import framework.TreeWorker;
import implementation.ActionBuildCollection;
import implementation.ActionToString;
import implementation.ConcreteTreeNode;
import implementation.ConditionIsInteger;
import implementation.ConditionIsString;
import implementation.SorterDepthFirst;
import implementation.TraverseFirstToLast;

public class MainTest {

	public static void main(String[] args) {
		ConcreteTreeNode startNode = createTestData();
		
		testPrintStringCondition(startNode);
		testPrintIntegerCondition(startNode);

		testCollectionStringCondition(startNode);
		testCollectionIntegerCondition(startNode);

		
		

		
		
	}

	private static void testCollectionIntegerCondition(ConcreteTreeNode startNode) {
		Action action = new ActionBuildCollection();
		Condition condition = new ConditionIsInteger();
		Sorter sorter = new SorterDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println(worker.doWork());
	}

	private static void testCollectionStringCondition(ConcreteTreeNode startNode) {
		Action action = new ActionBuildCollection();
		Condition condition = new ConditionIsString();
		Sorter sorter = new SorterDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println(worker.doWork());
	}

	private static void testPrintIntegerCondition(ConcreteTreeNode startNode) {
		Action action = new ActionToString();
		Condition condition = new ConditionIsInteger();
		Sorter sorter = new SorterDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println(worker.doWork());
	}
	
	private static void testPrintStringCondition(ConcreteTreeNode startNode) {
		Action action = new ActionToString();
		Condition condition = new ConditionIsString();
		Sorter sorter = new SorterDepthFirst();
		Traverser traverser = new TraverseFirstToLast(sorter, startNode);
		TreeWorker worker = new TreeWorker(action, condition, traverser); 
		System.out.println(worker.doWork());
	}

	private static ConcreteTreeNode createTestData() {
		// Even nodes contain String data
		// Odd contains Integer wrapper data
		ArrayList<ConcreteTreeNode> test = new ArrayList<ConcreteTreeNode>();
		for(int i=0; i<=10; i++) {
			if( i%2 == 0)
				test.add(new ConcreteTreeNode(String.valueOf(i)));
			else
				test.add(new ConcreteTreeNode(Integer.valueOf(i)));
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
		
		ConcreteTreeNode startNode = test.get(0);
		
		/*
		 * 					   0 			<- startNode
		 * 				1	   2	3
		 * 			   4 5	   7	   
		 * 			  6	      8 9  	
		 * 								 10 <- not connected to tree
		 */
		
		return startNode;
	}

}
