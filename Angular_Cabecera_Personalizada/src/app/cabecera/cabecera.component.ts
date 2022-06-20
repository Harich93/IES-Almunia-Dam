
import { 
  Component,
  EventEmitter, 
  Input, 
  OnInit, 
  Output, 
  } from '@angular/core';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.scss']
})
export class CabeceraComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input()  oculta!: boolean;
 
  @Output() onCambioImg: EventEmitter<any> = new EventEmitter();
  @Output() onCambioImgVC: EventEmitter<any> = new EventEmitter();
  @Output() onOcultarImg: EventEmitter<any> = new EventEmitter();
  
  cambiarImagen(){
    this.onCambioImg.emit();
  }

  cambiarImagenVC(){
    this.onCambioImgVC.emit();
  }

  ocultarImagen(){
    this.onOcultarImg.emit();
  }

}
