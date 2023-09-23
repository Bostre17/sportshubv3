<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<%@ page session="true"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB" %>
<%@page import="java.sql.PreparedStatement" %>
<!-- import di classi Java -->
<%@ page import="beans.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>Home Cliente</title>
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
    <p align="right">Logged: <%= session.getAttribute("username") %></p>
      <div class="TitoloPagina">
        <h1>HomeCliente</h1>
         
      </div>
     

      <div class="azioniCliente">
      <form action="visualizzaPT_cliente.jsp" method="POST" class="inline-form">
      <button id="btn"  type="submit" >Visualizza PT</button>
          </form>
          <form action="CalendarioCliente.jsp" method="POST" class="inline-form">
      <button id="btn"  type="submit" >Calendario</button>
          </form>
          <form action="StoricoCliente.jsp" method="POST" class="inline-form">
      <button id="btn"  type="submit" >Le mie Sessioni</button>
          </form>
        
      </div>

      <div class="viewSchede">
        <h2>Le Mie Schede</h2>

        <%-- import di classi Java --%>
        <%
        List<Scheda> schedeCliente=new ArrayList<>();
        List<Cliente> listClienti=(ArrayList<Cliente>) this.getServletContext().getAttribute("listClienti");
		for(Cliente cl : listClienti) {
			if(session.getAttribute("username").equals(cl.getUsername())) {
				schedeCliente = (List<Scheda>) cl.getListaSchede();
			}
		}
          for (Scheda scheda : schedeCliente) {
        %>
        <div class="scheda">
          <h2><%= scheda.getNome() %></h2>
          <p>Difficoltà: <%= scheda.getDifficolta() %></p>
          <p>PersonalTrainer: <%= scheda.getPersonalTrainerScheda() %></p>
          <form action="EsecuzioneScheda.jsp" method="POST">
            <input type="hidden" name="scheda" value="<%= scheda.getNome() %>">
            <button class="btn-vaiScheda" type="submit">Visualizza</button>
          </form>
        </div>
        <% }
        %>
      </div>
    </div>
  </main>

  <footer>
    <!-- Inserisci qui il piÃ¨ di pagina (es. informazioni di contatto, link utili) -->
    <form action="index.jsp">
    	<input id="btn-back" type="submit" value="LogOUT" size="40">
    </form>
  </footer>

  <!-- Includi qui i tuoi script JavaScript -->
  <script src="script.js"></script>
</body>
</html>
