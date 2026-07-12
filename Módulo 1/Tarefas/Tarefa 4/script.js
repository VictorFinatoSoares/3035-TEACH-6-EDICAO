const square = document.getElementById('square')
const btn = document.getElementById('action-button')

function corAleatoria() {
  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  square.style.backgroundColor = `rgb(${r}, ${g}, ${b})`
}

btn.addEventListener('click', () => {
    corAleatoria()
})
