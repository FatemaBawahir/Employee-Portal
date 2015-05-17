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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Trial2 extends HttpServlet {
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
            String par=req.getParameter("del");
            String sql="select * from emp_info where id =\""+par+"\"";             
            ResultSet rs=smt.executeQuery(sql);                     
                while(rs.next()){
                String f,mname,lname,gen,dt,month,rel,year,empd,degn,addr,sal,dom,id,exp;
                f=rs.getString("fn1");
                mname=rs.getString("fn2");
                lname=rs.getString("fn3");
                gen=rs.getString("gender");
                dt=rs.getString("dt");
                month=rs.getString("month");
                year=rs.getString("year");
                rel=rs.getString("religion");
                empd=rs.getString("emp_dep");
                degn=rs.getString("des");
                id=rs.getString("id");
                sal=rs.getString("sal");
                dom=rs.getString("dom");
                exp=rs.getString("exp");
                addr=rs.getString("txt_ar1");
                
                String title="Stored information";
                String docType =
      "<!doctype html public \"-//w3c//dtd html 4.0 " +
      "transitional//en\">\n";
      out.println(docType +
        "<html>\n" +
        "<head><title>" + title + "</title><link href=\"style.css\" rel=\"stylesheet\" type=text/css>"+
             "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"+
        "<style>"+
             "body{ color:#2F5E5E;       font-size: 24px;       background-color: #FFB693;            }"+
           " form{ background-color:#CB9898;  padding: 30px 20px 30px 20px;        }"+
            ".btn {"+
  "background: #3cb0fd;"+
 " background-image: -webkit-linear-gradient(top, #966, #966);"+
  "background-image: -moz-linear-gradient(top, #966, #966);"+
"  background-image: -ms-linear-gradient(top, #966, #966);"+
"  background-image: -o-linear-gradient(top, #966, #966); background-image: linear-gradient(to bottom, #966, #966); -webkit-border-radius: 28;"+
 " -moz-border-radius: 28;"+
  "border-radius: 28px;  font-family: Arial;  color: #ffba8c;  font-size: 24px;  padding: 4px 20px 4px 20px;  border: solid #056aa8 3px;"+
  "text-decoration: none;}"+

".btn:hover {"+
 " background: blue;  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);"+
 " background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);text-decoration: none;"+
"}</style>"       
    
              + "</head>\n" +
"<body>\n" +
"<form action=\"Insert_UpdatedData\" method=\"get\">\n" +
"<br>FIRST-NAME: <input class=\"textbox\" name=\"firstname\" type=\"text\" value=\""+f+"\" />" +
              
"MIDDLE-NAME : <input class=\"textbox\" name=\"middlename\" type=\"text\" value=\""+mname+"\" />\n" +
              
"LAST-NAME : <input class=\"textbox\" name=\"lastname\" type=\"text\" value=\""+lname+"\" /><br/><br/>\n" +
              
  "RELIGION : <input class=\"textbox\" name=\"religion\" type=\"text\" value=\""+rel+"\" />" +
              
   "ID : <input class=\"textbox\" name=\"id\" type=\"text\" value="+id+" /><br><br>\n" +
              
"Gender : MALE<input name=\"gender\" type=\"radio\" value=\"male\" />\n" +
"FEMALE<input name=\"gender\" type=\"radio\" value=\"female\" /><br/><br/>\n" +
"Date Of Birth : <select name=\"date\">\n" +
              "    <option selected=\"selected\">"+dt+"</option>\n"+
"    <option value=\"01\">01</option>\n" +
"  <option value=\"02\">02</option>\n" +
"  <option value=\"03\">03</option>\n" +
"  <option value=\"04\">04</option>\n" +
"  <option value=\"05\">05</option>\n" +
"  <option value=\"06\">06</option>\n" +
"  <option value=\"07\">07</option>\n" +
"  <option value=\"08\">08</option>\n" +
"  <option value=\"09\">09</option>\n" +
"  <option value=\"10\">10</option>\n" +
"  <option value=\"12\">12</option>\n" +
"  <option value=\"13\">13</option>\n" +
"  <option value=\"13\">14</option>\n" +
"  <option value=\"14\">15</option>\n" +
"  <option value=\"16\">16</option>\n" +
"  <option value=\"17\">17</option>\n" +
"  <option value=\"18\">18</option>\n" +
"  <option value=\"19\">19</option>\n" +
"  <option value=\"20\">20</option>\n" +
"  <option value=\"21\">21</option>\n" +
"  <option value=\"22\">22</option>\n" +
"  <option value=\"23\">23</option>\n" +
"  <option value=\"24\">24</option>\n" +
"  <option value=\"25\">25</option>\n" +
"  <option value=\"26\">26</option>\n" +
"  <option value=\"27\">27</option>\n" +
"  <option value=\"28\">28</option>\n" +
"  <option value=\"29\">29</option>\n" +
"  <option value=\"30\">30</option>\n" +
"  <option value=\"31\">31</option>\n" +
"  </select>\n" +
"  <select name=\"month\">\n" +
              "    <option selected=\"selected\">"+month+"</option>\n"+
"      <option value=\"01\">01</option>\n" +
"      <option value=\"02\">02</option>\n" +
"      <option value=\"03\">03</option>\n" +
"      <option value=\"04\">04</option>\n" +
"      <option value=\"05\">05</option>\n" +
"      <option value=\"06\">06</option>\n" +
"      <option value=\"07\">07</option>\n" +
"      <option value=\"08\">08</option>\n" +
"      <option value=\"09\">09</option>\n" +
"      <option value=\"10\">10</option>\n" +
"      <option value=\"11\">11</option>\n" +
"      <option value=\"12\">12</option>\n" +
"\n" +
"  </select>\n" +
"  <select name=\"year\">\n" +
              "    <option selected=\"selected\">"+year+"</option>"+
        "<option value='1980'>1980</option>"+
"<option value='1981'>1981</option>  "+
"<option value='1982'>1982</option>"+
"<option value='1983'>1983</option>"+
"<option value='1984'>1984</option>"+
"<option value='1985'>1985</option>"+
"<option value='1986'>1986</option>"+
"<option value='1987'>1987</option>"+
"<option value='1988'>1988</option>"+
"<option value='1989'>1989</option>"+
"<option value='1990'>1990</option> "+     
"  <option value=\"1991\">1991</option>\n" +
"  <option value=\"1992\">1992</option>\n" +
"  <option value=\"1993\">1993</option>\n" +              
 "  <option value=\"1994\">1994</option>\n" +             
"      <option value=\"1995\">1995</option>\n" +
"  </select><br/><br/>"
              + "Employee Department :<select name=\"emp_dept\">\n" +
              "    <option selected=\"selected\">"+empd+"</option>\n"+
"    <option value=\"A\">A</option>\n" +
"<option value=\"B\">B</option>\n" +
"<option value=\"C\">C</option>\n" +
"<option value=\"D\">D</option>\n" +
              "  </select><br/><br/>"+

"Designation: <input name=\"designation\" type=\"text\" value=\""+degn+"\" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" + 
              
"Salary: <input name=\"salary\" type=\"text\" value="+sal+"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>\n" +
              
 "Experience: <input name=\"e\" type=\"text\" value="+exp+"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
              
"Domicile: <input name=\"domicile\" type=\"text\" value="+dom+"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/>\n" +
              
"Address: <textarea name=\"address\">"+addr+"</textarea>\n<br><br>" +
"<center><input class=\"btn\" name=\"\" type=\"submit\" style=\" margin-bottom: 20px;\"/></center></br>\n" +
"</form>" +
"</div>" +
"</body>" +
"</html>\n");
            }
   }catch(Exception e){
       
   }

}

  
}
