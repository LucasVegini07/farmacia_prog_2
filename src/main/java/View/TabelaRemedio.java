package View;

import Model.Remedio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lucas
 */
public class TabelaRemedio extends AbstractTableModel {

    private List<Remedio> remedios;
    private String[] nomeColunas = {"Nome", "Valor"};

    private final int COLUNA_REMEDIO = 0;
    private final int COLUNA_PRECO = 1;

    public TabelaRemedio(List<Remedio> remedios) {
        this.remedios = remedios;
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public int getRowCount() {
        return remedios.size();
    }

    @Override
    public String getColumnName(int index) {
        return nomeColunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Remedio remedio = this.remedios.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_REMEDIO:
                return remedio.getNome();
            case COLUNA_PRECO:
                return remedio.getValor();

        }
        return null;

    }

}
