import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { iUser, iDireccion } from '../app/interfaces/user.interface';
import { Router } from '@angular/router';
import { doc, setDoc } from 'firebase/firestore/lite';
import { db } from 'src/app/config/firebase.config';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private _desconectado: iUser = { 
    displayName: "",
    uid: "",
    direccion: {
      dir: "",
      ciudad:""
    },
    email: "",
  };
  private _usuario!: iUser;
  private _usuario$: Subject<iUser>;

  constructor( private router: Router ) { 
    this._usuario$ = new Subject(); 
    this._usuario = {...this._desconectado};
  }

  get usuario():iUser {
    return this._usuario;
  }

  get usuario$():Observable<iUser> {
    return this._usuario$.asObservable();
  }

  get direccion(){
    return this._usuario!.direccion.dir + this._usuario!.direccion.ciudad;
  }
  
  isConnected(): boolean {
    if( this._usuario.uid === "") return true;
    return false;
  }
  
  login( uid: string, displayName: string, email: string, direccion = { ciudad: "", dir: "" } ){
    this._usuario.uid = uid;
    this._usuario.displayName = displayName;
    this._usuario.email = email;
    this._usuario.direccion = direccion;
  }

  logout() {
    this._usuario = {...this._desconectado};
    this.router.navigate(['/auth/login'])
  }



}
