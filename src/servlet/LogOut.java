package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


import beans.*;

public class LogOut extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson g;

	@Override
	public void init(ServletConfig conf)throws ServletException{
		super.init(conf);
		g=new Gson();
		
		
	
	
	}
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		String tipo = req.getParameter("tipo");
		System.out.println("tipo in servlet: "+tipo);
		if(tipo.equals("admin")) {
			session.setAttribute("admin", false);
			System.out.println((Boolean)session.getAttribute("admin"));
		}
		else if(tipo.equals("Cliente")) {
			session.setAttribute("Cliente", false);
		}else if(tipo.equals("PersonalTrainer")) {
			session.setAttribute("PersonalTrainer", false);
		}
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		return;
		
	}
	
	

}
