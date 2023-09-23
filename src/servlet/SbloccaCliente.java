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

public class SbloccaCliente extends HttpServlet{

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
		
		String username = req.getParameter("nomeCliente");		
		
		
		
		//controllo se è un personal trainer
		List<Cliente> listClienti=(ArrayList<Cliente>) this.getServletContext().getAttribute("listClienti");
		for(Cliente cl : listClienti) {
			if(username.equals(cl.getUsername())) {
				if(cl.getStato()=="Attivo") {
					cl.setStato("Bloccato");
					Log.writeLog("admin", LocalDateTime.now(), "bloccaggio cliente");
				}
				else {
					cl.setStato("Attivo");
					Log.writeLog("admin", LocalDateTime.now(), "sbloccaggio cliente");
				}
			}
			
		}
		
		this.getServletContext().setAttribute("listClienti", listClienti);
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/visualizzaClienti_admin.jsp");
		rd.forward(req, resp);
		return;
		
	}
	
	

}
