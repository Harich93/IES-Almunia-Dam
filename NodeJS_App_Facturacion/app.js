const yargs = require("yargs");
const Gestion = require('./models/Gestion.js')

const gestion = new Gestion();

yargs.command({
    command: 'addCliente',
    describe: 'Agregar cliente',
    builder: {
        nombre: {
            describe: 'Nombre cliente',
            demandOption: true,
            type: 'string'
        },
        dni: {
            describe: 'DNI cliente',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv){
        gestion.agregarCliente( argv.nombre, argv.dni );
    }
})

yargs.command({
    command: 'borraCliente',
    describe: 'Eliminar factura',
    builder: {
        dni: {
            describe: 'DNI cliente',
            demandOption: true,
            type: 'string'
        },
    },
    handler(argv){
        gestion.eliminarClienteId(argv.id);
    }
})

yargs.command({
    command: 'addFactura',
    describe: 'Agregar factura',
    builder: {
        fecha: {
            describe: 'Fecha de la factura: dd/mm/yy',
            demandOption: true,
            type: 'date'
        },
        dni: {
            describe: 'DNI cliente',
            demandOption: true,
            type: 'string'
        },
        total: {
            describe: 'Total factura',
            demandOption: true,
            type: 'number'
        },
        articulos: {
            describe: 'Lista de rticulos, [command]=arg1 arg2 ...',
            demandOption: false,
            type: 'array'
        }
    },
    handler(argv){
        gestion.agregarFactura(argv.fecha, argv.dni, argv.total, argv.articles);
    }
})

yargs.command({
    command: 'borraFactura',
    describe: 'Eliminar factura',
    builder: {
        id: {
            describe: 'Identificador factura',
            demandOption: true,
            type: 'string'
        },
    },
    handler(argv){
        gestion.eliminarFacturaId(argv.id);
    }
})

yargs.command({
    command: 'listaClientes',
    describe: 'Listar clientes',
    builder: {
        dni: {
            describe: 'Filtrar por dni',
            demandOption: false,
            type: 'string'
        },
    },
    handler(argv){
        gestion.listarClientes( argv.dni );
    }
})

yargs.command({
    command: 'listaFacturas',
    describe: 'Listar facturas',
    builder: {
        id: {
            describe: 'Filtrar id factura',
            demandOption: false,
            type: 'string'
        },
    },
    handler(argv){
        gestion.listarFacturas( argv.id );
    }
})

yargs.parse();