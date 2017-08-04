const Payments = require('./payments');

/**
 * AccountMoney
 * @constructor
 */
class CreditCard extends Payments{
    constructor(amount){
        super(amount);
    }
}

module.exports = CreditCard;