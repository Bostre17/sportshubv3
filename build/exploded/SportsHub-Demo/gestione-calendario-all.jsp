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