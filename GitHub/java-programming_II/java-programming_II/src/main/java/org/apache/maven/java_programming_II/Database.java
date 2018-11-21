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

  public static void printDb() {
    for (Entity en : arr1) {
      en.printEn();
    }
  }

  public String getter(int i) {
	Entity entemp = arr1.get(i);
	return entemp.getS(pk_loc);
	}

  public void removeEnt(int i) {
    arr1.remove(i);
  }

  public void clearDb() {
    arr1.clear();
  }

  public int getIndex(String name) {
    for (Entity en: arr1) {
      if (name.equals(en.getS(pk_loc))) {
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
	for(Entity en : arr1) {
		if(s.equals(en.getS(pk_loc))) {
			pointer.add(arr1.indexOf(en));
			flag = 0;
		}
		if(flag == 0 && !s.equals(en.getS(pk_loc))) {
			break;
		}
	}
	return pointer;
  }

	public void dbSort() {
		for(int i=0; i< arr1.size();i++) {
			for(int j= i+1; j <= arr1.size() ; j++) {
				int l = getter(j).compareTo(getter(i));
				if(l > 0) {
					Entity temp = arr1.get(j);
					arr1.add(j,arr1.get(i));
					arr1.add(i,temp);
				}
			}
		}
	}

	public void altDB(int i, int j,String s) {
		Entity en = arr1.get(i);
		en.changedt(j,s);
		arr1.add(i,en);
	}


}
