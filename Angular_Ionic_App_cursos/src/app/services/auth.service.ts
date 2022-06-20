import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable, BehaviorSubject } from 'rxjs';
import { User } from '../interfaces/user';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _connectedUser: User = null;

  private _connectedUser$: Subject<User>;

  constructor( private http: HttpClient, private router: Router ) {
    this._connectedUser$ = new BehaviorSubject<User>(this._connectedUser);
    this._connectedUser$.next(this._connectedUser);
  }

  get connectedUser$(): Observable<User> {
    return this._connectedUser$.asObservable();
  }

  get isConnected(): boolean {
    if( this._connectedUser === null ) return false;
    return true;
  }

  login( email: string, password: string) {

    this.http.post<User>('http://localhost:8080/auth/login', {email, password})
      .subscribe( (resp) => {
        
        if( resp.token !== undefined ) {
          this._connectedUser = resp;
          localStorage.setItem('x-token', resp.token );
          this._connectedUser$.next(this._connectedUser);
          this.router.navigate(['/list-courses'])
          this.router.navigate(['/'])
        }
        
      })
  }

  logout() {
    localStorage.clear();
    this._connectedUser = null;
    this.router.navigate(['/'])
  }

  loginWithToken( token: string ) {

    this.http.post<User>('http://localhost:8080/auth/loginToken',{},{
      headers: {
        "x-token": token
      }
    }).subscribe( (resp) => {
      this._connectedUser = resp;
      this._connectedUser$.next(this._connectedUser);
      this.router.navigate(['/list-courses'])
    })
      
  }
}


