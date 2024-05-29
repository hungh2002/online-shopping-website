import { urlContextPath } from "./globalVariable.js";

let login=document.getElementById( "check-login" );

fetch( `${ urlContextPath }/api/customer?auth=sign-in`, {
    method: 'POST',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    }
} );

