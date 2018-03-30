package br.pro.hashi.ensino.desagil.rafaelogic.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pro.hashi.ensino.desagil.rafaelogic.model.NandGate;

public class NandGateTest {
	private NandGate gate;

	@Before
	public void setUp() {
		gate = new NandGate();
	}

	@Test
	public void fromInputFalseFalseShouldOutputTrue() {
		gate.connect(0, new FalseEmitter());
		gate.connect(1, new FalseEmitter());
		assertEquals(true, gate.read());
	}

	@Test
	public void fromInputFalseTrueShouldOutputTrue() {
		gate.connect(0, new FalseEmitter());
		gate.connect(1, new TrueEmitter());
		assertEquals(true, gate.read());
	}

	@Test
	public void fromInputTrueFalseShouldOutputTrue() {
		gate.connect(0, new TrueEmitter());
		gate.connect(1, new FalseEmitter());
		assertEquals(true, gate.read());
	}

	@Test
	public void fromInputTrueTrueShouldOutputFalse() {
		gate.connect(0, new TrueEmitter());
		gate.connect(1, new TrueEmitter());
		assertEquals(false, gate.read());
	}
}
