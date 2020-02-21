import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Skill } from '../models/skill';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  private url = 'http://localhost:8099/api/';

  private credentials = this.auth.getCredentials();
  delete(user: any) {
    throw new Error('Method not implemented');
  }
  getSkills() {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X=Requested-With' : 'XMLHttpRequest'
      })
    };

    return this.http.get<Skill[]>(this.url + 'skills/', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('skill.service.ts index error');
      })
    );
  }


}
