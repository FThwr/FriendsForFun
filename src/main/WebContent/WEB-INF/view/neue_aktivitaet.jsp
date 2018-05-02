<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Neue Aktivit�t</title>
    <link rel="stylesheet" type="text/css" href="format.css"/>
</head>
<body>
<div class="page-wrapper">
    <header>
        <h1>M&aelig;ty</h1>
    </header>
    <div class="preamble" id="zen-preamble" role="article">
        <h3>Erstellen Sie eine neue Aktivit�t!</h3><br>
        <form name="neue_aktivitaet" action="neue_aktivitaet.php" method="post">
            Bezeichnung*<br>
            <input type="text" name="Bez_Aktivitaet" size="50" maxlength="25" required><br><br>
            Kategorie*<br>
            <select name="Kategorie" required>
                <option>Mannschaftssportarten</option>
                <option>Strategiespiele</option>
                <option>Outddoraktivit�ten</option>
            </select><br><br>
            Altersempfehlung<br>
            <input type="number" name="Altersempfehlung" size="20" min="16" max="99"><br><br>
            Minimale Personenanzahl<br>
            <input type="number" name="Min_PersAnzahl" size="20" min="2"><br><br>
            Maximale Personenanzahl<br>
            <input type="number" name="Max_PersAnzahl" size="20" min="2" max="35"><br><br>
            Beschreibung<br>
            <textarea name="Beschreibung_aktivitaet" cols="100" rows="5" maxlength="400"></textarea><br><br>
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
                    <ul><a href="neuer_ort.html" class="menue">Neuer Eventort</a></ul>
                    <br>
                </li>
            </div>
        </div>
    </aside>
</div>
</body>
</html>