import { Component, OnInit } from '@angular/core';
import { FormGroup, AbstractControl, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['../auth.page.scss'],
})
export class RegisterPage implements OnInit {

  public formRegister : FormGroup;
  
  public name: AbstractControl;
  public email: AbstractControl;
  public pass: AbstractControl;


  constructor( private fb: FormBuilder ) { }

  ngOnInit() {
    this.formRegister = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      pass: ['', [Validators.required, Validators.minLength(6)] ]
    });

    const { name, email, pass } = this.formRegister.controls;
    this.name = name;
    this.email = email;
    this.pass = pass;
  }

  login(){

  }

  googleSignIn(){
    
  }
}
