/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import DAL.EmployeeDBContext;
import Model.Employee;
import Model.WorkDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class ControllerHelper {
     public int[] year_month(String str){
        int[] ym = new int[2];
        if(str != null && str.length()>0){
            StringTokenizer stk = new StringTokenizer(str, "- ");
            try {
                ym[0] = Integer.parseInt( stk.nextToken());
                ym[1] = Integer.parseInt( stk.nextToken());

            } catch (Exception e) {
                //System.out.println("fail!");
                Calendar calendar = Calendar.getInstance();             
                ym[0] = calendar.get(Calendar.MONTH) + 1;
                ym[1] = calendar.get(Calendar.YEAR);
            }
        } else {
            Calendar calendar = Calendar.getInstance();             
            ym[0] = calendar.get(Calendar.MONTH) + 1;
            ym[1] = calendar.get(Calendar.YEAR);
        }        
        return ym;        
    }
    
    public int getDay (String str){
        int result=0;    
        if(str != null && str.length()>0){
            StringTokenizer stk = new StringTokenizer(str, "\n");
            stk.nextToken();
            try {
                result = Integer.parseInt(stk.nextToken());
            } catch (Exception e) {
                
            }
        }
        return result;
    }
    
    public int totalLeaveDateHasPer(ArrayList<WorkDate> workdate, int month, int year, int eid){
        int total = 0;
        for (WorkDate wd : workdate) {
           if(wd.getValue().equals("CP") && wd.getMonth()==month && wd.getYear()==year && wd.getEid() == eid) total++; 
        }
        return total;
    }
    
    public int totalLeaveDateNoPer(ArrayList<WorkDate> workdate, int month, int year, int eid){
        int total = 0;
        for (WorkDate wd : workdate) {
           if(wd.getValue().equals("KP") && wd.getMonth()==month && wd.getYear()==year && wd.getEid() == eid) total++; 
        }
        return total;
    }
    
    public double countNorWorkDate(ArrayList<WorkDate> workdate, int month, int year, int eid){
        double total = 0.0;
        for (WorkDate wd : workdate) {
           if(wd.getDow()!=1 && wd.getMonth()==month && wd.getYear()==year && wd.getEid() == eid){
               if(wd.getValue().equals("1")){ total = total+1;}
               else if(wd.getValue().equals("0.5")){ total = total+0.5;}
           }
        }
        return total;
    }
    
    public double countSunWorkDate(ArrayList<WorkDate> workdate, int month, int year, int eid){
        double total = 0.0;
        for (WorkDate wd : workdate) {
           if(wd.getDow()==1 && wd.getMonth()==month && wd.getYear()==year && wd.getEid() == eid){
               if(wd.getValue().equals("1")){ total = total+ 1;}
               else if(wd.getValue().equals("0.5")){ total = total+ 0.5;}
           }
        }
        return total;
    }
    
     public static void main(String[] args) {
        ControllerHelper chelp = new ControllerHelper();
//        int[] list = chelp.year_month("08-2022");
//         System.out.println(list[0]);
//         System.out.println(list[1]);
        EmployeeDBContext db = new EmployeeDBContext();
        ArrayList<Employee> eList = db.loadEmployees();
        Employee e = eList.get(7);
         System.out.println(e.getName());
        System.out.println(chelp.countNorWorkDate(e.getWorkdate(), 8, 2022, e.getId()));
    }
    
    
}
