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
    String pk = input.next();
    int index = db.getIndex(pk);
    if (index != -1) {
      db.removeEnt(index);
    } else {

    }
  }

  public void del3(Database db, String pk, String del_el) {

  }

  public void delMenu() {
    System.out.println("1.For complete termination of your data");
    System.out.println("2.For deletion of a specific entity");
    System.out.println("3.For deletion of a specific element from an entity");
  }

}
