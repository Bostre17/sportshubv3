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
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .logo {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            margin-right: 10px;
            border-color: white;
            border-style: solid;
        }

        .intestazione {
            display: flex;
            align-items: center;
            justify-content: space-between;
            text-align: center;
            width: 100%;
            background-color: black;
            padding: 5px;
            height: 40px;
        }

        #nome.intestazione {
            color: white;
            font-size: 18px;
        }

        .calendario {
            display: grid;
            grid-template-columns: repeat(1, 1fr);
            gap: 10px;
            margin: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        .giorno {
            border: 1px solid lightgray;
            padding: 10px;
            border-radius: 10px;
        }

        .sessione {
            border: 1px solid lightgray;
            padding: 10px;
            margin-top: 10px;
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            position: relative;
        }

        .btn-iscriviti {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin-top: 10px;
            cursor: pointer;
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }

        .btn-data {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 14px;
            margin-bottom: 10px;
            cursor: pointer;
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }

        .titolo-calendario {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
            border: 1px solid lightgray;
            padding: 10px;
            border-radius: 10px;
        }
    </style>
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
        <h1>Calendario Cliente</h1>
    </div>

    
    <%
    
    List<Sessione> sessioni=(ArrayList<Sessione>) this.getServletContext().getAttribute("sessioni");
    %>
    <h1 class="titolo-calendario">Calendario</h1>
    <div align="center">
        <input type="date" class="btn-data">
    </div>
    	
    
    <div class="calendario">
        
            
            
            <%
    if(sessioni!=null){
    for(Sessione s : sessioni){
	    	
    	%>
    	<div class="sessione">
                <h3><%=s.getNome() %></h3>
                
                <p><b>Data:</b> <%=s.getLocalDateTime() %></p>
                <p><b>Durata:</b> <%=s.getDurata() %> min</p>
                <p><b>PT:</b> <%=s.getPt() %></p>
                <form action="Calendario" method="post" >
		    	<input type="text" name="id" value=<%=s.getId() %> style="display: none;">
		    	<%
		    	boolean iscritto=false;
		    	for(String cliente:s.getClientiInscritti()) {
		    		if(cliente.equals(session.getAttribute("username"))){iscritto=true;}
		    		
		    	}
		    	if(!iscritto){%>
		    	
		    		<input class="btn-iscriviti" type="submit" name="tipo" value="iscrizione" size="40"/>
		    	<%}else{%>
		    		<input class="btn-iscriviti" type="submit" name="tipo" value="Gia Iscritto" size="40" disabled/>
		    	<%} %>
		    	</form>
                
            </div>
    		<br><% 
    	
    	
    	
    	
	    	
	    	
    	}
    }
    %>
    </div>
   

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
