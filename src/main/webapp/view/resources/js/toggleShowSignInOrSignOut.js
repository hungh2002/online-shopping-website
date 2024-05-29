const toggleShowSignInOrSignOutOnClick=() =>
{
    let button=document.getElementById( "toggleShowSignInOrSignOut" );
    let signUp=document.getElementById( "sign-up" );
    let signIn=document.getElementById( "sign-in" );


    button.onclick=() =>
    {
        if ( signUp.style.display=="none" )
        {
            signUp.style.display="block";
            signIn.style.display="none";
            button.innerHTML="Sign In";
        } else
        {
            signUp.style.display="none";
            signIn.style.display="block";
            button.innerHTML="Sign Up";
        }
    };
};

export default toggleShowSignInOrSignOutOnClick;

