
let contador = 1

setInterval(function() {
    document.getElementById('slide' + contador).checked = true;
    contador = (contador % 5) + 1
}, 3000)
