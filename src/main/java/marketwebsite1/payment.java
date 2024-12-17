package marketwebsite1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/payment")
public class payment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cardname = req.getParameter("cardholdername");
		String cardno = req.getParameter("cardnumber");
		String expiry = req.getParameter("expirydate");
		String cv = req.getParameter("cvv");
		try {
			PrintWriter pw = resp.getWriter();

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy", "root", "root");

			String sql = "insert into paymentdetails(cardholdername,cardnumber,expirydate,cvv)values(?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, cardname);
			pmst.setString(2, cardno);
			pmst.setString(3, expiry);
			pmst.setString(4, cv);
			int i = pmst.executeUpdate();
			if (i > 0) {
				pw.println("successfully inserted.");
			} else {
				pw.println("Error");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
