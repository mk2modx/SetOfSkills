import { throwError } from 'rxjs';
import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  private url = 'http://localhost:8099/api/users/';

  private credentials = this.auth.getCredentials();
  delete(user: any) {
    throw new Error('Method not implemented');
  }

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X=Requested-With' : 'XMLHttpRequest'
      })
    };

    return this.http.get<User[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('user.service.ts index error');
      })
    );
  }

  registerUser(user) {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.post(this.url, user, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Student service.registerStudent(); error registering student ');
      })
    );
  }

}
