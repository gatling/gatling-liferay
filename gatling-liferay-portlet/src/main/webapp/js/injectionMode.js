
handleInjection();

// Handle the injectionMode selection, duration is disabled if "at Once" is selected
$( "select" ).change(handleInjection);
function handleInjection() {
	var input = $("#<portlet:namespace/>rampUp");
	var str = $( "select option:selected" ).text();
    if (str.includes("at Once")) {
    	input.attr("disabled", "true");
    }
    else {
    	input.removeAttr("disabled");
    }
}
