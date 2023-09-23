<%@ page session="true"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB" %>
<%@page import="java.sql.PreparedStatement" %>

<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
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
  <%
  //String user=request.getParameter("nome");
  //Connection con=DB.connection();
  //PreparedStatement p=con.preparedStatement("insert into prova1 (nome) values(?)");
  
  %>
    <!-- Inserisci qui il contenuto principale della pagina -->
    <div class="TitoloPagina">
        <h1>Login</h1>
    </div>

    <div class="inputForm">
      <form action="LogIn" method="post">
        <h3>Username:</h3>
        <input type="text" name="username" size="30"/><br>
        <h3>Password:</h3>
        <input type="password" name="password" size="30"/><br></br></br>
        <input id="btn" type="submit" value="Login" size="40"/>
      </form>

    </div>

  </main>
  
  <footer>
    <!-- Inserisci qui il piè di pagina (es. informazioni di contatto, link utili) -->
    <form action="LogIn">
    	<input type="hidden" name="azione" value="registra">
    	<input id="btn" type="submit" value="Registrazione Cliente" size="60">
    </form>
  </footer>
  
  <!-- Includi qui i tuoi script JavaScript -->
  <!--<script src="script.js"></script>-->
</body>
</html>
