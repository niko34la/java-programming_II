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

  public int delete_data(Database db) {
    Delete d = new Delete();
    d.delMenu();
    int ch = input.nextInt();
    assert (ch == 1 || ch == 2 || ch == 3) : "Wrong insertion";
    if(ch == 1) {
      d.del1(db);
	} else if(ch == 2){
      d.del2(db);
    } else {

    }
      return 3;
    }

    public int change_data(Database db) {
      return 4;
    }

    public void printMenu() {
      System.out.println("Welcome to our menu");
      System.out.println("For entering new data press 1");
      System.out.println("For presentation of your data press 2");
      System.out.println("For deletion of your data press 3");
      System.out.println("For modification of your data press 4");
    }

}
