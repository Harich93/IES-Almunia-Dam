import { Component, OnInit } from '@angular/core';
import { ChisteService } from 'src/app/service/chiste.service';
import { Chiste } from '../../model/chiste.class';


@Component({
  selector: 'app-main-chistes',
  templateUrl: './main-chistes.component.html',
})


export class MainChistesComponent implements OnInit{
  
  
  private _chiste:Chiste = new Chiste('', '');
  private _chistes!:Chiste[] ;

  constructor( private chistesService:ChisteService ){}
  
  ngOnInit(): void {
    this._chistes = this.chistesService.chistes;
    this.chistesService.chistes$.subscribe( chistes => this._chistes = chistes );
  }
  
  get chiste() {
    return this._chiste
  }

  get chistes() {
    return this._chistes;
  }

}
