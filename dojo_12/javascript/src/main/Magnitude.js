class Magnitude {
    constructor(number) {
        this.number = number;
    }

    greaterOrEquals(condition) {
        return this.number <= condition.number;
    }
}

export default Magnitude;