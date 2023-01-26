import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'tableFilter'
})
export class TableFilterPipe implements PipeTransform {

  transform(list: any[], value: string){
    return value ? list.filter(item => Object.keys(item).some(k => item[k] != null && item[k].toString().toLowerCase().includes(value.toLowerCase()))) : list;
  }

}
