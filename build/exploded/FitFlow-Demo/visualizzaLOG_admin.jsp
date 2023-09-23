<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- import di classi Java -->
<%@ page import="beans.User"%>
<%@ page import="beans.Group"%>
<%@ page import="java.util.*"%>
<%@ page import="beans.Cliente" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.IOException" %>

<!DOCTYPE html>
<html>
<head>
  <title>VisualizzaLOGAdmin</title>
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
          <h1>VISUALIZZA LOG ADMIN</h1>
      </div>
      
      
      
      <form action="ResetLog">
      	<input id="btn" type="submit" value="Reset LOG" size="40"/>
    </form>
    
    </br>
<%
	Boolean flagLogIn=(Boolean)session.getAttribute("admin");

	if(flagLogIn !=null && flagLogIn == true)
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader("log.txt"));
			String line;
			while((line = reader.readLine()) != null) {
				%>
				<p><%=line%></p>
				<%
			}
			

            System.out.println(" \n----------------- \nContenuto scritto nel file con successo.");
			
		}catch(IOException e) {
			System.out.println("Si è verificato un errore sulla scrittura del log");
		}
		
	}
			
		
%>
	
	</div>
  
  </main>
  
  <footer>
    <!-- Inserisci qui il piÃ¨ di pagina (es. informazioni di contatto, link utili) -->
    <form action="admin.jsp">
    	<input id="btn-back" type="submit" value="Back" size="40">
    </form>
  </footer>
  
  <!-- Includi qui i tuoi script JavaScript -->
  <script src="script.js"></script>
</body>
</html>
