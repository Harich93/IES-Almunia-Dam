import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Noticia } from '../models/Noticia.class';

@Injectable({
  providedIn: 'root'
})
export class NoticiasService {

  private _noticias!: Noticia[]
  private _noticias$: BehaviorSubject<Noticia[]>;

  constructor() { 
    this._noticias = [
      new Noticia( "titulo 1", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Recusandae accusantium, ratione temporibus quo perspiciatis quos eligendi saepe unde, eum culpa animi. Quaerat praesentium eligendi expedita nobis accusantium soluta sunt repellat?"),
      new Noticia( "titulo 2", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Recusandae accusantium, ratione temporibus quo perspiciatis quos eligendi saepe unde, eum culpa animi. Quaerat praesentium eligendi expedita nobis accusantium soluta sunt repellat?"),
      new Noticia( "titulo 3", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Recusandae accusantium, ratione temporibus quo perspiciatis quos eligendi saepe unde, eum culpa animi. Quaerat praesentium eligendi expedita nobis accusantium soluta sunt repellat? Lorem ipsum, dolor sit amet consectetur adipisicing elit. Recusandae accusantium, ratione temporibus quo perspiciatis quos eligendi saepe unde, eum culpa animi. Quaerat praesentium eligendi expedita nobis accusantium soluta sunt repellat? Lorem ipsum, dolor sit amet consectetur adipisicing elit. Recusandae accusantium, ratione temporibus quo perspiciatis quos eligendi saepe unde, eum culpa animi. Quaerat praesentium eligendi expedita nobis accusantium soluta sunt repellat?")
    ]
    this._noticias$ = new BehaviorSubject( [...this._noticias] );
    this._noticias$.next( [...this._noticias] );
  }

  get noticias(): Noticia[] {
    return [...this._noticias]
  }

  get noticias$(): Observable<Noticia[]> {
    return this._noticias$.asObservable();
  }

  agregar( arg: Noticia ) {
    this._noticias.unshift(arg);
    this._noticias$.next([...this._noticias]);
  }

  eliminar( arg: Noticia ){
    this._noticias = this._noticias.filter( not => not.fecha != arg.fecha );
    this._noticias$.next([...this._noticias])
  }
}
