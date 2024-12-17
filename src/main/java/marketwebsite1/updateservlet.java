package marketwebsite1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/update")
public class updateservlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username= req.getParameter("username");
	String email= req.getParameter("email");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy","root","root");
		
		String sql="update register set email=? where username=?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setString(1, email);
		pmst.setString(2, username);
		int i=pmst.executeUpdate();
		if(i>0) {
			resp.sendRedirect("welcome.jsp");
		}else {
			resp.sendRedirect("update.jsp");
		}
		pmst.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}

