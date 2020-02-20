import { Achiever } from './../models/achiever';
import { UserService } from './user.service';
import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AchieverService {
  private url = 'http://localhost:8099/api/';
  private credentials = this.auth.getCredentials();
  private achiever: Achiever = null;


  constructor(private auth: AuthService, private http: HttpClient, private userv: UserService) { }

  registerAchiever(achiever, uid) {

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.post(this.url + 'achiever/' + uid, achiever, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Achievement service.registerAciever(); error registering achiever ');
      })
    );
  }

  getAchieverByUsername() {

    const username = this.auth.getUsername();
    console.log(username);

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<Achiever>(this.url + 'achiever/' + username, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.error(err);
          return throwError('Student get by username failed');
        })
      );
  }

}
