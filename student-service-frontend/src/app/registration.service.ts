import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) { }

  registerStudent(student:any):Observable<any>{
    const options = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post('http://localhost:8082/api/student', student, { headers: options });
  }

  getStudents(){
    const httpOptions = {
      headers: new HttpHeaders(
      { 
         
         'Content-Type': 'application/json'
      })
  }
    return this.http.get('http://localhost:8082/api/students',httpOptions);
      
  }

  deleteStudent(email){
    return this.http.delete('http://localhost:8082/api/student/'+email);
  }
  updateStudent(email,student){
    console.log(email);
    
    return this.http.put('http://localhost:8082/api/student/'+email,student);
  }
}
