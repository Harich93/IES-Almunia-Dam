import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StyleService {

  public oscuro: boolean = false;

  constructor() { }

  cambiaEstilo(){
    this.oscuro = !this.oscuro
  }
}
