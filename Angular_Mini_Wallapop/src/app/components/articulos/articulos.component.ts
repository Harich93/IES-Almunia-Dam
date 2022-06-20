import { Component, OnInit } from '@angular/core';
import { iArticulo } from '../../interfaces/articulo.interface';
import { ArticulosService } from '../../../services/articulos.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-articulos',
  templateUrl: './articulos.component.html',
  styleUrls: ['./articulos.component.scss']
})
export class ArticulosComponent implements OnInit {

  public articulos: iArticulo[] = [];
  public articulos$!: Subscription;
  public lista: boolean = false;

  constructor( private aService: ArticulosService ) {}
    
    ngOnInit(): void {
      this.articulos$ = this.aService.articulos$.subscribe( datos => this.articulos.push( ...datos ) );
    }

    filtrar( categoria: string ) {
      if( categoria === 'all' )  this.articulos = this.aService.articulos;
      else this.articulos = this.aService.articulos.filter( art => art.categoria.toLocaleLowerCase() === categoria )
    }

}
