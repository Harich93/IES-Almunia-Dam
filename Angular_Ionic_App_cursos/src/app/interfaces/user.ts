export interface User {
  user:  UserClass;
  token: string;
}

export interface UserClass {
  name:        string;
  email:        string;
  sellsCourses?: string[];
  buyCourses?:   string[];
}

// Converts JSON strings to/from your types
export class Convert {
  public static toUser(json: string): User {
      return JSON.parse(json);
  }

  public static userToJson(value: User): string {
      return JSON.stringify(value);
  }
}