<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- import di classi Java -->
<%@ page import="beans.User"%>
<%@ page import="beans.Group"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>HomeAmministratore</title>
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
          <h1>HomeAmministratore</h1>
      </div>

      <div class="azioniCliente">
      	<form action="visualizzaPT_admin.jsp">
      		<input id="btn" type="submit" value="Visualizza PT" size="40"/>
      	</form>
      	<form action="aggiungiPT_admin.jsp">
      		<input id="btn" type="submit" value="Aggiungi PT" size="40"/>
      	</form>
      	<form action="visualizzaClienti_admin.jsp">
      		<input id="btn" type="submit" value="Visualizza Clienti" size="40"/>
      	</form>
      	<form action="visualizzaLOG_admin.jsp">
      		<input id="btn" type="submit" value="Visualizza LOG" size="40"/>
      	</form>
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
