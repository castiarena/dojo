import Classroom from "./Classroom";
import Label from "../Label/Label";
import People from "../People";

class EmptyClassroom extends Classroom{
    /* istanbul ignore next */
    constructor(){
        super(
            new Label('No hay aula disponible. Despedidoooooooo'),
            new People(0)
        );
    }
}

export default EmptyClassroom;