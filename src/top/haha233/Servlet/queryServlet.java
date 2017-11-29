package top.haha233.Servlet;

import top.haha233.DAO.ScoreDAO;
import top.haha233.entity.Score;
import top.haha233.service.ScoreService;
import top.haha233.service.ServiceFactory;
import top.haha233.service.util.SuperInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "queryServlet", urlPatterns = "/query")
public class queryServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key = request.getParameter("queryStr");
		SuperInfo si = ServiceFactory.getScoreService().query(key);
		if (si.ret == 1) {
			response.sendRedirect("Main.jsp");
		} else {
			//转发至原先的queryScore.jsp 查询页面
			if (si.retMap==null){
				response.sendRedirect("Error.html");
			}
			request.setAttribute("scoresDate", si);
			request.getRequestDispatcher("queryScore.jsp").forward(request, response);
		}
	}
}
