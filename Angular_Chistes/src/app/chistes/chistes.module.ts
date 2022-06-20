import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MainChistesComponent } from './main-chistes/main-chistes.component';
import { AgregarChistesComponent } from './agregar-chistes/agregar-chistes.component';
import { ChisteComponent } from './chiste/chiste.component';
import { ChisteService } from '../service/chiste.service';
import { SharedModule } from '../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    MainChistesComponent,
    AgregarChistesComponent,
    ChisteComponent
  ],
  exports: [
    MainChistesComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [ ChisteService ] 
})
export class ChistesModule { }
