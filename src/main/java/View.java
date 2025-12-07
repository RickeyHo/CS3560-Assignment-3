import com.openai.models.responses.Response;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Arrays;

import static java.awt.SystemColor.control;


public class View {

    public static void main(String[] args) throws RuntimeException{

        final WritingSession writingSession = new WritingSession();
        OpenAI openAI = OpenAI.getInstance();

        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 1000);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JTextArea inputField = new JTextArea(5, 10);
        JScrollPane inputPane = new JScrollPane(inputField);
        inputField.setLineWrap(true);
        JTextArea outputField = new JTextArea(5, 10);
        outputField.setText("Improved text will show here...");
        outputField.setFont(new Font("Arial", Font.ITALIC, 20));
        JScrollPane outputPane = new JScrollPane(outputField);
        outputField.setLineWrap(true);
        outputField.setEditable(true);

        DateAndTimeTable list = new DateAndTimeTable();

        String[] colNames = {"History"};

        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setPreferredSize(new Dimension(5, 5));

        DefaultTableModel model = new DefaultTableModel(null, colNames) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;

            }

        };



        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (writingSession.getSave(list.getSelectedRow()).getContent() != null){
                    try {

                        outputField.setText(writingSession.getSave((LocalDateTime) model.getValueAt(list.getSelectedRow(), 0)).getContent());

                    } catch (RuntimeException ex){

                        outputField.setText(ex.getMessage());
                        throw ex;

                    }

                }

            }
        };

        list.getSelectionModel().addListSelectionListener(listSelectionListener);
        list.setModel(model);


        JButton formal = new JButton("Formal");
        JButton casual = new JButton("Casual");
        JButton elaborate = new JButton("Elaborate");
        JButton shorten = new JButton("Shorten");
        JButton save = new JButton("Save To History");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == save){

                    writingSession.save(outputField.getText());
                    model.addRow(new LocalDateTime[]{writingSession.mostRecentChangeTime()});
                    return;

                }

                outputField.setText("Please wait...");

                SwingWorker swingWorker  = new SwingWorker() {
                    @Override
                    protected Response doInBackground() throws Exception {

                        Response response = null;

                        try {

                            response = openAI.respond();
                            return response;

                        } catch (RuntimeException e) {

                            throw e;
                        }


                    }
                    @Override
                    protected void done() {

                        Response response = null;
                        try {
                            get(); //throws exception to be catched if the request failed
                            response = (Response) get();
                            outputField.setText(response.output().get(1).message().get().content().get(0).outputText().get().text());

                        } catch (Exception ex) {

                            outputField.setText(ex.getMessage());
                            throw new RuntimeException(ex);
                        }

                    }
                };
                openAI.setPrompt("Make this text sound " + e.getActionCommand() + " JUST GIVE ONE VERSION OF TEXT NO CONVERSATION \"" + inputField.getText() + "\"");

                swingWorker.execute();
            }
        };


        formal.addActionListener(actionListener);
        casual.addActionListener(actionListener);
        elaborate.addActionListener(actionListener);
        shorten.addActionListener(actionListener);
        save.addActionListener(actionListener);

        jFrame.add(jPanel);
        jPanel.add(inputPane);
        jPanel.add(outputPane);
        jPanel.add(jScrollPane);
        jPanel.add(buttonPanel);

        buttonPanel.add(formal);
        buttonPanel.add(casual);
        buttonPanel.add(elaborate);
        buttonPanel.add(shorten);
        buttonPanel.add(save);


        jFrame.setVisible(true);



    }


}
