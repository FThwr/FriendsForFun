<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="format.css"/>
    <!--<style type="text/css">
        @import url("web.css") screen; dazu will ich mir noch was durchlesen, im Idealfall wird hier auch eine mobile Seite erzeugt
    </style>-->
</head>
<body>
<div class="page-wrapper">
    <header>
        <h1>M&aelig;ty</h1>
    </header>
    <div class="preamble" id="zen-preamble" role="article">
    	<h1>JSP</h1>
        <h3>Anmeldung</h3><br>
        <form name="login" action="login.xml" method="post">
            <!--Hier muss ich noch rausfinden, wo er die Formulardaten hin speichert-->
            Benutzername<br>
            <input type="text" name="Username" size="25" maxlength="25" required><br><br>
            Passwort<br>
            <input type="password" name="Passwort" size="25" maxlength="25" required><br><br>
<!--            <a href="homepage.html">
                <button>Anmelden</button>
            </a><br>
            <p class="kursiv_blau">Noch kein M&aelig;ty-Account?</p>--> <!--Wenn das funktioniert, kann hier der Button wieder rein und der Anmelden-Button weiter unten wieder raus-->
        </form>
        <a href="homepage.html">
            <button>Anmelden</button>
        </a><br>
        <p class="kursiv_blau">Noch kein M&aelig;ty-Account?</p>
        <a href="neuer_nutzer.html">
            <button>Registrieren</button>
        </a><br>
    </div>
    <footer>
        <p>&copy; FriendsForFun<sup>4</sup> <a
                href="mailto:s_ruhkieck@stud.hwr-berlin.de?cc=s_guhl@stud.hwr-berlin.de&amp;subject=Kontaktanfrage">Kontakt</a>
        </p>
    </footer>
</div>
</body>
</html>