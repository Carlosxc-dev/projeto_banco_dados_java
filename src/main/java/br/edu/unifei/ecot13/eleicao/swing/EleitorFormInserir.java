package br.edu.unifei.ecot13.eleicao.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.eleicao.Assalto;
import br.edu.unifei.ecot13.eleicao.Banco;
import br.edu.unifei.ecot13.eleicao.PlanoAssalto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class EleitorFormInserir extends JFrame {

	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("eleicaoPU");
	private EntityManager em = emf.createEntityManager();
	private Assalto assalto;

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txt_nome_banco;
	private JTextField txt_plano_senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleitorFormInserir frame = new EleitorFormInserir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EleitorFormInserir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Numero: id++");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setBounds(45, 50, 79, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Objetivo:");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setBounds(45, 75, 79, 14);
		contentPane.add(lblNome);
		
		JLabel lblSecao = new JLabel("quantAlmejada:");
		lblSecao.setForeground(new Color(0, 0, 0));
		lblSecao.setBounds(45, 156, 100, 20);
		contentPane.add(lblSecao);
		
		JLabel lblAlfabetizado = new JLabel("Iniciado?");
		lblAlfabetizado.setForeground(new Color(0, 0, 0));
		lblAlfabetizado.setBounds(45, 191, 69, 14);
		contentPane.add(lblAlfabetizado);
		
		txtNome = new JTextField();
		txtNome.setBounds(155, 72, 141, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JSpinner spnSecao = new JSpinner();
		spnSecao.setBounds(155, 154, 93, 20);
		contentPane.add(spnSecao);
		
		JCheckBox chkAlfabetizado = new JCheckBox("sim");
		chkAlfabetizado.setBounds(155, 187, 97, 23);
		contentPane.add(chkAlfabetizado);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setForeground(new Color(255, 255, 255));
		btnInserir.setBackground(new Color(0, 128, 64));
		btnInserir.setBounds(207, 236, 89, 23);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assalto = new Assalto();
				Banco banco = new Banco();
				PlanoAssalto plano = new PlanoAssalto();
				
				assalto.setObjetivo(txtNome.getText());
				assalto.setQuntAlmejada((Integer)spnSecao.getValue());
				assalto.setAssaltarBanco(chkAlfabetizado.isSelected());
				
				banco.setNomeBanco(txt_nome_banco.getText()); 
				assalto.setBanco(banco);

				plano.setSenha(Integer.parseInt(txt_plano_senha.getText()));
			  
				assalto.setPlano(plano);
				 
				
				em.getTransaction().begin();
				em.persist(plano);
				em.persist(banco);
				em.persist(assalto);
				em.getTransaction().commit();
			}
		});
		contentPane.add(btnInserir);
		
		txt_nome_banco = new JTextField();
		txt_nome_banco.setBounds(155, 100, 141, 20);
		contentPane.add(txt_nome_banco);
		txt_nome_banco.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome banco:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(45, 100, 100, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plano senha:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(45, 131, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_plano_senha = new JTextField();
		txt_plano_senha.setBounds(155, 128, 141, 20);
		contentPane.add(txt_plano_senha);
		txt_plano_senha.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Classe Assalto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(69, 11, 180, 33);
		contentPane.add(lblNewLabel_2);
	}
}
