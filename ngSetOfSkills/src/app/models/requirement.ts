import { SkillRequirement } from './skill-requirement';
export class Requirement {
  id: number;
  name: string;
  description: string;
  pointVal: number;
  skillReqs: SkillRequirement[];

  constructor(
    id?: number,
    name?: string,
    description?: string,
    pointVal?: number,
    skillReqs?: SkillRequirement[]
  ){
    this.id = id;
    this.name = name;
    this.description = description;
    this.pointVal = pointVal;
    this.skillReqs = skillReqs;
  }
}
