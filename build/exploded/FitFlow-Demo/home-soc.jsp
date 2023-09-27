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
    <title>Home Società</title>
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
                        <option value="home-soc.jsp">Homepage</option>
                        <option value="gestione-squadra-soc.jsp" data-url="gestione-squadra-soc.jsp">Gestione squadra</option>
                        <option value="gestione-calendario-soc.jsp" data-url="gestioneCalendario.jsp">Gestione calendario</option>
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

	<%
	String nome_societa = (String)session.getAttribute("nome_societa");
	String nome_squadra = (String)session.getAttribute("nome_squadra");
		%>
	<div class="content-container">
		<p style="font-size: 20px; font-weight: bold;">
			Benvenuto,
			<%=nome_societa%>!
		</p>
		<p style="font-size: 16px;">
			Questo è un account di gestione squadre, dove puoi gestire gli impegni ed i membri.
		</p>
		<p style="font-size: 16px;">Per accedere alle funzionalità aprire
			il menù a tendina in alto.</p>
	</div>

    <footer>
        <div class="footer-container">
            <p>© 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>
