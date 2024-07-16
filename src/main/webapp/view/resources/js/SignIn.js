import { urlContextPath } from './GlobalVariable.js'

const signIn = formData => {
  fetch(`${urlContextPath}/api/customer?auth=sign-in`, {
    method: 'POST',
    body: formData
  }).then(async data => {
    let status = await data.text()
    console.log(status)
    if (status == 'Sign in success') {
      window.location.href = `${urlContextPath}/auth`
    } else {
      window.location.href = `${urlContextPath}/auth?auth=sign-in`
    }
  })
}
export default signIn
