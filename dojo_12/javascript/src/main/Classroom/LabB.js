import Classroom from "./Classroom";
import People from "../People";
import Label from "../Label/Label";
import Miniatures from "../Miniatures";

class LabB extends Classroom {
    /* istanbul ignore next */
    constructor() {
        super(
            new Label('Aula: Lab B'),
            new People(10)
        );

        this.miniaturesLimit = new Miniatures(300);
    }
}

export default LabB;
