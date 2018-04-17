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

public class GateView extends SimplePanel implements ActionListener, MouseListener {

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


		if(inputs.length == 1){
			add(inputs[0], 10, 54, 75, 25);
		}
		else{
			add(inputs[0], 10, 32, 75, 25);
			add(inputs[1], 10, 78, 75, 25);
		}
		add(outputBox);

		for (int i = 0; i < inputs.length; i++) {
			inputs[i].addActionListener(this);
		}
		
		outputBox.setEnabled(false);

		update();
		
		
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();
		
		addMouseListener(this);

	}

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

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int x = e.getX();
		int y = e.getY();

		if(Math.pow((x-(185+15)), 2) + Math.pow((y-(122+15)), 2) < Math.pow(15, 2)) {

			color = JColorChooser.showDialog(this, null, color);

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

		super.paintComponent(g);

		g.drawImage(image, 10, 10, heightComp,widthComp, null);

		g.setColor(color);
		g.fillOval(185, 52, 30, 30);

		getToolkit().sync();
    }
}
