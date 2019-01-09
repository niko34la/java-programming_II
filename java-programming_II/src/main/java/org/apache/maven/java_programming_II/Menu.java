package org.apache.maven.java_programming_II;

import java.util.Scanner;

public class Menu implements Choice {
  Scanner input = new Scanner(System.in);

  @Override
public Entity enter_data(String[] els) {
    Entity en = new Entity(els);
    return en;
  }

  @Override
  public int print_data(Database db) {
    Columns col = new Columns();
    col.printCols();
    db.printDb();
    return 2;
  }

  @Override
  public int delete_data(Database db) {
    Delete d = new Delete();
    d.delMenu();
    int ch;
    /*do {*/
     System.out.println("Type your choice");
     ch = input.nextInt();
    /*} while (ch != 1 && ch != 2 && ch != 3);*/
    if (ch == 1) {
      d.del1(db);
      return 1;
    } else if (ch == 2) {
      d.del2(db);
      return 2;
    } else {
      d.del3(db);
      return 3;
    }
  }

  @Override
  public void change_data(Database db) {
    System.out.println("Enter the primary key of the entity you would like to modify");
    String old = input.next();
    db.dbSort();
    for (Integer i : db.allEntities(old)) {
      int pointer1 = i;
      db.printEntity(pointer1);
      System.out.println("Is this the entity you would like to change?\nPlease type 'yes' or 'no'");
      String answer = null;
      do {
        answer = input.next();
      } while ((!answer.equals("yes")) && (!answer.equals("no")));
      if (answer.equals("yes")) {
        System.out.println("Which field would you like to change?");
        String field = input.next();
        if (Columns.colIndex(field) != -1) {
          int pointer2 = Columns.colIndex(field);
          System.out.println("What is the new value?");
          String new_value = input.next();
          db.altDB(pointer1,pointer2,new_value);
          break;
        }
      }
    }
  }

  public void printMenu() {
    System.out.println("Welcome to our menu");
    System.out.println("For entering new data press 1");
    System.out.println("For presentation of your data press 2");
    System.out.println("For deletion of your data press 3");
    System.out.println("For modification of your data press 4");
  }

}
