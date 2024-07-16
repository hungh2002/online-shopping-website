import { urlContextPath } from './GlobalVariable.js'

document.getElementById('add-to-cart').onclick = async () => {
  const url = window.location.search
  const urlPram = new URLSearchParams(url)
  const productId = urlPram.get('product-id')
  const customerId = urlPram.get('customer-id')
  const quantity = document.getElementById('quantity')
  await fetch(`${urlContextPath}/cart?product-id=9&customer-id=1&quantity=2`, {
    method: 'POST'
  })
}
