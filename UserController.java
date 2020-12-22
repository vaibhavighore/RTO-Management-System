package code.microsystem.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import code.microsystem.Entity.PaymentD;
import code.microsystem.Entity.User;
import code.microsystem.Service.UserService;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("page");
		switch(action)
		{
		case "ureg":registration(request, response);
		break;
		case "userLogout":userLogout(request, response);
		break;
		case "ulogin":userLogin(request, response);
		break;
		case "checkPass": checkPassword(request, response);
		break;
		case "udriving": userDriving(request, response);
		break;
		case "payment": paymentUser(request, response);
		break;
		case "updateProfile": updateProfile(request, response);
		break;
		default : break;
		}
	}

	private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setId(Integer.parseInt(request.getParameter("id")));
		u.setTest(request.getParameter("test"));
		u.setName(request.getParameter("name"));
		u.setDob(request.getParameter("dob"));
		u.setAge(request.getParameter("age"));
		u.setAadhar(request.getParameter("aadhar"));
		u.setAddress(request.getParameter("address"));
		u.setMobile(request.getParameter("mobile"));
		u.setEmail(request.getParameter("email"));
		u.setGender(request.getParameter("gender"));
		u.setPassword(request.getParameter("password"));
		u.setCity(request.getParameter("city"));
		u.setState(request.getParameter("state"));
		u.setZip(request.getParameter("zip"));
		//u.setCreated(request.getParameter("created"));
		boolean status = UserService.updateProfle(u);
		if(status)
		{
			System.out.println("Updated");
			request.setAttribute("msg", "You are Successfully Updated");
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Error in Updation");
			request.setAttribute("msg", "You are Successfully Updated");
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
		}
	}
	private void paymentUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentD p = new PaymentD();
		p.setName(request.getParameter("name"));
		p.setPay(request.getParameter("pay"));
		p.setCardno(request.getParameter("cardno"));
		p.setMon(request.getParameter("mon"));
		p.setYear(request.getParameter("year"));
		p.setCvv(request.getParameter("cvv"));
		boolean status = UserService.paymentUser(p);
		if(status)
		{
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		else
		{
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}

	private void userDriving(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		if(email!=null)
		{
			System.out.println("Payment Done");
			request.getRequestDispatcher("Payment.jsp").include(request, response);
		}
		else
		{
			System.out.println("Payment not done");
			request.getRequestDispatcher("applyDriving.jsp").forward(request, response);
		}
	}

	private void checkPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("cemail");
	System.out.println(email);
	User user = UserService.checkPassword(email);
	HttpSession session = request.getSession();
	boolean status = user.isLogin();
		 if(status)
		 {
			 session.setAttribute("email", email);
			 //session.setAttribute("name", user.getName());
			 System.out.println(".....Change Pass");
			 request.getRequestDispatcher("changePass.jsp").forward(request, response);
		 }else
	 {
			 System.out.println(".....NotChange Pass");
			 request.getRequestDispatcher("checkPass.jsp").include(request, response);
		 }
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//System.out.println("---------------------------------->1");
		
		
		User user =  UserService.loginUser(email, password);
		HttpSession session = request.getSession();
		//System.out.println("2");
		boolean status = user.isLogin();
		if(status)
		{
			session.setAttribute("email", email);
			//session.setAttribute("id", user.getId());
			request.setAttribute("msg", "You are Successfully Loged In!!!");
			request.getRequestDispatcher("userHome.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("msg", "Email and Password are Incorrect!!");
			request.getRequestDispatcher("userLogin.jsp").include(request, response);
		}
	}

	private void userLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("msg", "You are Successfully Logout");
		request.getRequestDispatcher("userLogin.jsp").forward(request, response);
	}

	private void registration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		u.setTest(request.getParameter("test"));
		u.setName(request.getParameter("name"));
		u.setDob(request.getParameter("dob"));
		u.setAge(request.getParameter("age"));
		u.setAadhar(request.getParameter("aadhar"));
		u.setAddress(request.getParameter("address"));
		u.setMobile(request.getParameter("mobile"));
		u.setEmail(request.getParameter("email"));
		u.setGender(request.getParameter("gender"));
		u.setPassword(request.getParameter("password"));
		u.setCity(request.getParameter("city"));
		u.setState(request.getParameter("state"));
		u.setZip(request.getParameter("zip"));
		boolean status = UserService.saveData(u);
		if(status)
		{
			request.setAttribute("msg", "You are Successfully Registered");
			request.getRequestDispatcher("userHome.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("userLogin.jsp").include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
