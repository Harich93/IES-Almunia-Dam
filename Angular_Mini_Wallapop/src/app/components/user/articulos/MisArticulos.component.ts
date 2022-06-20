import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ArticulosService } from '../../../../services/articulos.service';
import { UserService } from '../../../../services/user.service';
import { iArticulo } from '../../../interfaces/articulo.interface';

@Component({
  selector: 'app-articulos',
  templateUrl: './misarticulos.component.html',
  styleUrls: ['./misarticulos.component.scss']
})
export class MisArticulosComponent implements OnInit {

  public articulos!: iArticulo[];
  public articulos$!: Subscription

  constructor( private aService: ArticulosService, private uService: UserService ) { 
    this.articulos$ = this.aService.articulos$.subscribe( arts => this.articulos = arts.filter( art => art.id_vendedor === this.uService.usuario.uid ) )
  }

  ngOnInit(): void {
  }

}
