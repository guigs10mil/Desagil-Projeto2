package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;


import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

import br.pro.hashi.ensino.desagil.rafaelogic.model.*;

// A classe JPanel representa um painel da interface gráfica,
// onde você pode adicionar componentes como menus e botões.
// A interface ActionListener é explicada melhor mais abaixo.
public class GateView extends SimplePanel implements ActionListener, MouseListener {

	// Não é necessário entender esta linha, mas se você estiver curioso
	// pode ler http://blog.caelum.com.br/entendendo-o-serialversionuid/.
	private static final long serialVersionUID = 1L;


	private Gate gate;
	
	private JCheckBox[] inputs;
	private JCheckBox outputBox;
	
	private Color color;
	private Image image;
	
	private int heightComp = 200;
	private int widthComp= 115 ;


	public GateView(Gate gate) {
		super(250,150);
		this.gate = gate;
		
		inputs = new JCheckBox[this.gate.getSize()];
		
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new JCheckBox();
		}

		outputBox = new JCheckBox();

		// A classe JLabel representa um componente que é simplesmente texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html

		if(inputs.length == 1){
			add(inputs[0], 10, 54, 75, 25);
		}
		else{
			add(inputs[0], 10, 32, 75, 25);
			add(inputs[1], 10, 78, 75, 25);
		}
		add(outputBox);

		// Estabelece que este subpainel reage ao usuário ativar as
		// caixas de seleção. Isso só pode ser feito se este subpainel for
		// do tipo ActionListener, por isso ele implementa essa interface.
		for (int i = 0; i < inputs.length; i++) {
			inputs[i].addActionListener(this);
		}
		

		// Estabelece que a ultíma caixa de seleção está desativada.
		outputBox.setEnabled(false);

		// Não podemos esquecer de chamar update na inicialização,
		// caso contrário a interface só ficará consistente depois
		// da primeira interação do usuário com as caixas de seleção.
		// A definição exata do método update é dada logo abaixo.
		update();
		
		
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();
		
		// Toda componente Swing possui este método, que
		// permite adicionar objetos que reagem a eventos
		// de mouse que acontecem nela. Ou seja, ao passar
		// this como parâmetro, estamos pedindo para a
		// componente reagir aos próprios eventos de mouse.
		addMouseListener(this);

	}


	// Método que liga as entradas dadas com a lógica das portas e
	// devolve o resultado.
	private void update() {
		Source[] sources = new Source[gate.getSize()];
		
		try {
			for (int i = 0; i < inputs.length; i++) {
				sources[i] = new Source();
				sources[i].turn(inputs[i].isSelected());
			}
		}
		catch(NumberFormatException exception) {
			outputBox.setText("?");
			return;
		}
		catch(NullPointerException exception) {
			outputBox.setText("TA NULL");
			return;
		}
		
		for (int i = 0; i < inputs.length; i++) {
			gate.connect(i, sources[i]);
		}
		if (gate.read()){
			color = Color.red;
		}
		else{
			color = Color.black;
		}
		
		outputBox.setSelected(gate.read());

		repaint();

	}


	// Método exigido pela interface ActionListener, que representa
	// a reação a qualquer interação do usuário no painel.
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		// Descobre em qual posição o clique ocorreu.
		int x = e.getX();
		int y = e.getY();

		// Se o clique foi dentro do circulo colorido...
		if(Math.pow((x-(185+15)), 2) + Math.pow((y-(122+15)), 2) < Math.pow(15, 2)) {

			// ...então abrimos o seletor de cor...
			color = JColorChooser.showDialog(this, null, color);

			// ...e atualizamos a tela.
			repaint();
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paintComponent(Graphics g) {

		// Não podemos esquecer desta linha, pois não somos os
		// únicos responsáveis por desenhar o painel, como era
		// o caso no Projeto 1. Agora é preciso desenhar também
		// componentes internas, e isso é feito pela superclasse.
		super.paintComponent(g);

		// Desenha a imagem passando posição e tamanho.
		// O último parâmetro pode ser sempre null.
		g.drawImage(image, 10, 10, heightComp,widthComp, null);


		g.setColor(color);
		g.fillOval(185, 52, 30, 30);

		

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }
}
