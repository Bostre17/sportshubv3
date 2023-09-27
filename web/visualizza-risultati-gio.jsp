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
    <title>Visualizza e inserisci risultati</title>
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
                        <option value="inserisci-risultati-all.jsp">Inserisci risultati</option>
                        <option value="home-all.jsp">Homepage</option>
                        <option value="visualizza-squadra-all.jsp">Visualizza squadra</option>
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
		
		<div>
			<h2>Aggiorna risultato</h2>
			<form action="inserisciRisultato" method="POST">
		        <label for="id">ID:</label>
		        <input type="text" id="id" name="id" required><br><br>
		
		        <label for="punteggioCasa">Punteggio Casa:</label>
		        <input type="number" id="punteggioCasa" name="punteggioCasa" required><br><br>
		
		        <label for="punteggioOspiti">Punteggio Ospiti:</label>
		        <input type="number" id="punteggioOspiti" name="punteggioOspiti" required><br><br>
		
				<button type="submit" class="btn-base">Inserisci</button>
		    </form>
		    <%
				Integer errato = (Integer)session.getAttribute("inserimento-errato");
				System.out.println(errato);
				if(errato != null && errato == 1){
					%>
					<p style="font-size:16px; color: red; font-weight: bold;">ID errato.</p><br>
					<%
				}
				else if(errato != null && errato == 0)
				{
					%>
					<p style="font-size:16px;">Risultato aggiornato correttamente.</p><br>
					<%
				}
			%>
	    </div>
	    
		<%
		String username_societa = (String) session.getAttribute("username_societa");
		String nome_squadra = (String) session.getAttribute("nome_squadra");
		%>
		<h2>Risultati partite della squadra <%=nome_squadra%></h2>
		<table>
			<tr>
				<td><b>ID</b></td>
				<td><b>Data</b></td>
				<td><b>Avversario</b></td>
				<td><b>Luogo</b></td>
				<td><b>Risultato</b></td>
				<td><b>Competizione</b></td>
			</tr>
			<%
			ArrayList<Societa> listSocieta = (ArrayList<Societa>) this.getServletContext().getAttribute("listSocieta");
					ArrayList<Squadra> squadre = new ArrayList<Squadra>();
					ArrayList<Partita> partite = new ArrayList<Partita>();

					for (Societa so : listSocieta) {
						if (so.getUsername().equals(username_societa)) {
							for (Squadra sq : so.getSquadre()) {
								if (sq.getNome().equals(nome_squadra)) {
									for (Impegno i : sq.getCalendario().getImpegni()) {
										if (i instanceof Partita) {
											Partita partita = (Partita) i;
											if (LocalDateTime.now().isAfter(partita.getFine())) {
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
				<td><%=partite.get(i).getIdImpegno()%></td>
				<td><%=data%></td>
				<td><%=partite.get(i).getAvversario()%></td>
				<%
				if (partite.get(i).isPartita_casa()) {
					%>
					<td>Casa</td>
					<%
					if (partite.get(i).getPunteggioCasa() == 0 && partite.get(i).getPunteggioOspiti() == 0) {
					%>
						<td>Risultato non ancora inserito</td>
					<%
					} else {
					%>
						<td><b><%=partite.get(i).getPunteggioCasa()%></b>&nbsp;-&nbsp;<%=partite.get(i).getPunteggioOspiti()%></td>
					<%
					}
				} else {
				%>
				<td>Ospiti</td>
				<%
					if (partite.get(i).getPunteggioCasa() == 0 && partite.get(i).getPunteggioOspiti() == 0) {
					%>
						<td>Risultato non ancora inserito</td>
					<%
					} else {
					%>
						<td><%=partite.get(i).getPunteggioCasa()%>&nbsp;-&nbsp;<b><%=partite.get(i).getPunteggioOspiti()%></b></td>
					<%
					}
				}
				%>

				<td><%=partite.get(i).getCompetizione()%></td>
			</tr>
			<%
			}
			%>
		</table>
		
	</div>

    <footer>
        <div class="footer-container">
        	<form action="logout" method="POST">
    			<button type="submit" class="btn-logout">Logout</button>
   			</form>
            <p>© 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>
