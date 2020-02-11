import { Resource } from './resource';
import { Supplies } from './supplies';
import { SkillRequirement } from './skill-requirement';
import { Achievement } from './achievement';
export class Skill {
  id: number;
  name: string;
  description: string;
  summary: string;
  preReq: number;
  achievements: Achievement[];
  skillReqs: SkillRequirement[];
  supplies: Supplies[];
  resources: Resource[];

  constructor(
    id?: number,
    name?: string,
    description?: string,
    summary?: string,
    preReq?: number,
    achievements?: Achievement[],
    skillReqs?: SkillRequirement[],
    supplies?: Supplies[],
    resources?: Resource[]
  ){
    this.id = id;
    this.name = name;
    this.description = description;
    this.summary = summary;
    this.preReq = preReq;
    this.achievements = achievements;
    this.skillReqs = skillReqs;
    this.supplies = supplies;
    this.resources = resources;
  }
}
