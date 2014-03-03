package com.example.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.classes.*;

/**
 * Servlet implementation class MainServelet
 */
@WebServlet("/MainServelet")
public class MainServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");

		String name = request.getParameter("name");
		String roll = request.getParameter("roll");
		String age = request.getParameter("age");

		
		
		if (operation.equals("create")){
			MysqlAccess db =  new MysqlAccess();
			
			
			try {
				response.getWriter().println(db.readDataBase());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		else if (operation.equals("update")){
			response.getWriter().println("update Operation was called");}
		else if (operation.equals("delete")){
			response.getWriter().println("Delete Operation was called");}
		else{
			response.getWriter().println("Delete Operation was called");}
		
		
	}

}
