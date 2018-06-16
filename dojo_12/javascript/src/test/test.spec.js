import {expect} from 'chai';
import braille from 'braille';
import Classroom from "../main/Classroom/Classroom";
import People from "../main/People";
import Miniatures from "../main/Miniatures";
import LabB from "../main/Classroom/LabB";
import LabA from "../main/Classroom/LabA";
import LabC from "../main/Classroom/LabC";

import ClassroomRequest from "../main/ClassroomRequest";
import Label from "../main/Label/Label";
import Computers from "../main/Computers";

describe('dojo', () => {
    it('se solicita un aula para 10 personas y se espera que la solicitud devuelva un aula habilitada', () => {

        const enabledClassroom = new ClassroomRequest([
            new Classroom(new Label('Aula: Lab B'), new People(10)),
            new Classroom(new Label('Aula: Lab A'), new People(2))
        ]).hasAtLeastPeople(
            new People(10)
        ).execute();

        expect(enabledClassroom.printLabelForVident()).to.be.equal('Aula: Lab B');
    });

    it('se solicita un aula para 30 personas y se espera que la solicitud falle', () => {
        const classRooms = [
            new Classroom(new Label('Aula: Lab A'), new People(28)),
            new Classroom(new Label('Aula: Lab B'), new People(10))
        ];

        const emptyClassroom = new ClassroomRequest(classRooms)
            .hasAtLeastPeople(new People(30))
            .execute();

        expect(emptyClassroom.printLabelForVident()).to.be.equal('No hay aula disponible. Despedidoooooooo');
    });

    it('La gente de arquitectura necesita además de capacidad en el aula, que la misma ' +
        'cumpla con cierta cantidad de metros cuadrados para poder exponer sus maquetas', () => {

        const classroomList = [
            new LabB(), new LabA()
        ];

        const enabledClassroom = new ClassroomRequest(classroomList)
            .hasAtLeastPeople(new People(10))
            .hasAtLeastMiniatures(new Miniatures(300))
            .execute();

        expect(enabledClassroom.printLabelForVident()).to.be.equal('Aula: Lab B');

    });

    it('Ciertas materias pueden solicitar que el aula que necesiten, disponga de cierta cantidad de computadoras.\n ' +
        'Dicha solicitud, al igual que los metros cuadrados son opcionales',  () => {

        const classroomList = [
            new LabB(), new LabA(), new LabC()
        ];

        const enabledClassroom = new ClassroomRequest(classroomList)
            .hasAtLeastPeople(new People(10))
            .hasAtLeastMiniatures(new Miniatures(300))
            .hasAtLeastComputers(new Computers(10))
            .execute();

        expect(enabledClassroom.printLabelForVident()).to.be.equal('Aula: Lab C')
    });

    it('Dado el aumento de alumnos no videntes en la universidad, se desea que las etiquetas ' +
        'se impriman en braille.', () => {

        const classroomList = [
            new LabA(), new LabC()
        ];

        const enabledClassroom = new ClassroomRequest(classroomList)
            .hasAtLeastComputers(new Computers(2))
            .hasAtLeastMiniatures(new Miniatures(5))
            .hasAtLeastPeople(new People(2))
            .execute();

        expect(
            enabledClassroom.printLabelForBlind()
        ).to.be.equal(
            braille.toBraille('Aula: Lab A')
        );
    });

});