"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const cors_1 = __importDefault(require("cors"));
const api_routes_1 = __importDefault(require("../routes/api.routes"));
class Server {
    constructor() {
        this._app = (0, express_1.default)();
        this._port = process.env.PORT || "8080";
        this.routes();
        this.middlewares();
    }
    middlewares() {
        this._app.use((0, cors_1.default)());
        this._app.use(express_1.default.json());
    }
    routes() {
        this._app.use('/api', api_routes_1.default);
        this._app.use(express_1.default.static('public'));
    }
    listen() {
        this._app.listen(this._port, () => {
            console.log(`Escuchando en puerto: ${this._port}`);
        });
    }
}
exports.default = Server;
