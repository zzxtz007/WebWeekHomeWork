package top.haha233.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.HttpCookie;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String cookieStr = java.net.URLEncoder.encode("神様", "UTF-8");            //编码
//		String   str   =   java.net.URLDecoder.decode("编码后的字符串","UTF-8");   // 解码
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("username");
		String pwd = request.getParameter("password");
		String ck = request.getParameter("ck");

		if ("admin".equals(uid) && "admin".equals(pwd))
		{
			Cookie cookie = new Cookie("userinfo", cookieStr);
			if ("on".equals(ck))
			{
				cookie.setMaxAge(60 * 60);
			} else
			{
				cookie.setMaxAge(0);
			}
			HttpSession session = request.getSession();
			session.setAttribute("userinfo","神様");
			response.addCookie(cookie);
			response.sendRedirect("Main.jsp");
		} else
		{

			response.getWriter().print("<script >alert('acount or password error!');location.href='login.html';</script>");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
}
