import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { NoticiasService } from 'src/app/service/noticias.service';
import { Noticia } from '../../models/Noticia.class';

@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.scss']
})
export class NoticiasComponent implements OnInit {

  public noticias$!: Observable<Noticia[]>;


  constructor( private serNoticias: NoticiasService ) {}

  ngOnInit(): void {
    this.noticias$ = this.serNoticias.noticias$;
  }

}
