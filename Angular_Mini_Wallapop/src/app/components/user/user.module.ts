import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CuentaComponent } from './cuenta/cuenta.component';
import { DatosPersonalesComponent } from './datos-personales/datos-personales.component';
import { MisArticulosComponent } from './articulos/MisArticulos.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NuevoArticuloComponent } from './articulos/nuevo-articulo/nuevo-articulo.component';
import { MatSelectModule } from '@angular/material/select';
import { GoogleMapModule } from '../google-map/google-map.module';
import { ArticulosModule } from '../articulos/articulos.module';


@NgModule({
  declarations: [
    CuentaComponent,
    DatosPersonalesComponent,
    MisArticulosComponent,
    NuevoArticuloComponent
  ],
  imports: [
    CommonModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    MatSelectModule,
    GoogleMapModule,
    ArticulosModule
  ],
  exports: [ CuentaComponent ]
})
export class UserModule { }
