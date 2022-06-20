import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { StyleService } from '../../service/style.service';
import { NoticiasService } from '../../service/noticias.service';
import { Noticia } from 'src/app/models/Noticia.class';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.scss']
})
export class FormularioComponent implements OnInit {
  
  public titulo!: AbstractControl;
  public texto!: AbstractControl;
  
  public formNoticia: FormGroup;

  constructor( private fb: FormBuilder, public style: StyleService, private sNoticias: NoticiasService ) { 
    this. formNoticia  = this.fb.group({
      titulo: ['', Validators.minLength(3) ],
      texto: [ '', [Validators.required, Validators.minLength(5) ] ]
    });
  }

  ngOnInit(): void {
    const { titulo, texto } = this.formNoticia.controls;
    this.titulo = titulo;
    this.texto = texto;
  }

  tieneError( arg: AbstractControl):boolean {
    if(arg?.invalid && arg.touched) return true ;

    return false;
  } 

  crear(){
    this.sNoticias.agregar( new Noticia( this.titulo.value, this.texto.value ))
  }

}
