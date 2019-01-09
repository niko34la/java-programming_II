package org.apache.maven.java_programming_II;
import java.util.Scanner;

public class Delete {
  Scanner input = new Scanner(System.in);
  public Delete() {

  }

  public void del1(Database db) {
    db.clearDb();
  }

  public void del2(Database db) {
    System.out.println("Enter the primary key value of the entity you want to delete:");
    String pk = input.nextLine();
    int index = db.getIndex(pk);
    if (index != -1) {
      db.removeEnt(index);
    } else {
      System.out.println("There is no such element");
    }
  }

  public void del3(Database db) {
    db.dbSort();
    System.out.println("Give the key's value from the entity you'd like to delete");
    String old = input.next();
    for (Integer i : db.allEntities(old)) {
      int pointer1 = i;
      db.printEntity(pointer1);
      System.out.println("Is this the entity you would like to delete a field from?\n"
          + "Please type 'yes' or 'no'");
      String answer = null;
      do {
        answer = input.next();
      } while ((!"yes".equals(answer)) && (!"no".equals(answer)));
      if (answer.equals("yes")) {
        System.out.println("Which field would you like to delete?");
        String field = input.next();
        if (Columns.colIndex(field) != -1) {
          int pointer2 = Columns.colIndex(field);
          db.altDB(pointer1,pointer2," ");
          break;
        }
      }
    }
  }

  public void delMenu() {
    System.out.println("1.For complete termination of your data");
    System.out.println("2.For deletion of a specific entity");
    System.out.println("3.For deletion of a specific element of an entity");
  }

}
