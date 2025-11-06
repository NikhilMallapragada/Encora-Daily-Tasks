// Initialize AOS
AOS.init(); // Initialize scroll animations

// Typing animation
const texts = ["Web Developer", "Frontend Designer", "Tech Enthusiast"];
let count = 0, index = 0;
const typingElement = document.getElementById("typing");

function type() {
  const current = texts[count];
  typingElement.textContent = current.slice(0, index++);
  if (index > current.length) {
    index = 0;
    count = (count + 1) % texts.length;
  }
  setTimeout(type, 200);
}
type();

// 🌙 Dark Mode Toggle Logic
const toggleButton = document.getElementById("theme-toggle");
const body = document.body;
const icon = toggleButton.querySelector("i");

// Check saved theme preference
const savedTheme = localStorage.getItem("theme");
if (savedTheme === "dark") {
  body.classList.add("dark-mode");
  icon.classList.replace("bi-moon", "bi-sun");
}

// Toggle theme when button clicked
toggleButton.addEventListener("click", () => {
  body.classList.toggle("dark-mode");
  
  if (body.classList.contains("dark-mode")) {
    icon.classList.replace("bi-moon", "bi-sun");
    localStorage.setItem("theme", "dark");
  } else {
    icon.classList.replace("bi-sun", "bi-moon");
    localStorage.setItem("theme", "light");
  }
});

// ✉️ Initialize EmailJS
(function() {
  emailjs.init("k2JgiyojRGrAwI3Il"); // your actual PUBLIC_KEY
})();

// 📤 Handle Contact Form Submission
document.getElementById("contact-form").addEventListener("submit", function(event) {
  event.preventDefault();

  const serviceID = "service_ew6i9uh";
  const templateID = "template_l9qz7nw";

  // Show sending message
  document.getElementById("status-message").innerHTML =
    '<div class="alert alert-info">⏳ Sending your message...</div>';

  emailjs.sendForm(serviceID, templateID, this)
    .then(() => {
      document.getElementById("status-message").innerHTML =
        '<div class="alert alert-success">✅ Message sent successfully!</div>';
      this.reset();
    })
    .catch((err) => {
      console.error("Error:", err);
      document.getElementById("status-message").innerHTML =
        '<div class="alert alert-danger">❌ Failed to send message. Please check your EmailJS setup.</div>';
    });
});
