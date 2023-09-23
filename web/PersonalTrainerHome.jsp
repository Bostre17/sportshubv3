<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<%@ page session="true"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB" %>
<%@page import="java.sql.PreparedStatement" %>

<!-- import di classi Java -->
<%@ page import="beans.User"%>
<%@ page import="beans.Group"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>PersonalTrainer</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Includi qui i tuoi fogli di stile CSS -->
  <link rel="stylesheet" href="styles/styles.css">
</head>

<body>
	
  
  
    <header>
    	<img class="logo" src="images/Logo.png">
    	<h1 class="app-name">FitFlow</h1>
  	</header>
  
  <main>
    <!-- Inserisci qui il contenuto principale della pagina -->
    <div class="container">
      <div class="TitoloPagina">
          <h1>HOME PERSONAL TRAINER</h1>

      </div>
		<p>Benvenuto <%= session.getAttribute("username")  %></p>
      <div class="azioniCliente">
      
      	<form action="visualizzaClienti_pt.jsp" method="POST" class="inline-form">
        	<input id="btn"  type="submit" value="Visualizza Clienti" size="40"/>
        </form>
        
        <form action="CreazioneScheda.jsp" method="POST" class="inline-form">
        	<input id="btn" type="submit" value="Creazione Scheda" size="40"/>
        </form>
        <form action="CreazioneSessione.jsp" method="POST" class="inline-form">
        	<input id="btn" type="submit" value="Gestione Calendario" size="40"/>
        </form>
        
      </div>

    </div>
  
  </main>
  
  
  <footer>
    <!-- Inserisci qui il piè di pagina (es. informazioni di contatto, link utili) -->
    <form action="index.jsp">
    	
    	<input id="btn-back" type="submit" value="LogOUT" size="40">
    </form>
  </footer>
  
  <!-- Includi qui i tuoi script JavaScript -->
  <script src="script.js"></script>
</body>
</html>
