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
   private int id;
   private String psychologue;

    Session(int i, String n) {
      this.id = i;
      this.psychologue = n;
    }
   
    public int getId() {
        return this.id;
    }

    public String getPsychologue() {
        return psychologue;
    }
   
   
}
