function onCategoryChange(field) {
	var passendeAktivitaeten = aktivitaetenListe.filter(function(aktivitaet){
		return aktivitaet.kategorie == field.value;
	});
	
	var list = document.getElementById('list');
	
	while (list.hasChildNodes()){
		list.removeChild(list.firstChild);
	}
	
	passendeAktivitaeten.forEach(function(item){
		var option = document.createElement('option');
		option.value = item.id;
		option.text = item.bezeichnung;
		list.appendChild(option);
	});
}