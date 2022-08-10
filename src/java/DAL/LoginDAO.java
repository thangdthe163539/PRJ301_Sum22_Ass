/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class LoginDAO {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    String status ="";
    
    public User checkLogin (String acc, String pass){
        
        String sql = "SELECT *"+
                    "  FROM [Hospital].[dbo].[User]\n" +
                    "  WHERE [Account] = ? and [Password] = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, acc);
            ps.setString(2, pass);            
            rs = ps.executeQuery();
            while(rs.next()){
                User a = new User(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(9),rs.getString(8),rs.getBoolean(10));
                //System.out.println(a.getAccount()+" "+a.getPassword()+" "+a.getRole());
                return a;
            }
        } catch (Exception e) {
            status = "Error insert student" + e.getMessage();
        }
        return null;
    }
    
    public static void main(String[] args) {
        LoginDAO dao = new LoginDAO();
        User a = dao.checkLogin("doctor1", "123456");
        System.out.println(a.toString());
    }
}
