package singleton;

import java.sql.Statement;
import java.sql.SQLException;

public class DbSingletonDemo {

  public static void main(String[] args) {
    // DbSingleton instance = DbSingleton.getInstance();
    // System.out.println(instance);

    // DbSingleton anotherInstance = DbSingleton.getInstance();
    // System.out.println(anotherInstance);

    // if (instance == anotherInstance) {
    //   System.out.println("Is equal");
    // }

    DbSingleton instance = DbSingleton.getInstance();

    long timeBefore = 0;
    long timeAfter = 0;

    System.out.println(instance);

    timeBefore = System.currentTimeMillis();
    java.sql.Connection conn = instance.getConnection();
    timeAfter = System.currentTimeMillis();

    System.out.println(timeAfter - timeBefore);

    Statement sta;
    try {
      sta = conn.createStatement();
      int count = sta.executeUpdate("CREATE TABLE Address (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
      System.out.println("Table created");
      sta.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    timeBefore = System.currentTimeMillis();
    conn = instance.getConnection();
    timeAfter = System.currentTimeMillis();

    System.out.println(timeAfter - timeBefore);
  }
}