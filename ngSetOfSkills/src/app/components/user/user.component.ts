import { Skill } from './../../models/skill';
import { AchieverService } from './../../services/achiever.service';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Achiever } from 'src/app/models/achiever';
import { Achievement } from 'src/app/models/achievement';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  achiever: Achiever = null;
  role: any;
  skills: Skill [] = null;
  achievements: Achievement [] = null;
  constructor(private auth: AuthService, private achieveService: AchieverService) { }

  ngOnInit() {
    this.checkRole();
    if (this.role) {
      this.refreshApps();
    }

  }

  refreshApps() {
    this.achieveService.getAchieverByUsername().subscribe(
      data => {
        this.achiever = new Achiever(data.id, data.user, data.firstName, data.lastName, data.age, data.imageLink, data.achievements);
        this.achievements = data.achievements;

      },

      err => console.error('Fetch student err: ' + err)
      );  }
      checkRole() {
        return this.role = this.auth.getRole();

  }


  login(loginForm) {
    // console.log(loginForm.value);
    this.auth
      .login(loginForm.value.username, loginForm.value.password)
      .subscribe(
        data => {
          window.location.reload();
          // console.log('loginComponenent.login(): user logged in.');
        },
        error => {
          console.error('loginComponent.login(): error logging in.');
        }
      );


  }

  logout() {
    // console.log('logout');
    this.auth.logout();
    if (this.auth.logoutSuccess) {

    }
  }

  checkLogin() {
    // console.log('Header Component- checkLogin()');
    // console.log(this.auth.checkLogin());
    return this.auth.checkLogin();
  }
}
