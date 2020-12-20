import { NgModule } from '@angular/core';
import {MatButtonModule} from '@angular/material/button'
import {MatToolbarModule} from '@angular/material/toolbar';

const Material = [
  MatButtonModule,
  MatToolbarModule
]

@NgModule({
  imports: [Material],
  exports: [Material]
})
export class MaterialModule { }
