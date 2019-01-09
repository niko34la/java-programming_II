package org.apache.maven.java_programming_II;

import java.util.ArrayList;

public class Database {
  static ArrayList<Entity> arr1 = new ArrayList<Entity>();
  static int counter = 0;
  public final int pk_loc;

  public Database(Entity en, int counter) {
    Database.counter = counter;
    pk_loc = Entity.getPkL();
    addEnt(en);
  }

  public void addEnt(Entity en) {
    arr1.add(counter, en);
    counter++;
  }

  public void printDb() {
    for (Entity en : arr1) {
      en.printEn();
    }
  }

  public String getter(int i) {
    Entity entemp = arr1.get(i);
    return entemp.getPkVal();
	}

  public void removeEnt(int i) {
    arr1.remove(i);
  }

  public void clearDb() {
    arr1.clear();
  }

  public int getIndex(String name) {
    for (Entity en: arr1) {
      if (name.equals(en.getPkVal())) {
        return arr1.indexOf(en);
      }
    }
    return -1;
  }

  public boolean exists(String name) {
    if (getIndex(name) == -1) {
      return false;
    } else {
      return true;
    }
  }

  public ArrayList<Integer> allEntities(String s) {
    ArrayList<Integer> pointer = new ArrayList<Integer>();
    int flag = 1;
    for (Entity en : arr1) {
      if (s.equals(en.getPkVal())) {
        pointer.add(arr1.indexOf(en));
        flag = 0;
      }
      if (flag == 0 && !s.equals(en.getPkVal())) {
        break;
      }
    }
    return pointer;
  }

  public void dbSort() {
    for (int i = 0; i < arr1.size(); i++) {
      for (int j = i + 1; j < arr1.size(); j++) {
        if (Columns.types.get(Entity.getPkL()) == 1) {
          double double_value1 = Double.parseDouble(getter(i));
          double double_value2 = Double.parseDouble(getter(j));
          if (double_value1 > double_value2) {
            Entity temp = arr1.get(j);
            arr1.set(j,arr1.get(i));
            arr1.set(i,temp);
          }
        } else {
          int l = getter(j).compareTo(getter(i));
          if (l < 0) {
            Entity temp = arr1.get(j);
            arr1.set(j,arr1.get(i));
            arr1.set(i,temp);
          }
        }
      }
    }
  }

  public void altDB(int i, int j, String s) {
    Entity en = arr1.get(i);
    en.changedt(j,s);
  }

  public void printEntity(int i) {
    for (Entity en : arr1) {
      if (en == arr1.get(i)) {
        en.printEn();
      }
    }
  }

  public static int countLength(int j) {
    int[] maxlengths = new int[Columns.cols.size()];
    for (int i = 0; i < Columns.cols.size(); i++) {
      Entity maxent = arr1.get(0);
      String maxstr = maxent.getEnt(i);
      int max = maxstr.length();
      for (Entity en : arr1) {
        String temp = en.getEnt(i);
        if (temp.length() > max) {
          max = temp.length();
        }
      }
      maxlengths[i] = max;
    }
    return maxlengths[j];
  }

}
