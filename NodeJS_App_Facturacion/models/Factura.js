const { v4 } = require('uuid');

class Factura {

    id;
    cliente ;
    fecha;
    total;
    articulos;

    constructor( id, cliente, fecha, total ,articulos = [] ){
        this.id = id
        this.total = total;
        this.cliente = cliente;
        this.fecha = fecha;
        this.articulos = articulos;
    }

    get id() {
        return this.id;
    }

    get fecha() {
        return this.fecha;
    }

    get cliente() {
        return this.cliente;
    }

    get articulos() {
        return this.articulos;
    }

    get total() {
        return this.total;
    }

    set total( arg ) {
        this.total = arg;
    }

    set cliente( arg ){
        this.cliente = arg;
    }

    set fecha( arg ) {
        this.fecha = arg;
    }

    set id( arg ){
        this.id = arg;
    }

    agregarArticulo( arg ) {
        this.articulos.push( arg );
    }

    eliminarArticulo( arg ) {
        this.articulos = this.articulos.filter( art => art != arg )
    }

}

module.exports = Factura;