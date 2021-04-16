/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Login;
import Controller.HomePageController;
import Controller.CadastroFuncionarioController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Funcionario;
import Dao.FuncionarioDAO;

public class LoginController {

    private Login LoginView;
    private HomePageController homePageController;
    private CadastroFuncionarioController cadastraFuncionarioController;
    private FuncionarioDAO fDao;

    public LoginController() {
        LoginView = new Login();
        fDao = new FuncionarioDAO();
        homePageController = new HomePageController();
        cadastraFuncionarioController = new CadastroFuncionarioController();
        adicionarAcoesBotoes();
    }

    public void exibirTela() {
        LoginView.setVisible(true);
    }

    public void adicionarAcoesBotoes() {
        acaoEntrar();
        acaoSair();
    }

    public void acaoEntrar() {
        LoginView.addAcaoBotaoEntrar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (LoginView.validateDados()) {

                    if (verificaSenha()) {
                        LoginView.limparDados();
                        homePageController.exibirTela();

                    } else {
                        LoginView.exibirMensagem("CPF ou senha inválidos");
                    }
                }

            }
        });
    }

    public boolean verificaSenha() {
        FuncionarioDAO newFdao = new FuncionarioDAO();

        for (Funcionario f : newFdao.buscarTodos()) {

            if (f.getCpf().equals(LoginView.getLogin()) && f.getPassword().equals(LoginView.getSenha())) {

                return true;
            }
        }
        return false;

    }

    public void acaoSair() {
        LoginView.addAcaobotaoRegistrar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastraFuncionarioController.exibirTela();
            }
        });
    }

}
