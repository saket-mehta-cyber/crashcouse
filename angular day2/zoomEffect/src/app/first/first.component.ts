import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {
  btnVal = "Click Here"
  constructor() { }
  

  ngOnInit(): void {
    console.log("started...");
  }

  isValid: boolean = true;

  onClick() {
    this.btnVal="Button Clicked"

  }

}
