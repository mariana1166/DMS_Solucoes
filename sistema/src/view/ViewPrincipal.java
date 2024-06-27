package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLayeredPane;


public class ViewPrincipal extends JFrame {
	   

    private static final long serialVersionUID = 1L;    
    private JLayeredPane dpnDesck;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
        	
        	
            public void run() {
                try {
                    ViewPrincipal frame = new ViewPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewPrincipal() {
        setTitle("DM's Soluções");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1040, 574);
        this.setExtendedState(MAXIMIZED_BOTH);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.window);
        setJMenuBar(menuBar);
        
        JMenu mnuCadastros = new JMenu("Cadastros");
        mnuCadastros.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnuCadastros);
        
        JMenuItem mnuCadastrosCclientes = new JMenuItem("Clientes");
        mnuCadastrosCclientes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewCliente vcli = new ViewCliente();
				vcli.setVisible(true);
        	}
        });
        mnuCadastros.add(mnuCadastrosCclientes);
        
        JMenuItem mntmFornecedor = new JMenuItem("Fornecedores");
        mnuCadastros.add(mntmFornecedor);
        
        JMenuItem mntmFuncionrios = new JMenuItem("Funcionários");
        mntmFuncionrios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewFuncionario vfun = new ViewFuncionario();
				vfun.setVisible(true);
        	}
        });
        mnuCadastros.add(mntmFuncionrios);
        
        JMenuItem mnuCadastrosCProdutos = new JMenuItem("Produtos");
        mnuCadastros.add(mnuCadastrosCProdutos);
        
        JMenuItem mnuCadastrosCServico = new JMenuItem("Serviços");
        mnuCadastros.add(mnuCadastrosCServico);
        
        JMenuItem mntmContratos = new JMenuItem("Contratos");
        mntmContratos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewContrato vcont = new ViewContrato();
        		vcont.setVisible(true);
        	}
        });
        mnuCadastros.add(mntmContratos);
        
        JMenu mnuMovimentos = new JMenu("Movimentos");
        mnuMovimentos.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnuMovimentos);
        
        JMenuItem mnuMovimentosNVenda = new JMenuItem("Vendas");
        mnuMovimentosNVenda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewVendas vd = new ViewVendas();
        		vd.setVisible(true);
        	}
        });
        mnuMovimentos.add(mnuMovimentosNVenda);
        
        JMenuItem mntmMonitContratos = new JMenuItem("Monit. Contratos");
        mntmMonitContratos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewMonitoramentoContrato vmcont = new ViewMonitoramentoContrato();
        		vmcont.setVisible(true);
        	}
        });
        mnuMovimentos.add(mntmMonitContratos);
        
        JMenuItem mntmDespesas = new JMenuItem("Despesas");
        mntmDespesas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewDespesas vd = new ViewDespesas();
        		vd.setVisible(true);
        	}
        });
        mnuMovimentos.add(mntmDespesas);
        
        JMenu mnFinanceiro = new JMenu("Financeiro");
        mnFinanceiro.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnFinanceiro);
        
        JMenuItem mntmContasPagar = new JMenuItem("Contas à Pagar");
        mntmContasPagar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewContasPagar vcp = new ViewContasPagar();
        		vcp.setVisible(true);
        	}
        });
        mnFinanceiro.add(mntmContasPagar);
        
        JMenuItem mntmContasReceber = new JMenuItem("Contas à Receber");
        mntmContasReceber.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ViewContasReceber vcr = new ViewContasReceber();
        		vcr.setVisible(true);
        	}
        });
        mnFinanceiro.add(mntmContasReceber);
        
        JMenu mnRelatrios = new JMenu("Relatórios");
        mnRelatrios.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnRelatrios);
        
        JMenu mnuMenu = new JMenu("Sistema");
        mnuMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnuMenu);
        
        JMenuItem mnuMenuUsuario = new JMenuItem("Usuários");
        mnuMenu.add(mnuMenuUsuario);
        mnuMenuUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                              
                
            }
        });
        
        JMenuItem mnuMenuTrUsuario = new JMenuItem("Trocar Usuário");
        mnuMenu.add(mnuMenuTrUsuario);
        
        JMenuItem mnuMenuTrSenha = new JMenuItem("Trocar Senha");
        mnuMenu.add(mnuMenuTrSenha);
        
        JMenuItem mnuMenuSair = new JMenuItem("Sair");
        mnuMenu.add(mnuMenuSair);
        
        JMenu mnuAjuda = new JMenu("Ajuda");
        mnuAjuda.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnuAjuda);
        
        JMenuItem mnuAjudaSobre = new JMenuItem("Sobre");
        mnuAjuda.add(mnuAjudaSobre);
        
        JMenuItem mnuAAjuda = new JMenuItem("Ajuda");
        mnuAjuda.add(mnuAAjuda);
        
        dpnDesck = new JLayeredPane();
        dpnDesck.setBackground(new Color(255, 255, 255));
        dpnDesck.setForeground(SystemColor.activeCaption);
        dpnDesck.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(dpnDesck);
        dpnDesck.setLayout(null);
        
        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBounds(0, 0, 1, 1);
        desktopPane.setBackground(SystemColor.activeCaption);
        dpnDesck.add(desktopPane);
    }

	
}