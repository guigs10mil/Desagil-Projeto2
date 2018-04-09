package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.*;

// A classe JPanel representa um painel da interface gráfica,
// onde você pode adicionar componentes como menus e botões.
// Esta em particular representa o subpainel de uma calculadora.
// A interface ActionListener é explicada melhor mais abaixo.
public class GateView extends JPanel implements ActionListener {

	// Não é necessário entender esta linha, mas se você estiver curioso
	// pode ler http://blog.caelum.com.br/entendendo-o-serialversionuid/.
	private static final long serialVersionUID = 1L;


	private Gate gate;

	// A classe JTextField representa um componente usado para digitação de texto.
	// https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html
	
	private JCheckBox[] inputs;
	private JCheckBox outputBox;


	public GateView(Gate gate) {
		this.gate = gate;
		
		inputs = new JCheckBox[this.gate.getSize()];
		
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = new JCheckBox();
		}

		outputBox = new JCheckBox();

		// A classe JLabel representa um componente que é simplesmente texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel inputLabel = new JLabel("Entrada:");
		JLabel outputLabel = new JLabel("Saida:");

		// Todo painel precisa de um layout, que estabelece como os componentes
		// são organizados dentro dele. O layout escolhido na linha abaixo é o
		// mais simples possível: simplesmente enfileira todos eles na vertical.
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Adiciona todas as componentes a este subpainel.
		add(inputLabel);
		for (int i = 0; i < inputs.length; i++) {
			add(inputs[i]);
		}
		add(outputLabel);
		add(outputBox);

		// Estabelece que este subpainel reage ao usuário digitar nos dois
		// primeiros campos. Isso só pode ser feito se este subpainel for
		// do tipo ActionListener, por isso ele implementa essa interface.
		for (int i = 0; i < inputs.length; i++) {
			inputs[i].addActionListener(this);
		}
		

		// Estabelece que o terceiro campo está desativado, não é digitável.
		outputBox.setEnabled(false);

		// Não podemos esquecer de chamar update na inicialização,
		// caso contrário a interface só ficará consistente depois
		// da primeira interação do usuário com os campos de texto.
		// A definição exata do método update é dada logo abaixo.
		update();
	}


	// Método que lê o peso e o raio dos primeiros campos,
	// calcula a densidade e a escreve no terceiro campo.
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

		outputBox.setSelected(gate.read());
		outputBox.setText("");

	}


	// Método exigido pela interface ActionListener, que representa
	// a reação a uma digitação do usuário nos dois primeiros campos.
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}