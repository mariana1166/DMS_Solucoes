package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.FuncionarioDAO;
import model.Funcionario;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class ViewFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JLabel lblCodcli = new JLabel("Código:");
	private final JTextField textCod = new JTextField();
	private final JLabel lblNomerazoSocial = new JLabel("Nome:");
	private final JTextField textNome = new JTextField();
	private final JLabel lblCnpjCpf = new JLabel("CPF:");
	private final JTextField textCpf = new JTextField();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_2_1 = new JPanel();
	private final JLabel lblListagemDeFuncionarios = new JLabel("LISTAGEM DE FuncionarioS");
	private final JTextField textField = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("Pesquisar:");
	private final JButton btnPesquisar = new JButton("Pesquisar");
	private final JTable tabelaFuncionarios = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel modeloTabela;
	private final JButton btnNovo = new JButton("Novo");
	private final JButton btnEditar = new JButton("Editar");
	private final JButton btnExcluir = new JButton("Excluir");
	private int selecao;
	private Funcionario f;
	private FuncionarioDAO fdao;
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblTelefone = new JLabel("Telefone 1:");
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblTelefone_2 = new JLabel("Telefone 2:");
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private final JTextField textField_9 = new JTextField();
	private final JSeparator separator_1 = new JSeparator();
	private final JLabel lblNewLabel_2_1 = new JLabel("OBSERVAÇÃO");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFuncionario frame = new ViewFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void listarFuncionarios() {
		Object col[] = new Object [] {"Codigo", "Nome", "CPF"};
		fdao = new FuncionarioDAO();
		List<Funcionario> lista = fdao.listarTodos();
		modeloTabela = new DefaultTableModel(col,0);
		tabelaFuncionarios.setModel(modeloTabela);
		
		for(Funcionario f : lista) {
			modeloTabela.addRow(new Object[] {f.getCodigo(), f.getNome(), f.getCpf()});
		}
		
	}
	
	
	public ViewFuncionario() {
		textField.setBounds(79, 32, 191, 20);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 884, 461);
		
		contentPane.add(tabbedPane);
		textField_9.setBounds(54, 308, 761, 56);
		textField_9.setColumns(10);
		textField_1.setBounds(54, 112, 172, 20);
		textField_1.setColumns(10);
		
		//ABA CADASTRO
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		lblCodcli.setBounds(54, 32, 55, 14);
		
		panel.add(lblCodcli);
		textCod.setBounds(54, 47, 86, 20);
		textCod.setEditable(false);
		textCod.setColumns(10);
		
		panel.add(textCod);
		lblNomerazoSocial.setBounds(225, 32, 129, 14);
		
		panel.add(lblNomerazoSocial);
		textNome.setBounds(225, 47, 269, 20);
		textNome.setColumns(10);
		
		panel.add(textNome);
		lblCnpjCpf.setBounds(582, 32, 66, 14);
		
		panel.add(lblCnpjCpf);
		textCpf.setColumns(10);
		textCpf.setBounds(582, 47, 141, 20);
		
		panel.add(textCpf);
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(0, 0, 879, 21);
		
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE FUNCIONARIO");
		lblNewLabel.setBounds(0, 0, 879, 21);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		//BOTÃO SALVAR
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setForeground(Color.WHITE);
				btnSalvar.setBackground(new Color(0, 64, 128));
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f = new Funcionario();
						f.setNome(textNome.getText());
						f.setCpf(textCpf.getText());
						fdao = new FuncionarioDAO();
						fdao.inserir(f);
						listarFuncionarios();
						tabbedPane.setSelectedIndex(1);
					}
				});
				btnSalvar.setBounds(225, 375, 89, 34);
				panel.add(btnSalvar);
				
				//BOTÃO ALTERAR
				JButton btnAlterar = new JButton("Alterar");
				btnAlterar.setForeground(Color.WHITE);
				btnAlterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f = new Funcionario();
						f.setCodigo(Integer.parseInt(textCod.getText()));
						f.setNome(textNome.getText());
						f.setCpf(textCpf.getText());
						fdao = new FuncionarioDAO();
						fdao.alterar(f);
						listarFuncionarios();
						//Ir para tela de listagem
						tabbedPane.setSelectedIndex(1);
						btnSalvar.setEnabled(true);
						btnAlterar.setEnabled(false);
					}
				});
				btnAlterar.setBackground(new Color(0, 64, 128));
				btnAlterar.setBounds(405, 375, 89, 34);
				panel.add(btnAlterar);
				
				
				//BOTÃO CANCELAR
						JButton btnCancelar = new JButton("Cancelar");
						btnCancelar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								textCod.setText(null);
								textNome.setText(null);
								textCpf.setText(null);
								btnSalvar.setEnabled(true);
								btnAlterar.setEnabled(false);
							}
						});
						btnCancelar.setForeground(Color.WHITE);
						btnCancelar.setBackground(new Color(0, 64, 128));
						btnCancelar.setBounds(582, 375, 89, 34);
						panel.add(btnCancelar);
						
						panel.add(textField_1);
						lblTelefone.setBounds(54, 94, 86, 14);
						
						panel.add(lblTelefone);
						textField_2.setColumns(10);
						textField_2.setBounds(322, 112, 172, 20);
						
						panel.add(textField_2);
						lblTelefone_2.setBounds(322, 94, 86, 14);
						
						panel.add(lblTelefone_2);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(0, 158, 869, 14);
						panel.add(separator);
						
						JLabel lblNewLabel_2 = new JLabel("ENDEREÇO");
						lblNewLabel_2.setBounds(420, 171, 108, 14);
						panel.add(lblNewLabel_2);
						
						textField_3 = new JTextField();
						textField_3.setBounds(54, 206, 108, 20);
						panel.add(textField_3);
						textField_3.setColumns(10);
						
						textField_4 = new JTextField();
						textField_4.setBounds(215, 206, 279, 20);
						panel.add(textField_4);
						textField_4.setColumns(10);
						
						textField_5 = new JTextField();
						textField_5.setBounds(550, 206, 66, 20);
						panel.add(textField_5);
						textField_5.setColumns(10);
						
						textField_6 = new JTextField();
						textField_6.setBounds(674, 206, 141, 20);
						panel.add(textField_6);
						textField_6.setColumns(10);
						
						textField_7 = new JTextField();
						textField_7.setColumns(10);
						textField_7.setBounds(215, 253, 159, 20);
						panel.add(textField_7);
						
						textField_8 = new JTextField();
						textField_8.setColumns(10);
						textField_8.setBounds(442, 253, 174, 20);
						panel.add(textField_8);
						
						JLabel lblCep = new JLabel("CEP:");
						lblCep.setBounds(54, 189, 55, 14);
						panel.add(lblCep);
						
						JLabel lblCodcli_1_1 = new JLabel("Logradouro:");
						lblCodcli_1_1.setBounds(215, 189, 99, 14);
						panel.add(lblCodcli_1_1);
						
						JLabel lblCodcli_1_2 = new JLabel("Número:");
						lblCodcli_1_2.setBounds(550, 189, 55, 14);
						panel.add(lblCodcli_1_2);
						
						JLabel lblCodcli_1_3 = new JLabel("Bairro:");
						lblCodcli_1_3.setBounds(674, 189, 55, 14);
						panel.add(lblCodcli_1_3);
						
						JLabel lblCodcli_1_4 = new JLabel("Cidade:");
						lblCodcli_1_4.setBounds(215, 235, 55, 14);
						panel.add(lblCodcli_1_4);
						
						JLabel lblCodcli_1_5 = new JLabel("Estado:");
						lblCodcli_1_5.setBounds(442, 235, 55, 14);
						panel.add(lblCodcli_1_5);
						
						panel.add(textField_9);
						separator_1.setBounds(0, 284, 879, 5);
						
						panel.add(separator_1);
						lblNewLabel_2_1.setBounds(420, 289, 108, 14);
						
						panel.add(lblNewLabel_2_1);
		
		//ABA LISTAGEM
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listagem", null, panel_1, null);
		panel_2_1.setBounds(0, 0, 879, 21);
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 64, 128));
		lblListagemDeFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListagemDeFuncionarios.setForeground(Color.WHITE);
		lblListagemDeFuncionarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblListagemDeFuncionarios.setBounds(0, 0, 879, 21);
		
		panel_2_1.add(lblListagemDeFuncionarios);
		scrollPane.setBounds(0, 64, 879, 302);
		scrollPane.setViewportView(tabelaFuncionarios);
		panel_1.setLayout(null);
		panel_1.add(panel_2_1);
		lblNewLabel_1.setBounds(10, 36, 71, 14);
		panel_1.add(lblNewLabel_1);
		panel_1.add(textField);
		btnPesquisar.setBounds(279, 31, 89, 23);
		panel_1.add(btnPesquisar);
		panel_1.add(scrollPane);
		
		//BOTÃO NOVO
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCod.setText(null);
				textNome.setText(null);
				textCpf.setText(null);
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setBackground(new Color(0, 64, 128));
		btnNovo.setBounds(205, 388, 89, 34);
		
		panel_1.add(btnNovo);
		
		//BOTÃO EDITAR
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaFuncionarios.getSelectedRow();
				if(selecao >= 0) {
					textCod.setText(tabelaFuncionarios.getValueAt(selecao, 0).toString());
					textNome.setText(tabelaFuncionarios.getValueAt(selecao, 1).toString());
					textCpf.setText(tabelaFuncionarios.getValueAt(selecao,2).toString());
					tabbedPane.setSelectedIndex(0);
					btnSalvar.setEnabled(false);
					btnAlterar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o Funcionario que deseja alterar!");
				}
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(0, 64, 128));
		btnEditar.setBounds(388, 388, 89, 34);
		
		panel_1.add(btnEditar);
		
		//BOTÃO EXCLUIR
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaFuncionarios.getSelectedRow();
				if(selecao>=0) {
					f = new Funcionario();
					f.setCodigo(Integer.parseInt(tabelaFuncionarios.getValueAt(selecao, 0).toString()));
					f.setNome(tabelaFuncionarios.getValueAt(selecao, 1).toString());
					fdao.excluir(f);
					listarFuncionarios();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o Funcionario que deseja excluir!");
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(0, 64, 128));
		btnExcluir.setBounds(577, 388, 89, 34);
		
		panel_1.add(btnExcluir);
		
		//Metodo para preencher tabela
		listarFuncionarios();
		//Metodo para abrir na tabela de listagem
		tabbedPane.setSelectedIndex(1);
		
		
	}
}
