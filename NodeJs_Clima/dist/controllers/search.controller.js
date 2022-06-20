"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.prueba = exports.search = void 0;
const axios_1 = __importDefault(require("axios"));
const paramsWeatherStack = {
    'access_key': '9c5ebf7c4abb443ee2d54daded592feb',
    'query': 'fetch:ip',
};
const search = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const { ciudad } = req.params;
    try {
        const peticion = axios_1.default.create({
            baseURL: `http://api.weatherstack.com/current`,
            params: Object.assign(Object.assign({}, paramsWeatherStack), { 'query': ciudad })
        });
        const { data } = yield peticion.get('');
        const { location, current } = data;
        res.json({
            'name': location.name,
            'country': location.country,
            'region': location.region,
            'temperature': current.temperature,
            'weather': current.weather_descriptions[0],
            'humidity': current.humidity
        });
    }
    catch (error) {
        res.json({
            msg: error
        });
    }
});
exports.search = search;
const prueba = (req, res) => {
    res.json({
        "msg": "Esto es una prueba"
    });
};
exports.prueba = prueba;
