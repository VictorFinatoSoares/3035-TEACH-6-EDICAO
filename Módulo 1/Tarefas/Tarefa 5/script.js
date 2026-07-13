function calcular(operador) {
  const numero1 = parseInt(document.getElementById("numero1").value);
  const numero2 = parseInt(document.getElementById("numero2").value);

  let resultado;

  if (operador === "+") {
    resultado = numero1 + numero2;

  } else if (operador === "-") {
    resultado = numero1 - numero2;

  } else if (operador === "*") {
    resultado = numero1 * numero2;

  } else if (operador === "/") {
    if (numero2 === 0) {
      alert("Operação Inválida: Divisão por ZERO!");
      return;
    }
    resultado = numero1 / numero2;
  }

  document.getElementById("resultado").textContent = resultado;
}
