package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate {
	private NandGate[] nandGates;
	private NotGate[] notGates;

	public OrGate() {
		super("Or", 2);
		
		nandGates = new NandGate[1];
		notGates = new NotGate[2];
		
		for (int i = 0; i < nandGates.length; i++) {
			nandGates[i] = new NandGate();
		}
		for (int i = 0; i < notGates.length; i++) {
			notGates[i] = new NotGate();
		}
		
		nandGates[0].connect(0, notGates[0]);
		nandGates[0].connect(1, notGates[1]);
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		notGates[pinIndex].connect(0, emitter);
	}

	@Override
	public boolean read() {
		return (nandGates[0].read());
	}
}
