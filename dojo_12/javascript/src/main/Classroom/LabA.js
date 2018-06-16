import Classroom from "./Classroom";
import People from "../People";
import Label from "../Label/Label";
import Miniatures from "../Miniatures";

class LabA extends Classroom {
    /* istanbul ignore next */
    constructor() {
        super(
            new Label('Aula: Lab A'),
            new People(10)
        );

        this.miniaturesLimit = new Miniatures(30);
    }
}

export default LabA;
