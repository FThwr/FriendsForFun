<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ihr M&aelig;ty-Konto!</title>
<link rel="stylesheet" type="text/css" href="format.css" />
</head>
<body>
	<header>
	<h1>M&aelig;ty</h1>
	</header>
	<div class="page-wrapper">
		<div class="preamble" id="zen-preamble" role="article">
			<h3>Erstellen Sie Ihr M&aelig;ty-Konto!</h3>
			<br>
			<form name="neuer_nutzer" action="neuer_nutzer.xml" method="post">
				Benutzername*<br> <input type="text" name="Username" size="50"
					maxlength="25" required><br> <br> Geschlecht*<br>
				<input type="radio" name="Geschlecht" value="weiblich" checked>Weiblich
				<input type="radio" name="Geschlecht" value="m�nnlich">M�nnlich<br>
				<br> Geburtsdatum*<br> <input type="date"
					name="Geburtsdatum" required><br> <br> E-Mail*<br>
				<input type="email" name="Mail" size="50" required><br>
				<br> Passwort*<br> <input type="password" name="Passwort"
					size="50" required><br> <br>
				<button>Speichern</button>
				<br>
				<p class="pflichtfeld">*Pflichtfeld</p>
				<br>
			</form>
		</div>
		<footer>
		<p>
			&copy; FriendsForFun<sup>4</sup> <a
				href="mailto:s_ruhkieck@stud.hwr-berlin.de?cc=s_guhl@stud.hwr-berlin.de&amp;subject=Kontaktanfrage">Kontakt</a>
		</p>
		</footer>
	</div>
</body>
</html>