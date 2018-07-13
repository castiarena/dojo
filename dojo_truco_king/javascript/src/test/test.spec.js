import { expect, assert } from 'chai';
import Dojo from '../main/Dojo';

describe('dojo', () => {
  it('should return the correct sensei name', () => {
    const dojo = new Dojo({
      sensei: 'Diego'
    });

    const expected = '{"sensei":"Diego"}';

    expect(dojo.toJSON()).to.be.equal(expected);
  });

  it("it should not be equal", () => {	
    const dojoSouth = new Dojo({ sensei: 'Diego' });
    const dojoNorth = new Dojo({ sensei: 'Juan' });

    assert.equal(dojoSouth.isEqual(dojoNorth), false);
  });

  it("it should be equal", () => {	
    const dojoSouth = new Dojo({ sensei: 'Diego' });
    const dojoNorth = new Dojo({ sensei: 'Diego' });

    assert.equal(dojoSouth.isEqual(dojoNorth), true);
  });	
  
  it("it should throw an exception", () => {	
    const dojito = new Dojo();

    assert.throws(() => {	dojito.explode() });	
  });
});