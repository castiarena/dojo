import Vue from 'vue';

import Link from '../src/link';


describe('Link tests', () => {
    it('should be in normal status', () => {
        const Creator = Vue.extend(Link);
        const vm = new Creator().$mount();

        expect(vm.className).toBe('link-normal');
    });

    it('should be in hovered status', () => {
        const Creator = Vue.extend(Link);
        const vm = new Creator().$mount();
        vm.handleMouseEnter();

        expect(vm.className).toBe('link-hovered');
    });

    it('should be in normal status after mouse enter and leave', () => {
        const Creator = Vue.extend(Link);
        const vm = new Creator().$mount();
        vm.handleMouseEnter();
        vm.handleMouseLeave();

        expect(vm.className).toBe('link-normal');
    });
});