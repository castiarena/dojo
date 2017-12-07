class Localidad {
  constructor(nombre, puntoGeografico){
    this.nombre = nombre;
    this.puntoGeografico = puntoGeografico;
  }

  distanciaHasta(localidad){
    return this.puntoGeografico.distanciaA(localidad.puntoGeografico);
  }
}

module.exports = Localidad;