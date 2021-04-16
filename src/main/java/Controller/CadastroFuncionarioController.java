package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.CadastroFuncionário;
import Model.Funcionario;
import Dao.FuncionarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 */
public class CadastroFuncionarioController {
    
    private CadastroFuncionário cadastroFuncionarioView;
    private FuncionarioDAO fDao;
    
    public CadastroFuncionarioController() {
        cadastroFuncionarioView = new CadastroFuncionário();
        fDao = new FuncionarioDAO();
        adicionarAcoesBotoes();
        
    }
    
    public void exibirTela() {
        cadastroFuncionarioView.setVisible(true);
    }
    
    public void adicionarAcoesBotoes() {
        acaoCadastrar();
        acaoVoltar();
    }
    
    public void acaoCadastrar() {
        cadastroFuncionarioView.addAcaoCadastrarFuncionario(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cadastroFuncionarioView.validateDados()) {
                    if (verificaCPF()) {
                        cadastraFuncionario(cadastroFuncionarioView.getDados());
                    }
                }
            }
        }
        );
    }
    
    public boolean verificaCPF() {
        
        List<Funcionario> funcionariosList = new ArrayList<Funcionario>();
        
        FuncionarioDAO fdao = new FuncionarioDAO();
        
        funcionariosList = fdao.buscarTodos();
        
        for (Funcionario f : funcionariosList) {
            if (f.getCpf().equals(cadastroFuncionarioView.getCPF())) {
                cadastroFuncionarioView.exibirMensagem("CPF já cadastrado no sistema");
                return false;
            }
        }
        return true;
        
    }
    
    public void cadastraFuncionario(Funcionario f) {
        try {
            
            fDao.gravar(f);
            cadastroFuncionarioView.exibirMensagem("Cadastro realizado com sucesso");
            cadastroFuncionarioView.limparDados();
            cadastroFuncionarioView.setVisible(false);
            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o funcionario");
        }
    }
    
    public void acaoVoltar() {
        cadastroFuncionarioView.addAcaoVoltar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastroFuncionarioView.setVisible(false);
                
            }
        });
    }
    
}
