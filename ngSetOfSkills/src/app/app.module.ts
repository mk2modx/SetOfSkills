import { AchievementService } from './services/achievement.service';
import { AchieverService } from './services/achiever.service';
import { AdminService } from './services/admin.service';
import { SkillService } from './services/skill.service';
import { AuthService } from './services/auth.service';
import { UserService } from './services/user.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import { FormModalComponent } from './components/form-modal/form-modal.component';
// import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import {NgbModule, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestSetOfSkillsComponent } from './components/test-set-of-skills/test-set-of-skills.component';
import { AchieverComponent } from './components/achiever/achiever.component';
import { AchievementComponent } from './components/achievement/achievement.component';
import { SkillComponent } from './components/skill/skill.component';
import { UserComponent } from './components/user/user.component';
import { NavComponent } from './components/nav/nav.component';
import { ProfilenavComponent } from './components/profilenav/profilenav.component';
import { MainpageComponent } from './components/mainpage/mainpage.component';

@NgModule({
  declarations: [
    AppComponent,
    TestSetOfSkillsComponent,
    AchieverComponent,
    AchievementComponent,
    SkillComponent,
    UserComponent,
    NavComponent,
    ProfilenavComponent,
    MainpageComponent
    // FormModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    NgbModalModule

  ],
  providers: [
    UserService,
    AuthService,
    SkillService,
    AdminService,
    AchieverService,
    AchievementService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
