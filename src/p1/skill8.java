package p1;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class skill8 {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    boolean repeat = true;
    System.out.println("* MENU *");
    System.out.println("1.INSERT");
    System.out.println("2.VIEW");
    System.out.println("3.EXIT\n");
    while(repeat) {
      System.out.println("\nENTER CHOICE: ");
      int key = sc.nextInt();
      switch (key) {
      case 1:
        System.out.println(insert());
        break;
      case 2:
        view();
        break;
      case 3:
        System.out.println("Exiting...\n");
        repeat = false;
        break;
      default:
        System.out.println("Enter Correct option");
      }
    }

  }//main

  public static Connection connect() {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/jfsd";
    String user = "root";
    String password = "Charmitha@5";

    try {
      con = DriverManager.getConnection(url, user,password);
      return con;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }//connection
  public static String insert()  {
    System.out.println("Enter id (Should be unique): ");
    int id = sc.nextInt();
    System.out.println("Enter name: ");
    String name = sc.next();
    System.out.println("Enter category: ");
    String cat = sc.next();
    System.out.println("Enter image file location: ");
    String img = sc.next();
    System.out.println("Description file location(.txt): ");
    String txt = sc.next();
    
    try {
      Connection con = connect();
      PreparedStatement ps = con.prepareStatement("INSERT INTO WILDLIFE VALUES(?,?,?,?,?)");
      ps.setInt(1, id);
      ps.setString(2, name);
      ps.setString(3, cat);
      FileInputStream file = new FileInputStream(img);
      ps.setBlob(4, file);
       File f = new File(txt);
          Scanner sf = new Scanner(f);
       String s = "";
        s+= sf.nextLine();  //reads only first line should be less than 200 words.
            
      ps.setString(5, s);
      ps.execute();
      return "Inserted\n";
    }
    catch (Exception e) {
      return e.getMessage();
    }  
  } //insert
  public static void view() {
    System.out.println("Enter id : ");
    int id = sc.nextInt();
    try {
      Connection con = connect();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM WILDLIFE WHERE ID=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        System.out.println("Name: "+rs.getString("name"));
        System.out.println("Name: "+rs.getString("category"));
        System.out.println("Name: "+rs.getBlob("img"));
        System.out.println("Name: "+rs.getString("description"));
             System.out.println();
      }
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }  
  }//void
}//class