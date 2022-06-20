import { Component, Input, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UserService } from '../../../services/user.service';
import { iDireccion } from '../../interfaces/user.interface';
import { AuthService } from '../../../services/auth.service';

interface iCenter {
  lat: number;
  lng: number;
}

@Component({
  selector: 'app-google-map',
  templateUrl: './google-map.component.html',
  styleUrls: ['./google-map.component.scss']
})
export class GoogleMapComponent implements OnInit {

  @Input() uid!: string;
  @Input() vistaArticulo: boolean = false;

  public src: string = "";
  private _ciudad!: string;
  public width!: number;
  public height!: number;

  constructor( private user: UserService, private auth: AuthService ) {
    this.vistaArticulo ? ( this.width = 600, this.height=650 ) : ( this.width = 800, this.height=350 )
  }
  
  ngOnInit(): void { this.establecerDireccion() }

  private establecerDireccion = async() => {
    
    if(this.uid === null ) this._ciudad = this.user.direccion;

    else {
      
      let direccion: iDireccion = await this.auth.getDireccion( this.uid );

      this._ciudad = direccion.dir + direccion.ciudad;
      
    }

    this.src = `https://www.google.com/maps/embed/v1/place?key=${environment.googleApi}&q=${ this._ciudad }`;
  }

}