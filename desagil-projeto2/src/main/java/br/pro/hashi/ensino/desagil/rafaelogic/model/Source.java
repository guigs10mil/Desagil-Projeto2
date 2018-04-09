package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class Source implements Emitter {
    private boolean on;

    public Source() {
        on = false;
    }

    public void turn(boolean on) {
        this.on = on;
    }

    @Override
    public boolean read() {
        return on;
    }
}
