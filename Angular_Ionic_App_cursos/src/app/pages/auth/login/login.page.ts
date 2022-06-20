import { Component, OnInit } from '@angular/core';
import { FormGroup, AbstractControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['../auth.page.scss'],
})
export class LoginPage implements OnInit {

  public formLogin : FormGroup;
  
  public email: AbstractControl;
  public pass: AbstractControl;


  constructor( private fb: FormBuilder, private as: AuthService, private router: Router) { }

  ngOnInit() {
    this.formLogin = this.fb.group({
      email: ['', [Validators.required, Validators.email ]],
      pass: ['', [Validators.required, Validators.minLength(6)] ]
    });

    const { email, pass } = this.formLogin.controls;
    this.email = email;
    this.pass = pass;
  }

  login(){
    this.as.login( this.email.value, this.pass.value );
  }


}
