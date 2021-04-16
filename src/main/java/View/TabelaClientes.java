/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class TabelaClientes extends AbstractTableModel {

    private List<Cliente> clientes;
    private String[] nomeColunas = {"Nome", "CPF", "Valor"};

    private final int COLUNA_NOME = 0;
    private final int COLUNA_CPF = 1;
    private final int COLUNA_VALOR = 2;

    public TabelaClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public String getColumnName(int index) {
        return nomeColunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Cliente cliente = this.clientes.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_NOME:
                return cliente.getNome();
            case COLUNA_CPF:
                return cliente.getCpf();
            case COLUNA_VALOR:
                return cliente.getValorGasto();
        }
        return null;

    }

}
