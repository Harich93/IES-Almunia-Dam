import exprees, { Application } from 'express';
import cors from 'cors';
import searchRouter from '../routes/api.routes';

class Server {

   private _app: Application;
   private _port: string;

   constructor(){
      this._app = exprees();
      this._port = process.env.PORT || "8080";

      this.routes()
      this.middlewares();
   }

   middlewares(){
      this._app.use( cors() );
      this._app.use( exprees.json() );
   }

   routes() {
      this._app.use( '/api', searchRouter )
      this._app.use( exprees.static('public') )
   }

   listen() {
      this._app.listen( this._port, () => {
         console.log(`Escuchando en puerto: ${this._port}`);
         
      })
   }

}

export default Server;