import { urlContextPath } from './GlobalVariable.js'

const forms = document.querySelectorAll('.add-product-to-cart')
if (forms !== null) {
  forms.forEach(form => {
    form.onsubmit = async event => {
      event.preventDefault()
      const formData = new FormData(form)
      let productId = formData.get('product-id').replace('.0', '')
      formData.set('product-id', productId)

      console.log(formData.get('product-id'))
      console.log(formData.get('quantity'))

      await fetch(`${urlContextPath}/api/cart`, {
        method: 'POST',
        body: formData
      })
    }
  })
}
