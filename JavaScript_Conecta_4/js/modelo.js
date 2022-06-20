class Player{
    
    constructor(nombre){
        this.name = nombre;
        this.color;
    }

    getColor() {
        return this.color;
    }

    setColor(color) {
        this.color = color;
    }

    getName() {
        return this.name;
    }

}

class Tablero{

    constructor(filas, columnas) {

        // Guardo las filas y columnas para en caso de comprobaciones o reinicio del tablero saber las dimensiones de este.
        this.filas = filas;
        this.columnas = columnas;

        this.tablero = new Array();

        for(let i=0; i<filas; i++){
            this.tablero[i] = new Array(columnas);
            for(let f=0; f<columnas; f++) {
                this.tablero[i][f] = null;
            }
        }

    }

    getTablero() {
        return this.tablero;
    }

    empty() {   // Reinicia el tablero.
        tablero = new Tablero(this.filas,this.columnas);
    }

    addFicha(y,x,name){
        this.tablero[y][x] = name;
    }

    contain(elemento){  // Busca si el elemento se encuentra en el Tablero:
        let td1Arr = new Array(); 

        for(let tr=6, td1=0; tr >=0 ; tr--) { // Recorro el tablero de abajo hacia arriba:
            for(let i=0;i<7;i++){
                if(this.tablero[tr][i] == elemento) {// Busco por cada tr si contiene fichas del jugador.
                    td1 = i;
                    td1Arr.push(td1); // Las almaceno en un array para despues comprobar.
                }
            }
        }

        return td1Arr;
    }

    checkHorizontal(){

        for(let tr=this.filas-1; tr >=0 ; tr--) { // Recorro el tablero de abajo hacia arriba:
            
            let cont1=0, cont2=0;
            for(let td=0; td<this.columnas; td++) {
                if(td>0) { // Empieza cuando td es mayor que 0, porque en 0 no tiene con que comparar.
                   
                    // Primero compruebo si contiene el nombre del jugador(ficha) y verifico si coincide con la anterior:
                    if(tablero.getTablero()[tr][td] == player1.getName() && tablero.getTablero()[tr][td] == tablero.getTablero()[tr][td-1]) {
                        cont1++;
                        if(cont1>=3) {
                            return player1.getName();
                        }
                        
                    }
                    else
                        cont1=0; // En el momento que la ficha de player1 (player2 en la siguiente condición) no este correlativa, vuelve a empezar 
    
                    if(tablero.getTablero()[tr][td] == player2.getName() &&tablero.getTablero()[tr][td] == tablero.getTablero()[tr][td-1]){
    
                         cont2++;
                        if(cont2>=3) {
    
                            return player2.getName();
                        }
                            
                    }
                        
                    else
                        cont2=0; 
                }
               
            }
        }
    }

    checkVertical() {
        let cont1, cont2;
        
        // Metodo de la class Tablero que busca el elemento y guarda el índice, si este esta, en un array:
        let td1Arr = tablero.contain(player1.getName());
        let td2Arr = tablero.contain(player2.getName());


        // Ya obtenidos en los td que se encuentran las fichas de los jugadores, paso a comprobar por cada jugador si estan continuas en horizontal:
        for(let i=0; i<td1Arr.length; i++) { 
            
            let e = td1Arr[i]; // Almaceno el indice donde se encuentra la ficha del jugador 1 en este caso.
        
            cont1=0;
            for(let tr=this.filas-1; tr>=0; tr--) {

                    if(tablero.getTablero()[tr][e] === player1.getName())
                        cont1++;
                    else 
                        cont1=0;    // En el momento en que no sea una ficha del jugador 1 reinicia el recuento.
                
                    if(cont1>=4)
                        return player1.getName();
            }
            
        }

        for(let i=0; i<td2Arr.length; i++) {
            let e = td2Arr[i];

            cont2=0;
            for(let tr=this.filas-1; tr>=0; tr--) {
                
                    if(tablero.getTablero()[tr][e] == player2.getName())
                        cont2++;
                    else 
                        cont2=0;
                
                    if(cont2>=4)
                        return player2.getName();
            
            }
        }
    }

    checkDiagonal() {
        let cont1iz=0,cont2iz=0, cont1=0, cont2=0;
        
        let td1Arr = tablero.contain(player1.getName());
        let td2Arr = tablero.contain(player2.getName());
    
        for(let i=0; i<td1Arr.length; i++) { //Player1 Diagonal
                
            let e = td1Arr[i];
            
            if(e<3) {// Compruebo hacia la derecha:
                
                cont1=0;
                for(let tr=this.filas-1; tr>=0; tr--,e++) {
                
                    if(cont1==0) 
                        e = td1Arr[i];
        
                    if(tablero.getTablero()[tr][e] === player1.getName())
                        cont1++;
                    else 
                        cont1=0;
                        
                    if(cont1>=4)
                        return player1.getName();
                }
            }
    
            if(e>3) {// Compruebo hacia la izquierda:
    
                cont1=0;
            
                for(let tr=this.filas-1; tr>=0; tr--,e--) {
                    if(cont1==0)
                        e = td1Arr[i];
        
                    if(tablero.getTablero()[tr][e] === player1.getName())
                        cont1++;
                    else 
                        cont1=0; 
                        
                    if(cont1>=4)
                        return player1.getName();
                }
            }
    
    
            else { // Hacia ambos lados
    
                cont1=0,cont1iz=0;
    
    
                    for(let tr=this.filas-1; tr>=0; tr--,e++) {
                        if(cont1==0)
                            e = td1Arr[i];
    
                        if(tablero.getTablero()[tr][e] === player1.getName())
                            cont1++;
                        else 
                            cont1=0; 
                            
                        if(cont1>=4)
                            return player1.getName();
                    }
    
                    e = td1Arr[i];
    
                    for(let tr=this.filas-1; tr>=0; tr--,e--) {
                        if(cont1iz==0)
                            e = td1Arr[i];
    
                        if(tablero.getTablero()[tr][e] === player1.getName())
                            cont1iz++;
                        else 
                            cont1iz=0; 
                            
                        if(cont1iz>=4)
                            return player1.getName();
                    } 
            }
        }
    
        for(let i=0; i<td2Arr.length; i++) { // Player2 Diagonal
            
            let e = td2Arr[i];

            cont2iz=0, cont2=0;
    
            if(e<3) {// Compruebo hacia la derecha:
    
                for(let tr=this.filas-1; tr>=0; tr--,e++) {
                    if(cont2==0)
                        e = td2Arr[i];
    
        
                    if(tablero.getTablero()[tr][e] === player2.getName())
                        cont2++;
                    else 
                        cont2=0;
                        
                    if(cont2>=4)
                        return player2.getName();
                }
            }
    
            if(e>3) {// Compruebo hacia la izquierda:
    
                cont2=0;

                for(let tr=this.filas-1; tr>=0; tr--,e--) {
                    if(cont2==0)
                        e = td2Arr[i];
    
                    if(tablero.getTablero()[tr][e] === player2.getName())
                        cont2++;
                    else 
                        cont2=0; 
                        
                    if(cont2>=4)
                        return player2.getName();
        
                }
            }
            else { //Ambos lados:
                
                cont2iz=0, cont2=0;
                for(let tr=this.filas-1; tr>=0; tr--,e++) {
                    if(cont2==0)
                        e = td2Arr[i];
    
                    if(tablero.getTablero()[tr][e] === player2.getName())
                        cont2++;
                    else 
                        cont2=0; 
                        
                    if(cont2>=4)
                        return player2.getName();
            
    
                }
                e = td2Arr[i];
                
                cont2iz=0, cont2=0;
                for(let tr=this.filas-1; tr>=0; tr--,e--) {
                    if(cont2iz==0)
                        e = td2Arr[i];
    
                    if(tablero.getTablero()[tr][e] === player2.getName())
                        cont2iz++;
                    else 
                        cont2iz=0; 
                        
                    if(cont2iz>=4)
                        return player2.getName();
                    
                }
            }
    
        }
    }

    checkComplete() {
        let cont=0;

            for(let td=0; td<this.columnas; td++)   // Solo recorro el final del tablero para verificar si se da el empate.
                if(this.tablero[0][td] != null)
                    cont++;

        if(cont == this.columnas)
            return true;
        
    }
}