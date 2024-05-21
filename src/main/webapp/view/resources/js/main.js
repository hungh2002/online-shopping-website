const urlContextPath='http://localhost:8080';

fetch( `${ urlContextPath }/api/product`, {
  method: 'GET',
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  }
} )
  .then( ( response ) => response.json() )
  .then( ( data ) => {
    let htmlString=data.map( ( item ) => {
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
    document.getElementById( 'show-new-releases' ).innerHTML='<h1>hello</h1>';
    console.log( document.getElementById( 'show-new-releases' ) );
    let html=htmlString.join( '' );
    document.getElementById( 'show-new-releases' ).innerHTML=html;
  } )
  .catch();