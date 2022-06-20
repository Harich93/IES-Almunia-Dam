import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';
import { UserService } from '../../../../services/user.service';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-datos-personales',
  templateUrl: './datos-personales.component.html',
  styleUrls: ['./datos-personales.component.scss']
})
export class DatosPersonalesComponent implements OnInit {

  public formDatosPersonales: FormGroup 
  public nombre!: AbstractControl;
  public apellidos!: AbstractControl;
  public ciudad!: AbstractControl;
  public direccion!: AbstractControl;

  constructor( private fb: FormBuilder, private uService: UserService  ,private auth: AuthService ) {

    const user = this.uService.usuario;

    this.formDatosPersonales = this.fb.group({
      nombre: [user.displayName ,[Validators.required,Validators.minLength(3) ]],
      ciudad: [user.direccion.ciudad, [Validators.required,Validators.minLength(3) ]],
      direccion: [user.direccion.dir, [Validators.required,Validators.minLength(5) ]],
    })
  }

  ngOnInit(): void {
    const { nombre, ciudad, direccion } = this.formDatosPersonales.controls;
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.direccion = direccion;
  }

  actualizarDatos() {
    this.auth.setPersonalData( this.nombre.value, this.ciudad.value, this.direccion.value);
  }

}
