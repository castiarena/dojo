const Localidad = require('./Localidad');
const PuntoGeografico = require('./PuntoGeografico');

class LocalidadTrelew extends Localidad {
  constructor(){
    super(
      'Trelew',
      new PuntoGeografico(
        -43.2548235,
        -65.3345366
      )
    );
  }
}

module.exports = LocalidadTrelew;
