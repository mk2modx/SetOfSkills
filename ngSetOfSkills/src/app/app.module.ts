import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestSetOfSkillsComponent } from './components/test-set-of-skills/test-set-of-skills.component';
import { AchieverComponent } from './components/achiever/achiever.component';
import { AchievementComponent } from './components/achievement/achievement.component';
import { SkillComponent } from './components/skill/skill.component';

@NgModule({
  declarations: [
    AppComponent,
    TestSetOfSkillsComponent,
    AchieverComponent,
    AchievementComponent,
    SkillComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
