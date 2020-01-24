package base;

import domaine.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Thery Ehlrich
 */
public class UserDao {

    //Récupère les utilisateurs (Managers, Techniciens et Demandeurs d'accès)
    public static ArrayList getUsers() throws SQLException {
        ArrayList users = new ArrayList();
        String sql = "SELECT * FROM vw_user ORDER BY lastname";
        Statement s = MyConnection.getConnection().createStatement();
        OracleResultSet rs = (OracleResultSet) s.executeQuery(sql);
        while (rs.next()) {
            User u = new User(rs.getString("firstname"), rs.getString("Lastname"), rs.getString("Email"), rs.getString("Username"), rs.getString("Usr_password"), rs.getString("Usr_role"), rs.getInt("Emp_no"), rs.getString("Reg_status"));
            users.add(u);
        }
        rs.close();
        return users;
    }
    
    //Ajoute un nouvel utilisateur à la base
    public static void addUser(User u) throws SQLException {
        String sql = "INSERT into vw_user VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        OraclePreparedStatement pSt = (OraclePreparedStatement) MyConnection.getConnection().prepareStatement(sql);
        pSt.setString(1, u.getFirstname());
        pSt.setString(2, u.getLastname());
        pSt.setString(3, u.getEmail());
        pSt.setString(4, u.getUsername());
        pSt.setString(5, u.getPassword());
        pSt.setString(6, u.getRole());
        pSt.setInt(7, u.getEmpNo());
        pSt.setString(8, u.getStatus());
        pSt.executeUpdate();
        pSt.close();
        //System.out.println("EMPLOYEE INSERTED");
    }

    //Met a jour un utilisateur fourni en paramètre 
    public static void updateExistingUser(User u) throws SQLException {
        String sql = "UPDATE vw_user SET Reg_status = ?, Emp_no = ?,  Usr_role = ? WHERE Firstname = ? AND Lastname = ? AND Username = ?";
        OraclePreparedStatement pSt = (OraclePreparedStatement) MyConnection.getConnection().prepareStatement(sql);
        pSt.setString(1, u.getStatus());
        pSt.setInt(2, u.getEmpNo());
        pSt.setString(3, u.getRole());
        pSt.setString(4, u.getFirstname());
        pSt.setString(5, u.getLastname());
        pSt.setString(6, u.getUsername());
        pSt.executeUpdate();
        pSt.close();
        //System.out.println("EMPLOYEE UPDATED");
    }

    //Supprime un utilisateur de la base
    public static void deleteUser(User u) throws SQLException {
        String sql = "DELETE FROM vw_user WHERE Firstname = ? AND Lastname = ? AND Username = ?";
        OraclePreparedStatement pSt = (OraclePreparedStatement) MyConnection.getConnection().prepareStatement(sql);
        pSt.setString(1, u.getFirstname());
        pSt.setString(2, u.getLastname());
        pSt.setString(3, u.getUsername());
        pSt.executeUpdate();
        pSt.close();
        //System.out.println("EMPLOYEE DELETED");
    }
    
    //Récupère l'utilisateur pour un nom d'utilisateur et mot de pass fourni
    public static User getCredentials(String username, String pwd) throws SQLException {
        String sql = "SELECT Username, Usr_password, Usr_role FROM vw_user WHERE Username = ? AND Usr_password = ?";
        OraclePreparedStatement pSt = (OraclePreparedStatement) MyConnection.getConnection().prepareStatement(sql);
        pSt.setString(1, username);
        pSt.setString(2, pwd);
        ResultSet rs = pSt.executeQuery();
        rs.next();
        User u = new User(rs.getString("Username"), rs.getString("Usr_password"), rs.getString("Usr_role"));  
        rs.close();
        return u;  
    }
}