
export class Chiste {
    private _id:Date;
    private _anecdota  : string;
    private _respuesta : string;
    private _oculto: boolean;

    constructor( anecdota:string, respuesta:string ) {
        this._anecdota = anecdota;
        this._respuesta = respuesta;
        this._oculto = true;
        this._id = new Date();
    }

    get anecdota():string {
        return this._anecdota;
    }

    get respuesta():string {
        return this._respuesta;
    }

    get oculto():boolean {
        return this._oculto;
    }

    get id():Date {
        return this._id;
    }

    set anecdota( anecdota:string ){
        this._anecdota = anecdota;
    }

    set respuesta( respuesta:string ){
        this._respuesta = respuesta;
    }

    set oculto( estado:boolean ){
        this._oculto= estado;
    }
    
}