function display(species){
	var cardList = document.getElementById('cardList');
	while (cardList.firstChild) {
		cardList.removeChild(cardList.firstChild);
	}
	for (var i = 0; i < species.length; i++) {
		var card = document.createElement("div");
		var image = document.createElement("div");
		var imageUrl = document.createElement("img");
		var speciesName = document.createElement("p");
		var sciName = document.createElement("p");
		var population = document.createElement("p");
		var location = document.createElement("p");
		var conserStatus = document.createElement("p");
		
		image.appendChild(imageUrl);
		card.appendChild(image);
		card.appendChild(speciesName);
		card.appendChild(sciName);
		card.appendChild(population);
		card.appendChild(location);
		card.appendChild(conserStatus);

		cardList.appendChild(card);
		
		
		card.classList.add("card");
		
		image.classList.add("image");
		imageUrl.src = species[i].imageUrl;
		speciesName.classList.add("SpeciesName");
		speciesName.innerHTML=species[i].speciesName;
		sciName.classList.add("SciName");
		sciName.innerHTML=species[i].scientificName;
		population.classList.add("Population");
		population.innerHTML="Population: " + species[i].population;
		location.classList.add("Population");
		location.innerHTML="Location: " + species[i].location;
		conserStatus.classList.add("Population");
		conserStatus.innerHTML="Conservation Status: " + species[i].conservationStatus;		
	}
}