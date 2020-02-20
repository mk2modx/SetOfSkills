import { Achievement } from './../../models/achievement';
import { AchievementService } from './../../services/achievement.service';
import { Achiever } from './../../models/achiever';
import { AuthService } from './../../services/auth.service';
import { AchieverService } from './../../services/achiever.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-achiever',
  templateUrl: './achiever.component.html',
  styleUrls: ['./achiever.component.css']
})
export class AchieverComponent implements OnInit {
  achiever: Achiever = null;
  role: any;
  achievements: Achievement [] = [];


  constructor(private achieveService: AchieverService, private auth: AuthService) { }

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
      },

      err => console.error('Fetch student err: ' + err)
    );  }
  checkRole() {
    return this.role = this.auth.getRole();
  }

}
