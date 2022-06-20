"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const search_controller_1 = require("../controllers/search.controller");
const router = (0, express_1.Router)();
router.get('/search/:ciudad', search_controller_1.search);
router.get('/prueba', search_controller_1.prueba);
exports.default = router;
