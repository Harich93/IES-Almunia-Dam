import { Component, OnInit } from '@angular/core';
import { StyleService } from '../../service/style.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  constructor( public style: StyleService) { }


  ngOnInit(): void {
  }

  cambiaEstilo(){
    this.style.cambiaEstilo();
  }
}
