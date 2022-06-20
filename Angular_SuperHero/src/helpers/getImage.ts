import { heroes } from "src/db/heroes"

export const getImage = ( id:string ):string => {
    const heroImage = heroes.filter( heroe => heroe.id === id );

    const url = `/src/assets/heroes/${heroImage}.jpg` 

    return url;
}