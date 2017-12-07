class Tramo {
  constructor(origen, destino) {
    this.origen = origen;
    this.destino = destino;
  }

  distancia(){
    return this.origen.distanciaHasta(this.destino);
  }
}

module.exports = Tramo;