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

/**
 *
 * @author fatema
 */
public class Update_Data extends HttpServlet {

     private static final String DRIVER_CLASS="org.gjt.mm.mysql.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD="";  
    private Connection con;
   
  
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try{
        PrintWriter out=res.getWriter();
          Class.forName(DRIVER_CLASS);
          
          con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
         String x=req.getParameter("del");
         PreparedStatement smt= (PreparedStatement)con.prepareStatement("select * from emp_info where id=?");        
        smt.setString(1, x);
         ResultSet rs=smt.executeQuery();
      String y = null;
           
          while(rs.next())
          {
              String x1=rs.getString("fn1");
               y=rs.getString("fn2");
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
              String a14=rs.getString("txt_ar2");
              out.println(a1);
         res.setContentType("text/html");
          out.println("<html>\n" +
                "<head><title>" + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" + "<form action=\"InsertData\" method=\"get\" style=\"border:double #966\">\n" +
"<center><strong>Employee Information Form</strong></center>\n" +
"</br>\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;First Name</label>\n" +
"<input name=\"fn1\" type=\"text\" value="+x1+" size=\"40\" maxlength=\"100\" />\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Middle Name</label>\n" +
"<input name=\"fn2\" type=\"text\" value="+y+"  size=\"40\" maxlength=\"100\" />\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Last Name</label>\n" +
"<input name=\"fn3\" type=\"text\" value="+z+"  size=\"40\" maxlength=\"100\" />\n" +
"</br>\n" +
"</br>\n" );
          if(a1.equals("male"))
              out.println(
"Gender : MALE<input name=\"gender\" type=\"radio\" selected=\"selected\" value=\"male\" />\n"+
 " FEMALE<input name=\"gender\" type=\"radio\" value=\"null\" />\n"
);
          else
              out.println(
                      "Gender : MALE<input name=\"gender\" type=\"radio\"  value=\"null\" />\n"+
 " FEMALE<input name=\"gender\" type=\"radio\"   value=\"female\" />\n"
);
                      
          
          out.println(
"Gender : MALE<input name=\"gender\" type=\"radio\" value=\"male\" />\n" +
"FEMALE<input name=\"gender\" type=\"radio\" value=\"female\" /><br/><br/>\n" +
"Date Of Birth : <select name=\"date\">\n" +
              "    <option selected=\"selected\">"+a3+"</option>\n"+
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
              "    <option selected=\"selected\">"+a4+"</option>\n"+
"      <option value=\"JAN\">JAN</option>\n" +
"      <option value=\"FEB\">FEB</option>\n" +
"      <option value=\"MAR\">MAR</option>\n" +
"      <option value=\"APR\">APR</option>\n" +
"      <option value=\"MAY\">MAY</option>\n" +
"      <option value=\"JUN\">JUN</option>\n" +
"      <option value=\"JUL\">JUL</option>\n" +
"      <option value=\"AUG\">AUG</option>\n" +
"      <option value=\"SEP\">SEP</option>\n" +
"      <option value=\"OCT\">OCT</option>\n" +
"      <option value=\"NOV\">NOV</option>\n" +
"      <option value=\"DEC\">DEC</option>\n" +
"\n" +
"  </select>\n" +
"  <select name=\"year\">\n" +
              "    <option selected=\"selected\">"+a5+"</option>\n"+
"      <option value=\"1995\">1995</option>\n" +
"  <option value=\"1994\">1994</option>\n" +
"  <option value=\"1993\">1993</option>\n" +
"  <option value=\"1992\">1992</option>\n" +
"  <option value=\"1991\">1991</option>\n" +
                  
  "  </select><br/><br/>Employee Department: <select name=\"emp_dep\" >\n"+
                   "    <option selected=\"selected\">"+a6+"</option>\n"+
"<option value=\"A\">A</option>"+
"<option value='B'>B</option>"+
"<option value='C'>C</option>"+
"<option value='D'>D</option>"+
"</select>"+
                  
"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Religion</label>\n" +
"<input name=\"religion\" type=\"text\" value="+a2+"  size=\"40\" maxlength=\"100\" />\n" +
"</br>\n" +


"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; \n" +
"&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Designation</label>\n" +
"<input name=\"des\" type=\"text\" value="+a7+"  size=\"40\" maxlength=\"100\" />\n" +
"</br></br>\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Employee-ID</label>\n" +
"<input name=\"id\" type=\"text\" value="+a8+"  size=\"40\" maxlength=\"100\" />\n" +
"<label>&nbsp; &nbsp; &nbsp; Experience</label>\n" +
"<input name=\"exp\" type=\"text\" value="+a10+"  size=\"40\" maxlength=\"100\" />\n" +
"</br></br>\n" +
"<label>&nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;Salary</label>\n" +
"<input name=\"sal\" type=\"text\" value="+a11+"  size=\"6\" maxlength=\"100\" />\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; Domicile</label>\n" +
"<input name=\"dom\" type=\"text\" value="+a12+"  size=\"40\" maxlength=\"100\" />\n" +
"</br></br>\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Present Address &nbsp; &nbsp; &nbsp;</label>\n" +
"<textarea name=\"txt_ar1\" cols=\"30\" value="+a13+" rows=\"3\"></textarea>\n" +
"</br></br>\n" +
"<label>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Permanent Address</label>\n" +
"<textarea name=\"txt_ar2\" cols=\"30\" value="+a14+" rows=\"3\"></textarea>\n" +
"</br></br>\n" +
"<center> <input name=\"SUBMIT\" type=\"submit\"  value=\"SUBMIT\" style=\"border:double\" /></center>\n" +
"</br></br>\n" +
"\n" +
"</form>\n"  );
           out.println("</table>"+
                "</body></html>");
          }
        
        
    }    catch (Exception ex) {
            ex.printStackTrace();
         }
}
}

    
