import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../../services/courses.service';
import { Course } from '../../interfaces/course';
import { NavController } from '@ionic/angular';
import { Subscription } from 'rxjs';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage {

  public buyCourses: Course[] = [];
  public sellsCourses: Course[] = [];

  private buyCourses$: Subscription;
  private sellsCourses$: Subscription;


  constructor( public sCourses: CoursesService, private nav: NavController, private sAuth: AuthService) {
    
    sCourses.loadBuyCourses()
    sCourses.loadSellsCourses()
   
    this.buyCourses$ = this.sCourses.buyCourses$.subscribe( buyCourses => this.buyCourses = buyCourses )
    this.sellsCourses$ = this.sCourses.sellsCourses$.subscribe( sellsCourses => this.sellsCourses = sellsCourses )
    
  }

  details( value: Course ){
    this.nav.navigateForward(`/details/${value.id}`)
  }

  logout() {
    this.sAuth.logout();
  }

}
