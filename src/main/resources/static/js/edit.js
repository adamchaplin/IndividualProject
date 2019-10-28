async function deleteCard(id){
	const url = 'http://localhost:8080/currentSpecies';
	axios.delete(url, {data: { id: id }});
	var cardList = document.getElementById('cardList');
	var card = document.getElementById('card' + id);
				cardList.removeChild(card);
}

async function addCard(){
	const url = 'http://localhost:8080/currentSpecies';
	
	params = {
		speciesName: 'zinosaur',
	    scientificName: 'Dinosaur',
	    location: 'Everywhere',
	    population: 0,
	    conservationStatus: 'CR',
	    image_url: ''
      }

    let res = await axios.post(url, params);
	console.log(res);
	sortCards('Name');
}

async function updateCard(id, params){
	const url = 'http://localhost:8080/currentSpecies/' + id;

    let res = await axios.put(url, params);
	console.log(res);
	sortCards('Name');
}
  
function display(species){
	var cardList = document.getElementById('cardList');
	while (cardList.firstChild) {
		cardList.removeChild(cardList.firstChild);
	}
	for (var i = 0; i < species.length; i++) {
		var card = document.createElement("div");
		var close = document.createElement("a");
		var image = document.createElement("div");
		var imageUrl = document.createElement("img");
		var speciesName = document.createElement("p");
		var sciName = document.createElement("p");
		var population = document.createElement("p");
		var popLabel = document.createElement("label");
		var location = document.createElement("p");
		var locLabel = document.createElement("label");
		var conserStatus = document.createElement("p");
		var csLabel = document.createElement("label");
		
		image.appendChild(imageUrl);
		card.appendChild(image);
		card.appendChild(close);
		card.appendChild(speciesName);
		card.appendChild(sciName);
		population.appendChild(popLabel);
		card.appendChild(population);
		location.appendChild(locLabel);
		card.appendChild(location);
		conserStatus.appendChild(csLabel);
		card.appendChild(conserStatus);
	
		cardList.appendChild(card);
		
		card.classList.add("card");
		card.id = "card" + species[i].speciesId;
		close.classList.add("close");
		close.id = species[i].speciesId;
		close.onclick = function() { if (confirm('WARNING!\nYou are about to delete this item')) {
			deleteCard(this.id);
		}};
		
		image.classList.add("image");
		imageUrl.src = species[i].imageUrl;
		speciesName.classList.add("SpeciesName");
		speciesName.innerHTML=species[i].speciesName;
		speciesName.id = species[i].speciesId;
		speciesName.ondblclick = function() {
			let input = document.createElement("input");
			input.classList.add("input");
			input.classList.add("SpeciesName");
			input.type="text";
			input.value = this.textContent;
			input.id = this.id;
			this.innerHTML = "";
			this.appendChild(input);
			input.select();
			input.addEventListener("keyup", function(event) {
				if (event.keyCode === 13) {
					if (confirm('WARNING!\nYou are about to update this item')) {
						params = {
								"speciesName": this.value
						}
						updateCard(this.id, params);
					}
				}
			});
		};
		sciName.classList.add("SciName");
		sciName.innerHTML=species[i].scientificName;
		sciName.id = species[i].speciesId;
		sciName.ondblclick = function() {
			let input = document.createElement("input");
			input.classList.add("input");
			input.classList.add("SciName");
			input.type="text";
			input.value = this.textContent;
			input.id = this.id;
			this.innerHTML = "";
			this.appendChild(input);
			input.select();
			input.addEventListener("keyup", function(event) {
				if (event.keyCode === 13) {
					if (confirm('WARNING!\nYou are about to update this item')) {
						params = {
								"scientificName": this.value
						}
						updateCard(this.id, params);
					}
				}
			});
		};
		population.classList.add("Population");
		popLabel.classList.add("Population");
		popLabel.innerText = "Population: ";
		var popTextNode = document.createTextNode(species[i].population);
		population.appendChild(popTextNode);
		population.id = species[i].speciesId;
		population.ondblclick = function() {
			let input = document.createElement("input");
			input.classList.add("input");
			input.classList.add("Population");
			input.type="text";
			input.value = this.lastChild.nodeValue;
			input.id = this.id;
			this.innerHTML = "";
			this.appendChild(input);
			input.select();
			input.addEventListener("keyup", function(event) {
				if (event.keyCode === 13) {
					if (confirm('WARNING!\nYou are about to update this item')) {
						params = {
								"population": this.value
						}
						updateCard(this.id, params);
					}
				}
			});
		};
		location.classList.add("Population");
		locLabel.innerText = "Location: ";
		var locTextNode = document.createTextNode(species[i].location);
		location.appendChild(locTextNode);
		location.id = species[i].speciesId;
		location.ondblclick = function() {
			let input = document.createElement("input");
			input.classList.add("input");
			input.classList.add("Population");
			input.type="text";
			input.value = this.lastChild.nodeValue;
			input.id = this.id;
			this.innerHTML = "";
			this.appendChild(input);
			input.select();
			input.addEventListener("keyup", function(event) {
				if (event.keyCode === 13) {
					if (confirm('WARNING!\nYou are about to update this item')) {
						params = {
								"location": this.value
						}
						updateCard(this.id, params);
					}
				}
			});
		};
		conserStatus.classList.add("Population");
		csLabel.innerText = "Conservation Status: ";
		var csTextNode = document.createTextNode(species[i].conservationStatus);
		conserStatus.appendChild(csTextNode);
		conserStatus.ondblclick = function() {
			let input = document.createElement("input");
			input.classList.add("input");
			input.classList.add("Population");
			input.type="text";
			input.value = this.lastChild.nodeValue;
			input.id = this.id;
			this.innerHTML = "";
			this.appendChild(input);
			input.select();
			input.addEventListener("keyup", function(event) {
				if (event.keyCode === 13) {
					if (confirm('WARNING!\nYou are about to update this item')) {
						params = {
								"conservationStatus": this.value
						}
						updateCard(this.id, params);
					}
				}
			});
		};
	}
	var flipCard = document.createElement("div");
	var cardFront = document.createElement("div");
	var add = document.createElement("div");
	var cardBack = document.createElement("div");
	var image = document.createElement("div");
	
	let nameInput = document.createElement("input");
	nameInput.classList.add("input");
	nameInput.classList.add("SpeciesName");
	nameInput.type="text";
	nameInput.placeholder="Name";
	let sciInput = document.createElement("input");
	sciInput.classList.add("input");
	sciInput.classList.add("SciName");
	sciInput.type="text";
	sciInput.placeholder="Scientific Name";
	let popInput = document.createElement("input");
	popInput.classList.add("input");
	popInput.classList.add("Population");
	popInput.type="text";
	popInput.placeholder="Population";
	let locInput = document.createElement("input");
	locInput.classList.add("input");
	locInput.classList.add("Population");
	locInput.type="text";
	locInput.placeholder="Location";
	let csInput = document.createElement("input");
	csInput.classList.add("input");
	csInput.classList.add("Population");
	csInput.type="text";
	csInput.placeholder="Conservation Status";
	
	cardBack.appendChild(image);
	cardBack.appendChild(nameInput);
	cardBack.appendChild(sciInput);
	cardBack.appendChild(popInput);
	cardBack.appendChild(locInput);
	cardBack.appendChild(csInput);
	cardFront.appendChild(add);
	flipCard.appendChild(cardFront);
	flipCard.appendChild(cardBack);
	cardList.appendChild(flipCard);
	
	add.onclick = function() {
		document.getElementById('flipCard').style.transform = "rotatey(0deg)";
	};

	flipCard.classList.add("card");
	flipCard.classList.add("flipCard");
	cardFront.classList.add("cardAddFront");
	cardBack.classList.add("cardAddBack");
	add.classList.add("add");
	flipCard.id = "flipCard";
}