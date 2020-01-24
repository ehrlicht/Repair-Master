/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.Connection;
/**
* Outil de connexion à la base de données
**
@author Peter DAEHNE ‐ HEG‐Genève
* @version Version 2.2
*/
public class Bases {
    /* Effectue la connexion et la retourne en fonction de nomBase:
    . MYSQL : base de données MySQL "EmplDept"
    . ORACLE : base Oracle HEGLOCAL
    Par défaut: MYSQL */
    public static Connection connect(String nomBase) throws Exception {
        Connection con;
        nomBase = nomBase.toUpperCase();
        if (nomBase.startsWith("MY")) {
            con = base.mysql.Outils.connect("GestionAct"); 
            System.out.println("Base de données MySQL \"GestionAct\"");
        } else if (nomBase.startsWith("OR")) {
            con = base.oracle.Outils.connect("XE"); 
            System.out.println("Base de données Oracle de l'instance \"XE\"");
        } else {
            con = base.mysql.Outils.connect("GestionAct"); 
            System.out.println("Base de données MySQL \"EmplDept\"");
        }
        return con;
    } // connect
} // Bases