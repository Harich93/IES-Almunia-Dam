import { Router } from "express";
import { search, prueba } from "../controllers/search.controller";


const router = Router();

router.get('/search/:ciudad', search)
router.get('/prueba', prueba)


export default router;