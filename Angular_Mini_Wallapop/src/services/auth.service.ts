import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { createUserWithEmailAndPassword, signInWithEmailAndPassword, getAuth, updateProfile, signInWithPopup, signOut, Auth  } from "firebase/auth";
import { getDoc, doc, setDoc, addDoc, collection } from 'firebase/firestore/lite';
import { googleAuthProvider, db } from '../app/config/firebase.config'
import { UserService } from './user.service';
import { iDireccion } from '../app/interfaces/user.interface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private auth!: Auth;

  constructor( private uService: UserService, private router: Router ) {}

  public startRegisterWhithEmailPassword = async( email:string, password:string, name:string ) => {

    this.auth = getAuth();
    const userCredential = await createUserWithEmailAndPassword( this.auth, email, password );
    const user = userCredential.user;
    await updateProfile( user, { displayName: name });
    
    const { displayName, uid } = user;

    if(displayName && email) {
      this.uService.login( uid, displayName, email);
      this.router.navigate(['/'])
    }
      
  }

  public startLoginEmailPass = async( email: string, pass: string ) => {
        this.auth = getAuth();
        
        const userCredential = await signInWithEmailAndPassword(this.auth, email, pass )
        const user = userCredential.user;
        
        const direccion: iDireccion = await this.getDireccion( user.uid );

        this.uService.login( user.uid, user.displayName!, email, direccion );
        this.router.navigate(['/'])
  
  }

  public startGoogleLogin = async() => {
   
    this.auth = getAuth();
    const userCredential = await signInWithPopup( this.auth, googleAuthProvider );
    
    const { displayName, email, uid } = userCredential.user;
    
    if(displayName && email) {
      const direccion = await this.getDireccion();
      this.uService.login( uid, displayName, email, direccion);
      this.router.navigate(['/'])
    }
  }
 
  public startLogout = async() => {   
    await signOut(this.auth);
    this.uService.logout();   
  }

  public getDireccion = async( uid: string = this.auth.currentUser?.uid! ): Promise<iDireccion> => {

    let dir!: iDireccion;

    const docSnap = await getDoc(doc(db, "users", `${uid.trim()}`));

    if (docSnap.exists()) {
      
      const{ direccion } = docSnap.data()
      dir = { ciudad: direccion[1], dir: direccion[0] } 
      return dir;
    }
    
    return dir;
  }

  public getPaypal = async( uid: string = this.auth.currentUser?.uid! ): Promise<string> => {

    const docRef = doc(db, "users", `${uid}`);
    const docSnap = await getDoc(docRef);
    
    
    if( docSnap.exists() ) 
      return docSnap.data().paypal

    return "";
  }

  public setPersonalData = async( displayName: string, ciudad: string, direccion: string ) => {
    const uid =  this.auth.currentUser?.uid;
    await setDoc(doc(db,"users",`${uid}`),{
      displayName,
      direccion: [ direccion, ciudad ],
    });
  }
  
}

