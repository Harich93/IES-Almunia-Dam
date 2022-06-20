import { Component, Input, OnInit } from '@angular/core';
import { Noticia } from 'src/app/models/Noticia.class';
import { StyleService } from '../../service/style.service';
import { NoticiasService } from 'src/app/service/noticias.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.scss']
})
export class NoticiaComponent implements OnInit {

  @Input() noticia!: Noticia;

  constructor( public style: StyleService, private nNoticias: NoticiasService, private router: Router) { }

  ngOnInit(): void {
  }

  eliminar(){
    this.nNoticias.eliminar( this.noticia );
  }

  modificar(){
    this.router.navigate([`/noticia/${this.noticia.id}`])
  }
}
