import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Course } from '../interfaces/course';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  private _shop: Course[] = [];
  private _shop$: BehaviorSubject<Course[]>;
  
  constructor( private http: HttpClient ) { 
    this._shop$ = new BehaviorSubject([...this._shop]); 
  }

  get shop(): Course[] {
    return this._shop;
  }

  get shop$(): Observable<Course[]> {
    return this._shop$.asObservable();
  }

  addToShop( course: Course ) {
    
    !this._shop.includes( course ) 
      && this._shop.push( course );

    this._shop$.next([...this._shop]);
  }

  removeAll(){
    this._shop = [];
    this._shop$.next([...this._shop]);
  }

  removeToShop( course: Course ) {
    this._shop = this._shop.filter( item => item != course );
    this._shop$.next([...this._shop]);
  }

  buyCourses( idsCourses: string[] ): Observable<Course[]> {
    
    const token = localStorage.getItem('x-token');
    
    return this.http.post<Course[]>('http://localhost:8080/users/buy',{ courses: idsCourses }, {
      headers: {
        "x-token": token
      }
    });
  }


}
