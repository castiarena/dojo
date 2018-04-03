import Section from "./Section";

export default class SectionModifier extends Section{
    /* istanbul ignore next */
    constructor(valueToFind, valueToModify){
        super();
        this.valueToFind = valueToFind;
        this.valueToModify = valueToModify;
    }

    applyTo(sectionsList){
        const section = sectionsList.findByType(this.valueToFind);
        const { valueToModify } = this;
        section.type = valueToModify;
    }
}
