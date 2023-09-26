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
    <title>Home</title>
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
                        <option value="#">Seleziona</option>
                        <option value="#">Opzione 1</option>
                        <option value="#">Opzione 2</option>
                        <option value="#">Opzione 3</option>
                        <!-- Aggiungi altre opzioni del menu qui -->
                    </select>
                </nav>
            </div>
        </div>
    </header>

    <div class="content-container">
        <h2>Benvenuti su SportsHub</h2>
        <p>La tua piattaforma di gestione per squadre di basket.</p>

        <!-- Pagina di login -->
        <div class="login-container">
			<h2>Accesso</h2>
			<form action="login.php" method="POST">
				<label for="username">Username:</label>
				<br>
				<input type="text" id="username" name="username" required>
				<br><br> <!-- Aggiunto spazio tra gli input -->

				<label for="password">Password:</label>
				<br>
				<input type="password" id="password" name="password" required>
				<br><br> <!-- Aggiunto spazio tra gli input -->

				<button type="submit">Accedi</button>
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
