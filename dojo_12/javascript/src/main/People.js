class People {
    constructor(number) {
        this.number = number;
    }

    gte(number){
        return this.number <= number;
    }
}

export default People;