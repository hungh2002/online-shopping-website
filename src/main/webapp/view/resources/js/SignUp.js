import { urlContextPath } from './GlobalVariable.js'
import signIn from './SignIn.js'

const signUp = async formData => {
  await fetch(`${urlContextPath}/api/customer?auth=sign-up`, {
    method: 'POST',
    body: formData
  })
  await signIn(formData)
}

export default signUp
