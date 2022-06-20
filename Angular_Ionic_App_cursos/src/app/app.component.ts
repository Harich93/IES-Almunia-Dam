import { Component } from '@angular/core';
import { MenuController } from '@ionic/angular';
import { Subscription } from 'rxjs';
import { User } from './interfaces/user';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  private token: string;

  constructor( public as: AuthService ) {
    this.token = localStorage.getItem('x-token');
    this.as.loginWithToken(this.token);
  }

  get connectedUser() {
    return this.as.isConnected
  }

}
