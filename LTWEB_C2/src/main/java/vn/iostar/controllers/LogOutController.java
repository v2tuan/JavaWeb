package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/logout"})
public class LogOutController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3225943328990143901L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Hủy session nếu có
        HttpSession session = req.getSession(false); // Không tạo session mới
        if (session != null) {
            session.invalidate(); // Hủy session
        }

        // Xóa cookie "username" nếu tồn tại
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    cookie.setMaxAge(0); // Đặt thời gian sống của cookie về 0 để xóa nó
                    cookie.setPath("/"); // Đảm bảo cookie có thể bị xóa trên toàn bộ ứng dụng
                    resp.addCookie(cookie); // Gửi cookie đã xóa về trình duyệt
                }
            }
        }

        // Chuyển hướng người dùng về trang đăng nhập
        resp.sendRedirect(req.getContextPath() + "/login");
	}

}
