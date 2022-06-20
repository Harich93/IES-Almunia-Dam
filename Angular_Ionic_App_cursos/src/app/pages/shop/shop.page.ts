import { Component } from '@angular/core';
import { Course } from 'src/app/interfaces/course';
import { Subscription } from 'rxjs';
import { ShopService } from '../../services/shop.service';
import { CoursesService } from '../../services/courses.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.page.html',
  styleUrls: ['./shop.page.scss'],
})
export class ShopPage{

  public shop: Course[] = []
  private shop$: Subscription;

  constructor( private sShop: ShopService, private sCourses: CoursesService ) { 
    this.shop$ = sShop.shop$.subscribe( shop => this.shop = shop)  
  }

  delete( course: Course ) {
    this.sShop.removeToShop( course );
  }

  buy(){
    const idsCourses: string[] = this.shop.map( course => course.id )
    this.sCourses.addBuyCourses( this.shop ) 
    this.sShop.buyCourses( idsCourses ).subscribe( console.log );
  
    this.sShop.removeAll();
  }

}
