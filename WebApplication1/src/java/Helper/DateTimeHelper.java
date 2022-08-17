/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;


import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class DateTimeHelper {
    Calendar calendar = Calendar.getInstance();
   
    
    public int getDow(Date date){
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    
    public int getDay(Date date){
         calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }
    
    public int getMonth(Date date){
         calendar.setTime(date);
        return calendar.get(Calendar.MONTH)+1;
    }
    
    public int getYear(Date date){
         calendar.setTime(date);       
        return calendar.get(Calendar.YEAR);
    }
    
    
    public static void main(String[] args) {
        DateTimeHelper dth = new DateTimeHelper();
        Date d = new Date();
         System.out.println(dth.getDow(d));
         System.out.println(dth.getDay(d));
         System.out.println(dth.getMonth(d));
         System.out.println(dth.getYear(d));
         
    }
}
