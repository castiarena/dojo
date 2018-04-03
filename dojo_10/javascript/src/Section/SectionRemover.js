import Section from "./Section";

export default class SectionRemover extends Section{
    /* istanbul ignore next */
    constructor(sectionTypeToRemove){
        super();
        this.sectionTypeToRemove = sectionTypeToRemove;
    }

    applyTo(sectionsList){
        sectionsList.removeByType(this.sectionTypeToRemove);
    }
}
