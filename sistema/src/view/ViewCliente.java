package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
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

public class ViewCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JLabel lblCodcli = new JLabel("Código:");
	private final JTextField textCod = new JTextField();
	private final JLabel lblNomerazoSocial = new JLabel("Nome/Razão Social:");
	private final JTextField textNome = new JTextField();
	private final JLabel lblCnpjCpf = new JLabel("CNPJ/CPF:");
	private final JTextField textCpf = new JTextField();
	private final JPanel panel_2 = new JPanel();
	private JRadioButton fisico;
	private final JPanel panel_2_1 = new JPanel();
	private final JLabel lblListagemDeClientes = new JLabel("LISTAGEM DE CLIENTES");
	private final JTextField textField = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("Pesquisar:");
	private final JButton btnPesquisar = new JButton("Pesquisar");
	private final JTable tabelaClientes = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel modeloTabela;
	private final JButton btnNovo = new JButton("Novo");
	private final JButton btnEditar = new JButton("Editar");
	private final JButton btnExcluir = new JButton("Excluir");
	private int selecao;
	private Cliente c;
	private ClienteDAO cdao;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCliente frame = new ViewCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void listarClientes() {
		Object col[] = new Object [] {"Codigo", "Nome/Razão Social", "CPF/CNPJ"};
		cdao = new ClienteDAO();
		List<Cliente> lista = cdao.listarTodos();
		modeloTabela = new DefaultTableModel(col,0);
		tabelaClientes.setModel(modeloTabela);
		
		for(Cliente c : lista) {
			modeloTabela.addRow(new Object[] {c.getCodigo(), c.getNome(), c.getCnpj()});
		}
	}
	
	
	public ViewCliente() {
		textField.setBounds(79, 32, 191, 20);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(0, 0, 647, 350);
		
		contentPane.add(tabbedPane);
		
		//ABA CADASTRO
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		lblCodcli.setBounds(10, 32, 55, 14);
		
		panel.add(lblCodcli);
		textCod.setBounds(10, 47, 86, 20);
		textCod.setEditable(false);
		textCod.setColumns(10);
		
		panel.add(textCod);
		lblNomerazoSocial.setBounds(122, 32, 129, 14);
		
		panel.add(lblNomerazoSocial);
		textNome.setBounds(122, 47, 202, 20);
		textNome.setColumns(10);
		
		panel.add(textNome);
		lblCnpjCpf.setBounds(354, 32, 66, 14);
		
		panel.add(lblCnpjCpf);
		textCpf.setColumns(10);
		textCpf.setBounds(354, 47, 141, 20);
		
		panel.add(textCpf);
		
		fisico = new JRadioButton("Cliente Físico");
		fisico.setBounds(525, 46, 117, 23);
		panel.add(fisico);
		panel_2.setBackground(new Color(0, 64, 128));
		panel_2.setBounds(0, 0, 642, 21);
		
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE CLIENTE");
		lblNewLabel.setBounds(0, 0, 642, 21);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		
		//ABA LISTAGEM
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listagem", null, panel_1, null);
		panel_2_1.setBounds(0, 0, 642, 21);
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 64, 128));
		lblListagemDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListagemDeClientes.setForeground(Color.WHITE);
		lblListagemDeClientes.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblListagemDeClientes.setBounds(0, 0, 642, 21);
		
		panel_2_1.add(lblListagemDeClientes);
		scrollPane.setBounds(0, 64, 642, 211);
		scrollPane.setViewportView(tabelaClientes);
		panel_1.setLayout(null);
		panel_1.add(panel_2_1);
		lblNewLabel_1.setBounds(10, 36, 71, 14);
		panel_1.add(lblNewLabel_1);
		panel_1.add(textField);
		btnPesquisar.setBounds(279, 31, 89, 23);
		panel_1.add(btnPesquisar);
		panel_1.add(scrollPane);
		
		//BOTÃO SALVAR
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setForeground(Color.WHITE);
				btnSalvar.setBackground(new Color(0, 64, 128));
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						c = new Cliente();
						c.setNome(textNome.getText());
						c.setCnpj(textCpf.getText());
						cdao = new ClienteDAO();
						cdao.inserir(c);
						listarClientes();
						tabbedPane.setSelectedIndex(1);
					}
				});
				btnSalvar.setBounds(94, 276, 89, 34);
				panel.add(btnSalvar);
		
		//BOTÃO ALTERAR
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = new Cliente();
				c.setCodigo(Integer.parseInt(textCod.getText()));
				c.setNome(textNome.getText());
				c.setCnpj(textCpf.getText());
				cdao = new ClienteDAO();
				cdao.alterar(c);
				listarClientes();
				//Ir para tela de listagem
				tabbedPane.setSelectedIndex(1);
				btnSalvar.setEnabled(true);
				btnAlterar.setEnabled(false);
			}
		});
		btnAlterar.setBackground(new Color(0, 64, 128));
		btnAlterar.setBounds(274, 276, 89, 34);
		panel.add(btnAlterar);
		
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
		btnNovo.setBounds(96, 277, 89, 34);
		
		panel_1.add(btnNovo);
		
		//BOTÃO EDITAR
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaClientes.getSelectedRow();
				if(selecao >= 0) {
					textCod.setText(tabelaClientes.getValueAt(selecao, 0).toString());
					textNome.setText(tabelaClientes.getValueAt(selecao, 1).toString());
					textCpf.setText(tabelaClientes.getValueAt(selecao,2).toString());
					tabbedPane.setSelectedIndex(0);
					btnSalvar.setEnabled(false);
					btnAlterar.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja alterar!");
				}
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(0, 64, 128));
		btnEditar.setBounds(279, 277, 89, 34);
		
		panel_1.add(btnEditar);
		
		
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
				btnCancelar.setBounds(451, 276, 89, 34);
				panel.add(btnCancelar);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(10, 99, 117, 20);
				panel.add(textField_1);
				
				JLabel lblTelefone = new JLabel("Telefone 1");
				lblTelefone.setBounds(10, 84, 129, 14);
				panel.add(lblTelefone);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(174, 99, 117, 20);
				panel.add(textField_2);
				
				JLabel lblTelefone_1 = new JLabel("Telefone 1");
				lblTelefone_1.setBounds(174, 84, 129, 14);
				panel.add(lblTelefone_1);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(10, 156, 117, 20);
				panel.add(textField_3);
				
				JLabel lblCep = new JLabel("CEP");
				lblCep.setBounds(10, 141, 129, 14);
				panel.add(lblCep);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(174, 156, 189, 20);
				panel.add(textField_4);
				
				JLabel lblLogradouro = new JLabel("Logradouro");
				lblLogradouro.setBounds(174, 141, 129, 14);
				panel.add(lblLogradouro);
				
				JLabel lblCodcli_1_2 = new JLabel("Número:");
				lblCodcli_1_2.setBounds(397, 141, 55, 14);
				panel.add(lblCodcli_1_2);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(397, 156, 66, 20);
				panel.add(textField_5);
				
				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(497, 158, 141, 20);
				panel.add(textField_6);
				
				JLabel lblCodcli_1_3 = new JLabel("Bairro:");
				lblCodcli_1_3.setBounds(497, 141, 55, 14);
				panel.add(lblCodcli_1_3);
				
				JLabel lblCodcli_1_4 = new JLabel("Cidade:");
				lblCodcli_1_4.setBounds(10, 205, 55, 14);
				panel.add(lblCodcli_1_4);
				
				textField_7 = new JTextField();
				textField_7.setColumns(10);
				textField_7.setBounds(10, 223, 159, 20);
				panel.add(textField_7);
				
				textField_8 = new JTextField();
				textField_8.setColumns(10);
				textField_8.setBounds(237, 223, 174, 20);
				panel.add(textField_8);
				
				JLabel lblCodcli_1_5 = new JLabel("Estado:");
				lblCodcli_1_5.setBounds(237, 205, 55, 14);
				panel.add(lblCodcli_1_5);
		
		//BOTÃO EXCLUIR
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecao = tabelaClientes.getSelectedRow();
				if(selecao>=0) {
					c = new Cliente();
					c.setCodigo(Integer.parseInt(tabelaClientes.getValueAt(selecao, 0).toString()));
					c.setNome(tabelaClientes.getValueAt(selecao, 1).toString());
					cdao.excluir(c);
					listarClientes();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja excluir!");
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(0, 64, 128));
		btnExcluir.setBounds(468, 277, 89, 34);
		
		panel_1.add(btnExcluir);
		
		//Metodo para preencher tabela
		listarClientes();
		//Metodo para abrir na tabela de listagem
		tabbedPane.setSelectedIndex(1);
		
		
	}
}
