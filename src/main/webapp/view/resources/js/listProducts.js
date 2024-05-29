import { urlContextPath } from "./globalVariable.js";


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
            <a href="/product?id=${ item.id }" class="card h-100 card-size">
              <img src=${ item.image } class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title"> ${ item.name } (${ item.price }$) </h5>
              </div>
            </a>
          </div>
            `;
        } );
        let html=htmlString.join( '' );
        document.getElementById( 'list-products' ).innerHTML=html;
    } )
    .catch();