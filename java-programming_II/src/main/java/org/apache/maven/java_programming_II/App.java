package org.apache.maven.java_programming_II;

import java.util.Scanner;

import org.apache.maven.java_programming_II.Entity;
import org.apache.maven.java_programming_II.Menu;

/**
 * Class: Main.
 *
 */

public class App {
  public static Database db;
  public static Scanner input;
  @SuppressWarnings("unused")
  private static String name;
  
  /**
 * Method: main.
 */
  public static void main(String[] args) {
    Entity en = new Entity();
    input = new Scanner(System.in);
    System.out.println("What kind of database would you like to create?");
    name = input.next();
    System.out.println("How many columns would you like your database to contain?");
    int columns = input.nextInt();
    String[] colname = new String[columns];

    for (int i = 0; i < colname.length; i++) {
      System.out.print("Insert the name of the column\n");
      colname[i] = input.next();
    }
    Columns.setCols(colname);
    System.out.printf("%s\n", Columns.getCols());
    System.out.println("Declare a primary key");
    boolean accept = false;
    do {
      String primk = input.next();
      for (int i = 0; i < colname.length; i++) {
        if (primk.equals(colname[i])) {
          en.setPk(primk,i);
          accept = true;
          break;
        }
      }
    } while (!accept);
    Menu menu = new Menu();
    menu.printMenu();
    for (int i = 0; i < 5; i++) {
      String[] elements = new String[columns];
      System.out.println("Insert the elements");
      for (int j = 0; j < columns; j++) {
        elements[j] = input.next();
      }
      menu.enter_data(elements);
      db = new Database(menu.enter_data(elements),i);
    }
    Database.printDb();
    int choice = input.nextInt();
    switch (choice) {
      case 1:
        String[] elements = new String[columns];
        System.out.println("Insert the elements");
        for (int i = 0; i < columns; i++) {
          elements[i] = input.next();
        }
        menu.enter_data(elements);
        db = new Database(menu.enter_data(elements), choice);
        break;
        
      case 2:

      case 3:

      case 4:
   
      default: 

    }
  }
}
