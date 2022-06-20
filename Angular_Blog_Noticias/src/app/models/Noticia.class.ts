import { v4 } from 'uuid';

export class Noticia {

    private _id: string;
    private _fecha: Date;
    private _titulo: string;
    private _texto: string;

    constructor( titulo: string, texto: string ){
        this._id = v4();
        this._fecha = new Date();
        this._titulo = titulo;
        this._texto = texto;
    }

    get id(): string{
        return this._id;
    }

    get fecha(): Date {
        return this._fecha;
    }

    get titulo(): string {
        return this._titulo;
    }

    get texto(): string {
        return this._texto;
    }

    set fecha( arg: Date ) {
        this._fecha = arg;
    }

    set titulo( arg: string ) {
        this._titulo = arg;
    }

    set texto( arg: string ) {
        this._texto = arg;
    }

}