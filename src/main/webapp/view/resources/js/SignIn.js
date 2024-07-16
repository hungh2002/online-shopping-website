import { urlContextPath } from './GlobalVariable.js'

const signIn = async formData => {
  await fetch(`${urlContextPath}/api/customer?auth=sign-in`, {
    method: 'POST',
    body: formData
  })
  window.location.href = `${urlContextPath}/auth`
}
export default signIn
