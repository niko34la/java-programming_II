package org.apache.maven.java_programming_II;

import org.apache.maven.java_programming_II.Database;
import org.apache.maven.java_programming_II.Entity;

public interface Choice {
  Entity enter_data(String[] s);
  
  int print_data(Database d);
  
  int delete_data(Database d);
  
  int change_data(Database d);
}
