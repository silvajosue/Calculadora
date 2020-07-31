package calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	private final Color COLOR_GRAY = new Color(68,70,50);
	private final Color COLOR_CLEAN_GRAY = new Color(90,90,90);
	private final Color COLOR_ORANGE = new Color(240,160,55);

	public Teclado() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		adicionarBotao("AC", COLOR_GRAY, c, 0, 0);
		adicionarBotao("±", COLOR_GRAY, c, 1, 0);
		adicionarBotao("%", COLOR_GRAY, c, 2, 0);
		adicionarBotao("/", COLOR_ORANGE, c, 3, 0);
		
		adicionarBotao("7", COLOR_CLEAN_GRAY, c, 0, 1);
		adicionarBotao("8", COLOR_CLEAN_GRAY, c, 1, 1);
		adicionarBotao("9", COLOR_CLEAN_GRAY, c, 2, 1);
		adicionarBotao("*", COLOR_ORANGE, c, 3, 1);
		
		adicionarBotao("4", COLOR_CLEAN_GRAY, c, 0, 2);
		adicionarBotao("5", COLOR_CLEAN_GRAY, c, 1, 2);
		adicionarBotao("6", COLOR_CLEAN_GRAY, c, 2, 2);
		adicionarBotao("-", COLOR_ORANGE, c, 3, 2);
		
		adicionarBotao("1", COLOR_CLEAN_GRAY, c, 0, 3);
		adicionarBotao("2", COLOR_CLEAN_GRAY, c, 1, 3);
		adicionarBotao("3", COLOR_CLEAN_GRAY, c, 2, 3);
		adicionarBotao("+", COLOR_ORANGE, c, 3, 3);
		
		c.gridwidth = 2;
		adicionarBotao("0", COLOR_CLEAN_GRAY, c, 0, 4);
		c.gridwidth = 1;
		adicionarBotao(",", COLOR_CLEAN_GRAY, c, 2, 4);
		adicionarBotao("=", COLOR_ORANGE, c, 3, 4);
		

	}

	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		 
		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		Memoria.getInstancia().processarComando(botao.getText());
	}
}
