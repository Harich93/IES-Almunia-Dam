import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NoticiasService } from 'src/app/service/noticias.service';
import { Noticia } from '../../models/Noticia.class';
import { StyleService } from '../../service/style.service';

@Component({
  selector: 'app-detalle-noticia',
  templateUrl: './detalle-noticia.component.html',
  styleUrls: ['./detalle-noticia.component.scss']
})
export class DetalleNoticiaComponent implements OnInit {

  public noticia!: Noticia

  constructor( private rutaActiva: ActivatedRoute, private sNoticias: NoticiasService, public style: StyleService ) {
    
    
  }
  
  ngOnInit(): void {
    this.noticia = this.sNoticias.noticias.find( not => not.id === this.rutaActiva.snapshot.params.id )!;
  }

}
