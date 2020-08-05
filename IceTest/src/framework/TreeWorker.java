package framework;

public class TreeWorker {
	Action action;
	Condition condition;
	Traverser traverser;
	Object work;
	
	public TreeWorker(Action action, Condition condition, Traverser traverser) {
		this.action = action;
		this.condition = condition;
		this.traverser = traverser;
	}
	
	public Object doWork() {
		Object current;
		do {
			current = traverser.next();
			if(condition.checkCondition(current)) 
				work = action.performAction(current, work);
		} while(traverser.hasNext());
		
		return work;
	}
	
}
