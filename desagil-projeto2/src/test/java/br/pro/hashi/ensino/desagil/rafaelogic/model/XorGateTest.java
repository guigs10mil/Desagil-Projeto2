package br.pro.hashi.ensino.desagil.rafaelogic.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pro.hashi.ensino.desagil.rafaelogic.model.XorGate;

public class XorGateTest {
	private XorGate gate;

	@Before
	public void setUp() {
		gate = new XorGate();
	}

	@Test
	public void fromInputFalseFalseShouldOutputFalse() {
		gate.connect(0, new FalseEmitter());
		gate.connect(1, new FalseEmitter());
		assertEquals(false, gate.read());
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
