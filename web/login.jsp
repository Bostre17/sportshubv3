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
    <title>SportsHub Login</title>
</head>
<body>
    <header>
        <div class="header-container">
            <!-- Container per la scritta "SportsHub" al centro -->
            <div class="logo-container">
                <h1 class="logo">SportsHub</h1>
            </div>
            
        </div>
    </header>

    <div class="content-container">
       
<%
		Integer errato = (Integer)session.getAttribute("credenzialiErrate");
		Integer arrivederci = (Integer)session.getAttribute("arrivederci");
		
		if (errato != null && errato == 1) {
%>
		<p style="font-size:16px; color: red; font-weight: bold;">Credenziali errate.</p><br>
<%
		}
		else if (arrivederci != null && arrivederci == 1)
		{
			%>
        	<h2>Arrivederci!</h2>
		<p style="font-size:16px;">Effettua login con credenziali diverse per accedere con un altro account.</p><br>
			<%
		}
		else
		{
%>
        <p style="font-size:16px;">La tua piattaforma di gestione per squadre di basket.</p>
<%
		}
%>
        <!-- Pagina di login -->
        <div class="login-container">
			<form action="login" method="POST">
				<label for="username">Username:</label>
				<br>
				<input type="text" id="username" name="username" required>
				<br><br> <!-- Aggiunto spazio tra gli input -->

				<label for="password">Password:</label>
				<br>
				<input type="password" id="password" name="password" required>
				<br><br> <!-- Aggiunto spazio tra gli input -->

				<button type="submit" class="btn-login">Accedi</button>
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
