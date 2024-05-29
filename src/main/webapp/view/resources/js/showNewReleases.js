import { urlContextPath } from "./globalVariable.js";

const showNewReleases=() =>
{
  fetch( `${ urlContextPath }/api/product`, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  } )
    .then( ( response ) => response.json() )
    .then( ( data ) =>
    {
      let htmlString=data.map( ( item ) =>
      {
        return `
            <div class="col">
            <div class="card h-100 card-size">
              <img src=${ item.image } class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title"> ${ item.name } (${ item.price }$) </h5>
              </div>
            </div>
          </div>
            `;
      } );
      let html=htmlString.join( '' );
      document.getElementById( 'show-new-releases' ).innerHTML=html;
    } )
    .catch();
};

export default showNewReleases;