<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Neuer Ort</title>
    <link rel="stylesheet" type="text/css" href="format.css"/>
</head>
<body>
<div class="page-wrapper">
    <header>
        <h1>M&aelig;ty</h1>
    </header>
    <div class="preamble" id="zen-preamble" role="article">
        <h3>Erstellen Sie einen neuen Eventort!</h3><br>
        <form name="neuer_ort" action="neuer_ort.php" method="post">
            Bezeichnung*<br>
            <input type="text" name="Bez_Ort" size="50" maxlength="40" required><br><br>
            Postleitzahl*<br>
            <input pattern="[0-9]{5}" title="12345" name="PLZ" size="10" required><br><br>
            Stra�e/Nr.*<br>
            <input type="text" name="Strasse" size="50"><br><br>
            Beschreibung<br>
            <textarea name="Beschreibung_ort" cols="100" rows="5" maxlength="400"></textarea><br><br>
            <button>Speichern</button>
            <br>
            <p class="pflichtfeld">*Pflichtfeld</p><br>
        </form>
    </div>
    <footer>
        <p>&copy; FriendsForFun<sup>4</sup> <a
                href="mailto:s_ruhkieck@stud.hwr-berlin.de?cc=s_guhl@stud.hwr-berlin.de&amp;subject=Kontaktanfrage">Kontakt</a></p>
    </footer>
    <aside class="sidebar" role="complementary">
        <div class="wrapper">
            <div class="design-selection" id="design-selection">
                <h1 class="gr�n_sidebar">Men�</h1><br><br><br>
                <li>
                    <ul><a href="homepage.html" class="menue">HOME</a></ul>
                    <br>
                    <ul><a href="neues_event.html" class="menue">Neues Event</a></ul>
                    <br>
                    <ul><a href="neue_aktivitaet.html" class="menue">Neue Aktivit�t</a></ul>
                </li>
            </div>
        </div>
    </aside>
</div>
</body>
</html>
</html>