//Brandon Schaeffer
import java.util.*;

public class DateTest{

static Scanner in=new Scanner(System.in);

	public static void main(String args[]){
	
		Date date=null;
		System.out.println("Enter a month, day, and year");
		int m=0, d=0, y=0;
		do{
	
			try{//no exceptions for EoF or non-number inputs.
				
				if(in.hasNext())
				m=Integer.parseInt(in.next());
				else{
				
					System.err.println("No more data to read. Quitting program.");
					return;
				
				}
				if(in.hasNext())
				d=Integer.parseInt(in.next());
				else{
				
					System.err.println("No more data to read. Quitting program.");
					return;
				
				}
				if(in.hasNext())
				y=Integer.parseInt(in.next());
				else{
				
					System.err.println("No more data to read. Quitting program.");
					return;
				
				}
			
			}catch(NumberFormatException e){
		
				System.err.println("Invalid input.\nPlease enter a numeric month, day, and year");
		
			}
		
		}while(m==0||d==0||y==0);
		do{
			try{//ask user to re-enter an impossible date (ie 2/33/2011)
		
				date=new Date(m,d,y);
				System.out.println(date.toWords());
				date.tomorrow();
				System.out.println("The following day will be "+date.toWords());
				System.out.print("This could be formatted as "+date);
				date.fullYear(true);
				System.out.println(" or "+date);
			
			
			}catch(DateSetError e){
			
				System.err.println(e);
				System.out.println("Please enter a valid date.");
				in.next();
				
			}
		
		}while(date==null);
	
	}

}