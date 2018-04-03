import Section from "./Section";

export default class SectionNotFound extends Section{
    constructor(){
        /* istanbul ignore next */
        super({
            type: 'not_found',
            model: {}
        });
    }
}