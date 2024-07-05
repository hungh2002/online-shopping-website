import { urlContextPath } from './GlobalVariable.js'

const signOut = document.getElementById('sign-out-button')
if (signOut !== null) {
  signOut.onclick = async () => {
    await fetch(`${urlContextPath}/api/customer?auth=sign-out`)
    window.location.href = `${urlContextPath}/auth?auth=sign-in`
  }
}
