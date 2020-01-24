package base;

import domaine.Note;
import domaine.Part;
import domaine.Repair;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author Thery Ehrlich
 */
public class RepairDao {

    //Recupère toutes les réparations
    public static ArrayList getRepairs() throws SQLException {
        ArrayList repairs = new ArrayList();
        String sql = "SELECT Repair_no, Begin_date, End_date, Total_cost, Is_free, Status, Owner_firstname, Owner_lastname, Owner_id, Device_serial_no, Technician FROM vw_repair ORDER BY Repair_no";
        OracleStatement st = (OracleStatement) MyConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Repair r = new Repair(rs.getInt("Repair_no"), rs.getDate("Begin_date"), rs.getDate("End_date"), rs.getDouble("Total_cost"), rs.getString("Is_free"), rs.getInt("Status"), rs.getString("Owner_firstname"), rs.getString("Owner_lastname"), rs.getInt("Owner_id"), rs.getString("Device_serial_no"), rs.getString("Technician"));
            repairs.add(r);
        }
        rs.close();
        return repairs;
    }

    //Récupère les statuts possibles pour l'affichage dans les reparations
    public static ArrayList getStatusList() throws SQLException {
        ArrayList statusList = new ArrayList();
        String sql = "SELECT Sta_name FROM vw_status";
        OracleStatement st = (OracleStatement) MyConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            statusList.add(rs.getString("Sta_name"));
        }
        rs.close();
        return statusList;
    }

    //Met à jour le prix d'une répartaion si elle est passée gratuite 
    public static void updateRepairCost(Repair pr) throws SQLException {
        String sql = "UPDATE vw_repair SET Is_free = ? WHERE Repair_no = ?";
        OraclePreparedStatement pSt = (OraclePreparedStatement) MyConnection.getConnection().prepareStatement(sql);
        pSt.setString(1, pr.getIsFree());
        pSt.setInt(2, pr.getRepairNo());
        pSt.executeUpdate();
        pSt.close();
        //System.out.println("REPAIR COST UPDATED");
    }

    //Récupère les notes d'une réparation fournie en paramètre
    public static ArrayList getNotes(int repId) throws SQLException {
        ArrayList lstNotes = new ArrayList();
        String sql = "SELECT * FROM vw_note WHERE Repair_no = ? ORDER BY Not_date";
        OraclePreparedStatement pSt = (OraclePreparedStatement) MyConnection.getConnection().prepareStatement(sql);
        pSt.setString(1, String.valueOf(repId));
        ResultSet rs = pSt.executeQuery();
        while (rs.next()) {
            Note n = new Note(rs.getDate("Not_date"), rs.getString("Not_title"), rs.getString("Not_body"), rs.getInt("Repair_no"));
            lstNotes.add(n);
        }
        rs.close();
        return lstNotes;
    }

    //Récupère les pièces disponibles dans le stock
    public static ArrayList getParts() throws SQLException {
        ArrayList lstParts = new ArrayList();
        String sql = "SELECT * FROM vw_part ORDER BY cat";
        OracleStatement st = (OracleStatement) MyConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Part p = new Part(rs.getInt("Part_id"), rs.getString("Part_desc"), rs.getString("Serial_no"), rs.getDouble("Price"), rs.getInt("Stock"), rs.getString("Cat"));
            lstParts.add(p);
        }
        rs.close();
        return lstParts;
    }

    //Récupère la liste des pièces utilisées pour une réparation fournie en paramètre
    public static ArrayList getUsedParts(int repId) throws SQLException {
        ArrayList lstParts = new ArrayList();
        String sql = "SELECT * FROM vw_part_used WHERE Repair_no = ? ORDER BY cat";
        OraclePreparedStatement pSt = (OraclePreparedStatement) MyConnection.getConnection().prepareStatement(sql);
        pSt.setString(1, String.valueOf(repId));
        ResultSet rs = pSt.executeQuery();
        while (rs.next()) {
            Part p = new Part(rs.getInt("Part_id"), rs.getString("Part_desc"), rs.getString("Serial_no"), rs.getDouble("Price"), rs.getInt("Stock"), rs.getString("Cat"));
            lstParts.add(p);
        }
        rs.close();
        return lstParts;
    }

}
