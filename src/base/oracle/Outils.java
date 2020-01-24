package base.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
* Connexion à la base Oracle.
**
@author Peter DAEHNE ‐ HEG‐Genève
* @version Version 2.1
*/
public class Outils {
/** Retourne une connexion avec une intstance d'Oracle.
     * @param nomInstance
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException  */
    public static Connection connect (String nomInstance) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Properties props = new Properties();
        props.put("user", "RepairMaster_user"); props.put("password", "RepairMaster_user");
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + nomInstance, props);
    } // connect
} // Outils