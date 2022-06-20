import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../../services/courses.service';
import { NavController } from '@ionic/angular';
import { Course } from '../../interfaces/course';
import { ShopService } from '../../services/shop.service';
import { Subscription } from 'rxjs';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-list-courses',
  templateUrl: './list-courses.page.html',
  styleUrls: ['./list-courses.page.scss'],
})
export class ListCoursesPage implements OnInit {

  public courses: Course[] = [];
  private course$: Subscription;
  
  public shopLen: Number;
  private shop$: Subscription;

  constructor( 
    private sCourses: CoursesService, 
    private navControl: NavController,
    private sShop: ShopService,
    private sAuth: AuthService
  ) { 
    this.course$ = this.sCourses.courses$.subscribe( courses => this.courses = courses )
    this.shop$ = this.sShop.shop$.subscribe( shop => this.shopLen = shop.length )

  }
  
  ngOnInit() {

  }

  addToShop( course: Course ){
    this.sShop.addToShop( course );
  }


  details( value: Course ){
    this.navControl.navigateForward(`/details/${value.id}`)
  }

  logout() {
    this.sAuth.logout();
  }

}
