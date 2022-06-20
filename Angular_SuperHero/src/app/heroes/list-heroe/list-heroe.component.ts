import { Component } from '@angular/core';
import { heroes } from 'src/db/heroes';
import { Heroe } from '../model/heroe.class';



@Component({
  selector: 'app-list-heroe',
  templateUrl: './list-heroe.component.html',
  styleUrls: ['./list-heroe.component.scss']
})
export class ListHeroesComponent {

  private _heroes:Heroe[] = []

  constructor(){
    heroes.map( h => this._heroes.push( new Heroe( h.id, h.superhero, h.publisher, h.alter_ego, h.first_appearance, h.characters )) );

  }

  get heroes():Heroe[] {
    console.log( [...this._heroes])
    return [...this._heroes];
  }

  console ( data:Heroe ) {
    console.log( data );
  }

}
