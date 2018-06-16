
class Classroom {
    constructor(labelCourseName, peopleLimit) {
        this.peopleLimit = peopleLimit;
        this.label = labelCourseName;
        this.miniaturesLimit = 0;
        this.computersLimit = 0;
    }

    canContainPeople(persons){
        return persons.greaterOrEquals(this.peopleLimit);
    }

    canContainMiniatures(miniatures){
        return miniatures.greaterOrEquals(this.miniaturesLimit);
    }

    canContainComputers(computers){
        return computers.greaterOrEquals(this.computersLimit);
    }

    printLabelForVident() {
        return this.label.printForVident();
    }

    printLabelForBlind() {
        return this.label.printForBlind();
    }
}

export default Classroom;