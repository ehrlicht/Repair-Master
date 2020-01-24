/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.Connection;
import java.sql.SQLException;
import base.Bases;

/**
 *
 * @author mgr
 */
public class MyConnection {
    static String base = "OR";
    static Connection cnx;
    
    public MyConnection(String base){
        this.base = base;
    } 
    
    public static Connection getConnection(){
        if (cnx == null){
            try {
                cnx = Bases.connect(base);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnx;
    }
    
    public static void close(){
        if (cnx != null){
            try {
                cnx.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
