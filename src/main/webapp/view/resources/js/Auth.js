import signIn from './SignIn.js'
import signUp from './SignUp.js'

const form = document.forms['auth']
if (form !== null) {
  form.onsubmit = event => {
    event.preventDefault()
    const formData = new FormData(form)

    const url = window.location.search
    const urlPram = new URLSearchParams(url)
    const pram = urlPram.get('auth')
    if (pram === 'sign-in') {
      signIn(formData)
    } else if (pram === 'sign-up') {
      signUp(formData)
    }
  }
}
