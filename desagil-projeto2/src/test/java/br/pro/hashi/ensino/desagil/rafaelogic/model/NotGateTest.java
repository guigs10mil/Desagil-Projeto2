package br.pro.hashi.ensino.desagil.rafaelogic.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.pro.hashi.ensino.desagil.rafaelogic.model.NotGate;

public class NotGateTest {
	private NotGate gate;

	@Before
	public void setUp() {
		gate = new NotGate();
	}

	@Test
	public void fromInputFalseShouldOutputTrue() {
		gate.connect(0, new FalseEmitter());
		assertEquals(true, gate.read());
	}

	@Test
	public void fromInputTrueShouldOutputFalse() {
		gate.connect(0, new TrueEmitter());
		assertEquals(false, gate.read());
	}
}
