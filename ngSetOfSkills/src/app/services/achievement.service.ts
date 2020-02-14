import { UserService } from './user.service';
import { Achiever } from './../models/achiever';
import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AchievementService {
  private url = 'http://localhost:8095/api/';
  private credentials = this.auth.getCredentials();
  private user: User = null;
  private achiever: Achiever = null;

  constructor(private auth: AuthService, private http:HttpClient, private userv: UserService) { }


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


}
