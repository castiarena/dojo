import EmptyClassroom from "./EmptyClassroom";
Array.prototype.findOrDefault = function (dft, filter){
    return this.find(filter) || dft;
};

class CAU {
    constructor(classroomList) {
        this.classroomList = classroomList;
    }

    assignClassroom(persons, miniatures) {
        return this.classroomList.findOrDefault(
            new EmptyClassroom(), classroom =>
                classroom.canContainPersons(persons) &&
                classroom.canContainMiniatures(miniatures)
        );
    }
}

export default CAU;