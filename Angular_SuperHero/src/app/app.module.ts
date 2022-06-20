import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CardHeroeComponent } from './heroes/card-heroe/card-heroe.component';
import { ListHeroesComponent } from './heroes/list-heroe/list-heroe.component';

@NgModule({
  declarations: [
    AppComponent,
    ListHeroesComponent,
    CardHeroeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
