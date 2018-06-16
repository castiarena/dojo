import braille from 'braille';

class Label {
    constructor(name) {
        this.name = name;
    }

    printForVident() {
        return this.name;
    }

    printForBlind() {
        return braille.toBraille(this.name);
    }
}

export default Label;