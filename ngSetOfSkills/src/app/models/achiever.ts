import { Achievement } from './achievement';
import { User } from './user';

export class Achiever {
  id: number;
  user: User;
  firstName: string;
  lastName: string;
  age: Date;
  imageLink: string;
  achievements: Achievement[];

  constructor(
  id?: number,
  user?: User,
  firstName?: string,
  lastName?: string,
  age?: Date,
  imageLink?: string,
  achievements?: Achievement[]
  )
  {
  this.id = id;
  this.user = user;
  this.firstName = firstName;
  this.lastName = lastName;
  this.age = age;
  this.imageLink = imageLink;
  this.achievements = achievements;
  }
}
