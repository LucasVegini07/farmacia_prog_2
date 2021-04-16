/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.HomePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.CadastroRemedioController;
import Controller.NovoPedidoController;
import View.DadosGerais;

public class HomePageController {

    private HomePage homePageView;
    private CadastroRemedioController cadastroRemedioController;
    private NovoPedidoController novoPedidoController;
    private DadosGerais dadosGeraisView;

    public HomePageController() {
        homePageView = new HomePage();
        cadastroRemedioController = new CadastroRemedioController();
        novoPedidoController = new NovoPedidoController();
        dadosGeraisView = new DadosGerais();
        adicionarAcoesBotoes();

    }

    public void exibirTela() {
        homePageView.setVisible(true);
    }

    public void adicionarAcoesBotoes() {
        acaoCadastrarRemedio();
        acaoNovaCompra();
        acaoEstatistica();
        acaoLogout();
    }

    public void acaoCadastrarRemedio() {

        homePageView.addAcaoCadastrarRemedio(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.print("Lucas");
                cadastroRemedioController.exibirTela();
            }

        });

    }

    public void acaoNovaCompra() {

        homePageView.addAcaoNovaCompra(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                novoPedidoController.exibirTela();
            }

        });
    }

    public void acaoEstatistica() {

        homePageView.addAcaoEstatistica(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dadosGeraisView.setVisible(true);
            }

        });
    }

    public void acaoLogout() {

        homePageView.addAcaoLogout(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                homePageView.setVisible(false);

            }

        });
    }

}
