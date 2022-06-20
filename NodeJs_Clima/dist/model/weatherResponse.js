"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Convert = void 0;
// Converts JSON strings to/from your types
class Convert {
    static toWeatherResponse(json) {
        return JSON.parse(json);
    }
    static weatherResponseToJson(value) {
        return JSON.stringify(value);
    }
}
exports.Convert = Convert;
