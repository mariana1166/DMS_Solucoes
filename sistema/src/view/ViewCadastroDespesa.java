package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DespesasDAO;
import model.Despesas;
import model.Utilitarios;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastroDespesa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodFuncionario;
	private JTextField textNomeFuncionario;
	private JTextField textDescricao;
	private JTextField textDataEmissao;
	private JTextField textDataVencimento;
	private Despesas d;
	private DespesasDAO ddao;
	private Utilitarios util;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroDespesa frame = new ViewCadastroDespesa();
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
	public ViewCadastroDespesa() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCodFuncionario = new JTextField();
		textCodFuncionario.setBounds(10, 83, 86, 20);
		contentPane.add(textCodFuncionario);
		textCodFuncionario.setColumns(10);
		
		textNomeFuncionario = new JTextField();
		textNomeFuncionario.setBounds(116, 83, 261, 20);
		contentPane.add(textNomeFuncionario);
		textNomeFuncionario.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(387, 82, 37, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Funcionário");
		lblNewLabel.setBounds(10, 62, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(10, 11, 86, 14);
		contentPane.add(lblDescrio);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(10, 31, 310, 20);
		contentPane.add(textDescricao);
		
		JLabel lblLanamento_1_1 = new JLabel("Data Emissão");
		lblLanamento_1_1.setBounds(10, 114, 86, 14);
		contentPane.add(lblLanamento_1_1);
		
		textDataEmissao = new JTextField();
		textDataEmissao.setColumns(10);
		textDataEmissao.setBounds(10, 132, 86, 20);
		contentPane.add(textDataEmissao);
		
		JLabel lblLanamento_1_1_1 = new JLabel("Data Vencimento");
		lblLanamento_1_1_1.setBounds(116, 114, 86, 14);
		contentPane.add(lblLanamento_1_1_1);
		
		textDataVencimento = new JTextField();
		textDataVencimento.setColumns(10);
		textDataVencimento.setBounds(116, 132, 86, 20);
		contentPane.add(textDataVencimento);
		
		JLabel lblLanamento_1_1_2 = new JLabel("Tipo de Despesas");
		lblLanamento_1_1_2.setBounds(342, 11, 106, 14);
		contentPane.add(lblLanamento_1_1_2);
		
		JComboBox comboBoxTipoDespesa = new JComboBox();
		comboBoxTipoDespesa.setModel(new DefaultComboBoxModel(new String[] {"Combustível", "Alimentação", "Passagem", "Salário"}));
		comboBoxTipoDespesa.setBounds(342, 30, 156, 22);
		contentPane.add(comboBoxTipoDespesa);
		
		JLabel lblLanamento_1_1_3 = new JLabel("Tipo de Pagamento");
		lblLanamento_1_1_3.setBounds(342, 113, 138, 14);
		contentPane.add(lblLanamento_1_1_3);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = new Despesas();
				d.setCodFuncionario(Integer.parseInt(textCodFuncionario.getText()));
				d.setNomeFuncionario(textNomeFuncionario.getText());
				d.setTipoDespesa(comboBoxTipoDespesa.getSelectedItem().toString());
				d.setDescricao(textDescricao.getText());
				d.setDataEmissao(textDataEmissao.getText());
				d.setDataVencimento(textDataVencimento.getText());
				d.setValor(textValor.getText());
				//d.setTipoPag(comboBoxTipoPag.getSelectedItem().toString());
				ddao = new DespesasDAO();
				ddao.inserir(d);
				util = new Utilitarios();
				util.LimpaDados(contentPane);
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 64, 128));
		btnSalvar.setBounds(126, 171, 89, 20);
		contentPane.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(0, 64, 128));
		btnCancelar.setBounds(288, 171, 89, 20);
		contentPane.add(btnCancelar);
		
		JLabel lblLanamento_1_1_1_1 = new JLabel("Valor");
		lblLanamento_1_1_1_1.setBounds(234, 114, 86, 14);
		contentPane.add(lblLanamento_1_1_1_1);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(234, 132, 86, 20);
		contentPane.add(textValor);
		
		JComboBox comboBoxTipoPag = new JComboBox();
		comboBoxTipoPag.setModel(new DefaultComboBoxModel(new String[] {"Boleto", "Cartão de Crédito", "Cartão de Débito", "Cheque", "Depósito", "Dinheiro", "Pix"}));
		comboBoxTipoPag.setBounds(342, 131, 156, 22);
		contentPane.add(comboBoxTipoPag);
	}

}
