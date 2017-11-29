package top.haha233.Servlet;

import top.haha233.DAO.ScoreDAO;
import top.haha233.entity.Score;
import top.haha233.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteServlet", urlPatterns = "/delete")
public class deleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		int isSucceed = ServiceFactory.getScoreService().deleteScore(id);
		if (isSucceed > 0) {
			response.getWriter().print("<script >alert('删除成功!');location.href='query?queryStr=';</script>");
		} else {
			response.getWriter().print("<script >alert('删除失败!');location.href='query?queryStr=';</script>");
		}
	}
}
