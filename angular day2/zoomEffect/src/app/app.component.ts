import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'myApp';
  imageUrl = "flower1.jpg";
  altText = "alt"

  name: string;

  colorName = 'red';
  fontWeight = 'bold';
  borderStyle = '1px solid black';
  color = "red"
  show: boolean;
  applyClass = "applyClass";
  isApplied: boolean = true;
  myMessage = "Hello, I am from attribute directive"
  message: string;

  courses = [
    { courseId: 1, courseName: 'Node JS' },
    { courseId: 2, courseName: 'Typescript' },
    { courseId: 3, courseName: 'Angular' },
    { courseId: 4, courseName: 'React JS' }
  ];

  courseReg(course: any) {
    this.message = `Your registration for ${course.courseName} is successful`;
  }

  magnify: boolean = true;
}
