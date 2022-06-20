import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArticuloComponent } from './articulo/articulo.component';
import { ArticulosComponent } from './articulos.component';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatChipsModule } from '@angular/material/chips';
import { DetalleArticuloComponent } from './detalle-articulo/detalle-articulo.component'
import { RouterModule } from '@angular/router';
import { GoogleMapModule } from '../google-map/google-map.module';
import { PaypalComponent } from './paypal/paypal.component';
import { NgxPayPalModule } from 'ngx-paypal';






@NgModule({
  declarations: [
    ArticulosComponent,
    ArticuloComponent,
    DetalleArticuloComponent,
    PaypalComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    MatButtonToggleModule,
    MatChipsModule,
    GoogleMapModule,
    NgxPayPalModule
  ],
  exports: [ 
    ArticulosComponent, 
    ArticuloComponent
  ]
})
export class ArticulosModule { }
