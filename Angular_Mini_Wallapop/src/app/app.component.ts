import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FirebaseApp } from 'firebase/app';
import { firebase } from '../app/config/firebase.config'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  private app!: FirebaseApp;
  
  constructor(){ this.app = firebase }

  ngOnInit(): void {
      
  }
}
