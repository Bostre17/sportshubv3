<%@ page session="true"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB" %>
<%@page import="java.sql.PreparedStatement" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Sessione"%>


<!DOCTYPE html>
<html>
<head>
  <title>Creazione Sessione</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Includi qui i tuoi fogli di stile CSS -->
  <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
  <!-- Inserisci qui il contenuto della pagina -->
  
  <!--<header class="instestazione">
    <!-- Inserisci qui l'intestazione della pagina (es. logo, menu di navigazione) 
    <div class="intestazione">
        <img src="IMG/Logo.png" alt="Descrizione dell'immagine" class="logo">
        <h1 class="intestazione" id="nome">Fit-Flow</h1>
    </div>    

  </header> -->

  <header>
    <img class="logo" src="images/Logo.png">
    <h1 class="app-name">FitFlow</h1>
  </header>
  
  <main>
    <!-- Inserisci qui il contenuto principale della pagina -->
    <div class="TitoloPagina">
        <h1>Creazione Sessione</h1>
    </div>

    <div class="inputForm">
      <form action="Calendario" method="post" >
      
        <h3>Nome sessione:</h3>
        <input type="text" name="nome" size="30" required /><br>
        <h3>Numero partecipanti:</h3>
        <input type="text" name="numero" size="30" required /><br>
        <h3>Data:</h3>
        <input type="date" name="data" size="40" required /><br>
        <h3>Orario:</h3>
        <input type="time" name="orario" size="40" required /><br>
        
        <h3>Durata:</h3>
        <input type="text" name="durata" size="40" required /><br>
        <br>
        <input id="btn" type="submit" name="tipo" value="aggiungiSessione" size="40"/>
      </form>

    </div>
    <h2>Sessioni create:</h2>
    
    <%
    
    List<Sessione> sessioni=(ArrayList<Sessione>) this.getServletContext().getAttribute("sessioni");

    if(sessioni!=null){
    for(Sessione s : sessioni){
    	if(s.getPt().equals((String)session.getAttribute("username"))){
    		
	    	
	    	%><h4>Nome sessione: <%=s.getNome() %></h4>
	    	<p>Massimo partecipanti: <%=s.getMassimoPartecipanti() %></p>
	    	<p>Partecipanti: <%=s.getClientiInscritti().toString() %></p>
	    	 <form action="Calendario" method="post" >
	    	 <input type="text" name="id" value=<%=s.getId() %> style="display: none;">
	    	<input id="btn" type="submit" name="tipo" value="eliminaSessione" size="40"/>
      		
      		</form>
	    	<br><br><% 
	    	
	    	}
    	}
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
