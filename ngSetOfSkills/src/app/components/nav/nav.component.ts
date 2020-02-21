import { Component, OnInit, Inject, HostListener } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { DOCUMENT } from '@angular/common';
import { Achiever } from 'src/app/models/achiever';
import { Skill } from 'src/app/models/skill';
import { Achievement } from 'src/app/models/achievement';
import { AchieverService } from 'src/app/services/achiever.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  windowScrolled: boolean;
  achiever: Achiever = null;
  role: any;
  skills: Skill [] = null;
  achievements: Achievement [] = null;
  constructor(private auth: AuthService, private achieveService: AchieverService, @Inject(DOCUMENT) private document: Document) { }
  // constructor(private auth: AuthService, @Inject(DOCUMENT) private document: Document) { }

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

  @HostListener('window:scroll', [])
  onWindowScroll() {
    if (window.pageYOffset || this.document.documentElement.scrollTop > 100) {
      this.windowScrolled = true;
    } else if (this.windowScrolled && window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop < 10) {
      this.windowScrolled = false;
    }
  }

  scrollToTop() {
    (function smoothscroll() {
      const currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
      if (currentScroll > 0) {
        window.requestAnimationFrame(smoothscroll);
        window.scrollTo(0, currentScroll - (currentScroll / 8));
      }
    })();

  }


}
