
package controldetareas.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TareaRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable tabla,
            Object valor,
            boolean seleccionado,
            boolean tieneFoco,
            int fila,
            int columna) {

        JLabel etiqueta = (JLabel) super.getTableCellRendererComponent(
                tabla, valor, seleccionado, tieneFoco, fila, columna);

        boolean completada = Boolean.TRUE.equals(
                tabla.getValueAt(fila, 6));

        if (completada) {
            etiqueta.setText("<html><strike>" + valor + "</strike></html>");

            if (!seleccionado) {
                etiqueta.setForeground(Color.GRAY);
            }

        } else {
            etiqueta.setText(valor == null ? "" : valor.toString());

            if (!seleccionado) {
                etiqueta.setForeground(tabla.getForeground());
            }
        }

        return etiqueta;
    }
}