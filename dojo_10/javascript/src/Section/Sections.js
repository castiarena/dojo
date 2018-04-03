import Section from './Section';
import SectionNotFound from './SectionNotFound';

export default class Sections {
    constructor(jsonSections) {
        this.sections = jsonSections.map(
            jsonSection => new Section(jsonSection)
        );
    }

    findByType(type) {
        const section = this.sections.find( section =>
            section.whoAmIByType(type)
        );
        return section || new SectionNotFound();
    }

    removeByType(type) {
        const section = this.sections.find( section =>
            section.whoAmIByType(type)
        );
        const indexOf = this.sections.indexOf(section);
        this.sections.splice(indexOf, 1);
    }
}