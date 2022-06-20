import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModalController } from '@ionic/angular';
import { ImageService } from '../../services/image.service';
import { CoursesService } from '../../services/courses.service';

@Component({
  selector: 'app-new-course',
  templateUrl: './new-course.page.html',
  styleUrls: ['./new-course.page.scss'],
})
export class NewCoursePage implements OnInit {

  public formNewCourse : FormGroup;
  
  public name: AbstractControl;
  public price: AbstractControl;
  public img: Blob;
  public imgPath: string;
  public isModalOpen: boolean = false;

  constructor(
    private fb: FormBuilder,
    private sImage: ImageService,
    private sCourses: CoursesService, 
    public modalController: ModalController,
  ) { }

  ngOnInit() {
    this.formNewCourse = this.fb.group({
      name: ['', Validators.required ],
      price: ['', Validators.required ]
    });

    const { name, price } = this.formNewCourse.controls;
    this.name = name;
    this.price = price;
    this.img;
  }

  createCourse(){
    this.sCourses.createCourse( this.name.value, this.price.value, this.img )
    this.reset();
  }

  async openGalery(){
    this.isModalOpen = false;
    this.img = await this.sImage.imageGalery();
  }

  async takePhoto(){
    this.isModalOpen = false;
    this.img = await this.sImage.takePhoto();
  }

  reset(){
    this.img = null;
    this.name.reset("");
    this.price.reset(0.0);
  }

}
