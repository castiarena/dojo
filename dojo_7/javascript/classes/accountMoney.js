const Payments = require('./payments');

/**
 * AccountMoney
 * @constructor
 */
class AccountMoney extends Payments{
    constructor(amount){
        super(amount);
    }
}

module.exports = AccountMoney;