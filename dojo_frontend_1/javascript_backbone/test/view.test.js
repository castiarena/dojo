import Backbone from 'backbone';

import  View from '../src/view';


describe('My View', () => {
    it('should not regress', () => {
        const user = new Backbone.Model({
            firstName: 'Jordan',
            lastName: 'Eldredge'
        });
        const myView = new View({model: user}).render();
        expect(myView.$el.html()).toMatchSnapshot();
    });
    it('should welcome the user', () => {
        var user = new Backbone.Model({
            firstName: 'Jordan',
            lastName: 'Eldredge'
        });
        var myView = new View({model: user}).render();
        expect(myView.$el.html()).toContain('Hello Jordan!');
    });
    it('should rerender if user model changes', () => {
        var user = new Backbone.Model({
            firstName: 'Jordan',
            lastName: 'Eldredge'
        });
        var myView = new View({model: user}).render();
        user.set({firstName: 'Elizabeth'});
        expect(myView.$el.html()).toContain('Hello Elizabeth!');
    });
    it('should update counter when button is clicked', () => {
        var user = new Backbone.Model({
            firstName: 'Jordan',
            lastName: 'Eldredge'
        });
        var myView = new View({model: user}).render();
        expect(myView.$el.html()).toContain('You clicked 0 times');
        myView.$el.find('button').click();
        expect(myView.$el.html()).toContain('You clicked 1 times');
    });
});