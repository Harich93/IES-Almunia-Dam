import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { ArticulosService } from '../../../../../services/articulos.service';
import { UserService } from '../../../../../services/user.service';
import { iArticulo } from '../../../../interfaces/articulo.interface';

@Component({
  selector: 'app-nuevo-articulo',
  templateUrl: './nuevo-articulo.component.html',
  styleUrls: ['./nuevo-articulo.component.scss']
})
export class NuevoArticuloComponent implements OnInit {

  public formArticulo: FormGroup;
  private img!: File;
  public nombre!: AbstractControl;
  public precio!: AbstractControl;
  public descripcion!: AbstractControl;
  public categoria!: AbstractControl;
  public estado!: AbstractControl;

  constructor( private fb: FormBuilder, private aService: ArticulosService, private uService: UserService ) {
    this.formArticulo = this.fb.group({
      nombre: ["", Validators.required],
      descripcion: ["", Validators.required ],
      precio: ["", Validators.required ],
      categoria: ["", Validators.required ],
      estado: ["", Validators.required]
    })
  }

  ngOnInit(): void {

    const { nombre, descripcion, precio, categoria, estado } = this.formArticulo.controls;

    this.precio = precio
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.categoria = categoria;
    this.estado = estado;
  }

  onFileSelected( event: any ) {
    this.img = event.target.files[0];
  }

  publicar = async() => {
    
    let urlimg = await this.aService.imgUpload( this.img );
    const articulo: iArticulo = {
      id_vendedor: this.uService.usuario.uid,
      nombre: this.nombre.value,
      precio: this.precio.value,
      descripcion: this.descripcion.value,
      categoria: this.categoria.value,
      estado: this.estado.value,
      img: urlimg,
      vendido: false
    }
    
    this.aService.publicarArticulo( articulo )
  }

}
