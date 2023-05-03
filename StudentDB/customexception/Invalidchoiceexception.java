 package customexception;

public class Invalidchoiceexception extends RuntimeException {
	private String message;
	
	public Invalidchoiceexception(String message) {
		this.message=message;
		
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
