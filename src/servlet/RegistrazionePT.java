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

public class RegistrazionePT extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	@Override
	public void init(){

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String nome=req.getParameter("nome");
		String cognome=req.getParameter("cognome");
		
		
		// Creazione del formato per la data
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Creazione della data di nascita
		String data=req.getParameter("data");
		LocalDate dataNascita = LocalDate.parse(data, formatoData);
		
		PersonalTrainer pt=new PersonalTrainer(username, password, nome, cognome, dataNascita);
		
		List<PersonalTrainer> listPT=(ArrayList<PersonalTrainer>) this.getServletContext().getAttribute("listPT");
		listPT.add(pt);
		this.getServletContext().setAttribute("listPT", listPT);
		Log.writeLog("admin", LocalDateTime.now(), "aggiunta PersonalTrainer");
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/admin.jsp");
		rd.forward(req, resp);
		
		
		
	}

}
