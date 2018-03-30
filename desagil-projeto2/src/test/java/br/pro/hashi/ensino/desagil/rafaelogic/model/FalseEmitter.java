package br.pro.hashi.ensino.desagil.rafaelogic.model;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Emitter;

public class FalseEmitter implements Emitter {
	@Override
	public boolean read() {
		return false;
	}
}
