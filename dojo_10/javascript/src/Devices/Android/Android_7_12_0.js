import Device from '../Device';
import SectionModifier from "../../Section/SectionModifier";
import DeviceSectionRules from "../DeviceSectionRules";

export default class Android_7_12_0 extends Device{
    /* istanbul ignore next */
    constructor(){
        super('android', '7_12_0');

        // set rules
        this.rules = new DeviceSectionRules([
            new SectionModifier('mlu_offline_payment', 'offline_payment')
        ]);
    }
}