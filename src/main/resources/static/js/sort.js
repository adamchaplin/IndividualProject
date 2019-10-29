async function sortCards(sort){
			
	const url = 'http://' + location.host + ':8080/currentSpecies';
	var species = await axios.get(url)
	species = species.data;

	if (sort == 'Name') {
		species = species.sort(compareName);
	} else if (sort == 'SciName') {
		species = species.sort(compareSciName);
	} else if (sort == 'Pop') {
		species = species.sort(comparePop);
	} else if (sort == 'Loc') {
		species = species.sort(compareLoc);
	} else if (sort == 'CStatus') {
		species = species.sort(compareCStatus);
	}

	display(species);

}

function compareName(a, b){
	const valuea = a.speciesName;
	const valueb = b.speciesName;
	return compare(valuea, valueb);	
}

function compareSciName(a, b){
	const valuea = a.scientificName;
	const valueb = b.scientificName;
	return compare(valuea, valueb);	
}

function comparePop(a, b){
	const valuea = a.population;
	const valueb = b.population;
	return compare(valuea, valueb);		
}

function compareLoc(a, b){
	const valuea = a.location;
	const valueb = b.location;
	return compare(valuea, valueb);		
}

function compareCStatus(a, b){
	const valuea = a.conservationStatus;
	const valueb = b.conservationStatus;
	return compare(valuea, valueb);		
}

function compare(a, b){
	let comparison = 0;
	if (a > b) {
		comparison = 1;
	} else if (a < b) {
		comparison = -1;
	}
	return comparison;
}