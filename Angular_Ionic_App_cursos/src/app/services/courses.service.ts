import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AllCourses, Course } from '../interfaces/course';
import { WriteFileResult } from '@capacitor/filesystem';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  
  private header: Object ;
  private _courses: Course[] = [];
  private _courses$: BehaviorSubject<Course[]>;

  private _buyCourses: Course[] = [];
  private _buyCourses$: BehaviorSubject<Course[]>;

  private _sellsCourses: Course[] = [];
  private _sellsCourses$: BehaviorSubject<Course[]>;
  
  constructor( private http: HttpClient ) { 
   
    this.loadAllCourses();
    this._courses$ = new BehaviorSubject([...this._courses]);
    this._buyCourses$ = new BehaviorSubject([...this._buyCourses]); 
    this._sellsCourses$ = new BehaviorSubject([...this._sellsCourses]); 
    
    const token = localStorage.getItem('x-token');

    this.header = {
      headers: {
        "x-token": token
      }
    }
  }

  get courses(): Course[] {
    return [...this._courses];
  }

  get sellsCourses(): Course[] {
    return [...this._sellsCourses];
  }

  get courses$(): Observable<Course[]> {
    return this._courses$.asObservable();
  }

  get buyCourses$(): Observable<Course[]> {
    return this._buyCourses$.asObservable();
  }

  get sellsCourses$(): Observable<Course[]> {
    return this._sellsCourses$.asObservable();
  }

  addBuyCourses( courses: Course[] ) {
    courses.forEach( c => this._buyCourses.push(c) );
    this._buyCourses$.next([...this._buyCourses])
  }

  addCourse( course: Course ) {
    this._courses.push( course );
    this._courses$.next([...this._courses]);
  }

  createCourse( name: string, price: string, img: Blob ) {
    
    console.log( img );
    
    const body = { name, price,  img: img};

    const formData = new FormData();
    formData.append('name', name);
    formData.append('price', price);
    formData.append('img', img);
    // formData.append('json', JSON.stringify(json));

    this.http.post<Course>('http://localhost:8080/courses', formData, this.header )
      .subscribe( resp => {
        this._courses.push( resp );
        this._sellsCourses.push( resp );
        this._courses$.next([...this._courses])
        this._sellsCourses$.next([...this._sellsCourses])
      })
  }

  findCourse( id: string ): Observable<Course>  {
    return this.http.get<Course>(`http://localhost:8080/courses/${id}`);
  }

  loadAllCourses() {
    this.http.get<AllCourses>('http://localhost:8080/courses')
      .subscribe( resp => {
        this._courses = resp.courses;
        this._courses$.next([...this._courses])
      });
  }

  loadBuyCourses() {
    this.http.get<Course[]>('http://localhost:8080/courses/buy', this.header)
      .subscribe( resp => { 
        this._buyCourses = resp 
        this._buyCourses$.next([...this._buyCourses])
      })
  }

  loadSellsCourses() {
    this.http.get<Course[]>('http://localhost:8080/courses/sells', this.header)
      .subscribe( resp => {
        this._sellsCourses = resp 
        this._sellsCourses$.next([...this._sellsCourses])
        
      })

  }



}
