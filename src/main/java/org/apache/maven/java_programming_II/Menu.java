package org.apache.maven.java_programming_II;

import java.util.Scanner;

public class Menu implements Choice {
  Scanner input = new Scanner(System.in);

  public Entity enter_data(String[] els) {
    Entity en = new Entity(els);
    return en;
  }

  public int print_data(Database db) {
    Database.printDb();
    return 2;
  }

  /*
  * Method: delete_data 
  */
  public int delete_data(Database db) {
    Delete d = new Delete();
    d.delMenu();
    int ch = input.nextInt();
    assert (ch == 1 || ch == 2 || ch == 3) : "Wrong insertion";
    if (ch == 1) {
      d.del1(db);
    } else if (ch == 2) {
      d.del2(db);
    } else {

    }
    return 3;
  }


  public void change_data(Database db, String old) {
    db.dbSort();
    for (Integer i : db.allEntities(old)) {
      int pointer1 = db.allEntities(old).get(i);
      System.out.println(Database.arr1.get(pointer1));
      System.out.println("Is this the entity you would like to change?\nPlease type 'yes' or 'no'");
      String answer = null;
      do {
        answer = input.next();
      } while (!"yes".equals(answer) || !"no".equals(answer));
      if (answer.equals("yes")) {
        System.out.println("Which field would you like to change?");
        String field = input.next();
        if (Columns.colIndex(field) != -1) {
          int pointer2 = Columns.colIndex(field);
          System.out.println("What is the new value?");
          String newValue = input.next();
          db.altDb(pointer1,pointer2,newValue);
        }
      }
    }
  }

  /**
 * Our menu.  
 */
  public void printMenu() {
    System.out.println("Welcome to our menu");
    System.out.println("For entering new data press 1");
    System.out.println("For presentation of your data press 2");
    System.out.println("For deletion of your data press 3");
    System.out.println("For modification of your data press 4");
  }

}
