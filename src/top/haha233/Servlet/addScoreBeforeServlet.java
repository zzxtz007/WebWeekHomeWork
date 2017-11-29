package top.haha233.Servlet;

import top.haha233.entity.Course;
import top.haha233.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "addScoreBeforeServlet", urlPatterns = "/addScoreBefore")
public class addScoreBeforeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有的课程号
		ArrayList<Course> courses = ServiceFactory.getCourseService().addScoreBefore();
		//判断是否为空 空为没有值 转入错误界面
		if (courses != null) {
			request.setAttribute("allCourses", courses);
			request.getRequestDispatcher("addScore.jsp").forward(request, response);
		} else {
			response.sendRedirect("Error.html");
		}
	}
}
