import { v4 } from 'uuid';

export class Course {

   private _id: string;
   private _name: string;
   private _price: number;
   private _image: string;
   
   constructor( name, price, image = "", id = "" ){
      this._id = id != "" ? id : v4();
      this._name = name;
      this._price = price;
      this._image = image != "" ?  image : "http://estacionlafinca.com/img/producto_sin_imagen.jpg";
   }

   get id(): string {
      return this._id;
   }
   
   get image(): string {
      return this._image;
   }

   set image(value: string) {
      this._image = value;
   }

   get price(): number {
      return this._price;
   }

   set price(value: number) {
      this._price = value;
   }

   get name(): string {
      return this._name;
   }

   set name(value: string) {
      this._name = value;
   }


}