export default class Model {
    constructor(model) {
        Object.keys(model).forEach( key => {
            this[key] = model[key]
        });
    }
}