import { Component, ElementRef, ViewChild, OnInit } from '@angular/core';
import { iImage } from './interface/img.interface';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  private _urlsImage: iImage = {
    img1: 'https://images.pexels.com/photos/9187313/pexels-photo-9187313.jpeg?cs=srgb&dl=pexels-taras-kots-9187313.jpg&fm=jpg',
    img2: 'https://images.pexels.com/photos/9309903/pexels-photo-9309903.jpeg?cs=srgb&dl=pexels-feelalivenow-9309903.jpg&fm=jpg'
  }
  private _oculta: boolean;
  private _img: string;
  
  @ViewChild('imgVC') imgVC!: ElementRef<HTMLImageElement>; 
  
  constructor(){
    this._oculta = false;
    this._img = this._urlsImage.img1;
  }

  ngOnInit(): void {
  }
  
  ngAfterViewInit() {
    let imgPers = this.imgVC.nativeElement.src;
    
    if(imgPers != this._urlsImage.img1 && imgPers != this._urlsImage.img2)
        this._urlsImage = { ...this._urlsImage, imgPers };
  }


  get img(){
    return this._img;
  }

  get oculta() {
    return this._oculta;
  }

  get urlsImage(){
    return {...this._urlsImage};
  }

  ocultarImagen( event: any ){
    this._oculta = !this._oculta;
  }

  cambiarImg( event: any ) {
    this._img === this._urlsImage.img1 
      ? this._img = this._urlsImage.img2
      : this._img = this._urlsImage.img1
  }

  cambiarImgVC( event: any ) {
    
      this.imgVC.nativeElement.src === this._urlsImage.img1
        ? this.imgVC.nativeElement.src = this._urlsImage.img2
        : this.imgVC.nativeElement.src = this._urlsImage.img1
  
  }

  

}
