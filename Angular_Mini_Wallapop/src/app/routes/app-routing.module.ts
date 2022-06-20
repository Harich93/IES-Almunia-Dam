import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticulosComponent } from '../components/articulos/articulos.component';
import { DetalleArticuloComponent } from '../components/articulos/detalle-articulo/detalle-articulo.component';
import { LoginComponent } from '../components/auth/login/login.component';
import { RegistroComponent } from '../components/auth/registro/registro.component';
import { MisArticulosComponent } from '../components/user/articulos/MisArticulos.component';
import { CuentaComponent } from '../components/user/cuenta/cuenta.component';
import { DatosPersonalesComponent } from '../components/user/datos-personales/datos-personales.component';
import { ConectadoGuard } from './conectado.guard';
import { DesconectadoGuard } from './desconectado.guard';


const routes: Routes = [

  { path: '', canActivate:[ConectadoGuard], component: ArticulosComponent },
  { path: 'article/:id', canActivate:[ConectadoGuard], component: DetalleArticuloComponent},
  { path: 'user/count', canActivate:[ConectadoGuard], component: CuentaComponent, children: 
    [
      { path: '', component: DatosPersonalesComponent },
      { path: 'articles', component: MisArticulosComponent },
    ]
  },
     
  { path: 'auth',canActivate:[DesconectadoGuard], children:
    [
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegistroComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
