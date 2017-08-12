/**
 * Amount
 * @constructor
 */
class Amount {
    constructor(number){
        this.number = number;
    }
    // dismiss(amount){
    //     this.number -= amount.number;
    // }
    plus(amount){
        this.number += amount.number;
    }
    through(percent){
        this.number *= percent;
    }
    // diff(amount1, amount2){
    //     this.number = amount1.number > amount2.number ?
    //         amount1.number - amount2.number:
    //         amount2.number - amount2.number;
    // }
    value(){
        return this.number;
    }
}

module.exports = Amount;