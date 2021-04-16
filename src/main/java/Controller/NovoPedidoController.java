/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.NovoPedido;
import Dao.ClienteDAO;
import Dao.FuncionarioDAO;
import Model.Cliente;
import Model.Funcionario;
import Dao.PedidoDAO;
import java.util.ArrayList;
import java.util.List;

public class NovoPedidoController {

    private NovoPedido novoPedidoView;
    private FuncionarioDAO fDao;
    private ClienteDAO cDao;
    private PedidoDAO pDao;

    public NovoPedidoController() {
        novoPedidoView = new NovoPedido();
        fDao = new FuncionarioDAO();
        cDao = new ClienteDAO();
        pDao = new PedidoDAO();
        adicionarAcoesBotoes();

    }

    public void exibirTela() {
        novoPedidoView.setVisible(true);
    }

    public void adicionarAcoesBotoes() {
        acaoCompra();
        acaoVoltar();
        acaoPesquisa();
    }

    public void acaoCompra() {
        novoPedidoView.addAcaoFinalizar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Funcionario f1 = new Funcionario((float) 15.50, 15, "", "", "");

                if (novoPedidoView.validateDados()) {

                    if (verificaCpfFuncionario()) {

                        if (verificaClienteExiste()) {
                            atualizaCliente();
                            atualizaFuncionario();
                            finalizaPedido();

                        } else {
                            cadastraCliente();
                            atualizaFuncionario();
                            finalizaPedido();
                        }
                    }
                }
            }
        }
        );
    }

    public void atualizaFuncionario() {

        List<Funcionario> funcionarioList = new ArrayList<Funcionario>();

        FuncionarioDAO newFDao = new FuncionarioDAO();
        Funcionario f = new Funcionario();
        funcionarioList = newFDao.buscarTodos();

        for (Funcionario f1 : funcionarioList) {
            if (f1.getCpf().equals(novoPedidoView.getCpfFuncionario())) {
                f = f1;
            }
        }

        atualizaFuncionarioFinal(f.getId());

    }

    public void atualizaFuncionarioFinal(int id) {

        FuncionarioDAO newFDao = new FuncionarioDAO();
        Funcionario f = new Funcionario();

        try {
            newFDao.atualizar(f, id, (float) (novoPedidoView.getValorGasto() * 0.30));
        } catch (NullPointerException e) {
            novoPedidoView.exibirMensagem("Não foi possivel atualizar o funcionario");

        }
    }

    public void finalizaPedido() {

        PedidoDAO pdao = new PedidoDAO();

        try {

            pdao.gravar(novoPedidoView.getDados());
            novoPedidoView.exibirMensagem("Pedido realizado com sucesso");
            novoPedidoView.setVisible(false);
            novoPedidoView.limparDados();

        } catch (NullPointerException e) {
            novoPedidoView.exibirMensagem("Não foi possivel finalizar o pedido");
        }

    }

    public void atualizaCliente() {

        List<Cliente> clientList = new ArrayList<Cliente>();

        Cliente c = new Cliente();

        ClienteDAO cdao = new ClienteDAO();

        clientList = cdao.buscarTodos();

        for (Cliente c1 : clientList) {
            if (c1.getCpf().equals(novoPedidoView.getCpfCliente())) {
                c = c1;
            }
        }

        atualizaClienteFinal(c.getId(), novoPedidoView.getValorGasto());

    }

    public void atualizaClienteFinal(int id, float valor) {

        Cliente c = new Cliente();
        ClienteDAO newCDao = new ClienteDAO();

        try {
            newCDao.atualizar(c, id, valor);
        } catch (NullPointerException e) {

            novoPedidoView.exibirMensagem("Houve um erro ao atualizar o cliente");

        }
    }

    public void cadastraCliente() {
        ClienteDAO newCDao = new ClienteDAO();

        Cliente c = new Cliente(novoPedidoView.getNomeCliente(), novoPedidoView.getCpfCliente(), novoPedidoView.getValorGasto());
        newCDao.gravar(c);

    }

    public void acaoVoltar() {
        novoPedidoView.addAcaoVoltar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                novoPedidoView.setVisible(false);

            }
        });
    }

    public boolean verificaCpfFuncionario() {

        List<Funcionario> funcionarioList = new ArrayList<Funcionario>();

        FuncionarioDAO fdao = new FuncionarioDAO();

        funcionarioList = fdao.buscarTodos();

        for (Funcionario c : funcionarioList) {
            if (c.getCpf().equals(novoPedidoView.getCpfFuncionario())) {

                return true;
            }
        }

        novoPedidoView.exibirMensagem("CPF do funcionário não foi encontrado em nosso sistema");

        return false;

    }

    public boolean verificaClienteExiste() {

        List<Cliente> clientList = new ArrayList<Cliente>();

        ClienteDAO cdao = new ClienteDAO();

        clientList = cdao.buscarTodos();

        for (Cliente c : clientList) {
            if (c.getCpf().equals(novoPedidoView.getCpfCliente())) {

                return true;
            }
        }

        return false;
    }

    public void verificaCPFCliente() {

        List<Cliente> clientList = new ArrayList<Cliente>();

        ClienteDAO cdao = new ClienteDAO();

        clientList = cdao.buscarTodos();

        for (Cliente c : clientList) {
            if (c.getCpf().equals(novoPedidoView.getCpfCliente())) {

                novoPedidoView.setNomeCliente(c.getNome());
                return;
            }
        }

        novoPedidoView.exibirMensagem("CPF do cliente não encontrado em nosso sistema");
    }

    public void acaoPesquisa() {
        novoPedidoView.addAcaoPesquisar(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente c1 = new Cliente("", "", 0);

                if (novoPedidoView.validateCPFCliente()) {
                    verificaCPFCliente();
                }

            }
        });
    }

}
