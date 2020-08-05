package framework;

// ObjectNotInTreeException is a checked Exception
@SuppressWarnings("serial")
public class ObjectNotInTreeException extends Exception {
	
		public ObjectNotInTreeException(String errorMsg) {
			super(errorMsg);
		}
		
		public ObjectNotInTreeException(String errorMsg, Throwable err) {
			super(errorMsg, err);
		}
}
