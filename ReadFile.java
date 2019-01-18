/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleWebBrowser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Hyperlink;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author dell-pc
 */
public class ReadFile extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    public ReadFile() {
        super("Bucky Browser");
        addressBar = new JTextField("Enter a URL");
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                loadCrap(event.getActionCommand());
            }
        });
        add(addressBar, BorderLayout.NORTH);
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent event) {
                if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    loadCrap(event.getURL().toString());
                }
            }

        });
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }
    private void loadCrap(String userText)
    {
        try{
        display.setPage(userText);
        addressBar.setText(userText);
        }
        catch(Exception e)
        {
            System.out.println("Crap!");
        }
    }

}
