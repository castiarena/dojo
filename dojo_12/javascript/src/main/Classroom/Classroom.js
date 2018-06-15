import NoMiniatures from "../NoMiniatures";

class Classroom {
    constructor(courseName, limit, meters) {
        this.courseName = courseName;
        this.limit = limit;
        this.meters = meters;
    }

    canContainPersons(persons){
        return persons.gte(this.limit);
    }

    canContainMiniatures(miniatures = new NoMiniatures()){
        return miniatures.gte(this.meters);
    }

    printLabel() {
        return `Aula: ${this.courseName}`;
    }
}

export default Classroom;