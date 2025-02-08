function loadGetMsg() {
    let nameVar = document.getElementById("name").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        document.getElementById("getrespmsg").innerHTML =
            this.responseText;
    }
    xhttp.open("GET", `/app/greeting?name=${nameVar}` );
    xhttp.send();
}

function getPiFromRest() {
    let url = "/app/pi";
    fetch(url, { method: 'GET' })
        .then(x => x.text())
        .then(y => document.getElementById("getPiRest").innerHTML = y);
}

function getEulerFromRest() {
    let url = "/app/e";
    fetch(url, { method: 'GET' })
        .then(x => x.text())
        .then(y => document.getElementById("getEulerRest").innerHTML = y);
}

function getMultiplication(){
    let valor1 = document.getElementById("valor1").value;
    let valor2 = document.getElementById("valor2").value;
    fetch(`/app/multiplicacion?valor1=${valor1}&valor2=${valor2}`, { method: 'GET' })
        .then(x => x.text())
        .then(y => document.getElementById("getMultiplication").innerHTML = y);
}

function getSubstraction(){
    let valor1 = document.getElementById("valor1resta").value;
    let valor2 = document.getElementById("valor2resta").value;
    fetch(`/app/resta?valor1=${valor1}&valor2=${valor2}`, { method: 'GET' })
        .then(x => x.text())
        .then(y => document.getElementById("getSubstraction").innerHTML = y);
}

function getSuma(){
    let valor1 = document.getElementById("valor1suma").value;
    let valor2 = document.getElementById("valor2suma").value;
    fetch(`/app/suma?valor1=${valor1}&valor2=${valor2}`, { method: 'GET' })
        .then(x => x.text())
        .then(y => document.getElementById("getAddition").innerHTML = y);
}