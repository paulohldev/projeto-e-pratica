export default class Cep {
  constructor(input, bairro, rua, cidade) {
    this.input = document.querySelector(input);
    this.dados = { bairro, rua, cidade };
  }
  addEvent() {
    this.input.addEventListener("change", this.request);
  }

  init() {
    this.addEvent();
    return this;
  }
}
