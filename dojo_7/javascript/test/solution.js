const chai = require('chai');
const expect = chai.expect;

const Amount = require('../classes/amount.js');
const Order = require('../classes/order.js');
const AccountMoney = require('../classes/accountMoney');
const CreditCard = require('../classes/creditCard');
const GiftCard = require('../classes/giftCard');

describe("checkout - pay orders with multiple payments", () => {
    describe("account money", function() {
        it("should contribute a order of $1000 order with account money", () => {
            const number = 1000;
            const order = new Order(new Amount(number));
            const accountMoney = new AccountMoney(new Amount(number));
            order.contributeWith([accountMoney]);
            expect(accountMoney.contributed()).to.be.equal(number);
        });

    });

    describe("credit card", function() {
        it("should contribute a order of $1000 order with credit card", () => {
            const number = 1000;
            const order = new Order(new Amount(number));
            const creditCard = new CreditCard(new Amount(number));
            order.contributeWith([creditCard]);
            expect(creditCard.contributed()).to.be.equal(number);
        });

        it("should contribute a order of $1000 order with credit card with 15% of interests", () => {
            const order = new Order(new Amount(1000));
            const creditCard = new CreditCard(new Amount(1000), 15);
            order.contributeWith([creditCard]);
            expect(creditCard.contributed()).to.be.equal(1150);
        });
    });

    describe("gift card", function() {
        it("should contribute a order of $1000 order with gift card", () => {
            const number = 1000;
            const order = new Order(new Amount(number));
            const giftcard = new GiftCard(new Amount(number));
            order.contributeWith([giftcard]);
            expect(giftcard.contributed()).to.be.equal(number);
        });
    });

    describe("account money + gift card", () =>{
        it("should contribute a order of $1000 with account money and credit card without interests", () => {
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
    });

    describe("account money + gift card + credit card", ()=>{
        it("should contribute a order of $1000 with account money, gift card and credit card without interests", () => {
            const order = new Order(new Amount(1000));
            const accountMoney = new AccountMoney(new Amount(100));
            const creditCard = new CreditCard(new Amount(600));
            const giftCard = new GiftCard(new Amount(300));
            order.contributeWith([
                accountMoney,
                creditCard,
                giftCard
            ]);
            expect(accountMoney.contributed()).to.be.equal(100);
            expect(creditCard.contributed()).to.be.equal(600);
            expect(giftCard.contributed()).to.be.equal(300);
        });
    })
});
