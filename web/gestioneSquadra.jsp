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
        <h2>Benvenuti su SportsHub</h2>
       
<%
		Integer errato = (Integer)session.getAttribute("credenzialiErrate");
		if (errato != null && errato == 1) {
%>
		<p style="font-size:16px; color: red; font-weight: bold;">Credenziali errate.</p>
<%
		}
%>
<%
            ArrayList<Societa> listSocieta = (ArrayList<Societa>)=this.getServletContext().getAttribute("listSocieta");
            String idSoc = (String) session.getAttribute("idSoc");
                for (Societa s: listSocieta){
                    if(s.getId().equals(idSoc)){
                        this.getServletContext().setAttribute("squadre",s.getSquadre );
                    }
                }
%>

    <head>
        <title>Lista Squadre e Giocatori</title>
    </head>
    <body>
      <h1>Lista Squadre e Giocatori</h1>
    <c:forEach var="squadra" items="${squadre}">
        <h2>${squadra.nome}</h2>
        <table>
            <tr>
                
            </tr>
            <c:forEach var="giocatore" items="${squadra.giocatori}">
                <tr>
                    <td>${giocatore.nome}</td>
                    <td>${giocatore.numeroMaglia}</td>
                </tr>
            </c:forEach>
        </table>
    </c:forEach>
</body>
</html>

</div>
    </div>

    <footer>
        <div class="footer-container">
            <p>� 2023 SportsHub</p>
            <p>Bostrenghi Matteo - Gennaioli Leonardo - Severini Lorenzo</p>
        </div>
    </footer>

</body>
</html>