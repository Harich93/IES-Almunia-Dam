import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';

import { ToolbarComponent } from './toolbar/toolbar.component';
import { SafePipe } from './pipes/safe.pipe';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    ToolbarComponent,
    SafePipe,
    FooterComponent
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    RouterModule
  ],
  exports: [
    ToolbarComponent,
    SafePipe,
    FooterComponent
  ]
})
export class SharedModule { }
