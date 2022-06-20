import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { StyleService } from '../../service/style.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public formLogin: FormGroup;
  public usuario!: AbstractControl;
  public pass!: AbstractControl

  constructor( private fb: FormBuilder, private router: Router, public style: StyleService, private user: UserService ) { 
    this.formLogin = this.fb.group({
      usuario: ['', Validators.required ],
      pass: ['', [ Validators.required, Validators.minLength(8) ] ]
    })
  }

  ngOnInit(): void {
    const { usuario, pass } = this.formLogin.controls;

    this.usuario = usuario;
    this.pass = pass;

  }

  loging(){
    this.user.conectado = true;
    this.router.navigate(["/noticias"])
  }
}
