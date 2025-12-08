

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateAndTimeTable extends JTable {

    public boolean isAccessible = false;

    @Override
    public Class<?> getColumnClass(int column) {

        return super.getColumnClass(column);

    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Object value = getValueAt(row, column);

        boolean isSelected = false;
        boolean hasFocus = false;

        // Only indicate the selection and focused cell if not printing
        if (!isPaintingForPrint()) {
            isSelected = isCellSelected(row, column);

            boolean rowIsLead =
                    (selectionModel.getLeadSelectionIndex() == row);
            boolean colIsLead =
                    (columnModel.getSelectionModel().getLeadSelectionIndex() == column);

            hasFocus = (rowIsLead && colIsLead) && isFocusOwner();
        }
        Component component;
        if (value instanceof LocalDateTime) {

            LocalDateTime time = (LocalDateTime) value;
            time = time.truncatedTo(ChronoUnit.SECONDS);

            component = renderer.getTableCellRendererComponent(this, DateTimeFormatter.ISO_LOCAL_TIME.format(time) + " - " + DateTimeFormatter.ISO_LOCAL_DATE.format(time) + " [" + WritingSession.getSave((LocalDateTime) value).getClass().getSimpleName() + "]",
                    isSelected, hasFocus,
                    row, column);



        } else {

            component = renderer.getTableCellRendererComponent(this, value.toString(),
                    isSelected, hasFocus,
                    row, column);
            component.setBackground(new Color(30, 30, 30));
            component.setSize(50, 50);
            component.setForeground(Color.white);

        }

        return component;

    }
}
