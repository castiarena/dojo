import Backbone from 'backbone';
import Link from '../src/link.view';


describe('Link tests', () => {
    it('should be in hovered status', () => {
        const model = new Backbone.Model({
            page: 'google.com',
            text: 'Google page'
        });

        const linkView = new Link({model});
        expect(linkView.render().el.innerHTML).toMatchSnapshot();
    });

    it('should be in hovered status', () => {
        const model = new Backbone.Model({
            page: 'google.com',
            text: 'Google page'
        });

        const linkView = new Link({model});
        linkView.mouseEnterHandler();

        expect(linkView.render().el.innerHTML).toMatchSnapshot();
    });

    it('should be in normal status after mouse enter and leave', () => {
        const model = new Backbone.Model({
            page: 'google.com',
            text: 'Google page'
        });

        const linkView = new Link({model});
        linkView.mouseEnterHandler();
        linkView.mouseLeaveHandler();

        expect(linkView.render().el.innerHTML).toMatchSnapshot();
    });

    it('should validate events association with methods of the Link view', () => {
        const model = new Backbone.Model({});
        const linkView = new Link({model});

        const keyEvents = Object.keys(linkView.getEvents());
        const eventsHandlers = keyEvents.map(keyEvent => linkView.getEvents()[keyEvent]);

        const propsNamesAndMethods = Object.getOwnPropertyNames(Link.prototype);

        expect(eventsHandlers
            .every(eventHandler => propsNamesAndMethods.indexOf(eventHandler) !== -1)
        ).toBeTruthy();

    });
});