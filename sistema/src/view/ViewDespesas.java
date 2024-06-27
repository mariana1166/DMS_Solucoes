package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ContasPagarDAO;
import dao.DespesasDAO;
import model.ContasPagar;
import model.Despesas;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ViewDespesas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tableDespesas;
	
	private dao.DespesasDAO ddao;
	private model.Despesas d;
	private DefaultTableModel modeloTabela;
	private int selecao;
	private model.ContasPagar cp;
	private dao.ContasPagarDAO cpdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDespesas frame = new ViewDespesas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void listarDespesas() {
		Object col[] = new Object [] {"Código", "Tipo Despesa", "Cod Func.", "Nome Func.", "Descricao", "Data Emissão", "Data Vencimento", "Valor", "Tipo Pag."};
		ddao = new DespesasDAO();
		List<Despesas> lista = ddao.listarTodos();
		modeloTabela = new DefaultTableModel(col,0);
		tableDespesas.setModel(modeloTabela);
		
		for(Despesas d : lista) {
			modeloTabela.addRow(new Object[] {d.getCodigo(), d.getTipoDespesa(), d.getCodFuncionario(), d.getNomeFuncionario(), d.getDescricao(), d.getDataEmissao(), d.getDataVencimento(), d.getValor(), d.getTipoPag()});
		}	
	}

	/**
	 * Create the frame.
	 */
	public ViewDespesas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//BOTÃO EXCLUIR DESPESA SELECIONADA
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tableDespesas.getSelectedRow();
				if(selecao>=0) {
					d = new Despesas();
					d.setCodigo(tableDespesas.getValueAt(selecao, 0).toString());
					ddao.excluir(d);
					listarDespesas();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione a despesa que deseja excluir!");
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(0, 64, 128));
		btnExcluir.setBounds(751, 318, 89, 34);
		contentPane.add(btnExcluir);
		
		JButton btnGerarFinanceiro = new JButton("Gerar Financeiro");
		btnGerarFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tableDespesas.getSelectedRow();
				cp = new ContasPagar();
				cpdao = new ContasPagarDAO();
				if(selecao>=0) {
					cp.setCodigo(tableDespesas.getValueAt(selecao, 0).toString()+"-1");
					cp.setCodRecebedor(Integer.parseInt(tableDespesas.getValueAt(selecao, 2).toString()));
					cp.setNomeRecebedor(tableDespesas.getValueAt(selecao, 3).toString());
					cp.setTipoDoc("Boleto");
					cp.setDescricao("Gerado das Despesas");
					cp.setMovimento(tableDespesas.getValueAt(selecao, 0).toString());
					cp.setValorPago(0);
					cp.setValorPagar(0);
					cp.setDataEmissao(tableDespesas.getValueAt(selecao, 5).toString());
					cp.setDataVenc(tableDespesas.getValueAt(selecao, 6).toString());
					cp.setValorTotal(Float.parseFloat(tableDespesas.getValueAt(selecao, 7).toString()));
					cp.setDataPag("");
					cpdao.inserir(cp);
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione a despesa!");
				}
			}
		});
		btnGerarFinanceiro.setForeground(Color.WHITE);
		btnGerarFinanceiro.setBackground(new Color(0, 64, 128));
		btnGerarFinanceiro.setBounds(583, 390, 128, 34);
		contentPane.add(btnGerarFinanceiro);
		
		//BOTÃO PARA ABRIR TELA CADASTRO DE DESPESAS
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroDespesa vcd = new ViewCadastroDespesa();
				vcd.setVisible(true);
			}
		});
		btnInserir.setForeground(Color.WHITE);
		btnInserir.setBackground(new Color(0, 64, 128));
		btnInserir.setBounds(751, 156, 89, 34);
		contentPane.add(btnInserir);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(0, 0, 884, 21);
		contentPane.add(panel_2);
		
		JLabel lblDespesas = new JLabel("DESPESAS DE FUNCIONÁRIOS");
		lblDespesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespesas.setForeground(Color.WHITE);
		lblDespesas.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblDespesas.setBounds(0, 0, 884, 21);
		panel_2.add(lblDespesas);
		
		textField = new JTextField();
		textField.setBounds(133, 107, 223, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(34, 107, 89, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(366, 106, 28, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Funcionário");
		lblNewLabel.setBounds(34, 91, 89, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(437, 107, 107, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(604, 107, 107, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("a");
		lblNewLabel_1.setBounds(569, 113, 40, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Período");
		lblNewLabel_2.setBounds(437, 91, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(437, 58, 274, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tipo");
		lblNewLabel_2_1.setBounds(437, 42, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 156, 678, 196);
		contentPane.add(scrollPane);
		
		tableDespesas = new JTable();
		scrollPane.setViewportView(tableDespesas);
		
		listarDespesas();
	}
}
