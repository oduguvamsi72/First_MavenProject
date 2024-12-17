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
	String password= req.getParameter("password");
	String Npassword= req.getParameter("newpassword");
	String CNpassword= req.getParameter("confirmnewpassword");

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy","root","root");
		
		String sql="update register set password=?,password=? where password=?";
		PreparedStatement pmst=conn.prepareStatement(sql);
		pmst.setString(1, Npassword);
		pmst.setString(2, CNpassword);
		pmst.setString(3, password);

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

