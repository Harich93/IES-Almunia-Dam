import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CoursesService } from '../../services/courses.service';
import { ImageService } from '../../services/image.service';
import { ModalController } from '@ionic/angular';
import { Course } from 'src/app/interfaces/course';
import { AuthService } from 'src/app/services/auth.service';
import { Photo } from '@capacitor/camera';

@Component({
  selector: 'app-details',
  templateUrl: './details.page.html',
  styleUrls: ['./details.page.scss'],
})
export class DetailsPage implements OnInit {

  public id: string;
  public course: Course;
  public formModCourse : FormGroup;
  
  public name: AbstractControl;
  public price: AbstractControl;
  public img: Photo;
  public imgPath: string;
  public isModalOpen: boolean = false;


  constructor( 
    private route: ActivatedRoute, 
    private sCourses: CoursesService, 
    private fb: FormBuilder,
    private sImage: ImageService,
    public modalController: ModalController,  
  ) { }

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    
    this.sCourses.findCourse(id).subscribe( course =>{
      this.course = course;
      this.name.setValue(course.name);
      this.price.setValue(course.price);
    });

    this.formModCourse = this.fb.group({
      name: ['', Validators.required ],
      price: ['', Validators.required ]
    });

    const { name, price } = this.formModCourse.controls;
    this.name = name;
    this.price = price;
    this.imgPath = this.course.img;

    this.name.setValue(this.course.name);
    this.price.setValue(this.course.price);
    
  }

  // delete(){
  //   this.sCourses.deleteCourse( this.course );
  //   this.router.navigate(['/list-courses']);
  // }

  myCourse(): boolean {
    return this.sCourses.sellsCourses.includes( this.course )
  }

  modCourse(){
    this.course.name = this.name.value;
    this.course.price = this.price.value;
    this.course.img = this.img.webPath;
  }

  async openGalery(){
    this.isModalOpen = false;
    await this.sImage.imageGalery();
    this.course.img = this.img.webPath;
  }

  async takePhoto(){
    this.isModalOpen = false;
    await this.sImage.takePhoto();
    this.course.img = this.img.webPath;
  }

}
