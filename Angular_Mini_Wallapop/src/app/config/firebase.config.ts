import { initializeApp } from "firebase/app";
import { environment } from "src/environments/environment";
import { getFirestore } from 'firebase/firestore/lite';
import { GoogleAuthProvider, createUserWithEmailAndPassword, getAuth } from "firebase/auth";

  const firebaseConfig = {
    apiKey: environment.firebase.key ,
    authDomain: environment.firebase.authDomain ,
    projectId: environment.firebase.projectId ,
    storageBucket: environment.firebase.storageBucket,
    messagingSenderId: environment.firebase.messagingSenderId,
    appId: environment.firebase.appId
  };

  const firebase = initializeApp(firebaseConfig);
  
  const db = getFirestore(firebase);

  const googleAuthProvider = new GoogleAuthProvider();
  googleAuthProvider.setCustomParameters({
    prompt: 'select_account'
  });

export {
    db,
    googleAuthProvider,
    firebase,
    createUserWithEmailAndPassword,
    getAuth
}