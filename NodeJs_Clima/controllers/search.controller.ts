import { Request, Response } from "express";
import axios from "axios";
import { WeatherResponse } from '../model/weatherResponse';

const paramsWeatherStack = {
   'access_key': '9c5ebf7c4abb443ee2d54daded592feb',
   'query': 'fetch:ip',
}

export const search = async( req: Request, res: Response ) => {

   const { ciudad } = req.params;
   
   try {

      const peticion =  axios.create({
         baseURL: `http://api.weatherstack.com/current`,
         params: {...paramsWeatherStack, 'query': ciudad }
      });
      
      
      const { data } = await peticion.get('');
      const { location, current } = data as WeatherResponse;
      
      res.json({
         'name': location.name,
         'country': location.country,
         'region': location.region,
         'temperature': current.temperature,
         'weather': current.weather_descriptions[0],
         'humidity': current.humidity
      })
      
   } catch (error) {
      
      res.json({
         msg: error
      })

   }

}

export const prueba = ( req: Request, res: Response ) => {

   res.json({
      "msg": "Esto es una prueba"
   })

}