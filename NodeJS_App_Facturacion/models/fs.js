const fs = require('fs');

let pathClientes = './data/clientes.json';
let pathFacturas = './data/facturas.json'

const leerClientesDB = () => {
    
    if ( !fs.existsSync( pathClientes ) ) return null;

    const info = fs.readFileSync( pathClientes, { encoding: 'utf-8'} );
    const data = JSON.parse(info);

    return data;
}

const leerFacturasDB = () => {
    
    if ( !fs.existsSync( pathFacturas ) ) return null;

    const info = fs.readFileSync( pathFacturas, { encoding: 'utf-8'} );
    const data = JSON.parse(info);
    
    return data;
}

const guardarClienteDB = ( clientes ) => fs.writeFileSync( pathClientes, JSON.stringify(clientes) );

const guardarFacturaDB = ( facturas ) => fs.writeFileSync( pathFacturas, JSON.stringify(facturas) );


module.exports = {
    leerClientesDB,
    leerFacturasDB,
    guardarClienteDB,
    guardarFacturaDB
}