

//Prepares the div array and addActions on all the elements space-container
var cols = document.querySelectorAll('.space-container');
[].forEach.call(cols, function(col) {
	addDragFeature(col);
});

//The counter
var count = parseInt($("#COUNTER").val(), 10);
console.log("Initial identifier: " + count);

function freshIdentifier() {
	count++;
	console.log("Fresh identifier: " + count);
	return count;
}

function addDragFeature(elt) {
	elt.addEventListener('dragenter', handleDragEnter, false);
	elt.addEventListener('dragover', handleDragOver, false);
	elt.addEventListener('dragleave', handleDragLeave, false);
	elt.addEventListener('drop', drop, false);
}

// Function called when any draggable element is dragged
function drag(ev) {
	console.log("Drag->Element:" + ev.target.id + " dragged");
	ev.dataTransfer.setData("text", ev.target.id);
}

// Function called when the element is dropped
function drop(ev) {
	console.log("Droping in: " + this.id);
	ev.preventDefault();

	$(this).removeClass("extented-space");
	$(this).addClass("space-container");

	var data = ev.dataTransfer.getData("text");
	console.log("Element: " + data + " dropped");

	// Retreives the DOM elements
	var blockTarget = this.parentNode;
	var workflow = blockTarget.parentNode;
	var blockDragged = document.getElementById(data);

	// Removes "template" class if present
	if (blockDragged.className.includes("template")) {
		console.log("cloning...");
		blockDragged = blockDragged.cloneNode(true);

		$(blockDragged).removeClass("template");
		$(blockDragged).attr("id", freshIdentifier());

		// Retrieve the space Container in the fresh dragged Block
		var spaceContainer = blockDragged.childNodes[1];
		addDragFeature(spaceContainer);
	}

	// Insert the elements
	workflow.insertBefore(blockDragged, blockTarget);
}

// TODO check the use of this fucntion
function handleDragOver(e) {
	if (e.preventDefault) {
		e.preventDefault(); // Necessary. Allows us to drop.
	}
	e.dataTransfer.dropEffect = 'move'; // See the section on the DataTransfer
										// object.
	return false;
}

function handleDragEnter(e) {
	console.log("Entering in: " + this.id);
	$(this).removeClass("space-container");
	$(this).addClass("extented-space");
}

function handleDragLeave(e) {
	console.log("Leaving: " + this.id);
	$(this).removeClass("extented-space");
	$(this).addClass("space-container");
}