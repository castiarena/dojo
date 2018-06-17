import React from 'react';

const status = {
    NORMAL: 'link-normal',
    HOVERED: 'link-hovered',
};

export default class Link extends React.Component{
    constructor(props) {
        super(props);

        this._onMouseEnter = this._onMouseEnter.bind(this);
        this._onMouseLeave = this._onMouseLeave.bind(this);

        this.state = {
            className: status.NORMAL
        };
    }

    _onMouseEnter() {
        this.setState({className : status.HOVERED})
    }

    _onMouseLeave() {
        this.setState({className : status.NORMAL})
    }

    render() {
        return (
            <a
            className={this.state.className}
            href={this.props.page}
            onMouseEnter={this._onMouseEnter}
            onMouseLeave={this._onMouseLeave}>
                {this.props.children}
            </a>
        );
    }
}