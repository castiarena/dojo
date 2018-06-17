import Marionette from 'backbone.marionette';

const status = {
    NORMAL: 'link-normal',
    HOVERED: 'link-hovered',
};


class Link extends Marionette.View {
    initialize(props) {
        this.props = props;
        this.model.set('className', status.NORMAL);
    }

    template(attributes) {
        const { page, text, className } = attributes;
        return `<a href="${page}" class="link ${className}">
            ${text}
        </a>`;
    }

    getEvents(){
        return {
            'mouseEnter .link': 'mouseEnterHandler',
            'mouseLeave .link': 'mouseLeaveHandler'
        };
    }

    mouseEnterHandler() {
        this.model.set('className', status.HOVERED);
    }

    mouseLeaveHandler() {
        this.model.set('className', status.NORMAL);
    }
}

export default Link;