import { Skill } from './skill';

export class Resource {
  id: number;
  name: string;
  imageLink: string;
  videoLink: string;
  siteLink: string;
  skills: Skill[];

  constructor(
    id?: number,
    name?: string,
    imageLink?: string,
    videoLink?: string,
    siteLink?: string,
    skills?: Skill[]
  ){
    this.id = id;
    this.name = name;
    this.imageLink = imageLink;
    this.videoLink = videoLink;
    this.siteLink = siteLink;
    this.skills = skills;
  }
}
