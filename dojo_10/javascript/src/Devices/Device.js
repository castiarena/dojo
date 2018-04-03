import Congrats from '../Congrats';
import DevicesRules from "./DevicesRules";

export default class Device {
    constructor(os, version) {
        this.os = os;
        this.version = version;
        this.rules = new DevicesRules();
    }

    congrats(jsonCongrats){
        return new Congrats(
            jsonCongrats, this.rules
        );
    }
}