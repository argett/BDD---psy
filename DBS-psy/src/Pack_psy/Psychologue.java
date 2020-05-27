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
public class Psychologue {
   private int id;
   private String name;

   Psychologue(int i, String n) {
      this.id = i;
      this.name = n;
   }

   public String getName() {
      return this.name;
   }

   public int getId() {
      return this.id;
   }
}
