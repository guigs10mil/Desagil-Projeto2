package br.pro.hashi.ensino.desagil.rafaelogic.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pro.hashi.ensino.desagil.rafaelogic.model.AndGate;

public class AndGateTest {
	private AndGate gate;

	@Before
	public void setUp() {
		gate = new AndGate();
	}

	@Test
	public void fromInputFalseFalseShouldOutputFalse() {
		gate.connect(0, new FalseEmitter());
		gate.connect(1, new FalseEmitter());
		assertEquals(false, gate.read());
	}

	@Test
	public void fromInputFalseTrueShouldOutputFalse() {
		gate.connect(0, new FalseEmitter());
		gate.connect(1, new TrueEmitter());
		assertEquals(false, gate.read());
	}

	@Test
	public void fromInputTrueFalseShouldOutputFalse() {
		gate.connect(0, new TrueEmitter());
		gate.connect(1, new FalseEmitter());
		assertEquals(false, gate.read());
	}

	@Test
	public void fromInputTrueTrueShouldOutputTrue() {
		gate.connect(0, new TrueEmitter());
		gate.connect(1, new TrueEmitter());
		assertEquals(true, gate.read());
	}
}
