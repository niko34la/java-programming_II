package org.apache.maven.java_programming_II;

import java.util.Scanner;

/**
 * Main class.
 *
 */

public class App {
  public static Database db;
  public static Scanner input;
  @SuppressWarnings("unused")
  private static String name;


  public static void main(String[] args) {
    Entity en = new Entity();
    input = new Scanner(System.in);
    System.out.println("What kind of database would you like to create?");
    name = input.nextLine();
    System.out.println("How many columns would you like your database to contain?");
    int columns = input.nextInt();
    String[] colname = new String[columns];
    int[] coltype = new int[columns];

    for (int i = 0; i < colname.length; i++) {
      System.out.print("Insert the name of the column\n");
      String cname = "";
      cname = input.nextLine();
      cname += input.nextLine();
      colname[i] = cname;
      System.out.println("choose type for " + colname[i] + "(type the number on the left)");
      Columns.columnTypes();
      int type;
      do {
        type = input.nextInt();
        coltype[i] = type;
        if (type != 1 && type != 2 && type != 3) {
          System.out.println("Wrong insertion!\nPlease insert again");
        }
      } while (type != 1 && type != 2 && type != 3);
    }
    Columns.setCols(colname);
    Columns.setTypes(coltype);
    System.out.printf("%s\n", Columns.getCols());
    boolean accept = false;
    do {
      System.out.println("Declare a primary key");
      String primk = "";
      primk = input.nextLine();
      primk += input.nextLine();
      for (int i = 0; i < colname.length; i++) {
        if (primk.equals(colname[i])) {
          en.setPk(primk,i);
          accept = true;
          break;
        }
      }
      if (accept != true) {
        System.out.println("Invalid primary key!");
      }
    } while (!accept);
    Menu menu = new Menu();
    int insertions = 0;
    int choice;
    int temp1 = 0;
    int temp2 = 0;
    do {
      menu.printMenu();
      System.out.println("To eliminate the programme press 0");
      choice = input.nextInt();
      if (insertions == 0 && choice != 1 && choice != 0) {
        System.out.println("The database is empty.\nInsert some elements");
        choice = 1;
      }
      switch (choice) {
        case 1:
          String exit = null;
          System.out.println("When you want to finish the insertion type 'exit'");
          do {
            String[] elements = new String[columns];
            for (int j = 0; j < columns; j++) {
              System.out.println("Insert the " + colname[j]);
              String temporary = "";
              if (insertions == 0) {
              temporary = input.nextLine();
                if (j == 0) {
                  temporary += input.nextLine();
                }
              } else {
            	  if (j == 0 && temp1 > 0 && temp2 == 0) {
            		temporary = input.nextLine();
                    temporary += input.nextLine();
            	  } else {
            	    temporary += input.nextLine();
            	  }
              }
              if (temporary.equals("exit")) {
                exit = "exit";
                break;
              } else {
                elements[j] = Columns.checkType(j, temporary);
              }
            }
            temp2++;
            if (exit != "exit") {
              insertions++;
              menu.enter_data(elements);
              db = new Database(menu.enter_data(elements),insertions - 1);
            }
          } while (exit != "exit");
          temp1++;
          temp2 = 0;
          break;
        case 2:
          db.dbSort();
          menu.print_data(db);
          break;
        case 3:
          int tempdeletion = menu.delete_data(db);
          if (tempdeletion == 1) {
            insertions = 0;
          } else if (tempdeletion == 2) {
            insertions -= 1;
          }
          break;
        case 4:
          menu.change_data(db);
          break;
        default:

      }
    } while (choice != 0);
  }
}
