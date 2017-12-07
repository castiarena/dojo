const Distancia = require('./Distancia');

class PuntoGeografico {
  constructor( lat, lng){
    this.lat = lat;
    this.lng = lng;
  }

  distanciaA(punto){

    const lat2 = punto.lat;
    const lon2 = punto.lng;
    const lat1 = this.lat;
    const lon1 = this.lng;

    const radlat1 = Math.PI * lat1/180;
    const radlat2 = Math.PI * lat2/180;
    const theta = lon1-lon2;
    const radtheta = Math.PI * theta/180;
    let dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
    
    dist = Math.acos(dist);
    dist = dist * 180/Math.PI;
    dist = dist * 60 * 1.1515;
    dist = dist * 1.609344;
    return new Distancia(dist);
  }
}

module.exports = PuntoGeografico;