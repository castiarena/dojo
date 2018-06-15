import {expect} from 'chai';
import Classroom from "../main/Classroom/Classroom";
import CAU from "../main/CAU";
import People from "../main/People";
import Miniatures from "../main/Miniatures";
import LabB from "../main/Classroom/LabB";
import LabA from "../main/Classroom/LabA";

describe('dojo', () => {
    it('se solicita un aula para 10 personas y se espera que la solicitud devuelva un aula habilitada', () => {
        const cau = new CAU([
            new Classroom('Lab B', 10),
            new Classroom('Lab A', 2)
        ]);
        const enabledClassroom = cau.assignClassroom(
            new People(10)
        );

        expect(enabledClassroom.printLabel()).to.be.equal('Aula: Lab B');
    });

    it('se solicita un aula para 30 personas y se espera que la solicitud falle', () => {
        const cau = new CAU([
            new Classroom('Lab A', 28),
            new Classroom('Lab B', 10)
        ]);
        const emptyClassroom = cau.assignClassroom(
            new People(30)
        );

        expect(emptyClassroom.printLabel()).to.be.equal('No hay aula disponible. Despedidoooooooo');
    });

    it('La gente de arquitectura necesita además de capacidad en el aula, que la misma ' +
        'cumpla con cierta cantidad de metros cuadrados para poder exponer sus maquetas', () => {

        const cau = new CAU([
            new LabA(),
            new LabB()
        ]);

        const enabledClassroom = cau.assignClassroom(
            new People(10),
            new Miniatures(300)
        );

        expect(enabledClassroom.printLabel()).to.be.equal('Aula: Lab B');

    });
});