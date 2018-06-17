import React from 'react';
import renderer from 'react-test-renderer';
import Adapter from 'enzyme-adapter-react-16';
import {shallow} from 'enzyme';
import * as enzyme from 'enzyme';

import Link from '../src/Link';

enzyme.configure({ adapter: new Adapter() });

describe('Link tests', () => {
    it('should be in normal status', () => {
        const component = renderer.create(
            <Link page="google.com.ar">Google argentina</Link>
        ).toJSON();

        expect(component).toMatchSnapshot();
    });

    it('should be in hovered status', () => {
        const component = shallow(
            <Link page="google.com.ar">Google argentina</Link>
        );

        component.find('a').simulate('mouseEnter');

        expect(component.find('a').hasClass('link-hovered')).toBeTruthy();
    });

    it('should be in normal status after mouse enter and leave', () => {
        const component = shallow(
            <Link page="google.com.ar">Google argentina</Link>
        );

        component.find('a').simulate('mouseEnter');
        component.find('a').simulate('mouseLeave');
        expect(component.find('a').hasClass('link-normal')).toBeTruthy();
    });
});