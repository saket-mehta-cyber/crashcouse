import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegistrationService } from '../registration.service';
@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  // studentDetails:any[]=[]
  registerForm!: FormGroup;
  submitted!: boolean;
  constructor(private formBuilder: FormBuilder,private service:RegistrationService) { }


  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required,Validators.email]],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      favSubject: ['', Validators.required],
      
    });
  }

  apply(){
    // console.log(this.registerForm.value);
    this.submitted=true
    this.service.registerStudent(this.registerForm.value).subscribe({
      next(value) {
        console.log(value);
        
      },
    })
  }
}
