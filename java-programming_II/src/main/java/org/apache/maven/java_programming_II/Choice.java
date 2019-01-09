package org.apache.maven.java_programming_II;

public interface Choice {
  Entity enter_data(String[] s);

  int print_data(Database d);

  int delete_data(Database d);

  void change_data(Database d);
}
