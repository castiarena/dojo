import EmptyClassroom from "./Classroom/EmptyClassroom";

Array.prototype.findOrDefault = function (dft, filter){
    return this.find(filter) || dft;
};


class ClassroomRequest {
    constructor(classroomList) {
        this.classroomList = classroomList;
        this.classroom = new EmptyClassroom();
    }

    hasAtLeastPeople(people) {
        this.classroom = this.classroomList.findOrDefault(
            new EmptyClassroom(),
            classroom => classroom.canContainPeople(people)
        );
        return this;
    }

    hasAtLeastMiniatures(miniatures) {
        this.classroom = this.classroomList.findOrDefault(
            new EmptyClassroom(),
            classroom => classroom.canContainMiniatures(miniatures)
        );
        return this;
    }

    hasAtLeastComputers(computers) {
        this.classroom = this.classroomList.findOrDefault(
            new EmptyClassroom(),
            classroom => classroom.canContainComputers(computers)
        );
        return this;
    }

    execute(){
        return this.classroom;
    }
}

export default ClassroomRequest;