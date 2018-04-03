import Device from '../Device';
import DevicesRules from '../DevicesRules';
import SectionModifier from "../../Section/SectionModifier";

export default class Ios_8_10_0 extends Device{
    /* istanbul ignore next */
    constructor(){
        super('ios', '8_10_0');

        // set rules
        this.rules = new DevicesRules([
            new SectionModifier('offline_payment', 'mlu_offline_payment')
        ]);
    }
}