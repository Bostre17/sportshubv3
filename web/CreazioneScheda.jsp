<%@ page session="true"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB" %>
<%@page import="java.sql.PreparedStatement" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Sessione"%>
<%@page import="beans.Cliente"%>


<!DOCTYPE html>
<html>
<head>
<script>
function aggiornaNumeroInput() {
    var numeroDesiderato = document.getElementById("numeroEs").value;
    var container = document.getElementById("containerInput");

    // Rimuovi tutti i vecchi input
    while (container.firstChild) {
      container.removeChild(container.firstChild);
    }

    // Genera i nuovi input in base al numero desiderato
    for (var i = 0; i < numeroDesiderato; i++) {
      // Crea un elemento <label> per la descrizione
      var label = document.createElement("label");
      label.textContent = "NomeEs " + (i + 1)+":";
      container.appendChild(label);

      // Crea un elemento <input> per l'input
      var input = document.createElement("input");
      input.type = "text";
      input.name = "nomeEs" + i;
      container.appendChild(input);
      
      var label = document.createElement("label");
      label.textContent = "    Serie:";
      container.appendChild(label);

      // Crea un elemento <input> per l'input
      var input = document.createElement("input");
      input.type = "text";
      input.name = "serie" + i;
      container.appendChild(input);
      
      var label = document.createElement("label");
      label.textContent = "    Ripetizioni" ;
      container.appendChild(label);

      // Crea un elemento <input> per l'input
      var input = document.createElement("input");
      input.type = "text";
      input.name = "ripetizioni" + i;
      container.appendChild(input);
      
      var label = document.createElement("label");
      label.textContent = "    Recupero" ;
      container.appendChild(label);

      // Crea un elemento <input> per l'input
      var input = document.createElement("input");
      input.type = "text";
      input.name = "recupero" + i;
      container.appendChild(input);

      // Aggiungi un salto di linea tra gli elementi
      container.appendChild(document.createElement("br"));
    }
  }
</script>
  <title>Creazione Scheda</title>
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
        <h1>Creazione Scheda</h1>
    </div>
    <%int numeroEs=1; %>
    
    <div class="inputForm">
      <form action="CreaScheda" method="post" >
    	<h3>Nome Scheda:</h3>
        <input type="text" name="nome" size="30" required /><br>
        <h3>Cliente:</h3>
        <select name="cliente" id="cliente" required >
        	<%for(Cliente c:((ArrayList<Cliente>)this.getServletContext().getAttribute("listClienti"))){
        		%><option value="<%=c.getUsername()%>"><%=c.getUsername()%></option>
        		<%
        		}%>
		  </select>
        <h3>Difficoltà:</h3>
        <input type="text" name="difficolta" size="30"/><br>
        
        <h3>numeroEs:</h3>
        <input type="number" name="numeroEs" id="numeroEs" onchange="aggiornaNumeroInput()" required />
	    
	    <div id="containerInput"></div>
	
	<input id="btn" type="submit" name="tipo" value="creaScheda" size="40" />
    </form>

   
  
  </main>
  
  <footer>
    <!-- Inserisci qui il piÃ¨ di pagina (es. informazioni di contatto, link utili) -->
    <form action="PersonalTrainerHome.jsp">
    	<input id="btn-back" type="submit" value="Back" size="40">
    </form>
  </footer>
  
  <!-- Includi qui i tuoi script JavaScript -->
  <script src="script.js"></script>
</body>
</html>
