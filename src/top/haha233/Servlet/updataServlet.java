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

@WebServlet(name = "updataServlet", urlPatterns = "/updata")
public class updataServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("先使用了Post");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String score = request.getParameter("score");
		String id = request.getParameter("id");

		int isSucceed = ServiceFactory.getScoreService().update(score, id);
		if (isSucceed > 0) {
			response.getWriter().print("<script >alert('修改成功!');location.href='query?queryStr=';</script>");
		} else {
			response.getWriter().print("<script >alert('修改失败!');location.href='query?queryStr=';</script>");
		}
	}
}
