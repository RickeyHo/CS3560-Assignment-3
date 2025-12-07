import com.openai.models.beta.threads.runs.Run;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.ResponseError;
import com.openai.models.responses.ResponseStatus;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


public class View {

    public static void main(String[] args) throws RuntimeException{

        final WritingSession[] writingSession = {null};
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

        JList versionHistory = new JList();


        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (versionHistory.getSelectedValue() != null){

                    outputField.setText(writingSession[0].getSave((LocalDateTime) versionHistory.getSelectedValue()).content);

                }

            }
        };

        JButton formal = new JButton("Formal");
        JButton casual = new JButton("Casual");
        JButton elaborate = new JButton("Elaborate");
        JButton shorten = new JButton("Shorten");
        JButton save = new JButton("Save To History");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == save){

                    if (writingSession[0] == null){

                        writingSession[0] = new WritingSession("Title", outputField.getText());
                        versionHistory.setListData(writingSession[0].saves.toArray());

                    } else {

                        writingSession[0].content = outputField.getText();
                        writingSession[0].save();
                        versionHistory.setListData(writingSession[0].saves.toArray());

                    }

                    return;

                }

                outputField.setText("Please wait...");

                SwingWorker swingWorker  = new SwingWorker() {
                    @Override
                    protected Response doInBackground() throws Exception {

                        System.out.println(openAI.prompt);
                        Response response = openAI.respond();

                        try {
                            openAI.respond();
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
                openAI.prompt = "Make this text sound " + e.getActionCommand() + " JUST GIVE ONE VERSION OF TEXT NO CONVERSATION \"" + inputField.getText() + "\"";

                swingWorker.execute();
            }
        };


        formal.addActionListener(actionListener);
        casual.addActionListener(actionListener);
        elaborate.addActionListener(actionListener);
        shorten.addActionListener(actionListener);
        save.addActionListener(actionListener);
        versionHistory.addListSelectionListener(listSelectionListener);

        jFrame.add(jPanel);
        jPanel.add(inputPane);
        jPanel.add(outputPane);
        jPanel.add(buttonPanel);

        buttonPanel.add(formal);
        buttonPanel.add(casual);
        buttonPanel.add(elaborate);
        buttonPanel.add(shorten);
        buttonPanel.add(save);
        buttonPanel.add(versionHistory);
        jFrame.setVisible(true);



    }


}
