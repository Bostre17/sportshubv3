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
    <title>Visualizza squadra</title>
</head>
<body>
    <header>
        <div class="header-container">
            <!-- Container per la scritta "SportsHub" al centro -->
            <div class="logo-container">
                <h1 class="logo">SportsHub</h1>
            </div>
            
            <!-- Container per il menu a tendina a sinistra -->
            <div class="menu-container">
                <!-- Menu a tendina a sinistra -->
                <nav class="menu">
                    <select id="dropdown-menu">
                        <option value="#">Menù</option>
                        <option value="visualizzaRis.jsp" data-url="visualizzaRis.jsp">Visualizza risultati</option>
                        <option value="gestioneCalendario.jsp" data-url="gestioneCalendario.jsp">Gestione calendario</option>
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
		
	
		String username_societa = (String)session.getAttribute("username_societa");
		System.out.println(username_societa);
		ArrayList<Societa> listSocieta = (ArrayList<Societa>)this.getServletContext().getAttribute("listSocieta");
		ArrayList<Squadra> squadre = new ArrayList<Squadra>();
		ArrayList<Allenatore> allenatori = new ArrayList<Allenatore>();
		ArrayList<Giocatore> giocatori = new ArrayList<Giocatore>();
		System.out.println(username_societa);
		for(Societa so : listSocieta)
		{	
			System.out.println(so.getNome());
			if(so.getUsername().equals(username_societa))
			{
				System.out.println(so.getNome());
				for(Squadra sq : so.getSquadre())
				{
					System.out.println(sq.getNome());
					allenatori = sq.getAllenatori();
					giocatori = sq.getGiocatori();
			
	%>
		      
		        <h2>Squadra <%= sq.getNome()%></h2>
		        
		        <h3>Allenatori</h3>
				<table>
					<tr>
						<td><b>ID</b></td>
						<td><b>Cognome</b></td>
						<td><b>Nome</b></td>
					</tr>
				<%
				int j;
				for(j = 0 ; j < allenatori.size(); j++) {
					System.out.println(allenatori.get(j).getCognome());
				%>
					<tr>
						
						<td><%=allenatori.get(j).getId()%></td>
						<td><%=allenatori.get(j).getCognome()%></td>
						<td><%=allenatori.get(j).getNome()%></td>
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
		
					</tr>
				<%
				int i=0;
				for(i = 0 ; i < giocatori.size(); i++) {
					System.out.println(giocatori.get(i).getCognome());
				%>
					<tr>
					
						<td><%=giocatori.get(i).getId()%></td>
						<td><%=giocatori.get(i).getCognome()%></td>
						<td><%=giocatori.get(i).getNome()%></td>
		
					</tr>
		        <%
				}
				%>
				
		</table>
		<%
			}
		}
	}
        %>
	
	<h3>Inserimento Giocatore</h3>

   <div class="aggiungiGiocatore">
    <form action="aggiungiGiocatore" method="post">
    	<label for="id">id</label>
        <input type="text" id="id" name="id" required><br><br>
    	<label for="nomeSquadra">nomeSuqadra</label>
        <input type="text" id="nomeSquadra" name="nomeSquadra" required><br><br>
        <label for="username">username</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="nome">nome</label>
        <input type="text" id="nome" name="nome" required><br><br>

        <label for="cognome">cognome</label>
        <input type="text" id="cognome" name="cognome" required><br><br>

        <label for="altezza">altezza:</label>
        <input type="text" id="altezza" name="altezza" required><br><br>

        <button type="submit" name="submit">Invia</button>
    </form>
 
    </div>
    <h3>Rimozione Giocatore</h3>
    <div class="RimuoviGiocatore">
    <form action="RimuoviGiocatore" method="post">
    	<label for="id">id</label>
        <input type="text" id="id" name="id" required><br><br>

        <button type="submit" name="submit">Invia</button>
    </form>
    </div>
    <h3>Inserimento Squadra</h3>

   <div class="aggiungiSquadra">
    <form action="aggiungiSquadra" method="post">
        <label for="nomeSquadra">Nome della squadra:</label>
        <input type="text" id="nomeSquadra" name="nomeSquadra" required><br><br>
         <label for="nomeSquadra">Id</label>
        <input type="text" id="id" name="id" required><br><br>
		<button type="submit" name="submit">Invia</button>
    </form>

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
