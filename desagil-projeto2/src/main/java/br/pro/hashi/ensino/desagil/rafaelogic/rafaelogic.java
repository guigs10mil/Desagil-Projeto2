package br.pro.hashi.ensino.desagil.rafaelogic;

import java.util.LinkedList;

import javax.swing.JFrame;

import br.pro.hashi.ensino.desagil.rafaelogic.model.*;

import br.pro.hashi.ensino.desagil.rafaelogic.view.View;

public class rafaelogic {
	public static void main(String[] args) {

		// Estrutura b�sica de um programa Swing, j� usada no Projeto 1.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				// Constr�i o modelo.
				LinkedList<Gate> model = new LinkedList<>();
				model.add(new AndGate());
				model.add(new NandGate());
				model.add(new NotGate());
				model.add(new OrGate());
				model.add(new XorGate());

				// Constr�i a vis�o.
				View view = new View(model);

				// Configura��o b�sica de uma janela Swing, j� usada no Projeto 1.
				JFrame frame = new JFrame();
            	frame.setContentPane(view);
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setResizable(false);
            	frame.pack();
            	frame.setVisible(true);
			}
		});
	}
}
