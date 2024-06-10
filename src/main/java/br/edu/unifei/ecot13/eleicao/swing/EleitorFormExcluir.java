package br.edu.unifei.ecot13.eleicao.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.eleicao.Assalto;

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
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class EleitorFormExcluir extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private EntityManagerFactory emf=
	Persistence.createEntityManagerFactory("eleicaoPU");
	private EntityManager em = 
		emf.createEntityManager();
	private Assalto assaltar;
	private JTextField txt_banco_nome;
	private JTextField txt_plano_senha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleitorFormExcluir frame = new EleitorFormExcluir();
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
	public EleitorFormExcluir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblTitulo = new JLabel("Numero:");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setBounds(51, 56, 79, 14);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Objetivo:");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setBounds(51, 81, 69, 14);
		contentPane.add(lblNome);
		
		JLabel lblSecao = new JLabel("quantAlmejada:");
		lblSecao.setForeground(new Color(0, 0, 0));
		lblSecao.setBounds(51, 172, 95, 14);
		contentPane.add(lblSecao);
		
		JLabel lblAlfabetizado = new JLabel("Iniciado:");
		lblAlfabetizado.setForeground(new Color(0, 0, 0));
		lblAlfabetizado.setBounds(51, 197, 69, 14);
		contentPane.add(lblAlfabetizado);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(157, 81, 151, 20);
		contentPane.add(txtNome);
		
		JSpinner spnSecao = new JSpinner();
		spnSecao.setEnabled(false);
		spnSecao.setBounds(156, 172, 93, 20);
		contentPane.add(spnSecao);
		
		JCheckBox chkAlfabetizado = new JCheckBox("Em andamento");
		chkAlfabetizado.setEnabled(false);
		chkAlfabetizado.setBounds(157, 197, 97, 23);
		contentPane.add(chkAlfabetizado);

		JSpinner spnTitulo = new JSpinner();
		spnTitulo.setBounds(157, 56, 92, 20);
		contentPane.add(spnTitulo);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExcluir.setBackground(new Color(128, 0, 0));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assaltar.setObjetivo(txtNome.getText());
				assaltar.setQuntAlmejada((Integer)spnSecao.getValue());
				assaltar.setAssaltarBanco(chkAlfabetizado.isSelected());
				chkAlfabetizado.setEnabled(false);
				spnTitulo.setEnabled(true);
				em.getTransaction().begin();
				em.remove(assaltar);
				em.getTransaction().commit();							
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(259, 228, 89, 23);
		contentPane.add(btnExcluir);
		
		txt_banco_nome = new JTextField();
		txt_banco_nome.setEnabled(false);
		txt_banco_nome.setBounds(157, 110, 151, 20);
		contentPane.add(txt_banco_nome);
		txt_banco_nome.setColumns(10);
		
		txt_plano_senha = new JTextField();
		txt_plano_senha.setEnabled(false);
		txt_plano_senha.setBounds(157, 143, 151, 20);
		contentPane.add(txt_plano_senha);
		txt_plano_senha.setColumns(10);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				assaltar = (Assalto) em.createQuery("from Assalto s where s.numero=" + spnTitulo.getValue()).getSingleResult();
				
				if(assaltar!=null) {
					spnTitulo.setEnabled(false);
					txt_banco_nome.setEnabled(false);
					txt_plano_senha.setEnabled(false);
					txtNome.setText(assaltar.getObjetivo());
					spnSecao.setValue(assaltar.getQuntAlmejada());
					chkAlfabetizado.setSelected(assaltar.isAssaltarBanco());
					btnExcluir.setEnabled(true);
					txt_banco_nome.setText(assaltar.getBanco().getNomeBanco());
					txt_plano_senha.setText(Integer.toString(assaltar.getPlano().getSenha()));
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Eleitor não existe");
				}
				
				
			}
		});
		btnBuscar.setBounds(259, 52, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Nome banco:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(51, 106, 79, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Plano senha:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(51, 147, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Classe Assalto");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(103, 11, 180, 33);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
