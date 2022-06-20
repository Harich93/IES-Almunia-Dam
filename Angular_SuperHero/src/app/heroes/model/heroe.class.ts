export class Heroe {

    private _id:string;
    private _superhero:string;
    private _publisher:string; 
    private _alter_ego:string;
    private _first_appearance:string;
    private _characters:string;
    private _oculto:boolean;

    constructor( id:string, superhero:string, publisher:string, alter_ego:string, first_appearence:string, characters:string ) {
        this._id = id;
        this._superhero = superhero;  
        this._publisher =  publisher;
        this._alter_ego =  alter_ego;
        this._first_appearance = first_appearence;
        this._characters = characters;
        this._oculto = false;
    }

    get id(){
        return this._id;
    }

    get superhero() {
        return this._superhero;
    }

    get publisher() {
        return this._publisher;
    }

    get alter_ego() {
        return this._alter_ego;
    }

    get first_appearence() {
        return this._first_appearance;
    }

    get characters() {
        return this._characters;
    }

    get oculto() {
        return this._oculto;
    }

    changeVisibility() {
        this._oculto = !this._oculto;

    }

}