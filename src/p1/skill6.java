package p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class skill6 {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    
    boolean repeat = true;
    System.out.println("*** MENU ***");
    System.out.println("1.INSERT");
    System.out.println("2.FIND COST");
    System.out.println("3.EXIT\n");
    while(repeat) {
      System.out.println("\nENTER CHOICE: ");
      int key = sc.nextInt();
      switch (key) {
      case 1:
        System.out.println(insert());
        break;
      case 2:
        System.out.println("Total cost: "+cost() +"\n");
        break;
      case 3:
        System.out.println("Exiting...\n");
        repeat = false;
        break;
      default:
        System.out.println("Enter Correct option");
      
      } //switch
    } //while

  }  ///main
  public static Connection connect() {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/selenium";
    String user = "root";
    String password = "Charmitha@5";
    
    try {
      con = DriverManager.getConnection(url, user,password);
      return con;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
  public static String insert()  {
    System.out.println("Enter id (Should be unique): ");
    int id = sc.nextInt();
    System.out.println("Enter name: ");
    String name = sc.next();
    System.out.println("Enter cost: ");
    int cost = sc.nextInt();
    try {
    Connection con = connect();
    PreparedStatement ps = con.prepareStatement("INSERT INTO SALES VALUES(?,?,?)");
    ps.setInt(1, id);
    ps.setString(2, name);
    ps.setInt(3, cost);
    ps.execute();
    return "Inserted\n";
    }
    catch (Exception e) {
      return e.getMessage();
    }
    
    
  } //insert
  
  public static int cost() {
    try {
    Connection con = connect();
    PreparedStatement ps = con.prepareStatement("SELECT  SUM(COST) AS COST FROM SALES");
    ResultSet rs = ps.executeQuery();
    String sum ="";
    if(rs.next()) {
    sum += rs.getString("COST");
    }
    int c = Integer.parseInt(sum);
    return c;
  }
    catch (Exception e) {
      System.out.println(e.getMessage());
      return 0;
    }
  }
  

} //class