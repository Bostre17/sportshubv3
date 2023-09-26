<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- import di classi Java -->
<%@ page import="beans.User"%>
<%@ page import="beans.Group"%>
<%@ page import="beans.*"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.util.*"%>
<%@ page import="beans.PersonalTrainer" %>

<!DOCTYPE html>
<html>
<head>
  <title>VisualizzaPTCliente</title>
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
          <h1>VISUALIZZA PERSONAL TRAINER</h1>
      </div>
<%
	List<PersonalTrainer> listPT=(ArrayList<PersonalTrainer>) this.getServletContext().getAttribute("listPT");
	Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "visualizza personal trainer");
	for(PersonalTrainer pt:listPT){
			
		
%>
    <div class="elenco">
    
                <h2><%= pt.getUsername() %></h2>     
                   <%= pt.getNome() %>
                   <%= pt.getCognome() %>
                   <%= pt.getDataNascita() %>
                
                -------------------------------------------------------------
                </div>
    
<%
	}
%>
  
  </main>
  
  <footer>
    <!-- Inserisci qui il piè di pagina (es. informazioni di contatto, link utili) -->
    <form action="HomeCliente.jsp">
    	<input id="btn-back" type="submit" value="Back" size="40">
    </form>
  </footer>
  
  <!-- Includi qui i tuoi script JavaScript -->
  <script src="script.js"></script>
</body>
</html>
