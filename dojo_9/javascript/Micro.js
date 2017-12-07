const Transporte = require('./Transporte');
const Precio = require('./Precio');

class Micro extends Transporte{
  constructor(tramos) {
    super(tramos, new Precio(4));
  }
}

module.exports = Micro;