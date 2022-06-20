import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleNoticiaComponent } from '../components/detalle-noticia/detalle-noticia.component';
import { LoginComponent } from '../components/login/login.component';
import { NoticiasComponent } from '../components/noticias/noticias.component';
import { BlockGuard } from './block.guard';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
  { path: 'noticias', canActivate: [BlockGuard], component: NoticiasComponent },
  { path: 'noticia/:id', canActivate: [BlockGuard], component: DetalleNoticiaComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
