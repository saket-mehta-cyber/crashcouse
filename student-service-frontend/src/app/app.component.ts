import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'first-app';
  registerPage:boolean
  getStudentPage:boolean

  register(){
    this.registerPage=true;
    this.getStudentPage=false;
  }
  get(){
    this.registerPage=false;
    this.getStudentPage=true;
  }
}
