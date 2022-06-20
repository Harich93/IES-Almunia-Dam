import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { Chiste } from '../model/chiste.class';

@Injectable()
export class ChisteService {

  private _chistes: Chiste[];

  private _chistes$: Subject<Chiste[]>;

  constructor() {
  
    this._chistes = [
      new Chiste('¿Por qué las focas del circo miran siempre hacia arriba?', 'Porque es donde están los focos.',),
      new Chiste('¡Estás obsesionado con la comida!', 'No sé a qué te refieres croquetamente.',)
    ];

    this._chistes$ = new Subject();
  }


  get chistes(): Chiste[] {
    return [...this._chistes]
  }

  get chistes$(): Observable<Chiste[]> {
    return this._chistes$.asObservable();
  }

  agregarChiste( chiste:Chiste ){

      this._chistes.unshift(chiste);
      this._chistes$.next( [...this.chistes] );
  }

  borrarChiste( chiste:Chiste ){

    this._chistes = this._chistes.filter( ch => ch.anecdota != chiste.anecdota )
    this._chistes$.next( [...this._chistes] );
  }


}
