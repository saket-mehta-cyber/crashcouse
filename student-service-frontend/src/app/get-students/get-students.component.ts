import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-get-students',
  templateUrl: './get-students.component.html',
  styleUrls: ['./get-students.component.css']
})
export class GetStudentsComponent implements OnInit {
  
  studentDetails: any
  constructor(private service: RegistrationService) { }

  ngOnInit(): void {
    this.service.getStudents().subscribe({
      next: (val) => {this.studentDetails=val  },
      error: (val) => {console.log(val)  },

    }
    )

  
    
  }




}
