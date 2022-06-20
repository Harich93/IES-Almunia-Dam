import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthModule } from './auth/auth.module';
import { UserModule } from './user/user.module';
import { ArticulosModule } from './articulos/articulos.module';
import { GoogleMapModule } from './google-map/google-map.module';

@NgModule({
  declarations: [ 
 
  ],
  imports: [
    CommonModule,
    AuthModule,
    UserModule,
    ArticulosModule,
    GoogleMapModule
  ],
  exports: []
})
export class ComponentsModule { }
