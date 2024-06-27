package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dao.ContratoDAO;
import model.Cliente;
import model.Contrato;
import model.Utilitarios;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewContrato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textCodCli;
	private JTextField textNomeCli;
	private JTextField textDtInicio;
	private JTextField textDtVenc;
	private JTextField textDiaFat;
	private JTable table_1;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	private Contrato cont;
	private ContratoDAO cdao;
	private JTextField textDiaPag;
	private JTextField textValor;
	private JTable tabelaListar;
	private Cliente cli;
	private ClienteDAO clidao;
	private Utilitarios util;
	private DefaultTableModel modeloTabela;
	private int selecao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewContrato frame = new ViewContrato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void listarContratos() {
		Object col[] = new Object [] {"Codigo", "Cod Cliente", "Nome Cliente", "Dia Faturamento", "Data Vencimento", "Valor"};
		cdao = new ContratoDAO();
		List<Contrato> lista = cdao.listarTodos();
		modeloTabela = new DefaultTableModel(col,0);
		tabelaListar.setModel(modeloTabela);
		
		for(Contrato cont : lista) {
			modeloTabela.addRow(new Object[] {cont.getCodigo(), cont.getCodCli(), cont.getNomeCli(), cont.getDiaFat(), cont.getDtVenc(), cont.getValor()});
		}
		
	}
	

	/**
	 * Create the frame.
	 */
	public ViewContrato() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 884, 461);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 884, 21);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 64, 128));
		panel.add(panel_2);
		
		JLabel lblCadastroDeContrato = new JLabel("CADASTRO DE CONTRATO");
		lblCadastroDeContrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContrato.setForeground(Color.WHITE);
		lblCadastroDeContrato.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCadastroDeContrato.setBounds(0, 0, 884, 21);
		panel_2.add(lblCadastroDeContrato);
		
		JLabel lblNewLabel = new JLabel("Nº Contrato");
		lblNewLabel.setBounds(47, 45, 86, 14);
		panel.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(47, 62, 86, 20);
		panel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblCdCliente = new JLabel("Cliente");
		lblCdCliente.setBounds(171, 45, 86, 14);
		panel.add(lblCdCliente);
		
		textCodCli = new JTextField();
		textCodCli.setBounds(171, 62, 86, 20);
		textCodCli.setColumns(10);
		panel.add(textCodCli);
		
		textNomeCli = new JTextField();
		textNomeCli.setBounds(267, 62, 299, 20);
		textNomeCli.setColumns(10);
		panel.add(textNomeCli);
		
		JCheckBox chckbxSituacao = new JCheckBox("Inativar contrato");
		chckbxSituacao.setBounds(537, 28, 124, 23);
		panel.add(chckbxSituacao);
		
		textDtInicio = new JTextField();
		textDtInicio.setToolTipText("");
		textDtInicio.setBounds(47, 118, 86, 20);
		textDtInicio.setColumns(10);
		panel.add(textDtInicio);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(47, 100, 86, 14);
		panel.add(lblDataInicio);
		
		textDtVenc = new JTextField();
		textDtVenc.setBounds(171, 118, 86, 20);
		textDtVenc.setColumns(10);
		panel.add(textDtVenc);
		
		JLabel lblDataVencimento = new JLabel("Data Vencimento");
		lblDataVencimento.setBounds(171, 100, 98, 14);
		panel.add(lblDataVencimento);
		
		textDiaFat = new JTextField();
		textDiaFat.setBounds(300, 118, 86, 20);
		textDiaFat.setColumns(10);
		panel.add(textDiaFat);
		
		JLabel lblDiaFaturamento = new JLabel("Dia Faturamento");
		lblDiaFaturamento.setBounds(300, 100, 108, 14);
		panel.add(lblDiaFaturamento);
		
		JLabel lblDiaPagamento = new JLabel("Dia pagamento");
		lblDiaPagamento.setBounds(681, 108, 98, 14);
		panel.add(lblDiaPagamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 198, 614, 141);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel lblServiosContratados = new JLabel("SERVIÇOS CONTRATADOS");
		lblServiosContratados.setBounds(388, 173, 179, 14);
		panel.add(lblServiosContratados);
		
		JButton btnNewButton_1 = new JButton("Inserir");
		btnNewButton_1.setBounds(756, 203, 37, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Inserir");
		btnNewButton_1_1.setBounds(756, 248, 37, 34);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Inserir");
		btnNewButton_1_1_1.setBounds(756, 293, 37, 34);
		panel.add(btnNewButton_1_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 161, 884, 187);
		panel.add(separator);
		
		//BOTÃO SALVAR		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont = new Contrato();
				cont.setCodigo(textCodigo.getText());
				cont.setCodCli(Integer.parseInt(textCodCli.getText()));
				cont.setNomeCli(textNomeCli.getText());
				cont.setDtInicio(textDtInicio.getText());
				cont.setDtVenc(textDtVenc.getText());
				cont.setDiaFat(Integer.parseInt(textDiaFat.getText()));
				//cont.setCondPag(comboBoxPag.getSelectedItem().toString());
				cont.setCondPag("Dinheiro");
				cont.setDiaPag(Integer.parseInt(textDiaPag.getText()));
				cont.setValor(Float.parseFloat(textValor.getText()));
				//cont.setSituacao(Boolean.parseBoolean(textCondPag.getText()));
				//cont.setObs(textObs.getText());
				cdao = new ContratoDAO();
				cdao.inserir(cont);
				util = new Utilitarios();
				util.LimpaDados(panel);
				listarContratos();
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 64, 128));
		btnSalvar.setBounds(267, 388, 89, 34);
		panel.add(btnSalvar);
		
		//BOTÃO CANCELAR
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilitarios util = new Utilitarios();
				util.LimpaDados(panel);
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(0, 64, 128));
		btnCancelar.setBounds(521, 388, 89, 34);
		panel.add(btnCancelar);
		
		//BOTÃO PESQUISA CLIENTE
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codcli = textCodCli.getText();
				cli = new Cliente();
				clidao = new ClienteDAO();
				cli=clidao.BurcarCodigoCli(codcli);
				if(cli.getCodigo() > 0) {
					textCodCli.setText(String.valueOf(cli.getCodigo()));
					textNomeCli.setText(cli.getNome());
				}else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
				}			
			}
		});
		btnNewButton.setBounds(576, 62, 37, 21);
		panel.add(btnNewButton);
		
		textDiaPag = new JTextField();
		textDiaPag.setColumns(10);
		textDiaPag.setBounds(681, 130, 62, 20);
		panel.add(textDiaPag);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(669, 21, 15, 141);
		panel.add(separator_1);
		
		JLabel lblFinanceiro = new JLabel("FINANCEIRO");
		lblFinanceiro.setBounds(745, 32, 86, 14);
		panel.add(lblFinanceiro);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(638, 350, 108, 20);
		panel.add(textValor);
		
		JLabel lblTotalContratado = new JLabel("Valor Contratado: ");
		lblTotalContratado.setBounds(511, 350, 117, 21);
		panel.add(lblTotalContratado);
		
		//BOTÃO ALTERA CONTRATO
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cont = new Contrato();
				cont.setCodigo(textCodigo.getText());
				cont.setCodCli(Integer.parseInt(textCodCli.getText()));
				cont.setNomeCli(textNomeCli.getText());
				cont.setDtInicio(textDtInicio.getText());
				cont.setDtVenc(textDtVenc.getText());
				cont.setDiaFat(Integer.parseInt(textDiaFat.getText()));
				//cont.setCondPag(comboBoxPag.getSelectedItem().toString());
				cont.setCondPag("Dinheiro");
				cont.setDiaPag(Integer.parseInt(textDiaPag.getText()));
				cont.setValor(Float.parseFloat(textValor.getText()));
				//cont.setSituacao(Boolean.parseBoolean(textCondPag.getText()));
				//cont.setObs(textObs.getText());
				cdao.alterar(cont);
				listarContratos();
				util = new Utilitarios();
				util.LimpaDados(panel);
				tabbedPane.setSelectedIndex(1);//Ir para tela de listagem
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setEnabled(false);
		btnAlterar.setBackground(new Color(0, 64, 128));
		btnAlterar.setBounds(132, 388, 89, 34);
		panel.add(btnAlterar);
		
		JComboBox comboBoxPag = new JComboBox();
		comboBoxPag.setModel(new DefaultComboBoxModel(new String[] {"Boleto", "Cartão de Crédito", "Cartão de Débito", "Cheque", "Depósito", "Dinheiro", "Pix"}));
		comboBoxPag.setBounds(681, 62, 185, 22);
		panel.add(comboBoxPag);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listagem", null, panel_1, null);
		tabbedPane.setEnabledAt(1, true);
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(0, 0, 884, 21);
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 64, 128));
		panel_1.add(panel_2_1);
		
		JLabel lblCadastroDeContrato_1 = new JLabel("LISTAGEM DE CONTRATOS");
		lblCadastroDeContrato_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContrato_1.setForeground(Color.WHITE);
		lblCadastroDeContrato_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblCadastroDeContrato_1.setBounds(0, 0, 884, 21);
		panel_2_1.add(lblCadastroDeContrato_1);
		
		//BOTÃO NOVO
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilitarios util = new Utilitarios();
				util.LimpaDados(panel);
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setBackground(new Color(0, 64, 128));
		btnNovo.setBounds(240, 378, 89, 34);
		panel_1.add(btnNovo);
		
		//BOTÃO PARA IR PARA TELA DE EDIÇÃO E PUXAR DADOS
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaListar.getSelectedRow();
				cont = new Contrato();
				cdao = new ContratoDAO();
				if(selecao >= 0) {
					String codigo = tabelaListar.getValueAt(selecao, 0).toString();
					cont = cdao.BurcarCodigo(codigo);
					if(cont != null) {
						textCodigo.setText(cont.getCodigo());
						textCodCli.setText(String.valueOf(cont.getCodCli()));
						textNomeCli.setText(cont.getNomeCli());
						comboBoxPag.setSelectedItem(cont.getCondPag());
						textDiaFat.setText(String.valueOf(cont.getDiaFat()));
						textDiaPag.setText(String.valueOf(cont.getDiaPag()));
						textDtInicio.setText(cont.getDtInicio());
						textDtVenc.setText(cont.getDtVenc());
						textValor.setText(Float.valueOf(cont.getValor()).toString());
						//textObs.setText(cont.getObs());
					}
					else{
						JOptionPane.showMessageDialog(null, "Título não localizado");
					}
					
					tabbedPane.setSelectedIndex(0);
					btnSalvar.setEnabled(false);
					btnAlterar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um título que deseja alterar!");
				}
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(0, 64, 128));
		btnEditar.setBounds(374, 378, 89, 34);
		panel_1.add(btnEditar);
		
		//BOTÃO EXCLUIR CONTRATO
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaListar.getSelectedRow();
				if(selecao>=0) {
					cont = new Contrato();
					cont.setCodigo(tabelaListar.getValueAt(selecao, 0).toString());
					cdao.excluir(cont);
					listarContratos();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o contrato que deseja excluir!");
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(0, 64, 128));
		btnExcluir.setBounds(507, 378, 89, 34);
		panel_1.add(btnExcluir);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 120, 869, 213);
		panel_1.add(scrollPane_1);
		
		tabelaListar = new JTable();
		scrollPane_1.setViewportView(tabelaListar);
		listarContratos();
		tabbedPane.setSelectedIndex(1);
	}
}
