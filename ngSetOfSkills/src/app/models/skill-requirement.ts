import { Requirement } from './requirement';
import { AchievementRequirement } from './achievement-requirement';
import { Skill } from './skill';
export class SkillRequirement {
  id: number;
  stepNumber: number;
  achievementReqs: AchievementRequirement[];
  skill: Skill;
  requirement: Requirement;

  constructor(
    id?: number,
    stepNumber?: number,
    achievementReqs?: AchievementRequirement[],
    skill?: Skill,
    requirement?: Requirement
  ){
    this.id = id;
    this.stepNumber = stepNumber;
    this.achievementReqs = achievementReqs;
    this.skill = skill;
    this.requirement = requirement;
  }

}
