export class User {
  id: number;
  enabled: boolean;
  password: string;
  username: string;
  role: string;
  email: string;

  constructor(
    id?: number,
    enabled?: boolean,
    password?: string,
    username?: string,
    role?: string,
    email?: string,
  ) {
    this.id = id;
    this.enabled = enabled;
    this.password = password;
    this.username = username;
    this.role = role;
    this.email = email;
  }
}
