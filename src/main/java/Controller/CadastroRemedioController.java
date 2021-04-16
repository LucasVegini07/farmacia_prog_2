/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.CadastroRemedio;
import Dao.RemedioDAO;
import javax.swing.JOptionPane;

/**
 *
 */
public class CadastroRemedioController {

    private CadastroRemedio CadastroRemedioView;
    private RemedioDAO rdao;

    public CadastroRemedioController() {
        CadastroRemedioView = new CadastroRemedio();
        rdao = new RemedioDAO();
        adicionarAcoesBotoes();

    }

    public void exibirTela() {
        CadastroRemedioView.setVisible(true);
    }

    public void adicionarAcoesBotoes() {
        acaoCadastrar();
        acaoVoltar();
    }

    public void acaoCadastrar() {
        CadastroRemedioView.addAcaoCadastrarRemedio(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (CadastroRemedioView.validateDados()) {
                    try {
                        rdao.gravar(CadastroRemedioView.getDados());
                        CadastroRemedioView.exibirMensagem("Remédio cadastrado com sucesso");
                        CadastroRemedioView.setVisible(false);
                        CadastroRemedioView.limparDados();

                    } catch (NullPointerException n) {
                        CadastroRemedioView.exibirMensagem("Não foi possivel cadastrar o remédio");
                    }
                }
            }
        }
        );

    }

    public void acaoVoltar() {
        CadastroRemedioView.addAcaoVoltar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cadastrar");

                CadastroRemedioView.setVisible(false);

            }
        });
    }

}
