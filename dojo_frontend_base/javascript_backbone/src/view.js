import _ from 'underscore';
import Backbone from 'backbone';

export default Backbone.View.extend({
    events: {
        'click button': 'clickHandler'
    },
    initialize() {
        this.clicks = 0;
        this.listenTo(this.model, 'change', this.render);
    },
    template: _.template('<h2>Hello <%- firstName %>! You clicked <%- clicks %> times! <button>Click me!</button></h2>'),
    render(){
        var context = _.extend(
            this.model.toJSON(),
            {clicks: this.clicks}
        );
        this.$el.html(this.template(context));
        return this;
    },
    clickHandler(){
        this.clicks++;
        this.render();
    }
});
