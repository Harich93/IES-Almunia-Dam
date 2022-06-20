import { Component, Input} from '@angular/core';
import { Heroe } from '../model/heroe.class';

@Component({
  selector: 'app-card-heroe',
  templateUrl: './card-heroe.component.html',
  styleUrls: ['./card-heroe.component.scss']
})
export class CardHeroeComponent {

  @Input() heroe!:Heroe;

  constructor(){}

  console ( data:Heroe) {
    console.log(data)
  }
  get heroeImage():string{

      const url = `assets/img/${this.heroe.id}.jpg` 
      return url;
  }
}
  


