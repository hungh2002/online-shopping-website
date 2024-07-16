import { urlContextPath } from './GlobalVariable.js'
import signIn from './SignIn.js'

const signUp = formData => {
  fetch(`${urlContextPath}/api/customer?auth=sign-up`, {
    method: 'POST',
    body: formData
  }).then(async data => {
    let status = await data.text()
    console.log(status != 'Account already exists')
    if (status != 'Account already exists') {
      signIn(formData)
    } else {
      window.location.href = `${urlContextPath}/auth?auth=sign-up`
    }
  })
}

export default signUp
