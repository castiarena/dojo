const Transporte = require('./Transporte');
const Precio = require('./Precio');

class Tren extends Transporte{
  constructor(tramos) {
    super(tramos, new Precio(2));
  }
}

module.exports = Tren;