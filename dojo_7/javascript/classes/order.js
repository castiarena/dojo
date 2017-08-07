/**
 * Order
 * @constructor
 */
class Order{
    constructor(amount){
        this.amount = amount;
    }

    contributeWith(payments){
        let amount = this.amount;
        payments.forEach( p => {
            p.contribute(amount);
        });
    }
}


module.exports = Order;