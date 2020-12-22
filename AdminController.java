package code.microsystem.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import code.microsystem.Entity.Application;
import code.microsystem.Entity.User;
import code.microsystem.Service.AdminService;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("page");
		switch(action)
		{
		case "alogin":adminLogin(request, response);
		break;
		case "aLogout":adminLogout(request, response);
		break;
	    case "changeSt": changeStatus(request, response);
		break;
		case "udelete": userDelete(request, response);
		break;
		case "appDelete": applicationDelete(request, response);
		break;
		default: break;
		}
	}

	private void applicationDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setId(Integer.parseInt(request.getParameter("id")));
		boolean status = AdminService.applicationDelete(u);
		if(status)
		{
			request.getRequestDispatcher("changeApplication.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("changeApplication.jsp").forward(request, response);
		}
	}

	private void userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setId(Integer.parseInt(request.getParameter("id")));
		boolean status = AdminService.userDelete(u);
		if(status)
		{
			request.getRequestDispatcher("showUser.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("showUser.jsp").forward(request, response);
		}
	}

	private void changeStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Application ap = new Application();
		ap.setId(Integer.parseInt(request.getParameter("id")));
		ap.setName(request.getParameter("name"));
		ap.setEmail(request.getParameter("email"));
		ap.setStatus(request.getParameter("status"));
		
		boolean st = AdminService.changeStatus(ap);
		if(st)
		{
			request.getRequestDispatcher("changeApplication.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("changeApplication.jsp").forward(request, response);
		}
		
	}

	private void adminLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("msg", "You are Successfully Logout!!!");
		request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	}

	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean status = AdminService.loginAdmin(email, password);
		if(status)
		{
			request.setAttribute("msg", "You are Successfully Loged In");
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Email and Password are incorrect");
			System.out.println("Error in Login");
			request.getRequestDispatcher("adminLogin.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
