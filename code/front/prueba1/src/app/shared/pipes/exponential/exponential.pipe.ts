import { Pipe, PipeTransform } from '@angular/core';
import { PropertyWrite } from '@angular/compiler';

@Pipe({
  name: 'exponential'
})
export class ExponentialPipe implements PipeTransform {

  transform(value: number): any {
    return Math.pow(value,2);
  }

}
