package br.pro.hashi.ensino.desagil.rafaelogic.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pro.hashi.ensino.desagil.rafaelogic.model.OrGate;

public class OrGateTest {
	private OrGate gate;

	@Before
	public void setUp() {
		gate = new OrGate();
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
	public void fromInputTrueTrueShouldOutputTrue() {
		gate.connect(0, new TrueEmitter());
		gate.connect(1, new TrueEmitter());
		assertEquals(true, gate.read());
	}
}
