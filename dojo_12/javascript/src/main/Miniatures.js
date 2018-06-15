
class Miniatures {
    constructor(meters) {
        this.meters = meters;
    }

    gte(meters){
        return this.meters <= meters;
    }
}

export default Miniatures;