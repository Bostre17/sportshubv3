<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- import di classi Java -->
<%@ page import="beans.*"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="styles/style.css">
    <script src="scripts/script.js"></script>
    <title>SportsHub</title>
</head>
<body>
    <header>
        <div class="header-container">
            <!-- Container per la scritta "SportsHub" al centro -->
            <div class="logo-container">
                <h1 class="logo">Visualizza ed inserisci risultati</h1>
            </div>
            
            <!-- Container per il menu a tendina a sinistra -->
            <div class="menu-container">
                <!-- Menu a tendina a sinistra -->
                <nav class="menu">
                    <select id="dropdown-menu">
                        <option value="#">Men�</option>
                        <option value="visualizza-squadra-all.jsp">Visualizza squadra</option>
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


		<h2>Risultati partite</h2>
		<table>
			<tr>
				<td><b>Data</b></td>
				<td><b>Avversario</b></td>
				<td><b>Luogo</b></td>
				<td><b>Risultato</b></td>
				<td><b>Competizione</b></td>
			</tr>
			<%
			String input = (String) session.getAttribute("username");
				String[] username = input.split("\\.");

				ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
				ArrayList<Squadra> squadre = new ArrayList<Squadra>();
				ArrayList<Partita> partite = new ArrayList<Partita>();

				for (Societa so : listSocieta) {
					if (so.getUsername().equals(username[3])) {
						for (Squadra sq : so.getSquadre()) {
							if (sq.getNome().equals(username[2])) {
								for (Impegno i : sq.getCalendario().getImpegni()) {
									if (i instanceof Partita) {
										Partita partita = (Partita) i;
										if (LocalDateTime.now().isAfter(i.getFine())) {
											partite.add(partita);
										}
									}
								}
							}
						}
					}
				}
			%>
			<%
			for (int i = 0; i < partite.size(); i++) {
					LocalDate data = partite.get(i).getInizio().toLocalDate();
			%>
			<tr>
				<td><%=data%></td>
				<td><%=partite.get(i).getAvversario()%></td>
				<%
				if (partite.get(i).isPartita_casa()) {
				%>
					<td>Casa</td>
				<%
				} else {
				%>
					<td>Ospiti</td>
				<%
				}
				%>
				<td><%=partite.get(i).getPunteggioCasa()%>-<%=partite.get(i).getPunteggioOspiti()%></td>
				<td><%=partite.get(i).getCompetizione()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

    <footer>
        <div class="footer-container">
            <p>� 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>
