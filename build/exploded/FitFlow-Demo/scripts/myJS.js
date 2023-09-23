
function valueBottone(){
	var stato = '<%= cl.getStato() %>';
	var btn = document.getElementByNameID("btn-blocca");
	if (stato === "Attivo") {
		btn.value = "Blocca";
	} else {
		btn.value = "Sblocca";
		alert("dio cane");
 	}
}