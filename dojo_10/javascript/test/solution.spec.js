import chai from 'chai';

import Andorid_7_12_0 from '../src/Devices/Android/Android_7_12_0'
import Ios_8_10_0 from '../src/Devices/Ios/Ios_8_10_0';

import congratsAndroid from './resources/congrats_order_paid_off_for_android_7_12_0.json';
import congratsIOs from './resources/congrats_order_paid_off_for_ios_8_10_0.json';
import SectionNotFound from "../src/Section/SectionNotFound";
import Android_7_10_1 from "../src/Devices/Android/Android_7_10_1";

const { expect } = chai;

describe('Purchase adapter', () => {
    it('test congrats order paid off for ios_8_10_0', () => {
        const sectionType = 'mlu_offline_payment';
        const device = new Ios_8_10_0();

        const congrats = device.congrats(congratsIOs);
        const offLinePaymentSection = congrats.findSectionByType(sectionType);

        expect(offLinePaymentSection.checkType(sectionType)).to.be.equal(true);
    });

    it('test congrats order paid off for android_7_12_0', () => {
        const sectionType = 'offline_payment';
        const device = new Andorid_7_12_0();

        const congrats = device.congrats(congratsAndroid);
        const offLinePaymentSection = congrats.findSectionByType(sectionType);

        expect(offLinePaymentSection.checkType(sectionType)).to.be.equal(true);
    });

    it('test congrats order paid off for android_7_12_0 from ios congrats', () => {
        const sectionType = 'offline_payment';

        const device = new Andorid_7_12_0();

        const congrats = device.congrats(congratsIOs);
        const offLinePaymentSection = congrats.findSectionByType(sectionType);

        expect(offLinePaymentSection.checkType(sectionType))
            .to.be.equal(true);
    });

    it('test congrats order paid off for ios_8_10_0 from android congrats', () => {
        const sectionType = 'mlu_offline_payment';

        const device = new Ios_8_10_0();

        const congrats = device.congrats(congratsAndroid);
        const offLinePaymentSection = congrats.findSectionByType(sectionType);

        expect(offLinePaymentSection.checkType(sectionType))
            .to.be.equal(true);
    });

    it('test congrats order paid off for ios_8_10_0 from android congrats must return congrats section not found', () => {
        const sectionType = 'offline_payment';

        const device = new Ios_8_10_0();

        const congrats = device.congrats(congratsAndroid);
        const offLinePaymentSection = congrats.findSectionByType(sectionType);

        expect(
            offLinePaymentSection instanceof SectionNotFound
        ).to.be.equal(true);
    });

    it('test congrats order paid off for android_7_10_1 from ios_8_10_0 congrats, must delete exit and change the section type', () => {
        const sectionOfflinePayment = 'offline_payment';
        const sectionExit = 'exit';

        const device = new Android_7_10_1();

        const congrats = device.congrats(congratsIOs);
        const offLinePaymentSection = congrats.findSectionByType(sectionOfflinePayment);
        const exitSection = congrats.findSectionByType(sectionExit);

        expect(offLinePaymentSection.checkType(sectionOfflinePayment)).to.be.equal(true);
        expect(exitSection.checkType(exitSection)).to.be.equal(false);
    });
});