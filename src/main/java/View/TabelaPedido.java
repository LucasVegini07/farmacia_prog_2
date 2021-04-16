/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Pedido;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class TabelaPedido extends AbstractTableModel {

    private List<Pedido> pedidos;
    private String[] nomeColunas = {"Nome cliente", "Valor"};

    private final int COLUNA_CLIENTE = 0;
    private final int COLUNA_VALOR = 1;

    public TabelaPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public String getColumnName(int index) {
        return nomeColunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Pedido pedido = this.pedidos.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_CLIENTE:
                return pedido.getNomeCliente();
            case COLUNA_VALOR:
                return pedido.getValor();

        }
        return null;

    }

}
