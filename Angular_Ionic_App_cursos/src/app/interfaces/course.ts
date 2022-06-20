export interface AllCourses {
   total:   number;
   courses: Course[];
}

export interface Course {
   id:    string;
   owner?: string;
   name:  string;
   price: number;
   img: string | "http://estacionlafinca.com/img/producto_sin_imagen.jpg";
}

// Converts JSON strings to/from your types
export class Convert {
   public static toUser(json: string): Course {
       return JSON.parse(json);
   }

   public static userToJson(value: Course): string {
       return JSON.stringify(value);
   }
}