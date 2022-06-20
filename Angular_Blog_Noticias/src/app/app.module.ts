import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule } from './routes/app-routing.module';
import { NoticiasComponent } from './components/noticias/noticias.component';
import { FormularioComponent } from './components/formulario/formulario.component';
import { SharedModule } from './shared/shared.module';
import { NoticiaComponent } from './components/noticia/noticia.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DetalleNoticiaComponent } from './components/detalle-noticia/detalle-noticia.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NoticiasComponent,
    FormularioComponent,
    NoticiaComponent,
    DetalleNoticiaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
