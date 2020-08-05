//package implementation;
//
//import java.util.ArrayList;
//
//import framework.Traverser;
//import framework.TreeWorker;
//
//public class MainTest {
//
//	public static void main(String[] args) {
//		ArrayList<ConcreteTreeNode> test = new ArrayList<ConcreteTreeNode>();
//		for(int i=0; i<10; i++) {
//			if( i%2 == 0)
//				test.add(new ConcreteTreeNode(String.valueOf(i)));
//			else
//				test.add(new ConcreteTreeNode(Integer.valueOf(i)));
//		}
//		
//
//		test.get(0).addChild(test.get(1));
//		test.get(0).addChild(test.get(2));
//		test.get(0).addChild(test.get(3));
//		
//		test.get(1).addChild(test.get(4));
//		test.get(1).addChild(test.get(5));
//		
//		test.get(4).addChild(test.get(6));
//		
//		test.get(2).addChild(test.get(7));
//		
//		test.get(7).addChild(test.get(8));
//		test.get(7).addChild(test.get(9));
//		
//		ConcreteTreeNode start = test.get(0);
//		
//		ActionToString ats = new ActionToString();
//		ConditionIsString cis = new ConditionIsString();
//		SorterDepthFirst sdf = new SorterDepthFirst();
//		Traverser t = new TraverseFirstToLast(sdf, start);
//		
//		TreeWorker worker = new TreeWorker(ats, cis, t); 
//		
//		Object work = worker.doWork();
//		
//		System.out.println(work);
//		
//		/*
//		 * 					0
//		 * 				1	2	3
//		 * 			   4 5	7	   
//		 * 			  6	   8 9  	
//		 * 
//		 */
//		
//		
//	}
//
//}
