import Classroom from "./Classroom";
import Label from "../Label/Label";
import People from "../People";
import Magnitude from "../Magnitude";
import Computers from "../Computers";

class LabC extends Classroom {
    /* istanbul ignore next */
    constructor() {
        super(
            new Label('Aula: Lab C'),
            new People(10),
        );
        this.miniaturesLimit = new Magnitude(300);
        this.computersLimit = new Computers(12);
    }
}

export default LabC;
