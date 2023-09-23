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
    <title>SpecificaEser</title>
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
            font-weight: bold;
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
    </style>
   
</head>
<body>
<header class="intestazione">
    <img src="images/Logo.png" alt="Descrizione dell'immagine" class="logo">
    <h1 id="nome" class="intestazione">Fit-Flow</h1>
</header>

<main>
    

    
        <%
        Log.writeLog((String) session.getAttribute("username"), LocalDateTime.now(), "visualizza esercizio specifico");
        String nome=request.getParameter("nome");
        String url=request.getParameter("url");
        String descrizione=request.getParameter("descrizione");
        String difficolta=request.getParameter("difficolta");   
        %>
        <h1 class="titolo-calendario"><b><%= nome %></b></h1>
        <div class="giorno">
       <div class="sessione" style="text-align: center;">
    <img src="<%= url %>" alt="Immagine della sessione">
    <h2><b>Difficoltà</b></h2>
    <p><%= difficolta %></p>
    <h2><b>Descrizione</b></h2>
    <p><%= descrizione %></p>
</div>
    </div>
</main>

<footer>
   
  </footer>

<!-- Includi qui i tuoi script JavaScript -->
<script src="script.js"></script>
</body>
</html>