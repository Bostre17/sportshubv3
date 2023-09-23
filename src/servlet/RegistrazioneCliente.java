package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
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
import beans.User;

public class RegistrazioneCliente extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public void init(){

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");


		
		Cliente cl=new Cliente(username,password,nome,cognome);
		List<Cliente> listClienti=(ArrayList<Cliente>) this.getServletContext().getAttribute("listClienti");
		listClienti.add(cl);
		this.getServletContext().setAttribute("listClienti", listClienti);
		
		
		Log.writeLog(cl.getUsername(), LocalDateTime.now(), "si è registrato");
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		
		
		/*
		List<Group>gruppi=(List<Group>) this.getServletContext().getAttribute("gruppi");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int group=Integer.parseInt(req.getParameter("group"));
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setDataPassword(java.time.LocalDate.now());
		
		//aggiungo utente all' gruppo a cui è assegnato
		gruppi.get(group).aggiungiUtente(user);
		
		RequestDispatcher disp= this.getServletContext().getRequestDispatcher("/index.jsp");
		disp.forward(req, resp);
		*/
		
	}

}
