package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate {
	private NandGate[] nandGates;

	public NotGate() {
		super("Not", 1);
		
		nandGates = new NandGate[1];
		
		for (int i = 0; i < nandGates.length; i++) {
			nandGates[i] = new NandGate();
		}
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nandGates[0].connect(0, emitter);
		nandGates[0].connect(1, emitter);
	}

	@Override
	public boolean read() {
		return (nandGates[0].read());
	}
}
