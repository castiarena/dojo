const Localidad = require('./Localidad');
const PuntoGeografico = require('./PuntoGeografico');

class LocalidadMarDelPlata extends Localidad {
  constructor(){
    super(
      'Mar del Plata',
      new PuntoGeografico(
        -38.0250223,
        -57.5544091
      )
    );
  }
}

module.exports = LocalidadMarDelPlata;