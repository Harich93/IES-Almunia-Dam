
export interface iUser  {
    uid: string
    displayName: string
    email: string
    direccion: iDireccion
    paypal?: string
}

export interface iDireccion {
    ciudad  : string
    dir     : string
}

