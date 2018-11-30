package pl.edu.agh.student.zyngier;

import com.mysql.cj.util.StringUtils;

import java.sql.*;

public class DB{
  private Connection conn = null;
  private Statement stmt = null;
  private ResultSet rs = null;

  public void connect(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/zyngier1", "zyngier1","4FcqT2V60H3hSVEJ");
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }catch(Exception e){e.printStackTrace();}
  }

  public void getBooks(){
    try {
      connect();
      stmt = conn.createStatement();

      rs = stmt.executeQuery("SELECT * FROM books");

      System.out.println("isbn;title;author;year");

      while(rs.next()){
        String id = rs.getString(1);
        //System.out.println(rs.getString(1) + ";" + String.format("%1$"+rs.getString(2).length()+ "s", rs.getString(2)) + ";" + rs.getString(3) + ";" + rs.getString(4));
        System.out.println(StringUtils.leftPad("test", 20, "*"));
      }
      }catch (SQLException ex){
        // handle any errors

      }finally {
        if (rs != null) {
          try {
            rs.close();
          } catch (SQLException sqlEx) { } // ignore
          rs = null;
        }

        if (stmt != null) {
          try {
            stmt.close();
          } catch (SQLException sqlEx) { } // ignore

          stmt = null;
        }
      }
  }
}