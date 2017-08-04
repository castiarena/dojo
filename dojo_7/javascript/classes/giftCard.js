const Payments = require('./payments');

/**
 * AccountMoney
 * @constructor
 */
class GiftCard extends Payments{
    constructor(amount){
        super(amount);
    }
}

module.exports = GiftCard;