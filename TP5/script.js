class Bouteille {
    constructor(nom, annee, prix, quantite, description) {
        this.nom = nom
        this.annee = annee
        this.prix = prix
        this.quantite = quantite
        this.description = description
    }
}

let Bouteilles = [];

function ajoutBouteille() {
    let name = document.getElementById('nom').value;
    document.getElementById('nom').value = 'Vignasse'+Bouteilles.length.toString();
    let description = document.getElementById('description').value;
    let year = document.getElementById('year').value;
    let price = document.getElementById('price').value;
    let quantity = document.getElementById('quantity').value;

    let bouteille = new Bouteille(name, year, price, quantity, description);

    Bouteilles.push(bouteille);

    displayBouteilles();
}

function displayBouteilles() {

    if (document.getElementById('div-bouteilles')) document.getElementById('div-bouteilles').parentNode.removeChild(document.getElementById('div-bouteilles'))

    let divBouteilles = document.createElement('div')
    divBouteilles.setAttribute('id', 'div-bouteilles')

    Bouteilles.forEach(bouteille => {

        let nameElement = document.createElement('h1')
        nameElement.appendChild(document.createTextNode(bouteille.nom))

        let descriptionElement = document.createElement('p')
        descriptionElement.appendChild(document.createTextNode('Description : ' + bouteille.description))

        let yearElement = document.createElement('p')
        yearElement.appendChild(document.createTextNode('Année : ' + bouteille.annee))

        let priceElement = document.createElement('p')
        priceElement.appendChild(document.createTextNode('Prix : ' + bouteille.prix))

        let quantityElement = document.createElement('p')
        quantityElement.appendChild(document.createTextNode('Quantité : ' + bouteille.quantite))

        let imgElement = document.createElement('img')
        imgElement.setAttribute('src', 'vin.jpg')

        let bottleDiv = document.createElement('div')
        bottleDiv.setAttribute('id', 'div-bouteille')
        bottleDiv.appendChild(nameElement)
        bottleDiv.appendChild(descriptionElement)
        bottleDiv.appendChild(imgElement)
        bottleDiv.appendChild(yearElement)
        bottleDiv.appendChild(priceElement)
        bottleDiv.appendChild(quantityElement)

        divBouteilles.appendChild(bottleDiv)

        let currentDiv = document.getElementById('form-div')
        document.body.insertBefore(divBouteilles, currentDiv.nextSibling)
    })
}

function sauvegardeBouteilles() {
    localStorage.setItem('bouteilles', JSON.stringify(Bouteilles))
    console.log("Bouteilles Sauvegardées : ")
    console.log(JSON.stringify(Bouteilles))
}

function exportToXML() {
    let string = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
        "<!DOCTYPE Bouteille [>\n" +
        "<!ELEMENT Bouteille(Nom,Prix,Annee,Description,Quantite)>\n" +
        "<!ELEMENT Nom (#PCDATA) >\n" +
        "<!ELEMENT Annee (#PCDATA)>\n" +
        "<!ELEMENT Prix (#PCDATA)>\n" +
        "<!ELEMENT Quantite (#PCDATA)>\n" +
        "<!ELEMENT Description (#PCDATA)>\n" +
        "< ] >"
    + "<bouteilles> \n";
    Bouteilles.forEach(bouteille => {
      string +=
          "<bouteille> \n" +
          "\t\t <nom>\n" +
          "\t\t\t" + bouteille.nom + "\n" +
          "\t\t </nom>\n" +
          "\t\t <annee>\n" +
          "\t\t\t" + bouteille.annee + "\n" +
          "\t\t </annee>\n" +
          "\t\t <prix>\n" +
          "\t\t\t" + bouteille.prix + "\n" +
          "\t\t </prix>\n" +
          "\t\t <quantite>\n" +
          "\t\t\t" + bouteille.quantite + "\n" +
          "\t\t </quantite>\n" +
          "\t\t <description>\n" +
          "\t\t\t" + bouteille.description + "\n" +
          "\t\t </description>\n" +
          "</bouteille> \n"
    });
    string += "</bouteilles>"
    console.log(string);
}

function chargerBouteilles() {
    console.log("LocalStorage : " + localStorage.getItem('bouteilles'));
    let bouteilles = [];
    if (localStorage.getItem('bouteilles') != null)
        bouteilles = JSON.parse(localStorage.getItem('bouteilles'));
    Bouteilles = bouteilles;
    displayBouteilles();
}