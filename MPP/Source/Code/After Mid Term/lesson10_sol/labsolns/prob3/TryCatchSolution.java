

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TryCatchSolution {
	
	List<String> processList(List<String> list) {

	    return list.stream()
	    		   .map(x -> {
	    			   String retVal = null;
	    			   try {
	    				   retVal = doNothingIfShort(x);
	    			   } catch(InputTooLongException e) {
	    				   throw new InputTooLongRuntimeException(e);
	    			   }
	    			   return retVal;
	    		   })
	               .collect(Collectors.toList());
	 
	}
	
	 
	String doNothingIfShort(String input) throws InputTooLongException {
	    if (input.length() > 3) throw new InputTooLongException();
	    else return input;
	}
	
	public static void main(String[] args) {
		TryCatchSolution tcs = new TryCatchSolution();
		List<String> words1 = Arrays.asList("not", "too", "big", "yet", "oops");
		System.out.println(tcs.processList(words1));
	}
	
	class InputTooLongException extends Exception {
		private static final long serialVersionUID = 1L;
		public InputTooLongException() {
			super("Must be length 3 or less");
		}
		public InputTooLongException(String s) {
			super(s);
		}
		public InputTooLongException(Throwable t) {
			super(t);
		}
	}
}
