package org.apache.maven.java_programming_II;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Columns {

  static ArrayList<String> cols = new ArrayList<String>();
  static ArrayList<Integer> types = new ArrayList<Integer>();
  public static Scanner input;
  /**
  *Adding elements.
  */

  public static void setCols(String[] col) {
    for (int i = 0; i < col.length; i++) {
      cols.add(i,col[i]);
    }
  }

  public static void setTypes(int[] typ) {
    for (int i = 0; i < typ.length; i++) {
      types.add(i, typ[i]);
    }
  }

  public static ArrayList<String> getCols() {
    return cols;
  }

  public static ArrayList<Integer> getTypes(){
    return types;
  }

  public static int colIndex(String in) {
    for (String s : cols) {
      if (in.equals(s)) {
        return cols.indexOf(s);
      }
    }
    return -1;
  }

  public void printCols() {
    for (String s : cols) {
      System.out.printf("%1$-" + Database.countLength(cols.indexOf(s)) +"s  ", s);
    }
    System.out.print("\n");
  }

  public static void columnTypes() {
    System.out.println("1. numeric\n" + "2. alphabetic\n" + "3. mixed");
    /*throw exception*/
  }



  public static String checkType(int i, String checkstring) {
    input = new Scanner(System.in);
    if (types.get(i) == 1) {
      while (Pattern.matches("[0-9]+",checkstring) == false) {
        System.out.println("retype a numeric value");
        checkstring = input.nextLine();
      }
      return checkstring;
    } else if (types.get(i) == 2) {
      while (Pattern.matches("[a-zA-Z  ]+", checkstring) == false) {
        System.out.println("retype an alphabetic value");
        checkstring = input.nextLine();
      }
      return checkstring;
    } else {
      return checkstring;
    }
  }

}
