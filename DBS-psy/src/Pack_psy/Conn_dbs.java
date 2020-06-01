/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lilian
 */
public class Conn_dbs {    
    private static Connection conn;
     
    Conn_dbs(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:CONNEXION_SERVERName=NOM_DB;integratedSecurity=true");
            
            if (conn == null) {
               System.out.println("Problem in the connection with the data base");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conn_dbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Statement getStatement() {
        try {
            Statement stmt = conn.createStatement();
            return stmt;
        } catch (SQLException ex) {
            Logger.getLogger(Conn_dbs.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(1);
        return null;
    }   
    
    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conn_dbs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
