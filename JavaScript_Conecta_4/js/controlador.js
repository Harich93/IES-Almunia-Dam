window.addEventListener('load', main);

let tablero, tabla;
let player1, player2, change=true, ganador=false, txtWinner;;

function main() {   // Eventos del juego:

    document.querySelector('#btnReiniciar').addEventListener('click', ()=>{location.reload()});
    document.querySelector('#btnReiniciarMJ').addEventListener('click', reiniciarMJ);

    // Al pulsar el bnt Aceptar, creo los jugadores con los nombres ingresados y muestro el tablero de juego:
    document.querySelector('#btnFormulario').addEventListener('click', ()=>{
        createPlayers();
        tablero = new Tablero(7,7);
        createBoard();
    });

    
}

function chooseColors() {   // Elige las clases según el color elegido en el radio button:
    
    if(document.querySelectorAll('#c1')[0].checked)
        player1.setColor("turno1");
    else 
        player1.setColor("turno2");

    if(document.querySelectorAll('#c2')[0].checked)
        player2.setColor("turno3");
    else 
        player2.setColor("turno4")


}

function createBoard() {    // Genero la tabla de juego (visual):
    
    tabla = document.createElement('table');
    tabla.addEventListener('click', (e) => {putToken(e)})

    for (let i=0; i<7; i++) {
        let tr = document.createElement('tr');
        for (let f=0; f<7; f++) {
            let td = document.createElement('td');
            tr.appendChild(td);
        }
        tabla.appendChild(tr);
    }

    document.querySelector('#divTabla').appendChild(tabla);
}

function changePlayer() { // Cambia el turno de la partida. Y muestra en la cabecera a quién le corresponde jugar:
   
    if(ganador==false && change==false) { //Si es falso es el turno de Player2:
        change = true;
        document.querySelector('#turno').innerHTML = `Turno de ${player2.getName()}`;
        document.querySelector('#turno').className = `${player2.getColor()}`
    }

    else if(ganador==false && change==true){  // Si es true es el turno de Player1:
        change = false;
        document.querySelector('#turno').innerHTML = `Turno de ${player1.getName()}`;
        document.querySelector('#turno').className = `${player1.getColor()}`
    } 

    else if (txtWinner=="Empate") {
        document.querySelector('#turno').innerHTML = `${txtWinner}`;
        document.querySelector('#turno').className = 'turnoGanador'
    }
    else {
        document.querySelector('#turno').innerHTML = `Ha ganado ${txtWinner}`;
        document.querySelector('#turno').className = 'turnoGanador'
    }

}

function putToken(e) {  // Cambia el fondo del td de la tabla por el color del jugador.

    let putToken=false; // Para el bucle si se añade la ficha.

    if(!ganador) {
        
        if(e.target.localName == 'td' ){     // Verifico que se da el click en un td.
            
            let cell = e.target.cellIndex   // Agarro el indice del td donde se produce el evento. 
    
            for(let tr=6 ;tr >= 0 && putToken==false; tr--) 
                if(tablero.tablero[tr][cell] == null)   // Busco agregar la ficha en el primer td que este vacio en esa misma columna.
                    if(change == false) {
                        putToken=true;
                        e.currentTarget.children[tr].cells[cell].className = `${player1.getColor()}`;   //Cambio la clase que contiene el color del jugador correspondiente.
                        tablero.addFicha(tr,cell,player1.getName()); // Agrego el nombre del jugador al array tablero. Donde se realizarán las comprobaciones.
                        changePlayer();
                    }
                    else {
                        putToken=true;
                        e.currentTarget.children[tr].cells[cell].className = `${player2.getColor()}`;
                        tablero.addFicha(tr,cell,player2.getName());
                        changePlayer();
                    }
        }
    
        winner(); // Llamo a la función para comprobar si existe algún ganador.
    }
     
}

function createPlayers() {  // Creo los jugadores a partir del formulario:

    //Compruebo que los nombres no esten vacios. En caso de estarlos les asigno un valor por defecto:
    if(document.querySelector('#txtJugador1').value == "")
        name1 = "Jugador1"
    else
        name1 = document.querySelector('#txtJugador1').value

    if(document.querySelector('#txtJugador2').value == "")
        name2 = "Jugador2"
    else
        name2 = document.querySelector('#txtJugador2').value
    
    // Instancio los jugadores: 
    player1 = new Player(name1);
    player2 = new Player(name2);

    // Agrego los colores:
    chooseColors();

    // Muestro el juego:
    showGame();
}

function showGame() {   // Muestra los elementos de la página después del formulario:

    document.querySelector('#divForm').style.display = 'none'

    // Creo los párrafos donde se indicará que color corresponde a cada jugador:
    let p = document.createElement('p');
    let p2 = document.createElement('p');
    let color1, color2;
    let jugadores= document.querySelector('#jugadores');
    
    // Obtengo los nombres de los jugadores y los muestro en la cabecera con el color de fichas de cada uno:

    switch (player1.getColor()) {
        case "turno1": color1 ="Rojo"
            break;
        case "turno2": color1 ="Azul"
            break;
    }

    switch (player2.getColor()) {
        case "turno3": color2 ="Amarillo"
            break;
        case "turno4": color2 ="Verde"
            break;
    }

    p.innerHTML = `${player1.getName()}: ${color1}`;
    p2.innerHTML = `${player2.getName()}: ${color2}`;

    jugadores.appendChild(p);
    jugadores.appendChild(p2);
    
    // Cambio las clases de los elementos de la cabecera para que se muestren:
    document.querySelector('#cabecera').className='divTurnos';
    document.querySelector('#btnReiniciar').className = 'btn';
    document.querySelector('#btnReiniciarMJ').className = 'btn'

   
    changePlayer();     // Cambio de jugador para que muestre al jugador que empieza (Jugador 1).

}

function winner(){  // Comprueba si existe un ganador:

    // Utilizo los metodos check de la class Tablero para comprobar:

    if(tablero.checkHorizontal() == player1.getName() || tablero.checkHorizontal() == player2.getName())
        txtWinner=tablero.checkHorizontal();
    
    else if (tablero.checkVertical() == player1.getName() || tablero.checkVertical() == player2.getName())
        txtWinner = tablero.checkVertical();
    
    else if (tablero.checkDiagonal() == player1.getName() || tablero.checkDiagonal() == player2.getName())
        txtWinner = tablero.checkDiagonal();
    
    
    

    if(txtWinner == player1.getName() || txtWinner == player2.getName()){ // En caso de de ser cierto retorna el nombre del ganador y teremina la partida.
        ganador = true;
        changePlayer();
    }
    else if(tablero.checkComplete()) {
        txtWinner = "Empate";
        ganador = true;
        changePlayer();
    }
        
}
    
function reiniciarMJ() {   // Vuelve todo como al principio sin modificar los nombres de los participantes:

    ganador = false;
    txtWinner = " ";
    tablero.empty();
    changePlayer();
    
    td = document.querySelectorAll('td');

    for(let i=0; i<td.length; i++) {
        td[i].className = "1"
    }

}