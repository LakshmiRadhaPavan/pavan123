package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnection.WorkerDb;
import Models.WorkersModel;
import Service.WorkerService;
@WebServlet("/insert")
public class WorkerServlets extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String field = req.getParameter("field");
		Long phno = Long.parseLong(req.getParameter("phno"));
		int salary = Integer.parseInt(req.getParameter("salary"));
		WorkersModel worker = new WorkersModel(0,name,field,phno,salary);
		WorkerService ser = new WorkerService(WorkerDb.getcon());
		boolean i = ser.addworker(worker);
		if(i) {
			resp.sendRedirect("Welcome.jsp");
		}
		else {
			resp.sendRedirect("error.jsp");
		}
	}
}
