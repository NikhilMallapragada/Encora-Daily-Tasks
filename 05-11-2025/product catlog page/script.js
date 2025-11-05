// script.js

const buttons = document.querySelectorAll('.buy-btn');
const cartCount = document.getElementById('cart-count');
let cart = JSON.parse(localStorage.getItem('cart')) || [];

cartCount.innerText = cart.length;

buttons.forEach(button => {
  button.addEventListener('click', () => {
    const name = button.getAttribute('data-name');
    const price = button.getAttribute('data-price');

    cart.push({ name, price });
    localStorage.setItem('cart', JSON.stringify(cart));

    cartCount.innerText = cart.length;
    alert(`${name} added to cart!`);
  });
});
