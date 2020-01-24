/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import domaine.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleStatement;

/**
 *
 * @author mgtub
 */
public class CustomerDao {

    //Récupère la liste des clients
    public static ArrayList getCustomers() throws SQLException {
        ArrayList customers = new ArrayList();
        String sql = "SELECT * FROM vw_customer ORDER BY Lastname";
        OracleStatement st = (OracleStatement) MyConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Customer c = new Customer(rs.getInt("Cus_id"), rs.getString("Firstname"), rs.getString("Lastname"), rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"), rs.getString("Other"), rs.getInt("Postal_code"), rs.getString("Area"));
            customers.add(c);
        }
        rs.close();
        return customers;
    }
}
