import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArticulosService } from '../../../../services/articulos.service';
import { iArticulo } from '../../../interfaces/articulo.interface';



@Component({
  selector: 'app-detalle-articulo',
  templateUrl: './detalle-articulo.component.html',
  styleUrls: ['./detalle-articulo.component.scss']
})
export class DetalleArticuloComponent implements OnInit {


  public producto!: Object;

  public articulo!: iArticulo
  public id!: string;

  constructor( private rutaActiva: ActivatedRoute, private sArticulos: ArticulosService) {
    this.articulo = this.sArticulos.articulos.find( art => art.id === this.rutaActiva.snapshot.params.id )!;
    this.id = this.articulo.id_vendedor;
    
  }
  
  ngOnInit(): void {
  }

}
