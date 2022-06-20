import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cleanText'
})
export class CleanTextPipe implements PipeTransform {

  transform( value: string, list: string[] = [] ): string {

    let cadena: string =  value;
    let palabras: string[] = ['capullo','hijo de puta','cabron']

    palabras = [ ...list, ...palabras]

    palabras.map( palabra => cadena = cadena.replace( palabra, '****' ) );
    
    return cadena;
  }

}
