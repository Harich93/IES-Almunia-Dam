import { Injectable } from '@angular/core';
import { CanLoad, Route, UrlSegment, UrlTree, Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { User } from '../interfaces/user';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class LoginOut implements CanLoad {

  private _user: User
  private _user$: Subscription;
  constructor( private as: AuthService, private router: Router ){
    this._user$ = this.as.connectedUser$.subscribe( us => this._user = us )
  }

  canLoad(
    route: Route,
    segments: UrlSegment[]): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
 
      if( this._user != null ) return true;
      return this.router.navigate(['/login']).then(() => false);
    }
}
