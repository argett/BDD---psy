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
   private final String type; // patient or psy
   private final String id;

    Session(String id, String t) {
      this.id = id;
      this.type = t;
    }
   
    public String getType() {
        return this.type;
    }

    public String getInfos() {
        return id; 
    } 
}
