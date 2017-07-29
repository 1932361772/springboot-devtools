package com.itmuch.cloud.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("------------IndexServlet doGet.......");	// TODO Auto-generated method stub
		resp.getWriter().print("hello word!!!!!!!!!");
		resp.getWriter().flush();
		resp.getWriter().close();
		// super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("------------IndexServlet doPost.......");	// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
