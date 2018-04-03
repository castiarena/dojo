import Model from './Model';

export default class Section {
    constructor(data = { type: 'none', model: {}}) {
        this.type = data.type;
        this.model = new Model(data.model);
    }

    whoAmIByType(type) {
        return type === this.type && this;
    }

    checkType(type) {
        return type === this.type;
    }
}