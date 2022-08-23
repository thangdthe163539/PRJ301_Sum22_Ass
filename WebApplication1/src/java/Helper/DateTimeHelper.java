/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;


import DAL.EmployeeDBContext;
import Model.Holiday;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    public ArrayList<String> getListDayOfMonth(int month, int year){
        ArrayList<String> listDays = new ArrayList<>();
        
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat df = new SimpleDateFormat("EEE\ndd");
        //System.out.println(df.format(cal.getTime()));
        listDays.add(df.format(cal.getTime()));
        for (int i = 1; i < maxDay; i++) 
        {
            cal.set(Calendar.DAY_OF_MONTH, i + 1);
            listDays.add(df.format(cal.getTime()));
            //System.out.println(df.format(cal.getTime()));
        } 
        return listDays;
    }  
    
    public int totalDayofMonth(int month, int year){
        Calendar cal = Calendar.getInstance();
        int total = cal.getActualMaximum(Calendar.DAY_OF_MONTH)-this.countSunOfMonth(month, year);
        return total;
    }
   
    public int countSunOfMonth(int month, int year){
        int total = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= maxDay; day++) {
            cal.set(year, month, day);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY) {
                total++;
                // Or do whatever you need to with the result.
            }
        }    
        return total;
    }
    
    public int countSatOfMonth(int month, int year){
        int total = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= maxDay; day++) {
            cal.set(year, month, day);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SATURDAY) {
                total++;
                // Or do whatever you need to with the result.
            }
        }    
        return total;
    }
    
    public Boolean checkSun(String str){
        return str.contains("Sun");
    }
    
    public Boolean checkSat(String str){
        return str.contains("Sat");
    }
    
    public Boolean checkHoliday(String str, int month, int year){
        int count = 0;
        EmployeeDBContext db = new EmployeeDBContext();
        int day = Integer.parseInt(str.charAt(4)+""+str.charAt(5));
        //System.out.println(day);
        ArrayList<Holiday> hList = db.getListHoliday();
        for (Holiday h : hList) {
            if(h.getDay()== day && h.getMonth() == month && h.getYear() == year) count++;                
        }
        return count>0;
    }
    
    public Boolean checkCurDay(int month, int year){
        Calendar cur = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//        System.out.println("cal:"+cal.getTime());
//        System.out.println("cur:"+cur.getTime());
//        System.out.println(cal.compareTo(cur));
        return (cal.compareTo(cur)== -1);
    }
    
    public static void main(String[] args) {
        DateTimeHelper dth = new DateTimeHelper();
        //Date d = new Date();
//         ArrayList<String> listDays = dth.getListDayOfMonth(8, 2022);
//        SimpleDateFormat df = new SimpleDateFormat("EEE\ndd");
//        for (String listDay : listDays) {
//            System.out.println(listDay);
//        }
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        System.out.println(dth.getDow(Calendar.getInstance().getTime()));
        System.out.println(dth.checkCurDay(6,2022));
    }
}
