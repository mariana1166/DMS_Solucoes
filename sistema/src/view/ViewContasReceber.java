package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ContasReceberDAO;
import dao.ClienteDAO;
import model.Cliente;
import model.ContasReceber;
import model.Utilitarios;
import model.Baixas;
import dao.BaixasCRDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class ViewContasReceber extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textCodCli;
	private JTextField textNomeCli;
	private JTextField textDescricao;
	private JTextField textDataVenc;
	private JTextField textMovimento;
	private JTextField textValorTotal;
	private JTextField textContrato;
	private JTextField textValorRecebido;
	private JTextField textDataEmissao;
	private JTextField textValorReceber;
	private JTextField textDataPag;
	private JTextField textDataBaixa;
	private JTextField textValor;
	private JTextField textDesconto;
	private JTextField textJuros;
	private JTextField textTotalBaixa;
	private JTable tableListarBaixas;
	private JTable tabelaListar;
	private JTextField textField_17;
	
	private ContasReceber cr;
	private ContasReceberDAO crdao;
	private Cliente c;
	private ClienteDAO cdao;
	private int selecao;
	private DefaultTableModel modeloTabela;
	private Utilitarios util;
	private Baixas bcr;
	private BaixasCRDAO bcrdao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewContasReceber frame = new ViewContasReceber();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void listarContasReceber() {
		Object col[] = new Object [] {"Codigo", "Nome Cliente", "Data Emissão", "Data Vencimento", "Valor à Receber"};
		crdao = new ContasReceberDAO();
		List<ContasReceber> lista = crdao.listarTodos();
		modeloTabela = new DefaultTableModel(col,0);
		tabelaListar.setModel(modeloTabela);
		
		for(ContasReceber cr : lista) {
			modeloTabela.addRow(new Object[] {cr.getCodigo(), cr.getCodCli(), cr.getDataEmissao(), cr.getDataVenc(), cr.getValorReceber() });
		}
	}
	
	
	public void listarBaixas() {
		Object col[] = new Object [] {"Codigo", "Data Baixa", "Valor", "Desconto", "Juros", "Total Baixa"};
		bcrdao = new BaixasCRDAO();
		List<Baixas> lista = bcrdao.listarTodos(textCodigo.getText());
		modeloTabela = new DefaultTableModel(col,0);
		tableListarBaixas.setModel(modeloTabela);
		float recebido = 0;
		for(Baixas bcr : lista) {
			modeloTabela.addRow(new Object[] {bcr.getCodigo(), bcr.getDataBaixa(), bcr.getValor(), bcr.getDesconto(), bcr.getJuros(), bcr.getTotalBaixa()});
			recebido = bcr.getValor() + recebido;
		}
		textValorRecebido.setText(String.valueOf(recebido));
		float total = Float.parseFloat(textValorTotal.getText());
		textValorReceber.setText(String.valueOf((total-recebido)));
	}

	/**
	 * Create the frame.
	 */
	public ViewContasReceber() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 884, 21);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 64, 128));
		contentPane.add(panel_2);
		
		JLabel lblContasReceber = new JLabel("CONTAS À RECEBER");
		lblContasReceber.setHorizontalAlignment(SwingConstants.CENTER);
		lblContasReceber.setForeground(Color.WHITE);
		lblContasReceber.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblContasReceber.setBounds(0, 0, 884, 21);
		panel_2.add(lblContasReceber);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 22, 884, 439);
		contentPane.add(tabbedPane);
		
		JPanel panelDadosTitulo = new JPanel();
		tabbedPane.addTab("Título", null, panelDadosTitulo, null);
		panelDadosTitulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setBounds(30, 11, 46, 14);
		panelDadosTitulo.add(lblNewLabel);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(30, 30, 98, 20);
		panelDadosTitulo.add(textCodigo);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(179, 11, 46, 14);
		panelDadosTitulo.add(lblCliente);
		
		textCodCli = new JTextField();
		textCodCli.setColumns(10);
		textCodCli.setBounds(179, 30, 86, 20);
		panelDadosTitulo.add(textCodCli);
		
		textNomeCli = new JTextField();
		textNomeCli.setColumns(10);
		textNomeCli.setBounds(287, 30, 269, 20);
		panelDadosTitulo.add(textNomeCli);
		
		//PESQUISAR CLIENTE
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codcli = textCodCli.getText();
				c = new Cliente();
				cdao = new ClienteDAO();
				c=cdao.BurcarCodigoCli(codcli);
				if(c.getCodigo() > 0) {
					textCodCli.setText(String.valueOf(c.getCodigo()));
					textNomeCli.setText(c.getNome());
				}else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
				}			
			}
		});
		btnNewButton.setBounds(554, 29, 28, 23);
		panelDadosTitulo.add(btnNewButton);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(30, 80, 526, 20);
		panelDadosTitulo.add(textDescricao);
		
		JLabel lblDataEmisso = new JLabel("Descrição");
		lblDataEmisso.setBounds(30, 61, 86, 14);
		panelDadosTitulo.add(lblDataEmisso);
		
		JLabel lblDataEmisso_1 = new JLabel("Data Emissão");
		lblDataEmisso_1.setBounds(458, 111, 86, 14);
		panelDadosTitulo.add(lblDataEmisso_1);
		
		textDataVenc = new JTextField();
		textDataVenc.setColumns(10);
		textDataVenc.setBounds(606, 128, 98, 20);
		panelDadosTitulo.add(textDataVenc);
		
		JLabel lblDataEmisso_1_1 = new JLabel("Data Vencimento");
		lblDataEmisso_1_1.setBounds(606, 111, 86, 14);
		panelDadosTitulo.add(lblDataEmisso_1_1);
		
		textMovimento = new JTextField();
		textMovimento.setColumns(10);
		textMovimento.setBounds(606, 80, 98, 20);
		panelDadosTitulo.add(textMovimento);
		
		JLabel lblDataEmisso_1_2 = new JLabel("Movimento");
		lblDataEmisso_1_2.setBounds(606, 61, 86, 14);
		panelDadosTitulo.add(lblDataEmisso_1_2);
		
		textValorTotal = new JTextField();
		textValorTotal.setColumns(10);
		textValorTotal.setBounds(30, 128, 98, 20);
		panelDadosTitulo.add(textValorTotal);
		
		JLabel lblValor = new JLabel("Valor Total");
		lblValor.setBounds(30, 111, 86, 14);
		panelDadosTitulo.add(lblValor);
		
		textContrato = new JTextField();
		textContrato.setColumns(10);
		textContrato.setBounds(753, 80, 98, 20);
		panelDadosTitulo.add(textContrato);
		
		JLabel lblDataEmisso_1_3 = new JLabel("Contrato");
		lblDataEmisso_1_3.setBounds(753, 61, 86, 14);
		panelDadosTitulo.add(lblDataEmisso_1_3);
		
		textValorRecebido = new JTextField();
		textValorRecebido.setEditable(false);
		textValorRecebido.setColumns(10);
		textValorRecebido.setBounds(179, 128, 98, 20);
		panelDadosTitulo.add(textValorRecebido);
		
		JLabel lblTipoDocumento = new JLabel("Valor Recebido");
		lblTipoDocumento.setBounds(179, 111, 112, 14);
		panelDadosTitulo.add(lblTipoDocumento);
		
		textDataEmissao = new JTextField();
		textDataEmissao.setColumns(10);
		textDataEmissao.setBounds(458, 128, 98, 20);
		panelDadosTitulo.add(textDataEmissao);
		
		JLabel lblDataEmisso_1_4 = new JLabel("Data Pagamento");
		lblDataEmisso_1_4.setBounds(753, 111, 98, 14);
		panelDadosTitulo.add(lblDataEmisso_1_4);
		
		textValorReceber = new JTextField();
		textValorReceber.setEditable(false);
		textValorReceber.setColumns(10);
		textValorReceber.setBounds(316, 128, 98, 20);
		panelDadosTitulo.add(textValorReceber);
		
		textDataPag = new JTextField();
		textDataPag.setEditable(false);
		textDataPag.setColumns(10);
		textDataPag.setBounds(753, 128, 98, 20);
		panelDadosTitulo.add(textDataPag);
		
		JLabel lblValorReceber = new JLabel("Valor à Receber");
		lblValorReceber.setBounds(316, 111, 112, 14);
		panelDadosTitulo.add(lblValorReceber);
		
		JComboBox comboBoxTipoDoc = new JComboBox();
		comboBoxTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"Boleto", "Cartão de Crédito", "Cartão de Débito", "Cheque", "Depósito", "Dinheiro", "Pix"}));
		comboBoxTipoDoc.setBounds(634, 29, 217, 22);
		panelDadosTitulo.add(comboBoxTipoDoc);
		
		JLabel lblDataEmisso_1_2_1 = new JLabel("Tipo de Documento");
		lblDataEmisso_1_2_1.setBounds(634, 11, 153, 14);
		panelDadosTitulo.add(lblDataEmisso_1_2_1);
		
		JCheckBox chckbxInativar = new JCheckBox("Inativar título");
		chckbxInativar.setBounds(754, 154, 97, 23);
		panelDadosTitulo.add(chckbxInativar);
		
		JTabbedPane tabbedPaneBaixas = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneBaixas.setBounds(30, 173, 809, 185);
		panelDadosTitulo.add(tabbedPaneBaixas);
		
		JPanel panel_3 = new JPanel();
		tabbedPaneBaixas.addTab("Baixado", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 784, 105);
		panel_3.add(scrollPane);
		
		tableListarBaixas = new JTable();
		scrollPane.setViewportView(tableListarBaixas);
	//BOTOES BAIXA
		JButton btnNovoB = new JButton("Novo");
		btnNovoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPaneBaixas.setSelectedIndex(1);
			}
		});
		btnNovoB.setBounds(205, 127, 89, 23);
		panel_3.add(btnNovoB);
		
		JButton btnExcluirB = new JButton("Excluir");
		btnExcluirB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaListar.getSelectedRow();
				if(selecao>=0) {
					bcr = new Baixas();
					bcr.setCodigo(tableListarBaixas.getValueAt(selecao, 0).toString());
					bcrdao.excluir(bcr);
					listarContasReceber();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione a baixa que deseja excluir!");
				}
				listarBaixas();
			}
		});
		btnExcluirB.setBounds(493, 127, 89, 23);
		panel_3.add(btnExcluirB);
		
		JPanel panelBaixar = new JPanel();
		tabbedPaneBaixas.addTab("Baixar", null, panelBaixar, null);
		panelBaixar.setLayout(null);
		
		textDataBaixa = new JTextField();
		textDataBaixa.setBounds(20, 70, 110, 20);
		panelBaixar.add(textDataBaixa);
		textDataBaixa.setColumns(10);
		
		JLabel lblDataBaixa = new JLabel("Data Baixa");
		lblDataBaixa.setBounds(20, 57, 86, 9);
		panelBaixar.add(lblDataBaixa);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(165, 70, 110, 20);
		panelBaixar.add(textValor);
		
		JLabel lblBan = new JLabel("Valor");
		lblBan.setBounds(165, 57, 86, 9);
		panelBaixar.add(lblBan);
		
		textDesconto = new JTextField();
		textDesconto.setColumns(10);
		textDesconto.setBounds(317, 72, 110, 20);
		panelBaixar.add(textDesconto);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setBounds(317, 59, 86, 9);
		panelBaixar.add(lblDesconto);
		
		textJuros = new JTextField();
		textJuros.setColumns(10);
		textJuros.setBounds(466, 72, 110, 20);
		panelBaixar.add(textJuros);
		
		JLabel lblJuros = new JLabel("Juros");
		lblJuros.setBounds(466, 59, 86, 9);
		panelBaixar.add(lblJuros);
		
		textTotalBaixa = new JTextField();
		textTotalBaixa.setColumns(10);
		textTotalBaixa.setBounds(621, 70, 110, 20);
		panelBaixar.add(textTotalBaixa);
		
		JLabel lblTotal = new JLabel("Total Baixa");
		lblTotal.setBounds(621, 57, 86, 9);
		panelBaixar.add(lblTotal);
		
		//Botão para salvar baixas
		JButton btnSalvarBaixa = new JButton("Salvar");
		btnSalvarBaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bcr = new Baixas();
				bcr.setDataBaixa(textDataBaixa.getText());
				bcr.setCodTitulo(textCodigo.getText());
				bcr.setValor(Float.parseFloat(textValor.getText()));
				bcr.setDesconto(Float.parseFloat(textDesconto.getText()));
				bcr.setJuros(Float.parseFloat(textJuros.getText()));
				bcr.setTotalBaixa(Float.parseFloat(textTotalBaixa.getText()));
				bcrdao = new BaixasCRDAO();
				bcrdao.inserir(bcr);
				util = new Utilitarios();
				util.LimpaDados(panelBaixar);
				listarBaixas();
				tabbedPaneBaixas.setSelectedIndex(0);
			}
		});
		btnSalvarBaixa.setBounds(246, 111, 89, 23);
		panelBaixar.add(btnSalvarBaixa);
		
		JButton btnNewButton_1_2 = new JButton("Cancelar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilitarios util = new Utilitarios();
				util.LimpaDados(panelBaixar);
				tabbedPaneBaixas.setSelectedIndex(0);
			}
		});
		btnNewButton_1_2.setBounds(487, 111, 89, 23);
		panelBaixar.add(btnNewButton_1_2);
		
		//BOTÃO SALVAR TITULO
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cr = new ContasReceber();
				cr.setCodigo(textCodigo.getText());
				cr.setCodCli(Integer.parseInt(textCodCli.getText()));
				cr.setNomeCli(textNomeCli.getText());
				cr.setTipoDoc(comboBoxTipoDoc.getSelectedItem().toString());
				cr.setDescricao(textDescricao.getText());
				cr.setMovimento(textMovimento.getText());
				cr.setContrato(textContrato.getText());
				cr.setValorTotal(Float.parseFloat(textValorTotal.getText()));
				cr.setValorRecebido(Float.parseFloat(textValorRecebido.getText()));
				cr.setValorReceber(Float.parseFloat(textValorReceber.getText()));
				cr.setDataEmissao(textDataEmissao.getText());
				cr.setDataVenc(textDataVenc.getText());
				cr.setDataPag(textDataPag.getText());
				//cr.setInativar(chckbxInativar.);
				crdao = new ContasReceberDAO();
				crdao.inserir(cr);
				util = new Utilitarios();
				util.LimpaDados(panelDadosTitulo);
				listarContasReceber();
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBackground(new Color(0, 64, 128));
		btnSalvar.setBounds(402, 366, 89, 34);
		panelDadosTitulo.add(btnSalvar);
		
		
		
		//BOTÃO ALTERA TITULO
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cr = new ContasReceber();
				cr.setCodigo(textCodigo.getText());
				cr.setCodCli(Integer.parseInt(textCodCli.getText()));
				cr.setNomeCli(textNomeCli.getText());
				cr.setTipoDoc(comboBoxTipoDoc.getSelectedItem().toString());
				cr.setDescricao(textDescricao.getText());
				cr.setMovimento(textMovimento.getText());
				cr.setContrato(textContrato.getText());
				cr.setValorTotal(Float.parseFloat(textValorTotal.getText()));
				cr.setValorRecebido(Float.parseFloat(textValorRecebido.getText()));
				cr.setValorReceber(Float.parseFloat(textValorReceber.getText()));
				cr.setDataEmissao(textDataEmissao.getText());
				cr.setDataVenc(textDataVenc.getText());
				cr.setDataPag(textDataPag.getText());
				//cr.setInativar(textCodigo.getText());
				crdao.alterar(cr);
				listarContasReceber();
				util = new Utilitarios();
				util.LimpaDados(panelDadosTitulo);
				tabbedPane.setSelectedIndex(1);//Ir para tela de listagem
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setBackground(new Color(0, 64, 128));
		btnAlterar.setBounds(179, 369, 89, 34);
		panelDadosTitulo.add(btnAlterar);
		
		//BOTÃO CANCELAR E VOLTAR PARA LISTAGEM
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilitarios util = new Utilitarios();
				util.LimpaDados(panelDadosTitulo);
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(0, 64, 128));
		btnCancelar.setBounds(634, 366, 89, 34);
		panelDadosTitulo.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listar", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 859, 249);
		panel_1.add(scrollPane_1);
		
		tabelaListar = new JTable();
		scrollPane_1.setViewportView(tabelaListar);
		
		//BOTÃO PARA INSERIR NOVO TITULO
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilitarios util = new Utilitarios();
				util.LimpaDados(panelDadosTitulo);
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setBackground(new Color(0, 64, 128));
		btnNovo.setBounds(286, 355, 89, 34);
		panel_1.add(btnNovo);
		
		//BOTÃO ABRIR TITULO PARA EDITAR
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaListar.getSelectedRow();
				cr = new ContasReceber();
				crdao = new ContasReceberDAO();
				if(selecao >= 0) {
					String codCR = tabelaListar.getValueAt(selecao, 0).toString();
					cr = crdao.BurcarCodigo(codCR);
					if(cr != null) {
						textCodigo.setText(cr.getCodigo());
						textCodCli.setText(String.valueOf(cr.getCodCli()));
						textNomeCli.setText(cr.getNomeCli());
						comboBoxTipoDoc.setSelectedItem(cr.getTipoDoc());
						textDescricao.setText(cr.getDescricao());
						textMovimento.setText(cr.getMovimento());
						textContrato.setText(cr.getContrato());
						textValorTotal.setText(Float.valueOf(cr.getValorTotal()).toString());
						textValorRecebido.setText(Float.valueOf(cr.getValorRecebido()).toString());
						textValorReceber.setText(Float.valueOf(cr.getValorReceber()).toString());
						textDataEmissao.setText(cr.getDataEmissao());
						textDataVenc.setText(cr.getDataVenc());
						textDataPag.setText(cr.getDataPag());
						//textInativar.setText();	
					}
					else{
						JOptionPane.showMessageDialog(null, "Título não localizado");
					}
					
					tabbedPane.setSelectedIndex(0);
					btnSalvar.setEnabled(false);
					btnAlterar.setEnabled(true);
					listarBaixas();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um título que deseja alterar!");
				}
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(0, 64, 128));
		btnEditar.setBounds(420, 355, 89, 34);
		panel_1.add(btnEditar);
		
		//BOTÃO EXCLUIR TITULO
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaListar.getSelectedRow();
				if(selecao>=0) {
					cr = new ContasReceber();
					cr.setCodigo(tabelaListar.getValueAt(selecao, 0).toString());
					crdao.excluir(cr);
					listarContasReceber();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o título que deseja excluir!");
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(0, 64, 128));
		btnExcluir.setBounds(553, 355, 89, 34);
		panel_1.add(btnExcluir);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisar:");
		lblNewLabel_1.setBounds(10, 33, 71, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(279, 28, 89, 23);
		panel_1.add(btnPesquisar);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(79, 29, 191, 20);
		panel_1.add(textField_17);
		
		listarContasReceber();
		tabbedPane.setSelectedIndex(1);
		btnSalvar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnAlterar.setEnabled(false);
	}
}
