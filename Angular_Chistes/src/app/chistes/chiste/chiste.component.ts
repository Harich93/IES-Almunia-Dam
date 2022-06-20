import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ChisteService } from 'src/app/service/chiste.service';
import { Chiste } from '../../model/chiste.class';


@Component({
  selector: 'app-chiste',
  templateUrl: './chiste.component.html',
  styleUrls: ['./chiste.component.scss']
})
export class ChisteComponent{

  @Input() chiste:Chiste = new Chiste('','');

  constructor( private chistesService: ChisteService ){}

  mostrarOcultar(){
    this.chiste.oculto = !this.chiste.oculto;
  }

  eliminar( arg:Chiste ) {
    this.chistesService.borrarChiste(arg);
  }
  
}
