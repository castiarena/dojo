export default class DevicesRules {
    constructor(rules){
        this.rules = rules;
    }

    applyTo(congrats){
        this.rules.forEach(rule =>
            rule.applyTo(congrats)
        );
    }
}