<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- import di classi Java -->
<%@ page import="beans.*"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Comparator"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="styles/style.css">
<script src="scripts/script.js"></script>
<title>Gestione impegni</title>
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
                        <option value="gestione-calendario-all.jsp">Gestione impegni</option>
                        <option value="home-all.jsp">Homepage</option>
                        <option value="visualizza-squadra-all.jsp">Visualizza squadra</option>
                        <option value="inserisci-risultati-all.jsp">Inserisci risultati</option>
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
			String username = (String) session.getAttribute("username");
			String nome_allenatore = (String) session.getAttribute("nome_allenatore");
			String cognome_allenatore = (String) session.getAttribute("cognome_allenatore");
			String nome_squadra = (String) session.getAttribute("nome_squadra");
			String nome_societa = (String) session.getAttribute("nome_societa");

			ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
			%>
			<h2>
				Impegni squadra
				<%=nome_squadra%></h2>
			<br>
			<table>
				<tr>
					<td><b>ID</b></td>
					<td><b>Tipo</b></td>
					<td><b>Inizio</b></td>
					<td><b>Fine</b></td>
					<td><b>Avversario</b></td>
					<td><b>Competizione</b></td>
					<td><b>Titolo</b></td>
				</tr>
				<%
				for (Societa so : listSocieta) {
					for (Squadra sq : so.getSquadre()) {
						if (sq.getNome().equals(nome_squadra)) {
					Partita p;
					Allenamento a;

					for (Impegno i : sq.getCalendario().getImpegni()) {
						if (i.getInizio().isAfter(LocalDateTime.now())) {
				%>

				<tr>
					<td><%=i.getIdImpegno()%></td>
					<td><%=i.getTipo()%></td>
					<td><%=i.getInizio()%></td>
					<td><%=i.getFine()%></td>
					<td>
						<%
						if (i.getTipo().equals("P")) {
							p = (Partita) i;
						%> <%=p.getAvversario()%> <%
 }
 %>
					</td>
					<td>
						<%
						if (i.getTipo().equals("P")) {
							p = (Partita) i;
						%> <%=p.getCompetizione()%> <%
 }
 %>
					</td>
					<td>
						<%
						if (i.getTipo().equals("A")) {
							a = (Allenamento) i;
						%> <%=a.getTitolo()%> <%
 }
 %>
					</td>
				</tr>
				<%
				}
				}
				}
				}
				}
				
				%>
				
			</table>
			<h2>
				Richieste effettuate
			</h2>
			<br>
			<table>
				<tr>
					<td><b>ID</b></td>
					<td><b>Tipo</b></td>
					<td><b>Inizio</b></td>
					<td><b>Fine</b></td>
					<td><b>idAllenatore</b></td>
					<td><b>Titolo</b></td>

				</tr>
			<%	
				String idall=null;
				for(Societa s: listSocieta){
					for(Squadra sq:s.getSquadre()){
						for(Allenatore a:sq.getAllenatori()){
							if(a.getUsername().equals(username)) idall=a.getId();
						}
					}
				}
			
				ArrayList<Richiesta> richieste= (ArrayList<Richiesta>) this.getServletContext().getAttribute("richieste");
				for(Richiesta r:richieste){
					if(r.getIdAllenatore().equals(idall)){
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
	
			%>
			</table>
			</div>
			
			<h3>Effettua una richiesta</h3>
    		<div class="EffettuaRichiesta">
    		<form action="EffettuaRichiesta" method="post">
    		<label for="id">id</label>
       		<input type="text" id="id" name="id" value=<%=idall %> required><br><br>
       		<label for="tipo">Tipo</label>
       		<input type="text" id="tipo" name="tipo" required><br><br>
       		 <label for="data">Data della partita:</label>
        	<input type="text" id="data" name="data" required><br><br>

        	<label for="oraInizio">Ora di inizio:</label>
        	<input type="text" id="oraInizio" name="oraInizio" required><br><br>

        	<label for="oraFine">Ora di fine:</label>
        	<input type="text" id="oraFine" name="oraFine" required><br><br>
        	<label for="id">Titolo</label>
       		<input type="text" id="titolo" name="titolo" required><br><br>
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