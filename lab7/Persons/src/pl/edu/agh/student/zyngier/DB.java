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
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }

    public boolean isConnect(){
        if(conn!=null) return true;
        else return false;
    }

    public void showPersons(){
        try {
            connect();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM persons");

            System.out.println("full name; phone; pesel");

            while(rs.next()){
                System.out.println(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3));
            }
        }catch (SQLException ex){

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

    public void searchBooks(String element, String value){
        try {
            connect();
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM books WHERE " + element +" LIKE '%"+value+"%';");

            System.out.println("isbn;title;author;year");

            while(rs.next()){
                System.out.println(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";" + rs.getString(4));
            }
        }catch (SQLException ex){

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

    public void addPerson(String fullName, String phone, String pesel){
        try {
            connect();
            stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO persons VALUES ('" + fullName + "','" + phone + "','" + pesel + "')");
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