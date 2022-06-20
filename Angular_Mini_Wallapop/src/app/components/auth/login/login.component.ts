import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../auth.component.scss']
})
export class LoginComponent implements OnInit {

  public formLogin: FormGroup;
  public email!: AbstractControl;
  public pass!: AbstractControl;


  constructor( private fb: FormBuilder, private auth: AuthService) { 
    this.formLogin = this.fb.group({
      email: ['', [Validators.required, Validators.email ] ],
      password: ['', Validators.required ]
    })
  }

  ngOnInit(): void {
    const { email, password } = this.formLogin.controls;
    this.email = email;
    this.pass = password;
    
  }

  login(){
    this.auth.startLoginEmailPass( this.email.value, this.pass.value );
  }

  registrarGoogle() {
    this.auth.startGoogleLogin();
  }



}
