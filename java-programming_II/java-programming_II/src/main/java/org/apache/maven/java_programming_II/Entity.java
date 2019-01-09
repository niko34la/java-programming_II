package org.apache.maven.java_programming_II;
import java.util.ArrayList;


public class Entity {
  ArrayList<String> ent = new ArrayList<String>();
  static int counter = 0;
  public String primary_key;
  protected static int primarykey_location;

  public void setter(String[] colu) {
    for (int i = 0; i < colu.length; i++) {
      this.ent.add(i, colu[i]);
      counter++;
    }
  }

  public ArrayList<String> getter() {
    return ent;
  }

  public Entity(String[] col){
    setter(col);
  }

  public Entity() {

  }

  public String getEnt(int i) {
    return ent.get(i);
  }

  public void printEls(ArrayList<String> ent) {
    for (String s: ent) {
      System.out.printf("%1$" + Database.countLength(ent.indexOf(s)) + "s", s);
    }
  }

  public void setPk(String s, int i) {
    primary_key = s;
    primarykey_location = i;
  }

  /**
   * Prints
   *
   */
  public void printEn() {
    for (String s: ent) {
      System.out.printf("%1$-" + Database.countLength(ent.indexOf(s)) + "s  ", s);
    }
    System.out.print("\n");
  }

  public static int getPkL() {
    return primarykey_location;
  }

  public String getPkVal() {
    return ent.get(primarykey_location);
  }

  public void changedt(int i,String s) {
    ent.set(i,s);
  }

}
