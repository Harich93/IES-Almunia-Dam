import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {  AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Chiste } from 'src/app/model/chiste.class';
import { ChisteService } from '../../service/chiste.service';


@Component({
  selector: 'app-agregar-chistes',
  styleUrls: ['agregar-chistes.component.scss'],
  templateUrl: './agregar-chistes.component.html',
})
export class AgregarChistesComponent implements OnInit {
  
  @Output() onNuevoChiste:EventEmitter<Chiste> = new EventEmitter();
  
  private chiste:Chiste = new Chiste( '', '' );
  
  public formulario = new FormGroup({
    anecdota: new FormControl( "" , [Validators.required, Validators.minLength(6)]),
    respuesta: new FormControl("",[Validators.required, Validators.minLength(6)])
  });

  probado: boolean = false;
  anecdota !:AbstractControl
  respuesta !:AbstractControl

  constructor( private chistesService: ChisteService ){}

  ngOnInit(): void {
    const { controls : { anecdota, respuesta }} = this.formulario;
    
    this.anecdota = anecdota;
    this.respuesta = respuesta;
  }


  crearChiste = ():void => {
    
    if( !this.anecdota.invalid && !this.respuesta.invalid) {

      this.chiste.anecdota = this.formulario.get('anecdota')?.value;
      this.chiste.respuesta = this.formulario.get('respuesta')?.value;

      this.chistesService.agregarChiste( this.chiste );
      this.chiste = new Chiste('', '');

      this.probado = false;
    }
    else {
      this.probado = true;
    }
  }

  
}
