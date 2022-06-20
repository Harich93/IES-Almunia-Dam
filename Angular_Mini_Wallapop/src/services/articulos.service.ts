import { Injectable } from '@angular/core';
import { addDoc, collection, getDocs } from 'firebase/firestore/lite';
import { Subject, Observable, BehaviorSubject } from 'rxjs';
import { db } from 'src/app/config/firebase.config';
import { iArticulo } from 'src/app/interfaces/articulo.interface';

@Injectable({
  providedIn: 'root'
})
export class ArticulosService {

  private _articulos: iArticulo[] = []
  private _articulos$!: BehaviorSubject<iArticulo[]>;

  constructor() { 
    this._articulos$ = new BehaviorSubject<iArticulo[]>([...this._articulos]);
    this.getAllArticulos();
  }
  
  get articulos$(): Observable<iArticulo[]> {
    return this._articulos$.asObservable();
  }
  
  get articulos(): iArticulo[] {
    return [...this._articulos];
  }
  
  private getAllArticulos = async() => {
    this._articulos = [];
    const querySnapshot = await getDocs(collection(db,"articles"));
    
    querySnapshot.forEach( doc => {
      let articulo = { ...doc.data() as iArticulo , id: doc.id }
      this._articulos.push( articulo ) 
    } );
    this._articulos$.next( this.articulos );
  }

  agregarArticulo( arg: iArticulo ) {
    this._articulos.push( arg );
    this._articulos$.next( [...this._articulos] );
  }

  articulosPropietario( id: string): iArticulo[] {
    return this._articulos.filter( art => art.id_vendedor === id)
  }

  ariculosCategoria( categoria: string ): iArticulo[] {
    return this._articulos.filter( art => art.categoria === categoria)
  }

  publicarArticulo = async( articulo: iArticulo ) => {
    await addDoc(collection( db,"articles"), articulo );
    await this.getAllArticulos();
  }

  imgUpload = async( file: File): Promise<string> => {
    const cloudUrl = `https://api.cloudinary.com/v1_1/harich-projects/upload`;
    const formData = new FormData();

    formData.append('upload_preset','MiniWallapop');
    formData.append('file', file);

    try {
        const resp = await fetch( cloudUrl, {
            method: 'POST',
            body: formData
        });

        if( resp.ok ) {
            const cloudresp = await resp.json();
            return cloudresp.secure_url;
        }
    } catch (error) {
        throw error;
    }

    return "";
}


}
