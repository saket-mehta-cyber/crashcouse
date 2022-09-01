import { Component, Input, OnInit, Output , EventEmitter} from '@angular/core';


@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

   course="Angular";

   changeName(){
     this.course="Java"
   }

   url="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1cE-hrTBHfTXDxddQslTOFr9wvpYhd2bhYQ&usqp=CAU"


   alternateText="No image found!!"

   name ="Jack";

   isValid=true




  

}
