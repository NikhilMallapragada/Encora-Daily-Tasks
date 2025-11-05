// cart.js

const cartItemsContainer = document.getElementById('cart-items');
const totalAmount = document.getElementById('total-amount');
let cart = JSON.parse(localStorage.getItem('cart')) || [];
let total = 0;

function displayCart() {
  cartItemsContainer.innerHTML = '';
  total = 0;

  cart.forEach(item => {
    const div = document.createElement('div');
    div.classList.add('cart-item');
    div.innerHTML = `
      <p>${item.name} - $${item.price}</p>
    `;
    cartItemsContainer.appendChild(div);
    total += parseFloat(item.price);
  });

  totalAmount.innerText = `Total: $${total.toFixed(2)}`;
}

document.getElementById('apply-coupon').addEventListener('click', () => {
  const code = document.getElementById('coupon-code').value.trim().toUpperCase();
  let discount = 0;

  if (code === 'FESTIVE10') {
    discount = total * 0.10;
  } else if (code === 'SAVE20' && total > 100) {
    discount = 20;
  } else {
    alert('Invalid or Ineligible Coupon');
    return;
  }

  total -= discount;
  totalAmount.innerText = `Total after discount: $${total.toFixed(2)}`;
  alert(`Coupon Applied! You saved $${discount.toFixed(2)} 🎉`);
});

displayCart();
