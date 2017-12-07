class Precio{
  constructor(monto){
    this.monto = monto;
    this.moneda = '$';
  }

  costo(){
    return `${this.moneda}${this.monto}`;
  }

  porDistancia(distancia){
    this.monto *= distancia.total();
    return this;
  }
}

module.exports = Precio;