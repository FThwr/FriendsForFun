<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Neues Event</title>
    <link rel="stylesheet" type="text/css" href="format.css"/>
</head>
<body>
<div class="page-wrapper">
    <header>
        <h1>M&aelig;ty</h1>
    </header>
    <div class="preamble" id="zen-preamble" role="article">
        <h3>Erstellen Sie ein neues Event!</h3><br>
        <form name="neues_event" action="neues_event.php" method="post">
            Kategorie*<br>
            <select name="Kategorie" required>
                <option>Mannschaftssportarten</option>
                <option>Strategiespiele</option>
                <option>Outddoraktivit�ten</option>
            </select><br><br>
            Aktivit�t*<br>
            <input type="text" name="aktivitaet" list="list"><br>
            <datalist id="list">
                <option value="Volleyball">
                <option value="Basketball">
                <option value="Die Zwerge">
                <option value="Poker">
            </datalist>
            <br>
            Termin<br>
            <input type="datetime-local" class="datetime-local" required><br><br>
            Beschreibung<br>
            <textarea name="Beschreibung_event" cols="100" rows="5" maxlength="400"></textarea><br><br>
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
                    <ul><a href="neue_aktivitaet.html" class="menue">Neue Aktivit�t</a></ul>
                    <br>
                    <ul><a href="neuer_ort.html" class="menue">Neuer Eventort</a></ul>
                    <br>
                </li>
            </div>
        </div>
    </aside>
</div>
</body>
</html>