package top.haha233.Servlet;

import top.haha233.entity.Score;
import top.haha233.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updataBeforeServlet", urlPatterns = {"/updataBefore"})
public class updataBeforeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		Score score = ServiceFactory.getScoreService().queryById(id);
		if (score == null) {
			response.getWriter().print("<script >alert('操作有误！');location.href='Main.jsp';</script>");
		} else {
			request.setAttribute("score", score);
			request.getRequestDispatcher("updata.jsp").forward(request, response);
		}
	}
}
