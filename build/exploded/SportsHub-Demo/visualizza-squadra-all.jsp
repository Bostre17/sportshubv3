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
    <title>SportsHub</title>
</head>
<body>
    <header>
        <div class="header-container">
            <!-- Container per la scritta "SportsHub" al centro -->
            <div class="logo-container">
                <h1 class="logo">Visualizza Squadra</h1>
            </div>
            
            <!-- Container per il menu a tendina a sinistra -->
            <div class="menu-container">
                <!-- Menu a tendina a sinistra -->
                <nav class="menu">
                    <select id="dropdown-menu">
                        <option value="#">Menù</option>
<<<<<<< HEAD
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
	
	<%
		String input = (String)session.getAttribute("username");
		String[] username = input.split("\\.");
		
		ArrayList<Societa> listSocieta = (ArrayList<Societa>)this.getServletContext().getAttribute("listSocieta");
		ArrayList<Squadra> squadre = new ArrayList<Squadra>();
		ArrayList<Allenatore> allenatori = new ArrayList<Allenatore>();
		ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
		
		for(Societa so : listSocieta)
		{
			if(so.getUsername().equals(username[3]))
			{
				for(Squadra sq : so.getSquadre())
				{
					if(sq.getNome().equals(username[2]))
					{
						allenatori = sq.getAllenatori();
						giocatori = sq.getGiocatori();
					}
				}
			}
		}
	%>
        
        <h2>Squadra</h2>
        <h3>Allenatori</h3>
		<table>
			<tr>
				<td><b>ID</b></td>
				<td><b>Cognome</b></td>
				<td><b>Nome</b></td>
			</tr>
		<%
		for(int i = 0 ; i < allenatori.size(); i++) {
		%>
			<tr>
				<td><%=allenatori.get(i).getId()%></td>
				<td><%=allenatori.get(i).getCognome()%></td>
				<td><%=allenatori.get(i).getNome()%></td>
			</tr>
		<%
		}
		%>
		
		</table>
        <h3>Giocatori</h3>
		<table>
			<tr>
				<td><b>ID</b></td>
				<td><b>Cognome</b></td>
				<td><b>Nome</b></td>
				<td><b>Altezza</b></td>
				<td><b>Punti partita</b></td>
				<td><b>Assist partita</b></td>
				<td><b>Rimbalzi partita</b></td>
=======
                        <option value="#visualizza-squadra-all.jsp">Visualizza squadra</option>
                        <option value="#visualizza-risultati-all.jsp">Visualizza risultati</option>
                        <option value="#inserisci-risultati-all.jsp">Inserisci risultati</option>
                        <option value="#gestione-calendario-all.jsp">Gestione calendario</option>
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
	
	<%
		String input = (String)session.getAttribute("username");
		String[] username = input.split("\\.");
		
		ArrayList<Societa> listSocieta = (ArrayList<Societa>) session.getAttribute("listSocieta");
		ArrayList<Squadra> squadre = new ArrayList<Squadra>();
		ArrayList<Allenatore> allenatori = new ArrayList<Allenatore>();
		ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
		
		for(Societa so : listSocieta)
		{
			if(so.getUsername().equals(username[3]))
			{
				for(Squadra sq : so.getSquadre())
				{
					if(sq.getNome().equals(username[2]))
					{
						allenatori = sq.getAllenatori();
						giocatori = sq.getGiocatori();
					}
				}
			}
		}
	%>
        
        <h2>Squadra</h2>
        <h3>Allenatori</h3>
		<table>
			<tr>
				<td>ID</td>
				<td>Cognome</td>
				<td>Nome</td>
			</tr>
		<%
		for(int i = 0 ; i < allenatori.size(); i++) {
		%>
			<tr>
				<td><%=allenatori.get(i).getId()%></td>
				<td><%=allenatori.get(i).getCognome()%></td>
				<td><%=allenatori.get(i).getNome()%></td>
			</tr>
		<%
		}
		%>
		
		</table>
        <h3>Giocatori</h3>
		<table>
			<tr>
				<td>ID</td>
				<td>Cognome</td>
				<td>Nome</td>
				<td>Altezza</td>
				<td>Punti partita</td>
				<td>Assist partita</td>
				<td>Rimbalzi partita</td>
>>>>>>> branch 'main' of https://github.com/Bostre17/sportshubv3.git
			</tr>
		<%
		for(int i = 0 ; i < giocatori.size(); i++) {
		%>
			<tr>
				<td><%=giocatori.get(i).getId()%></td>
				<td><%=giocatori.get(i).getCognome()%></td>
				<td><%=giocatori.get(i).getNome()%></td>
				<td><%=giocatori.get(i).getAltezza()%></td>
				<td><%=giocatori.get(i).getPuntiPartita()%></td>
				<td><%=giocatori.get(i).getAssistPartita()%></td>
				<td><%=giocatori.get(i).getRimbalziPartita()%></td>
			</tr>
        <%
		}
        %>
		</table>
    </div>

    <footer>
        <div class="footer-container">
            <p>© 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>
