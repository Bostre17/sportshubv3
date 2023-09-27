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
                        <option value="logout.jsp">Logout</option>
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
					if(selectedValue == "logout.jsp")
					{
						fetch('logout', {
					        method: 'POST', // Puoi utilizzare 'POST' al posto di 'GET' se necessario
					        // Puoi aggiungere altre opzioni come intestazioni (headers) o dati (body) qui
					    })
					    .then(function(response) {
					        if (response.ok) {
					            // La richiesta alla servlet ha avuto successo
					            // Puoi gestire la risposta qui, se necessario
					        } else {
					            throw new Error('Errore nella richiesta alla servlet');
					        }
					    })
					    .catch(function(error) {
					        console.error(error);
					    });
					}
					else if (selectedValue !== "#") {
						window.location.href = selectedValue;
					}
				});
	</script>

	<div class="content-container">
        <img src="images/SportsHub.png" class="center">
        <p style="font-size:16px; font-weight: bold;">Per accedere alle funzionalità aprire il menù a tendina in alto.</p>
    </div>

    <footer>
        <div class="footer-container">
            <p>© 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>
