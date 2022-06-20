import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { iArticulo } from '../../../interfaces/articulo.interface';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-articulo',
  templateUrl: './articulo.component.html',
  styleUrls: ['./articulo.component.scss']
})
export class ArticuloComponent implements OnInit {

  @Input() articulo!: iArticulo;
  @Input() lista: boolean = false;
  @Input() listaSmall: boolean = false;
  
  constructor( private router: Router) { }

  ngOnInit(): void {}
  
  detalleArticulo(){
    this.router.navigate([`/article/${this.articulo.id}`]);
  }

}
