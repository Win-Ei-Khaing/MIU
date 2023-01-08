package support;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/support")
public class ComplainForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        String supportEmail = sc.getInitParameter("support-email");
        String userName = req.getParameter("user_name");
        String user_email_address = req.getParameter("user_email_address");
        String problem = req.getParameter("problem");
        String problem_description = req.getParameter("problem_description");
        resp.getWriter().print("Thank you! " + userName + " for contacting us. We should receive reply from us with in 24 hrs in\n" +
                "your email address " + user_email_address + " Let us know in our support email " + supportEmail + " if\n" +
                "you don’t receive reply within 24 hrs. Please be sure to attach your reference\n" +
                " in your email.");


    }
}
