/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Funcionario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class TabelaFuncionarios extends AbstractTableModel {

    private List<Funcionario> funcionarios;
    private String[] nomeColunas = {"Nome", "CPF", "Salário"};

    private final int COLUNA_NOME = 0;
    private final int COLUNA_CPF = 1;
    private final int COLUNA_SALARIO = 2;

    public TabelaFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public String getColumnName(int index) {
        return nomeColunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Funcionario funcionario = this.funcionarios.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_NOME:
                return funcionario.getNome();
            case COLUNA_CPF:
                return funcionario.getCpf();
            case COLUNA_SALARIO:
                return funcionario.getSalario();
        }
        return null;

    }

}
