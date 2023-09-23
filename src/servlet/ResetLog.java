package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cliente;
import beans.Group;
import beans.Log;
import beans.PersonalTrainer;
import beans.User;

public class ResetLog extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public void init(){

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Log.resetLog();
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/visualizzaLOG_admin.jsp");
		rd.forward(req, resp);
		
		
		
	}

}
