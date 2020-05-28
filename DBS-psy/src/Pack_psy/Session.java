/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

import java.sql.Connection;

/**
 *
 * @author lilian
 */
public class Session {
   private Connection conn;
   private int id;
   private String psychologue;

    Session(int i, String n, Connection con) {
      this.id = i;
      this.psychologue = n;
      this.conn = con;
    }
   
    public int getId() {
        return this.id;
    }

    public Connection getConn() {
        return conn;
    }

    public String getPsychologue() {
        return psychologue;
    }
   
   
}
