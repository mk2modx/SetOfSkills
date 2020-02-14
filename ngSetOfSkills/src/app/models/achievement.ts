import { Achiever } from './achiever';
import { AchievementRequirement } from './achievement-requirement';
import { Skill } from './skill';
export class Achievement {
  id: number;
  dateStarted: Date;
  achiever: Achiever;
  skill: Skill;
  achievermentReqs: AchievementRequirement[];

  constructor(
  id?: number,
  dateStarted?: Date,
  achiever?: Achiever,
  skill?: Skill,
  achievermentReqs?: AchievementRequirement[]
  ){
  this.id = id;
  this.dateStarted = dateStarted;
  this.achiever = achiever;
  this.skill = skill;
  this.achievermentReqs = achievermentReqs;
  }
}
