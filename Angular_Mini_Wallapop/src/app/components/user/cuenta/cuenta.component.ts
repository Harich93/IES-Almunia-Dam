import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../../services/user.service';

@Component({
  selector: 'app-cuenta',
  templateUrl: './cuenta.component.html',
  styleUrls: ['./cuenta.component.scss']
})
export class CuentaComponent implements OnInit {

  public name: string = "";
  public email: string = ""

  constructor( private uService: UserService ) { 
    this.name = uService.usuario.displayName;
    this.email = uService.usuario.email;
  }

  ngOnInit(): void {
  }

}
