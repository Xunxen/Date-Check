//Brandon Schaeffer
public class Date{

private String monthString[];
private int year, month, day;
private boolean full;

	public Date(int m,int d,int y) throws DateSetError{
	
		monthString=new String[]{"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
		if(d<1) throw new DateSetError("Invalid Day: "+d);
		if(m<1||m>12) throw new DateSetError("Invalid Month: "+m);
		if(y==0) throw new DateSetError("There is no Year 0");
		//30 days has september, april, june, and november.
		//leap year every 4 years, not every 100, unless also multiple of 400
		//31 days all other months
		if(((m==4||m==6||m==9||m==11)&&d<31)||(m==2&&d<30&&(y%4==0&&y%100!=0||y%400==0))
				||(m==2&&d<29&&(y%4!=0||y%100==0&&y%400!=0))
				||((m!=2&&m!=4&&m!=6&&m!=9&&m!=11)&&d<32)){

			year=y;
			month=m;
			day=d;
			full=false;
			
		}
		else throw new DateSetError("Invalid date: "+m+"/"+d+"/"+y);

	}
	
	public void fullYear(boolean f){
	
		full=f;
	
	}
	
	public String toString(){
		
		if(!full){
		
			if(year<0) return String.format("%02d/%02d/%02d BCE",month,day,((-year)%100));
			else return String.format("%02d/%02d/%02d",month,day,(year%100));
			
		}
		else{
		
			if(year<0) return String.format("%02d/%02d/%02d BCE",month,day,(-year));
			else return String.format("%02d/%02d/%d",month,day,year);
		
		}
	
	}
	
	public String toWords(){
	
		if(day%10==1&&day/10!=1) return (monthString[month-1]+" " +day+"st, "+ year);
		else if(day%10==2&&day/10!=1) return (monthString[month-1]+" " +day+"nd, "+ year);
		else if(day%10==3&&day/10!=1) return (monthString[month-1]+" " +day+"rd, "+ year);
		else return (monthString[month-1]+" " +day+"th, "+ year);
	
	}
	
	public void tomorrow(){
	
		if(((month==4||month==6||month==9||month==11)&&day==30)
				||(month==2&&day==29&&(year%4==0&&year%100!=0||year%400==0))
				||(month==2&&day==28&&(year%4!=0||year%100==0&&year%400!=0))
				||((month!=2&&month!=4&&month!=6&&month!=9&&month!=11)&&day==31)){
				
			day=1;
			if(++month==13){
					
				month=1;
				if(++year==0) ++year;
					
			}
				
		}
		else ++day;
				
	}
	
	public int getYear(){
	
		return year;
		
	}
	
	public int getDay(){
	
		return day;
	
	}
	
	public String getMonthString(){
	
		return monthString[month-1];
		
	}
	
	public int getMonth(){
	
		return month;
	
	}
			
}