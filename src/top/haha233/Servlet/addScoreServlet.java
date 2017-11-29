package top.haha233.Servlet;

import top.haha233.DAO.ScoreDAO;
import top.haha233.entity.Course;
import top.haha233.entity.Score;
import top.haha233.entity.Student;
import top.haha233.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addScoreServlet", urlPatterns = "/Add")
public class addScoreServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String stuid = request.getParameter("stuid");
		String courseid = request.getParameter("course");
		String score = request.getParameter("score");

		int isSucceed = ServiceFactory.getScoreService().addScore(stuid, courseid, score);

		if (isSucceed > 0) {
			response.getWriter().print("<script >alert('添加成功!');location.href='Main.jsp';</script>");
		} else {
			response.getWriter().print("<script >alert('添加失败!');location.href='Main.jsp';</script>");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
