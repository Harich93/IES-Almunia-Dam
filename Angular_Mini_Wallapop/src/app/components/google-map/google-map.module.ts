import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GoogleMapComponent } from './google-map.component';
import { SharedModule } from '../../shared/shared.module';



@NgModule({
  declarations: [ GoogleMapComponent ],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports: [ GoogleMapComponent ]
})
export class GoogleMapModule { }
