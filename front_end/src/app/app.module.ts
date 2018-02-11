import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {MatButtonModule, MatCardModule,MatIconModule,
  MatFormFieldModule,ShowOnDirtyErrorStateMatcher,
  ErrorStateMatcher,MatFormFieldControl,MatInputModule,
  MatButtonToggleModule } from '@angular/material';

import { AppComponent } from './app.component';
import {GitService} from './git.service'

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MatButtonModule, 
    MatCardModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonToggleModule
  ],
  providers: [{provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher},GitService],
  bootstrap: [AppComponent]
})
export class AppModule { }
