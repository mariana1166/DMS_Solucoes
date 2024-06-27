package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ContasReceberDAO;
import dao.ContratoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import model.ContasReceber;
import model.Contrato;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ViewMonitoramentoContrato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textComp;
	private JTextField textContrato;
	private JTextField textCliente;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tabelaListar;
	private ContratoDAO cdao;
	private DefaultTableModel modeloTabela;
	private ContasReceberDAO crdao;
	private ContasReceber cr;
	private int selecao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMonitoramentoContrato frame = new ViewMonitoramentoContrato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void preencherTabela() {
		Object col[] = new Object [] {"Codigo", "Cod Cliente", "Nome Cliente", "Dia Faturamento", "Dia Pag.", "Valor"};
		cdao = new ContratoDAO();
		List<Contrato> lista = cdao.listarTodos();
		modeloTabela = new DefaultTableModel(col,0);
		tabelaListar.setModel(modeloTabela);
		
		for(Contrato cont : lista) {
			modeloTabela.addRow(new Object[] {cont.getCodigo(), cont.getCodCli(), cont.getNomeCli(), cont.getDiaFat(), cont.getDiaPag(),cont.getValor()});
		}
		
	}

	/**
	 * Create the frame.
	 */
	public ViewMonitoramentoContrato() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeContrato = new JLabel("MONITORAMENTO DE CONTRATOS");
		lblCadastroDeContrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContrato.setForeground(Color.WHITE);
		lblCadastroDeContrato.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCadastroDeContrato.setBounds(0, 0, 884, 21);
		contentPane.add(lblCadastroDeContrato);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(0, 0, 884, 21);
		contentPane.add(panel_2);
		
		textComp = new JTextField();
		textComp.setBounds(39, 92, 86, 20);
		contentPane.add(textComp);
		textComp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Competência");
		lblNewLabel.setBounds(39, 74, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNContrato = new JLabel("Nº Contrato");
		lblNContrato.setBounds(167, 74, 86, 14);
		contentPane.add(lblNContrato);
		
		textContrato = new JTextField();
		textContrato.setColumns(10);
		textContrato.setBounds(167, 92, 86, 20);
		contentPane.add(textContrato);
		
		textCliente = new JTextField();
		textCliente.setColumns(10);
		textCliente.setBounds(297, 92, 86, 20);
		contentPane.add(textCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(297, 74, 86, 14);
		contentPane.add(lblCliente);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(430, 92, 44, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(519, 92, 44, 20);
		contentPane.add(textField_1);
		
		JLabel lblAt = new JLabel("Até");
		lblAt.setBounds(484, 95, 44, 14);
		contentPane.add(lblAt);
		
		JLabel lblDiaDeFaturamento = new JLabel("Dia de Faturamento");
		lblDiaDeFaturamento.setBounds(441, 74, 123, 14);
		contentPane.add(lblDiaDeFaturamento);
		
		JCheckBox chckbxSituacao = new JCheckBox("Abertos");
		chckbxSituacao.setBounds(608, 47, 124, 23);
		contentPane.add(chckbxSituacao);
		
		JCheckBox chckbxSituacao_1 = new JCheckBox("Faturados");
		chckbxSituacao_1.setBounds(608, 70, 124, 23);
		contentPane.add(chckbxSituacao_1);
		
		JCheckBox chckbxSituacao_2 = new JCheckBox("Somente Ativos");
		chckbxSituacao_2.setBounds(608, 91, 124, 23);
		contentPane.add(chckbxSituacao_2);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setBackground(new Color(0, 64, 128));
		btnFiltrar.setBounds(751, 78, 89, 34);
		contentPane.add(btnFiltrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(39, 154, 801, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 781, 223);
		panel.add(scrollPane);
		
		tabelaListar = new JTable();
		scrollPane.setViewportView(tabelaListar);
		preencherTabela();
		
		JButton btnFaturar = new JButton("Gerar Financeiro");
		btnFaturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaListar.getSelectedRow();
				cr = new ContasReceber();
				crdao = new ContasReceberDAO();
				if(selecao>=0) {
					
				cr.setCodigo(tabelaListar.getValueAt(selecao, 0).toString()+"-1");
	     		cr.setCodCli(Integer.parseInt(tabelaListar.getValueAt(selecao, 1).toString()));
				cr.setNomeCli(tabelaListar.getValueAt(selecao, 2).toString());
				cr.setTipoDoc("Boleto");
				cr.setDescricao("Gerado do fechamento do contrato "+tabelaListar.getValueAt(selecao, 0).toString());
				cr.setMovimento("");
				cr.setContrato(tabelaListar.getValueAt(selecao, 0).toString());
				cr.setValorTotal(Float.parseFloat(tabelaListar.getValueAt(selecao, 5).toString()));
				cr.setValorRecebido(0);
				cr.setValorReceber(0);
				cr.setDataEmissao("05/06/2024");
				cr.setDataVenc((tabelaListar.getValueAt(selecao, 4).toString())+"/"+textComp.getText());
				cr.setDataPag("");
				crdao.inserir(cr);
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione o contrato!");
				}
			}
		});
		btnFaturar.setForeground(Color.WHITE);
		btnFaturar.setBackground(new Color(0, 64, 128));
		btnFaturar.setBounds(709, 405, 131, 34);
		contentPane.add(btnFaturar);
		
		/**JCheckBox chckbxSelecionarTudo = new JCheckBox("Selecionar Tudo");
		chckbxSelecionarTudo.setBounds(39, 405, 124, 23);
		contentPane.add(chckbxSelecionarTudo);**/
		
		/**JCheckBox chckbxGerarFinanceiro = new JCheckBox("Gerar Financeiro");
		chckbxGerarFinanceiro.setBounds(167, 405, 124, 23);
		contentPane.add(chckbxGerarFinanceiro);**/
	}
	
}
