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
    <title>Home Allenatore</title>
</head>
<body>
    <header>
        <div class="header-container">
            <!-- Container per la scritta "SportsHub" al centro -->
            <div class="logo-container">
                <h1 class="logo">Homepage Allenatore</h1>
            </div>
            
            <!-- Container per il menu a tendina a sinistra -->
            <div class="menu-container">
                <!-- Menu a tendina a sinistra -->
                <nav class="menu">
                    <select id="dropdown-menu">
                        <option value="#">Menù</option>
                        <option value="visualizza-squadra-all.jsp">Visualizza squadra</option>
                        <option value="visualizza-risultati-all.jsp">Visualizza risultati</option>
                        <option value="inserisci-risultati-all.jsp">Inserisci risultati</option>
                        <option value="gestione-calendario-all.jsp">Gestione calendario</option>
                        <!-- Aggiungi altre opzioni del menu qui -->
                    </select>
                </nav>
            </div>
        </div>
    </header>

	<script>
		document.getElementById("dropdown-menu").addEventListener("change",
				function() {
					var selectedValue = this.value;
					if (selectedValue !== "#") {
						window.location.href = selectedValue;
					}
				});
	</script>

	<div class="content-container">
    <div id="eventi">

	<%

	String username= (String)session.getAttribute("username");
	ArrayList<Societa> listSocieta= (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
	
	for(Societa s: listSocieta )
	{
		%>
		società: 
		<%=s.getNome() %>
		<br>
		<br>
		<%
		if(s.getUsername().equals(username))
		{
			for(Squadra sq: s.getSquadre())
			{
				%>
				&emsp;Squadra: 
				<%=sq.getNome() %>
				<br>
				<%
				
				for(Impegno i: sq.getCalendario().getImpegni())
				{
					if(i.getInizio().isAfter(LocalDateTime.now()))
					{
						%>
						&emsp;&emsp;<%=i.toString() %>
						<br>
						<% 
					}
				
				}
			}
		}
	}
					
	
%>
</div>
<br>
<br>
<div id="richieste">
<%
	ArrayList<Richiesta> richieste= (ArrayList<Richiesta>) this.getServletContext().getAttribute("richieste");
	for(Societa s: listSocieta)
	{
		%>
		società: 
		<%=s.getNome() %>
		<br>
		<br>
		<%
		if(s.getUsername().equals(username))
			for(Squadra sq: s.getSquadre())
			{
				%>
				&emsp;Squadra: 
				<%=sq.getNome() %>
				<br>
				<%
				for(Richiesta r: richieste)
				{
					if(sq.esisteAllenatore(r.getIdAllenatore()))
					{
						%>
						&emsp;&emsp;<%=r.toString() %>
						<br>
						<% 
					}
						
				}
			}
	}
%>

</div>


<h4>Accetta o rifiuta richieste</h4>
    
    <div class="custom-form">
    <form id="myForm" method="post">
        <label for="inputText">Inserisci Id richiesta:</label>
        <input type="text" id="idRichiesta" name="idRichiesta" required>
        
        <button type="button" name="accettaButton" onclick="submitForm('accetta')">Accetta</button>
        <button type="button" name="rifiutaButton" onclick="submitForm('rifiuta')">Rifiuta</button>
    </form>
</div>

<script>
    function submitForm(action) {
        // Recupera il form
        var form = document.getElementById("myForm");

        // Modifica l'azione del form in base al pulsante cliccato
        if (action === "accetta") {
            form.action = "aggiungiImpegno"; // Sostituisci con l'URL della servlet "Accetta"
        } else if (action === "rifiuta") {
            form.action = "eliminaImpegno"; // Sostituisci con l'URL della servlet "Rifiuta"
        }

        // Invia il modulo
        form.submit();
    }
</script>




</div>

    <footer>
        <div class="footer-container">
            <p>© 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>