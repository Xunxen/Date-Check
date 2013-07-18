//Brandon Schaeffer
public class DateSetError extends Throwable{

	private String msg;
	public DateSetError(String s){
	
		msg=s;
	
	}
	public String toString(){
	
		return msg;
	
	}

}