class Dojo {
  constructor(sensei) {
    this.sensei = Object.assign({}, sensei);
  }

  toJSON() {
    return JSON.stringify(this.sensei);
  }

  isEqual(instance) {
    return this.toJSON() === instance.toJSON();
  }

  explode() {
    throw new Error('If statement detected, this dojo will self destruct in 3... 2... 1... 💥');
  }
}

export default Dojo;