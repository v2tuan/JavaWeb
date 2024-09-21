package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.models.UserModel;
import vn.iostar.services.impl.UserService;
import vn.iostar.utils.Constant;

@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotPasswordController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2824464191318510653L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/forgotpassword.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		UserService service = new UserService();
		UserModel user = service.findByUserName(username);
		String alertMsg = "";
		if (user != null) {
			alertMsg = user.getPassword();
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.FORGOTPASSWORD).forward(req, resp);
			return;
		}
		else {
			alertMsg = "User Name không tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant.FORGOTPASSWORD).forward(req, resp);
			return;
		}
	}
}
