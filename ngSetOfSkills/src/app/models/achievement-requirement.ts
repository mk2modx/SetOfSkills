import { SkillRequirement } from './skill-requirement';
import { Achievement } from './achievement';
export class AchievementRequirement {
  id: number;
  dateStarted: Date;
  dateCompleted: Date;
  achievement: Achievement;
  skillReqs: SkillRequirement;

  constructor(
  id?: number,
  dateStarted?: Date,
  dateCompleted?: Date,
  achievement?: Achievement,
  skillReqs?: SkillRequirement
  ){
  this.id = id;
  this.dateStarted = dateStarted;
  this.dateCompleted = dateCompleted;
  this.achievement = achievement;
  this.skillReqs = skillReqs;
  }
}
