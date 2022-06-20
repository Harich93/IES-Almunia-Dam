window.addEventListener('load', main);

let frameSearch, frameRecord;
let btnSearch, cityIn; 
let sError, resContainer, recordContainer;
let record = [];
let aux = 0; 

function main(){

   // Tabs
   document.querySelector('#tabSearch').addEventListener('click', openSearch)
   document.querySelector('#tabRecord').addEventListener('click', openRecord)

   // Buttons
   btnSearch = document.querySelector('#btnSearch');
   btnSearch.addEventListener('click', getWeather);

   // Inputs
   cityIn = document.querySelector('#cityIn');

   // Containers
   sError = document.querySelector('#sError');
   resContainer = document.querySelector('#res-container');
   recordContainer = document.querySelector('#record-container');


   // Frames
   frameSearch = document.querySelector('#search-frame')
   frameRecord = document.querySelector('#record-frame')

}

const getWeather = async() => {

   if( isError() ) return

   const res = await fetch(`http://127.0.0.1:8080/api/search/${cityIn.value}`)
   const resDecoded = await res.json();

   record.push( resDecoded );

   createCard( resDecoded, resContainer );
}

function isError() {
   if( cityIn.value.length < 3 ) {
      sError.classList.remove('hidden');
      return true
   }
   else {
      sError.classList.add('hidden');
      return false
   }
}

function createCard( data, container ) {

   const pathImg = selectImg( data.weather );
   
   if(container == resContainer) container.innerHTML = '';

   container.innerHTML += `
      <div class="card">
         
         <div class="card-header col">
            <h3>${data.name}</h3>
            <h4>${data.region}</h4>
            <h5>${data.country}</h5>
         </div>
      
         <div class="card-img col">
            <img src="./assets/${pathImg}.png" alt="weather">
         </div>

         <div class="card-clima col">
            <h3>${data.temperature}°C</h3>
            <h4>Humedad: ${data.humidity}%</h4>
         </div>

      </div>
   `
}

function selectImg( data ) {

   switch( data ) {
      case 'Clear' : return 'Sunny'
      case 'Fog'   : return 'Overcast'
      case 'Patchy rain possible' : return 'Rain'
      default: return data  
   }

}

function openRecord() {

   frameSearch.classList.add('hidden');
   frameRecord.classList.remove('hidden');

   listRecord();

}

function openSearch() {
   
   frameRecord.classList.add('hidden');
   frameSearch.classList.remove('hidden');
}

function listRecord() {
   record.forEach( (data, i ) => aux <= i && createCard( data, recordContainer ))
   aux = record.length;
}


