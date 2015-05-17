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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fatema
 */
public class Insert_UpdatedData extends HttpServlet {
private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD="";  
    private Connection con;
    
     public void doGet(HttpServletRequest req,HttpServletResponse res){
       res.setContentType("text/html");
       try {
            PrintWriter out=res.getWriter();
           Class.forName(DRIVER_CLASS);
          
          con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            Statement smt = con.createStatement();
            String k=req.getParameter("id");
            String fname,mname,lname,gen,date,month,year,empd,degn,addr,sal,id,exp,religion,dom;
            fname=req.getParameter("firstname");
            mname=req.getParameter("middlename");
            lname=req.getParameter("lastname");
            gen=req.getParameter("gender");
            date=req.getParameter("date");
            month=req.getParameter("month");
            year=req.getParameter("year");
            empd=req.getParameter("emp_dept");
            degn=req.getParameter("designation");
            sal=req.getParameter("salary");
            addr=req.getParameter("address");
            exp=req.getParameter("e");
            dom=req.getParameter("domicile");
            
            religion=req.getParameter("religion");
            PreparedStatement p=(PreparedStatement)con.prepareStatement("update emp_info set fn1=\""+fname+"\""
                    + ",fn2=\""+mname+"\",fn3=\""+lname+"\",gender=\""+gen+"\",religion=\""+religion+"\",dt=\""+date+"\",month=\""+month+"\",year=\""+year+"\",emp_dep=\""+empd+"\",des=\""+degn+"\",exp=\""+exp+"\",sal=\""+sal+"\",dom=\""+dom+"\",txt_ar1=\""+addr+"\" where id=\""+k+"\"");
            
            p.executeUpdate();
           
  
      
      
      out.println( "<html>\n" +
        "<head><title>"  + "</title></head>"+
                " <style>"+
             "body{"+
                "color:#2F5E5E;"+
                "font-size: 24px;"+
                "background-color: #FFB693;       }"+
          "  </style>"+
                  "<center> "+"Updation completed! "+
                  "<br/> <br/><input class=\"btn\" name=\"SUBMIT\" type=\"submit\" value=\"BACK\" style=\"border:double\" onclick=\"window.location.href=\'emprec.html\'\"/>" 
                  + "</center>"+
                "</body></html>");
        } catch (Exception ex) {
           
        }
     }

}
