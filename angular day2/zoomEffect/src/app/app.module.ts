import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './first/first.component';
import { DemoDirective } from './demo.directive';
import { MessageDirective } from './message.directive';

import { ChildComponent } from './child/child.component';
import { MagnifyDirective } from './magnify.directive';

@NgModule({
  // components
  declarations: [
    AppComponent,
    FirstComponent,
    DemoDirective,
    MessageDirective,
    ChildComponent,
    MagnifyDirective
  ],
  // modules
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  // services
  providers: [],
  // rendering
  bootstrap: [AppComponent]
})
export class AppModule { }
