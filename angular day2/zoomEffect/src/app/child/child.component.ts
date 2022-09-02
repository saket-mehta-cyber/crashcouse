import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  constructor() { }

  @Input() coursesList;

  @Output() registerEvent = new EventEmitter<any>();
  
  

  register(course:any) {
    
  }

ngOnInit(): void {
}

}


