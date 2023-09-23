<%@ page errorPage="../errors/failure.jsp"%>
<%@ page session="true"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.DB" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="beans.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.LocalDateTime"%>
<!DOCTYPE html>
<html>
<head>
    <title>Scheda</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }
        
        .logo {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            margin-right: 10px;
            border-color: white;
            border-style: solid;
        }
        
        .intestazione {
            display: flex;
            align-items: center;
            justify-content: space-between;
            text-align: center;
            width: 100%;
            background-color: black;
            padding: 5px;
            height: 40px;
        }
        footer{
    position: fixed;
    bottom: 30px;
    right: 10px;
}

        #nome.intestazione {
            color: white;
            font-size: 18px;
        }
        
        .calendario {
            display: grid;
            grid-template-columns: repeat(1, 1fr);
            gap: 10px;
            margin: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        
        .giorno {
            border: 1px solid lightgray;
            padding: 10px;
            border-radius: 10px;
        }
        
        .sessione {
            border: 1px solid lightgray;
            padding: 10px;
            margin-top: 10px;
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            position: relative;
        }
        
        .btn-iscriviti {
            background-color: #195dd2;
            color: white;
            border: none;
            padding: 8px 16px;
            text-align: left;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin-top: 10px;
            cursor: pointer;
            
            top: 50%;
           
            transform: translateY(-50%);
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }
        
        .btn-data {
            background-color: #007BFF;
            color: white;
            border: none;
            position:absolute;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin-bottom: 10px;
            cursor: pointer;
            border-radius: 10px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
        }
        
        .titolo-calendario {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
            border: 1px solid lightgray;
            padding: 10px;
            border-radius: 10px;
        }
        
        .timer {
            display: flex;
            align-items: center;
            justify-content: flex-end;
            padding: 10px;
            font-size: 18px;
            font-weight: bold;
        }
        
        .timer span {
            margin-left: 10px;
        }
        
        #btn-back{
    background-color: #195dd2;
    width: 20vw;
    color: white;
    border: none;
    padding: 8px 16px;
    text-align: center;
    text-decoration: none;
    font-size: 25px;
    margin-top: 10px;
    cursor: pointer;
    right: 10px;
    border-radius: 10px;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
    
}

@media (max-width: 950px) {

    #btn-back{
        width: 15vw;
        font-size: 12px;
        padding: 2px 2px;
    	text-align: center;
    	text-decoration: none;
    	margin-top: 10px;
    	cursor: pointer;
    	right: 5px;
    	border-radius: 10px;
    	box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
    }
}
    </style>
<script>
    // Variabili globali per tenere traccia dei timer attivi
    var timers = {};

    // Funzione per avviare il timer
    function startTimer(sessionId, recupero) {
        var timerElement = document.getElementById('timer-' + sessionId);
        var startButton = document.getElementById('start-button-' + sessionId);
        var resetButton = document.getElementById('reset-button-' + sessionId);
		

        var timerElement = document.getElementById('timer-'+ sessionId);
        var count = timerElement.innerText;

        // Funzione per aggiornare il timer ogni secondo
        function updateTimer() {
            if (count === 0) {
                clearInterval(timers[sessionId]);
                timers[sessionId] = null;
                startButton.innerText = 'START';
                resetButton.disabled = false;
            } else {
                count--;
                timerElement.innerText = count;
            }
        }

        // Avvia il timer
        if (!timers[sessionId]) {
            timers[sessionId] = setInterval(updateTimer, 1000);
            startButton.innerText = 'STOP';
            resetButton.disabled = false;
        } else {
            clearInterval(timers[sessionId]);
            timers[sessionId] = null;
            startButton.innerText = 'START';
            resetButton.disabled = false;
        }
    }

    // Funzione per reimpostare il timer
    function resetTimer(sessionId, recupero) {
        clearInterval(timers[sessionId]);
        timers[sessionId] = null;
        var timerElement = document.getElementById('timer-'+sessionId);
        var startButton = document.getElementById('start-button-' + sessionId);
        var resetButton = document.getElementById('reset-button-' + sessionId);
        timerElement.innerText = recupero;
        startButton.innerText = 'START';
        startButton.disabled = false;
        resetButton.disabled = true;
    }
</script>
</head>
<body>
<header class="intestazione">
    <img src="images/Logo.png" alt="Descrizione dell'immagine" class="logo">
    <h1 id="nome" class="intestazione">Fit-Flow</h1>
</header>

<main>
    <h1 class="titolo-calendario">Scheda1</h1>

    <div class="calendario">
        <div class="giorno">
            <% 
            Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "visualizza schede");
            String nomeScheda=request.getParameter("scheda");
            Scheda s=new Scheda();
            List<Scheda> schedeCliente=new ArrayList<>();
            List<Cliente> listClienti=(ArrayList<Cliente>) this.getServletContext().getAttribute("listClienti");
            for(Cliente cl : listClienti) {
                if(session.getAttribute("username").equals(cl.getUsername())) {
                    schedeCliente = (List<Scheda>) cl.getListaSchede();
                }
            }
            for (Scheda scheda : schedeCliente) {
                if(scheda.getNome().equals(nomeScheda))
                {
                    s=scheda;
                }
            }
            for(Esercizio e : s.getListaEsercizi())
            {
            %>
            <div class="sessione" style="text-align: center;">
                <h2><%= e.getNome() %></h2>
                <p>Serie: <%= e.getNumeroSerie() %></p>
                 <p>Ripetizioni: <%= e.getNumeroRipetizioni() %></p>
                <form action="SpecificaEsercizio.jsp" method="POST">
                    <input type="hidden" name="nome" value="<%= e.getNome() %>">
                    <input type="hidden" name="difficolta" value="<%= e.getDifficolta() %>">
                    <input type="hidden" name="url" value="<%= e.getUrlImmagine() %>">
                    <input type="hidden" name="descrizione" value="<%= e.getDescrizione() %>">
                    <button class="btn-iscriviti" type="submit">Info</button>
                </form>
               
                <div class="timer">
                    <button id="start-button-<%= e.getNome() %>" class="btn-iscriviti" onclick="startTimer('<%= e.getNome() %>','<%= e.getRecupero() %>')">START</button>
                <button id="reset-button-<%= e.getNome() %>" class="btn-iscriviti" onclick="resetTimer('<%= e.getNome() %>','<%= e.getRecupero() %>')" disabled>Reset</button>
            <span id="timer-<%= e.getNome() %>"><%= e.getRecupero() %></span><span>secondi</span>
            </div>
            </div>
            <% } %>
        </div>
    </div>
</main>

<footer>
    <!-- Inserisci qui il piè di pagina (es. informazioni di contatto, link utili) -->
    <form action="HomeCliente.jsp">
    	<input id="btn-back" type="submit" value="Back" size="40">
    </form>
  </footer>

<!-- Includi qui i tuoi script JavaScript -->
<script src="script.js"></script>
</body>
</html>