import { NgModule } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ChistesModule } from './chistes/chistes.module';






@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    ChistesModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
