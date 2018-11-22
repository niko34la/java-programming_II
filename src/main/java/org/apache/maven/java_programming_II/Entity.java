package org.apache.maven.java_programming_II;

import java.util.ArrayList;

public class Entity {
  ArrayList<String> ent = new ArrayList<String>();
  static int counter = 0;
  public String primarykey;
  protected static int primarykey_location;

  /**
 * Method: setter.
 */
  public void setter(String[] colu) {
    for (int i = 0; i < colu.length; i++) {
      this.ent.add(i, colu[i]);
      counter++;
    }
  }

  public ArrayList<String> getter() {
    return ent;
  }

  public Entity(String[] col) {
    setter(col);
  }

  public Entity() {

  }

  /**
   * Method: printEls.
  */
  public void printEls(ArrayList<String> col) {
    for (String s: col) {
      System.out.print("" + s + "   ");
    }
  }

  public void setPk(String s, int i) {
    primarykey = s;
    primarykey_location = i;
  }

  public void printEn() {
    System.out.println(ent);
  }

  public static int getPkL() {
    return primarykey_location;
  }

  public String getS(int i) {
    return ent.get(i);
  }

  public void changedt(int i,String s) {
    ent.add(i,s);
  }

}
