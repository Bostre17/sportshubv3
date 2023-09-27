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
    <title>Homepage Allenatore</title>
</head>
<body>
    <header>
        <div class="header-container">
            <!-- Container per la scritta "SportsHub" al centro -->
            <div class="logo-container">
                <h1 class="logo">Homepage</h1>
            </div>
            
            <!-- Container per il menu a tendina a sinistra -->
            <div class="menu-container">
                <!-- Menu a tendina a sinistra -->
                <nav class="menu">
                    <select id="dropdown-menu">
                        <option value="home-all.jsp">Homepage</option>
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
		<p style="font-size:20px; font-weight: bold;"> Benvenuto, <%
			String input = (String)session.getAttribute("username");
			String[] username = input.split("\\.");
			ArrayList<Societa> listSocieta = (ArrayList<Societa>)this.getServletContext().getAttribute("listSocieta");
			String nome_societa;
			String nome_allenatore;
			String nome_squadra;
			
			for(Societa so : listSocieta)
			{
				if(so.getUsername().equals(username[3]))
				{
					nome_societa = so.getNome();
					for(Squadra sq : so.getSquadre())
					{
						if(sq.getNome().equals(username[2]))
						{
							nome_squadra = sq.getNome();
							for(Allenatore a : sq.getAllenatori())
							{
								if(a.getUsername().equals(input))
								{
									nome_allenatore = a.getNome();
								}
							}
						}
					}
				}
			}
		%>
		<%=nome_allenatore %>!</p>
		<p style="font-size:16px;"> Sei nella società <%= nome_societa %> e la tua squadra è <%=nome_squadra %>.</p>
        <p style="font-size:16px;">Per accedere alle funzionalità aprire il menù a tendina in alto.</p>
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
