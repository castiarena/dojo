const chai = require('chai');
const { expect } = chai;

const Tramo = require('../Tramo');
const LocalidadBuenosAires = require('../LocalidadBuenosAires');
const LocalidadMarDelPlata = require('../LocalidadMarDelPlata');
const LocalidadTrelew = require('../LocalidadTrelew');
const Precio = require('../Precio');
const Micro = require('../Micro');
const Tren = require('../Tren');

describe("#Empresa de viajes", () => {
    describe("Viajando de Buenos Aires a MDQ en Micro", () => {
        it("En un tramo", () => {
            const precio = new Precio(1578.4);
            const tramo = new Tramo(
                new LocalidadBuenosAires(),
                new LocalidadMarDelPlata()
            );
            const micro = new Micro([tramo]);
            
            expect(precio.costo()).to.be.equal(micro.precio().costo());
        });
        it("En dos tramos, pasando por trelew", () => {
            const precio = new Precio(8044.16);
            const tramo1 = new Tramo(
                new LocalidadBuenosAires(),
                new LocalidadTrelew()
            );
            const tramo2 = new Tramo(
                new LocalidadTrelew(),
                new LocalidadMarDelPlata()
            );
            const micro = new Micro([tramo1, tramo2]);
            
            expect(precio.costo()).to.be.equal(micro.precio().costo());
        });
    });
    describe("Viajando de Buenos Aires a Trelew en Tren", () => {
        it("En un tramo", () => {
            const precio = new Precio(2269.6);
            const tramo = new Tramo(
                new LocalidadBuenosAires(),
                new LocalidadTrelew()
            );

            const tren = new Tren([tramo]);

            expect(precio.costo()).to.be.equal(tren.precio().costo());
        });            
    });        
});
