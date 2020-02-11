import { Skill } from './skill';
export class Supplies {
  id: number;
  name: string;
  link: string;
  imgUrl: string;
  skill: Skill;

  constructor(
    id?: number,
    name?: string,
    link?: string,
    imgUrl?: string,
    skill?: Skill
  ) {
    this.id = id;
    this.name = name;
    this.link = link;
    this.imgUrl = imgUrl;
    this.skill = skill;

  }
}
