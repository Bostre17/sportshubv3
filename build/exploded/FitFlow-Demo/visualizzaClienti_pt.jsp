<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- import di classi Java -->
<%@ page import="beans.User"%>
<%@ page import="beans.Group"%>
<%@ page import="java.util.*"%>
<%@ page import="beans.Cliente" %>
<%@ page import="beans.Log" %>
<%@ page import="java.time.LocalDateTime" %>

<!DOCTYPE html>
<html>
<head>
  <title>VisualizzaClientiPersonalTrainer</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Includi qui i tuoi fogli di stile CSS -->
  <link rel="stylesheet" href="styles/styles.css">
  
</head>
<body>
  <!-- Inserisciii qui il contenuto della pagina -->
  
  <header>
    <img class="logo" src="images/Logo.png">
    <h1 class="app-name">FitFlow</h1>
  </header>
  
  <main>
    <!-- Inserisci qui il contenuto principale della pagina -->
    <div class="container">
      <div class="TitoloPagina">
          <h1>VISUALIZZA CLIENTI</h1>
      </div>
<%
	List<Cliente> listClienti=(ArrayList<Cliente>) this.getServletContext().getAttribute("listClienti");
	Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "visualizza Clienti");
	for(Cliente cl:listClienti){
			
		
%>
    <div class="elenco">
    
                <h2><%= cl.getUsername() %></h2>
                <h2><%= cl.getNome() %></h2>   
                <h2><%= cl.getCognome() %></h2>
                <h2><%= cl.getStato() %></h2>    
                
                -------------------------------------------------------------
                </div>
    
<%
	}
%>
  
  </main>
  
  <footer>
    <!-- Inserisci qui il piè di pagina (es. informazioni di contatto, link utili) -->
    <form action="PersonalTrainerHome.jsp">
    	<input id="btn-back" type="submit" value="Back" size="40">
    </form>
  </footer>
  
  <!-- Includi qui i tuoi script JavaScript -->
  <script src="script.js"></script>
</body>
</html>
