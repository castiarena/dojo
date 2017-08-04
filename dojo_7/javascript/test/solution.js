const chai = require('chai');
const expect = chai.expect;

const Amount = require('../classes/amount.js');
const Order = require('../classes/order.js');
const AccountMoney = require('../classes/accountMoney');
const CreditCard = require('../classes/creditCard');

describe("checkout - pay orders with multiple payments", () => {
    describe("account money", function() {
        it("should pay a order of $1000 order with account money", () => {
            const number = 1000;
            const order = new Order(new Amount(number));
            const accountMoney = new AccountMoney(new Amount(number));
            order.contributeWith([accountMoney]);
            expect(accountMoney.contributed()).to.be.equal(number);
        });

        it("should pay a order with account money and credit card without interests", () => {
            const order = new Order(new Amount(1000));
            const accountMoney = new AccountMoney(new Amount(100));
            const creditCard = new CreditCard(new Amount(900));
            order.contributeWith([
                accountMoney,
                creditCard
            ]);
            expect(accountMoney.contributed()).to.be.equal(100);
            expect(creditCard.contributed()).to.be.equal(900);
        });

        it("should pay a order with account money and credit card without interests", () => {
            const order = new Order(new Amount(1000));
            const accountMoney = new AccountMoney(new Amount(100));
            const creditCard = new CreditCard(new Amount(600));
            const giftCard = new CreditCard(new Amount(300));
            order.contributeWith([
                accountMoney,
                creditCard,
                giftCard
            ]);
            expect(accountMoney.contributed()).to.be.equal(100);
            expect(creditCard.contributed()).to.be.equal(600);
            expect(giftCard.contributed()).to.be.equal(300);
        });

    });

    describe("credit card", function() {
        it("", () => {

        });
    });

    describe("gift card", function() {
        it("", () => {

        });
    });
});
