package br.edu.unifei.ecot13.eleicao.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.eleicao.Assalto;
import br.edu.unifei.ecot13.eleicao.Banco;
import br.edu.unifei.ecot13.eleicao.PlanoAssalto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class EleitorFormAltera extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private EntityManagerFactory emf=
	Persistence.createEntityManagerFactory("eleicaoPU");
	private EntityManager em = 
		emf.createEntityManager();
	private Assalto assalto;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleitorFormAltera frame = new EleitorFormAltera();
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
	public EleitorFormAltera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblTitulo = new JLabel("numero:");
		lblTitulo.setBounds(46, 56, 79, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("objetivo:");
		lblNome.setBounds(46, 88, 64, 14);
		contentPane.add(lblNome);
		
		JLabel lblSecao = new JLabel("quantAlmejada:");
		lblSecao.setBounds(46, 181, 93, 14);
		contentPane.add(lblSecao);
		
		JLabel lblAlfabetizado = new JLabel("Iniciado ?");
		lblAlfabetizado.setBounds(46, 206, 64, 14);
		contentPane.add(lblAlfabetizado);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(141, 85, 151, 20);
		contentPane.add(txtNome);
		
		JSpinner spnSecao = new JSpinner();
		spnSecao.setEnabled(false);
		spnSecao.setBounds(141, 178, 93, 20);
		contentPane.add(spnSecao);
		
		JCheckBox chkAlfabetizado = new JCheckBox("sim");
		chkAlfabetizado.setEnabled(false);
		chkAlfabetizado.setBounds(141, 202, 97, 23);
		contentPane.add(chkAlfabetizado);

		JSpinner spnTitulo = new JSpinner();
		spnTitulo.setBounds(141, 56, 92, 20);
		contentPane.add(spnTitulo);
		
		JTextArea txt_plano_senha = new JTextArea();
		txt_plano_senha.setEnabled(false);
		txt_plano_senha.setBounds(141, 148, 151, 22);
		contentPane.add(txt_plano_senha);
		
		JTextArea txt_banco_nome = new JTextArea();
		txt_banco_nome.setEnabled(false);
		txt_banco_nome.setBounds(141, 116, 151, 22);
		contentPane.add(txt_banco_nome);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterar.setBackground(new Color(255, 128, 0));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				assalto.setObjetivo(txtNome.getText());
				assalto.setQuntAlmejada((Integer)spnSecao.getValue());
				assalto.setAssaltarBanco(chkAlfabetizado.isSelected());
				txtNome.setEnabled(false);
				spnSecao.setEnabled(false);
				chkAlfabetizado.setEnabled(false);
				btnAlterar.setEnabled(false);
				spnTitulo.setEnabled(true);
				
				
				em.getTransaction().begin();
				em.merge(assalto);
				em.getTransaction().commit();			
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(243, 244, 89, 23);
		contentPane.add(btnAlterar);
		
		
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				assalto = (Assalto) em.createQuery("from Assalto s where s.numero=" + spnTitulo.getValue()).getSingleResult();
				
				if(assalto!=null) {
					spnTitulo.setEnabled(false);
					txtNome.setEnabled(true);
					txtNome.setText(assalto.getObjetivo());
					spnSecao.setEnabled(true);
					spnSecao.setValue(assalto.getNumero());
					chkAlfabetizado.setEnabled(true);
					chkAlfabetizado.setSelected(assalto.isAssaltarBanco());
					btnAlterar.setEnabled(true);
					
					txt_banco_nome.setText(assalto.getBanco().getNomeBanco());
					txt_banco_nome.setEnabled(false);
					
					txt_plano_senha.setText(Integer.toString(assalto.getPlano().getSenha()));
					txt_plano_senha.setEnabled(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Eleitor não existe");
				}
				
				
			}
		});
		btnBuscar.setBounds(243, 55, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Nome banco:");
		lblNewLabel.setBounds(46, 112, 79, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plano Senha: ");
		lblNewLabel_1.setBounds(46, 150, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Classe Assalto");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(105, 11, 180, 33);
		contentPane.add(lblNewLabel_2);
		
		
		
		
	}
}
