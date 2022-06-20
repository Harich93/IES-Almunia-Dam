// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  googleApi: 'AIzaSyCbdBIz3X5BIiBsQnYk1cRCJcQKl3kd_P8',
  paypal: {
    clientId : 'AeD37bVFkNd9N2JYLCSVDGdBTR3lsfJlyGBq6UjecEP1WsWmTSmYoGgQ4FGTrtKuBJvqsAauz5PN2Wad',
    secret   : 'EDQWejIdGPTJW0EMigCBNzpETrQcRV8MI8pvRcDz_Bzt73obWCZzYiQHQRh89kRpbnUWygpPguPxCs4O',
    auth: 'QWVEMzdiVkZrTmQ5TjJKWUxDU1ZER2RCVFIzbHNmSmx5R0JxNlVqZWNFUDFXc1dtVFNtWW9HZ1E0RkdUcnRLdUJKdnFzQWF1ejVQTjJXYWQ6RURRV2VqSWRHUFRKVzBFTWlnQ0JOenBFVHJRY1JWOE1JOHB2UmNEel9CenQ3M29iV0NaellpUUhRUmg4OWtScGJuVVd5Z3BQZ3VQeENzNE8=',
    oauthAPI : 'https://api-m.sandbox.paypal.com/v1/oauth2/token/',
    orderAPI :  'https://api-m.sandbox.paypal.com/v2/checkout/orders/'
  },
  firebase: {
    key           : 'AIzaSyC64If5_Y_xJ5UMwxRY8DOhXnIycG4ckBo',
    authDomain    : "miniwallapop.firebaseapp.com",
    projectId     : "miniwallapop",
    storageBucket : "miniwallapop.appspot.com",
    messagingSenderId : "377228560306",
    appId         : "1:377228560306:web:70737ca894e71898a246ab"
  },

  
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
