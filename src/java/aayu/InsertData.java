/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aayu;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertData extends HttpServlet{
    
    private static final String DRIVER_CLASS="org.gjt.mm.mysql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD="";  
    private Connection con;
   
  
  public void doGet(HttpServletRequest req,HttpServletResponse res) {
      try{
          PrintWriter out=res.getWriter();
          Class.forName(DRIVER_CLASS);
          
          con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
          PreparedStatement sp;          
          sp=con.prepareStatement("insert into emp_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                 sp.setString(1,req.getParameter("fn1"));
                 sp.setString(2,req.getParameter("fn2" )); 
                 sp.setString(3,req.getParameter("fn3") );
                 sp.setString(4,req.getParameter("gender") );
                 sp.setString(5,req.getParameter("religion") );
                 sp.setString(6,req.getParameter("dt") );
                 sp.setString(7,req.getParameter("month" ));
                 sp.setString(8,req.getParameter("year") );
                 sp.setString(9,req.getParameter("emp_dep") );
                 sp.setString(10,req.getParameter("des") );
                 sp.setString(11,req.getParameter("id") );
                 sp.setString(12,req.getParameter("exp"));
                 sp.setString(13,req.getParameter("sal") );
                 sp.setString(14,req.getParameter("dom") );
                 sp.setString(15,req.getParameter("txt_ar1") );
                             
                 int i=sp.executeUpdate();
                 res.sendRedirect("emprec.html");
            }catch(Exception e){
                e.printStackTrace();
            }

    }
}
