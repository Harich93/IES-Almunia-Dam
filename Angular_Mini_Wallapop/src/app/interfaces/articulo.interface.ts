export interface iArticulo {
    id?         : string;
    id_vendedor : string;
    nombre      : string;
    precio      : number;
    descripcion : string;
    img         : string;
    categoria   : 'vehiculo' | 'hogar' | 'electronica';
    estado      : string;
    vendido     : boolean;
}