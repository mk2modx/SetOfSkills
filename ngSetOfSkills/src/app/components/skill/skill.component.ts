import { UserService } from './../../services/user.service';
import { SkillService } from './../../services/skill.service';
import { AuthService } from './../../services/auth.service';
import { Achievement } from './../../models/achievement';
import { Component, OnInit } from '@angular/core';
import { Achiever } from 'src/app/models/achiever';
import { Skill } from 'src/app/models/skill';

@Component({
  selector: 'app-skill',
  templateUrl: './skill.component.html',
  styleUrls: ['./skill.component.css']
})
export class SkillComponent implements OnInit {
  achiever: Achiever = null;
  role: any;
  skills: Skill[] = null;
  achievements: Achievement [] = null;

  constructor(private auth: AuthService, private skillService: SkillService, private userService: UserService) { }

  ngOnInit() {
    this.checkRole();
    if (this.role) {
      this.refreshApps();
    }

  }
  checkRole() {
    return this.role = this.auth.getRole();

}

  refreshApps() {
    this.userService.getSkills().subscribe(
      data => {
        this.skills = data;

      },

      err => console.error('Fetch skills err: ' + err)
      );  }

}
