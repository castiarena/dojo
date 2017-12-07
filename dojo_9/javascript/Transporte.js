const Distancia = require('./Distancia');
const Precio = require('./Precio');

class Transporte {
  constructor(tramos, costoPorKm){
    this.tramos = tramos;
    this.costoPorKm = costoPorKm;
  }

  precio(){
    const distancia = this.tramos.reduce( 
      (distancia, tramo) => distancia.mas(tramo.distancia()), 
      new Distancia(0)
    );
    return this.costoPorKm.porDistancia(distancia);
  }
}

module.exports = Transporte;