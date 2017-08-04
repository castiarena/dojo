const Amount = require('./amount');
/**
 * Payments (abstract)
 * @constructor
 */
class Payments{
    constructor(amount){
        this.amount = amount;
        this.used = new Amount(0);
    }
    contribute(contribute) {
        this.used.plus(contribute);
    }
    contributed() {
        return this.amount.value();
    }
}

module.exports = Payments;