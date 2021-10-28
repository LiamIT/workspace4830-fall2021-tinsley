
/**
 * @file SimpleFormInsert.java
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertTinsley")
public class InsertTinsley extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public InsertTinsley() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String hwName = request.getParameter("hwName");
      String className = request.getParameter("className");
      String professorName = request.getParameter("professorName");
      String dueDate = request.getParameter("dueDate");
      String workTime = request.getParameter("workTime");

      Connection connection = null;
      String insertSql = " INSERT INTO MyTableTechEXTinsley (id, HW_NAME, CLASS_NAME, PROFESSOR_NAME, DUE_DATE, WORK_TIME) values (default, ?,?,?,?,?)";

      try {
         DBConnectionTinsley.getDBConnection();
         connection = DBConnectionTinsley.connection;
         PreparedStatement preparedStmt = connection.prepareStatement(insertSql);
         preparedStmt.setString(1, hwName);
         preparedStmt.setString(2, className);
         preparedStmt.setString(3, professorName);
         preparedStmt.setString(4, dueDate);
         preparedStmt.setString(5, workTime);
         preparedStmt.execute();
         connection.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Insert New Homework into Homework Manager";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h2 align=\"center\">" + title + "</h2>\n" + //
            "<ul>\n" + //

            "  <li><b>Hw Name</b>: " + hwName + "\n" + //
            "  <li><b>Class Name</b>: " + className + "\n" + //
            "  <li><b>Professor Name</b>: " + professorName + "\n" + //
            "  <li><b>Due Date</b>: " + dueDate + "\n" + //
            "  <li><b>Work Time</b>: " + workTime + "\n" + //

            "</ul>\n");

      out.println("<a href=/webproject-techex-tinsley/search_tinsley.html>Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}
