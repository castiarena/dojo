import Sections from './Section/Sections';

export default class Congrats {
    constructor(jsonCongrats, deviceSectionsRules) {
        const { sections } = jsonCongrats;
        this.sections = new Sections(sections);
        deviceSectionsRules.applyTo(this.sections);
    }

    findSectionByType(sectionType) {
        return this.sections.findByType(sectionType);
    }
}