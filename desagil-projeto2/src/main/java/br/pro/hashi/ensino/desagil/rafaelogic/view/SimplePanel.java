package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

//Componente criada especialmente para o projeto, que é
//basicamente um JPanel de tamanho fixo. Fixar tamanho
//geralmente não é considerada uma boa prática de design
//de interface, mas fazemos isso aqui por simplicidade.
public class SimplePanel extends JPanel {
	private static final long serialVersionUID = 1L;


	// O construtor recebe a largura e a altura do painel.
	public SimplePanel(int width, int height) {

		// É muito importante estabelecer que esse painel
		// não tem layout, pois caso contrário seu tamanho
		// vai ser definido pelo tamanho de seu conteúdo.
		setLayout(null);

		// Usamos esse método no Projeto 1, vocês lembram?
		setPreferredSize(new Dimension(width, height));
	}


	// Sobrecarga do método add que permite definir a posição e o
	// tamanho de cada componente dentro do painel. Essa também não
	// é uma boa prática, pois o normal é deixar o layout decidir.
	// Novamente, escolhemos fazer isso aqui por simplicidade.
	public Component add(Component comp, int x, int y, int width, int height) {

		// Usa a implementação original do método para adicionar.
		super.add(comp);

		// Redefine posição e tamanho do componente já adicionado.
		comp.setBounds(x, y, width, height);

		return comp;
	}
}

