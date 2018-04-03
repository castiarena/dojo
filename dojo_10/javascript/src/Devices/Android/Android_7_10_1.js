import Device from '../Device';
import DeviceSectionRules from "../DeviceSectionRules";
import SectionRemover from "../../Section/SectionRemover";
import SectionModifier from "../../Section/SectionModifier";

export default class Android_7_10_1 extends Device{
    /* istanbul ignore next */
    constructor(){
        super('android', '7_12_0');

        // set rules
        this.rules = new DeviceSectionRules([
            new SectionRemover('exit'),
            new SectionModifier('mlu_offline_payment', 'offline_payment')
        ]);
    }
}