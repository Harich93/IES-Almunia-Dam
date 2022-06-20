import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  constructor( private uService: UserService) { }

  ngOnInit(): void {
  }

  cerrarSesion(){
    this.uService.logout()
  }
}
