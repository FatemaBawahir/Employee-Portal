/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aayu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fatema
 */
@WebServlet(name = "DeleteData", urlPatterns = {"/DeleteData"})
public class DeleteData extends HttpServlet {
    
  private static final String DRIVER_CLASS="org.gjt.mm.mysql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD="";  
    private Connection con;
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        try{
             res.setContentType("text/html");
          PrintWriter out=res.getWriter();
          Class.forName(DRIVER_CLASS);          
         con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
         String x=req.getParameter("del");
         PreparedStatement smt= (PreparedStatement)con.prepareStatement("delete from emp_info where id=?");        
        smt.setString(1, x);
        smt.executeUpdate();
        ResultSet rs= smt.executeQuery("select * from emp_info");
        out.println(
                "<html>\n" +
                "<head><title>" + "</title></head>\n" +
                   "<style>"+
                  " .abc{"
                   + "font-size:24px;"+
                                  "color:black;\n" 
                   + "    } body{\n" +
"                color:#2F5E5E;\n" +            
"                background-color: #FFB693;\n" +
"            } </style>"+
                "<body>\n" +
                "<h1 align=\"center\">" + "The Employee Data Is As Follows:" + "</h1>\n" +
                "<table width=\"1300\" border=\"4\" cellspacing=\"4px\" cellpadding=\"2px\">"+
           
           "<tr>"+
    "<td>"+"First Name"+"</td>"+ "<td>"+"Middle Name"+"</td>"+ "<td>"+"Last Name"+"</td>"+ "<td>"+"gender"+"</td>"+
                    "<td>"+"religion"+"</td>"+"<td>"+"Date Of Birth:  "+"</td>"+ "<td>"+"Department"+"</td>"+
                   "<td>"+"Designation"+"</td>"+"<td>"+"Id"+"</td>"+"<td>"+"Experience"+"</td>"+ "<td>"+"Salary"+"</td>"+
                    "<td>"+"Domicile"+"</td>"+"<td>"+"Present Address"+"</td>"+ " </tr>");
          while(rs.next())
          {
              String x1=rs.getString("fn1");
              String y=rs.getString("fn2");
              String z=rs.getString("fn3");
              String a1=rs.getString("gender");
              String a2=rs.getString("religion");
              String a3=rs.getString("dt");
              String a4=rs.getString("month");
              String a5=rs.getString("year");
              String a6=rs.getString("emp_dep");
              String a7=rs.getString("des");
              String a8=rs.getString("id");
              String a10=rs.getString("exp");
              String a11=rs.getString("sal");
              String a12=rs.getString("dom");
              String a13=rs.getString("txt_ar1");
             
              
               out.println(
                
  "<tr>"+
   " <td>"+x1+"</td>"+  
   
   " <td>"+y+"</td>"+
    
   " <td>"+z+"</td>"+                       
      " <td>"+a1+"</td>"+
   
   " <td>"+a2+"</td>"+
   
    "<td>"  +a3+"&nbsp; &nbsp;"+a4+"&nbsp; &nbsp;"+a5+"</td>"+
  
   " <td>"+a6+"</td>"+
   " <td>"+a7+"</td>"+
   " <td>"+a8+"</td>"+
   " <td>"+a10+"</td>"+
   
   " <td>"+a11+"</td>"+
   " <td>"+a12+"</td>"+
 
    
    
   " <td>"+a13+"</td>"+
    "</tr>");

          }
          out.println(
                  "</table>"+
                  "<\br>"+"<\br>"+
                  "<center> "
                  + "<input class=\"btn\" name=\"SUBMIT\" type=\"submit\" value=\"BACK\" style=\"border:double\" onclick=\"window.location.href=\'emprec.html\'\"/>" 
                  + "</center>"+
                "</body></html>");
            }catch(Exception e){
                e.printStackTrace();
            }
        
        
        }
}