package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate {
	private NandGate[] nandGates;

	public AndGate() {
		nandGates = new NandGate[2];
		
		for (int i = 0; i < nandGates.length; i++) {
			nandGates[i] = new NandGate();
		}
		
		nandGates[1].connect(0, nandGates[0]);
		nandGates[1].connect(1, nandGates[0]);
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandGates[0].connect(pinIndex, emitter);
	}

	@Override
	public boolean read() {
		return (nandGates[1].read());
	}
}
