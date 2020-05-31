/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack_psy;

/**
 *
 * @author lilian
 */
public class Session {
   private String type; // patient or psy
   private int id;

    Session(int i, String t) {
      this.id = i;
      this.type = t;
    }
   
    public int getId() {
        return this.id;
    }

    public String getPsychologue() {
        return "en atente, WIP";
    }
   
   
}
