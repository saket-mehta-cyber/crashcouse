import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-get-students',
  templateUrl: './get-students.component.html',
  styleUrls: ['./get-students.component.css']
})
export class GetStudentsComponent implements OnInit {



  registerForm!: FormGroup;

  updateFormView: boolean = false;
  studentDetails: any
  constructor(private service: RegistrationService, private formBuilder: FormBuilder) { }

  initialget() {
    this.service.getStudents().subscribe({

      next: (val) => { this.studentDetails = val },
      error: (val) => { console.log(val) },

    }
    )
  }


  update(value: any) {

    this.registerForm.setValue({
      email: value.email,
      firstName: value.firstName,
      lastName: value.lastName,
      favSubject: value.favSubject
    });
    
    this.updateFormView = true
  }
  updateStudent() {
    this.service.updateStudent(this.registerForm.value.email, this.registerForm.value).subscribe({
      next: (val) => { this.initialget() },
      error: (val) => { console.log(val) },
    })
    this.updateFormView = false
  }

  deleteStudent(email: string) {
    this.service.deleteStudent(email).subscribe({
      next: (val) => { this.studentDetails = val },
      error: (val) => { console.log(val) },

    }
    )


  }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      favSubject: ['', Validators.required],

    });

    this.initialget();
  }
}
