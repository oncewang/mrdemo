package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class str_split {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String aa="a  b     c  d e f      g";
//		String [] arr = aa.split("s+");
//		for(String ss : arr){
//		    System.out.println(ss);
//		}
		
		
		public static void main(String[] args) throws ParseException {  
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  
//	        String str = "2011-08-31";  
//	        Date dt = sdf.parse(str);  
//	        Calendar rightNow = Calendar.getInstance();  
//	        rightNow.setTime(dt);  
////	        rightNow.add(Calendar.YEAR, -1);// 日期减1年  
////	        System.out.println(sdf.format(rightNow.getTime()));  
//	          
////	        rightNow.add(Calendar.MONTH, 3);// 日期加3个月  
////	        System.out.println(sdf.format(rightNow.getTime()));  
//	          
//	        rightNow.add(Calendar.DAY_OF_YEAR, -2);// 日期加10天  
//	        System.out.println(sdf.format(rightNow.getTime()));  
			 day_off2day("2017-05-26");
			
			
	    }  
	    public static String day_off2day(String dt){

	        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	        sdf.setLenient(false);
	        
	        try {
	            Date dt_ = sdf.parse(dt);
	            Calendar rightNow = Calendar.getInstance();
	            rightNow.setTime(dt_);
	            rightNow.add(Calendar.DAY_OF_YEAR, -2);// 日期加10天
	            System.out.println(sdf.format(rightNow.getTime()));
	            return sdf.format(rightNow.getTime());

	        }catch (ParseException e)
	        {
	            e.printStackTrace();
	        }

	       return "-1";
	    };

	}


