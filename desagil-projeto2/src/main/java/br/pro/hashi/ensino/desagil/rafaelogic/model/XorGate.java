package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate extends Gate {
	private NandGate[] nandGates;

	public XorGate() {
		nandGates = new NandGate[4];
		
		for (int i = 0; i < nandGates.length; i++) {
			nandGates[i] = new NandGate();
		}
		
		nandGates[1].connect(1, nandGates[0]);
		nandGates[2].connect(0, nandGates[0]);
		nandGates[3].connect(0, nandGates[1]);
		nandGates[3].connect(1, nandGates[2]);
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandGates[pinIndex + 1].connect(pinIndex, emitter);
		nandGates[0].connect(pinIndex, emitter);
	}

	@Override
	public boolean read() {
		return (nandGates[3].read());
	}
}
