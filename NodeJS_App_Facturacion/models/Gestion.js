require('colors');

const Cliente = require('./Cliente.js')
const Factura = require('./Factura.js')
const { leerClientesDB, leerFacturasDB, guardarClienteDB, guardarFacturaDB} = require('./fs.js')


class Gestion {

    clientes = [];
    facturas = [];

    constructor( clientes, facturas ){
        this.cargarDatos();
    }

    get clientes() {
        return this.clientes;
    }

    get facturas() {
        return this.facturas
    }

    cargarDatos(){

        let datosClientes, datosFacturas; 

        if( ( datosClientes = leerClientesDB() ) != null )
            datosClientes.map( cli => this.clientes.push(cli) );
        
        if( ( datosFacturas = leerFacturasDB() ) != undefined )
            datosFacturas.map( fac => this.facturas.push(fac) );
    }

    agregarCliente( nombre, dni ) {
        let nuevoCliente = new Cliente( nombre, dni);
        let existeCliente = this.clientes.find( cli => cli.dni === dni);

        if( !existeCliente ) {
            this.clientes.unshift( nuevoCliente );
            console.log("Cliente agregado".green);
            guardarClienteDB(this.clientes);
        }
        else{
            console.log("El cliente ya existe".red)
        }
    }

    agregarFactura( id, fecha, dniCliente, total, articulos = [] ) {
        let cliente = this.clientes.find( cli => cli.dni === dniCliente );
        let factura = this.facturas.find( fac => fac.id === id );

        if( !cliente ) console.log( 'El cliente no está registrado, cree al cliente.'.red )
            if( !factura ) console.log( `La factura con id: ${id} ya existe.`.red )
            else {
                let nuevaFactura = new Factura(id, cliente, fecha, total,articulos)  
                this.facturas.unshift( nuevaFactura );
                guardarFacturaDB( this.facturas );
                console.log('Factura agregada'.green )
            }
        
    }

    eliminarClienteId( arg ) {
        let cliente = this.clientes.find( cli => cli.dni === arg );

        if( cliente != undefined ){
            this.clientes = this.clientes.filter( cli => cli.dni != arg );
            guardarClienteDB( this.clientes );
            console.log('Cliente eliminado'.green);
        }
        else console.log('El DNI no corresponde a ningun cliente'.red);
    }

    eliminarFacturaId( arg ) {
        let factura = this.facturas.find( fact => fact.id === arg );

        if( factura != undefined ){
            this.facturas = this.facturas.filter( fact => fact.id != arg );
            guardarFacturaDB( this.facturas );
            console.log('Factura eliminada'.green);
        }
        else console.log('El identificador no corresponde a ninguna factura'.red);
    }

    listarClientes( arg ){

        if( arg ) 
            this.clientes.forEach( (cli, ind )=> 
                cli.dni === arg && 
                    console.log( `${ind + 1}. `.green + `${cli.dni}`.cyan + ` ${cli.nombre}`.cyan ) 
            );
        
        else 
            this.clientes.forEach( (cli, ind )=> 
                console.log( `${ind + 1}. `.green + `${cli.dni}`.cyan + ` ${cli.nombre}`.cyan ) 
            );
    }
    

    listarFacturas( arg ){
        if( arg ) 
            this.facturas.map( fact => fact.id === arg && console.log( fact ) );
        else 
            this.facturas.forEach( (fac, ind ) => 
                console.log( `${ind + 1}. `.green + `${fac.id}`.magenta + ` DNI cliente:`.gray + ` ${fac.cliente.dni}`.cyan +` Total: `.gray+`${fac.total} €`.cyan + ` Fecha: `.gray + ` ${fac.fecha}`.cyan ) 
            );
    }


}

module.exports = Gestion;