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
                <img src="images/SportsHub.png" class="center">
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
				<table>
					<tr>
						<td><b>ID</b></td>
						<td><b>Tipo</b></td>
						<td><b>Inizio</b></td>
						<td><b>Fine</b></td>
						<td><b>Avversario</b></td>
						<td><b>competizione</b></td>
						<td><b>Titolo</b></td>
					</tr>
				<%
				
				Partita p;
				Allenamento a;
				for(Impegno i: sq.getCalendario().getImpegni())
				{
					if(i.getInizio().isAfter(LocalDateTime.now()))
					{
						%>
						
						<tr>
						<td> <%=i.getIdImpegno() %> </td>
						<td> <%=i.getTipo() %> </td>
						<td> <%=i.getInizio() %> </td>
						<td> <%=i.getFine() %> </td>
						<td>
							<%
								if(i.getTipo().equals("P"))
								{
									p=(Partita)i;
									%>
									<%=p.getAvversario()%>
									<% 
								}
							%>
						</td>
						<td>
							<%
								if(i.getTipo().equals("P"))
								{
									p=(Partita)i;
									%>
									<%=p.getCompetizione()%>
									<% 
								}
							%>
						</td>
						<td>
							<%
								if(i.getTipo().equals("A"))
								{
									a=(Allenamento)i;
									%>
									<%=a.getTitolo()%>
									<% 
								}
							%>
						</td>
						</tr>
						
						<% 
					}
				
				}
			}
			
			%>
			</table>
			<% 
			
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
				<table>
					<tr>
						<td><b>ID</b></td>
						<td><b>Tipo</b></td>
						<td><b>Inizio</b></td>
						<td><b>Fine</b></td>
						<td><b>ID_allenatore</b></td>
						<td><b>Titolo</b></td>
					</tr>
				<%
				for(Richiesta r: richieste)
				{
					if(sq.esisteAllenatore(r.getIdAllenatore()))
					{
						%>
						<tr>
						<td><%=r.getId() %></td>
						<td><%=r.getTipo() %> </td>
						<td><%=r.getInizio() %></td>
						<td><%=r.getFine() %></td>
						<td><%=r.getIdAllenatore() %></td>
						<td><%=r.getTitolo() %></td>
					</tr>
						<% 
					}
						
				}
			}
		
		%>
		</table>
		<% 
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
            form.action = "accettaRichiesta"; // Sostituisci con l'URL della servlet "Accetta"
        } else if (action === "rifiuta") {
            form.action = "eliminaRichiesta"; // Sostituisci con l'URL della servlet "Rifiuta"
        }

        // Invia il modulo
        form.submit();
    }
</script>

<br>

<br>

<h3>Inserimento Partite</h3>

   <div class="inserisciPartita">
    <form action="process.php" method="post">
        <label for="nomeSquadra">Nome della squadra:</label>
        <input type="text" id="nomeSquadra" name="nomeSquadra" required><br><br>

        <label for="data">Data della partita:</label>
        <input type="date" id="data" name="data" required><br><br>

        <label for="oraInizio">Ora di inizio:</label>
        <input type="time" id="oraInizio" name="oraInizio" required><br><br>

        <label for="oraFine">Ora di fine:</label>
        <input type="time" id="oraFine" name="oraFine" required><br><br>

        <label for="avversario">Avversario:</label>
        <input type="text" id="avversario" name="avversario" required><br><br>

        <label for="competizione">Competizione:</label>
        <input type="text" id="competizione" name="competizione" required><br><br>

        <label for="partitaCasa">Partita in casa:</label>
        <input type="checkbox" id="partitaCasa" name="partitaCasa"><br><br>

        <button type="submit" name="submit">Invia</button>
    </form>
</div>



</div>

    <footer>
        <div class="footer-container">
            <p>© 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>