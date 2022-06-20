import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public conectado: boolean;
  
  constructor() { this.conectado = false }
}
