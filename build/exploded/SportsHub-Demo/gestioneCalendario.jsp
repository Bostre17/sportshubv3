<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- import di classi Java -->
<%@ page import="beans.*"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="styles/style.css">
    <script src="scripts/script.js"></script>
    <title>gestioneCalendario</title>
</head>
<body>
<div id="eventi">
<%

	String username= (String)session.getAttribute("username");
	ArrayList<Societa> listSocieta= (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
	for(Societa s: listSocieta )
	{
		if(s.getNome().equals(username))
		{
			for(Squadra sq: s.getSquadre())
			{
				for(Impegno i: sq.getCalendario().getImpegniSquadra())
				{
					%>
					<%= i.toString(); %>
					<% 
				
				}
			}
		}
	}
					
	
%>
</div>



<div id="richieste">

</div>
</body>