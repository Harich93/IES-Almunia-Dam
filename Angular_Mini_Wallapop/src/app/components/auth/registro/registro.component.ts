import { Component, OnInit } from '@angular/core';
import { FormBuilder, AbstractControl, FormGroup, Validators, FormControl } from '@angular/forms';
import { AuthService } from 'src/services/auth.service';
import { async } from '@firebase/util';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['../auth.component.scss']
})
export class RegistroComponent implements OnInit {

  public formRegistro: FormGroup;
  public name!: AbstractControl;
  public email!: AbstractControl;
  public ciudad!: AbstractControl;
  public direccion!: AbstractControl;
  public pass!: AbstractControl;
  public pass2!: AbstractControl;
  public msg: string = "";

  constructor( private fb: FormBuilder , private auth: AuthService ) { 
    this.formRegistro = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email ] ],
      ciudad: ['', [Validators.required,Validators.minLength(3) ]],
      direccion: ['', [Validators.required,Validators.minLength(3) ]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      password2: ['',[Validators.required, Validators.minLength(6)] ]
    })
  }

  ngOnInit(): void {

    const { name, ciudad, direccion, email, password, password2  } = this.formRegistro.controls;
    this.name = name;
    this.email = email;
    this.ciudad = ciudad;
    this.direccion = direccion;
    this.pass = password;
    this.pass2 = password2;
    
  }

  registrar = async() => {
    await this.auth.startRegisterWhithEmailPassword( this.email.value, this.pass.value, this.name.value );
    await this.auth.setPersonalData( this.name.value, this.ciudad.value, this.direccion.value ); 
  }

  registrarGoogle() {
    this.auth.startGoogleLogin();
  }

  tieneError(){
    
    if(this.pass.touched){
      
      if(this.pass.value.length === 0 && this.pass2.value.length === 0) 
        return false;

      else if( this.pass.value.length < 6 ) {
        this.msg = "Debe tener 6 caracteres minimo";
        return true;
      }

      if( this.pass2.touched ) {
        
        if(this.pass2.value !== this.pass.value ){
          this.msg = "Las contraseñas no coinciden"
          return true
        }
        
      }

    }

    return false
    
  }

}
