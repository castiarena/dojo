const Payments = require('./payments');

/**
 * AccountMoney
 * @constructor
 */
class CreditCard extends Payments{
    constructor(amount, interests = 0){
        super(amount);
        this.interests = (interests / 100) + 1;
    }
    contribute(contribute) {
        this.used.plus(contribute);
        this.amount.through(this.interests);
    }
    contributed() {
        return this.amount.value();
    }
}

module.exports = CreditCard;