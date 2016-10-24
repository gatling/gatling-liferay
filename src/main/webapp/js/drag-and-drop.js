/*
 * Copyright 2011-2016 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//Prepares the div array and addActions on all the elements space-container
var cols = document.querySelectorAll('.space-container');
[].forEach.call(cols, function(col) {
	addDragFeature(col);
});

var trash = document.getElementById("trashcan");
console.log("trash:"+ trash.innerHTML);

trash.addEventListener("drop", function(ev) {
    // prevent default action (open as link for some elements)
    ev.preventDefault();
	
	var data = ev.dataTransfer.getData("text");
    // move dragged elem to the selected drop target
    var blockDragged = document.getElementById(data);
    if (!trash.className.includes("hide-trashcan") && !blockDragged.className.includes("template")) {
    	blockDragged.parentNode.removeChild( blockDragged );
        //event.target.appendChild( dragged );
    }
    persistScenarios();
}, false);

trash.addEventListener('dragover', handleDragOver, false);

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

//Function called when any draggable element is dragged
function drag(ev) {
	console.log("Drag->Element:" + ev.target.id + " dragged");
	ev.dataTransfer.setData("text", ev.target.id);
	
	if (!ev.target.className.includes("template")) {
		//Display the process trashcan
		var trashcan = $("#trashcan");
		trashcan.removeClass("hide-trashcan");
		
		$(ev.target).addClass("dragged");
		setTimeout(function() {
			ev.target.style.display = "none";
		}, 1);
	}
}

function endDrag(ev) {
	$(ev.target).removeClass("dragged");
	ev.target.style.display = "inline-block";
	
	var trashcan = $("#trashcan");
	trashcan.addClass("hide-trashcan");
}

//Function called when the element is dropped
function drop(ev) {
	console.log("Droping in: " + this.id);
	ev.preventDefault();

	endDrag(ev);

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
	
	if (blockDragged.className.includes("_tyPAUSE")) {
		wanSpinerLaunch();
	}

	// Insert the elements
	workflow.insertBefore(blockDragged, blockTarget);
	
	persistScenarios();
}

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
