
class Cliente {

    nombre;
    dni;

    constructor( nombre, dni ){
        this.nombre = nombre;
        this.dni = dni;
     }

    get nombre() {
        return this.nombre;
    }

    get dni() {
        return this.dni;
    }

    set nombre( arg ) {
        this.nombre = arg;
    }
}

module.exports = Cliente;