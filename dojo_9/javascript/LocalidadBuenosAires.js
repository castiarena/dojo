const Localidad = require('./Localidad');
const PuntoGeografico = require('./PuntoGeografico');

class LocalidadBuenosAires extends Localidad {
  constructor(){
    super(
      'Buenos Aires',
      new PuntoGeografico(
        -34.5522783,
        -58.4618838
      )
    );
  }
}

module.exports = LocalidadBuenosAires;
