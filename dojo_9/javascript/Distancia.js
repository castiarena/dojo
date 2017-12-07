class Distancia {
  constructor(cant){
    this.cant = cant; 
  }
  
  mas(distancia){
    this.cant = this.cant + distancia.cant;
    return this;
  }

  total(){
    return this.cant.toFixed(2);
  }


} 


module.exports = Distancia;