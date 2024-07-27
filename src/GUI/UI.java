package src.GUI;

import src.database.Database;
import src.types.Experiment;
import src.types.Long_term;
import src.types.Short_term;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class UI extends JFrame{

    private JFrame frame;
    private JPanel mainPanel;
    private JTextField longTermName;
    private JTextField longTermDescription;
    private JTextField longTermMaterials;
    private JButton longTermButton;
    private JTextField shortTermName;
    private JTextField shortTermDescription;
    private JTextField shortTermMaterials;
    private JButton shortTermButton;
    private JTextField searchField;
    private JButton searchButton;
    private JTextField deleteField;
    private JButton deleteButton;
    private JTextField experiment;
    private JTextField updatedField;
    private JTextField updatedInfo;
    private JButton updateButton;
    private JLabel longTerm;
    private JLabel shortTerm;
    private JTable displayTable;


    private ArrayList<Experiment> list = new ArrayList<>();
    private Database database = new Database(list);

    public UI(){

        //create frame
        frame = new JFrame("Laboratory Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1200,1500);
        frame.setResizable(false);

        //create main panel
        mainPanel = new JPanel();


        //create long term section
        longTerm.setText("LONG TERM EXPERIMENT");
        longTerm.setBounds(0,0,200,200);
        longTermName.setText("Enter experiment's name");
        longTermName.setBounds(200,0,100,200);
        longTermDescription.setText("Enter description");
        longTermDescription.setBounds(300,0,100,200);
        longTermMaterials.setText("Enter materials");
        longTermMaterials.setBounds(400,0,100,200);
        longTermButton.setText("Enter");
        longTermButton.setBounds(500,0,100,200);
        longTermButton.setFocusable(false);

        //create short term section
        shortTerm.setText("SHORT TERM EXPERIMENT");
        shortTerm.setBounds(0,300,200,200);
        shortTermName.setText("Enter experiment's name");
        shortTermName.setBounds(200,300,100,200);
        shortTermDescription.setText("Enter description");
        shortTermDescription.setBounds(300,300,100,200);
        shortTermMaterials.setText("Enter materials");
        shortTermMaterials.setBounds(400,300,100,200);
        shortTermButton.setText("Enter");
        shortTermButton.setBounds(500,300,100,200);
        shortTermButton.setFocusable(false);


        //create searching tool
        searchField.setText("Enter id, name, element");
        searchField.setBounds(0,600,100,200);
        searchButton.setText("Search");
        searchButton.setBounds(200,600,100,200);
        searchButton.setFocusable(false);

        //create deleting tool
        deleteField.setText("Enter id, name, element");
        deleteField.setBounds(300,600,100,200);
        deleteButton.setText("Delete");
        deleteButton.setBounds(400,600,100,200);
        deleteButton.setFocusable(false);

        //create updating tool
        experiment.setText("Enter experiment name");
        experiment.setBounds(0,1000,100,200);
        updatedField.setText("Enter description/ materials");
        updatedField.setBounds(200,1000,100,200);
        updatedInfo.setText("Enter new information");
        updatedInfo.setBounds(300,1000,100,200);
        updateButton.setText("Update");
        updateButton.setBounds(400,1000,100,200);
        updateButton.setFocusable(false);

        //create table
        displayTable.setBounds(0,1300,1200,300);
        displayTable.setVisible(true);



        //panel adding long term
        mainPanel.add(longTerm);
        mainPanel.add(longTermName);
        mainPanel.add(longTermDescription);
        mainPanel.add(longTermMaterials);
        mainPanel.add(longTermButton);

        //panel adding short term
        mainPanel.add(shortTerm);
        mainPanel.add(shortTermName);
        mainPanel.add(shortTermDescription);
        mainPanel.add(shortTermMaterials);
        mainPanel.add(shortTermButton);

        //panel adding searching field
        mainPanel.add(searchField);
        mainPanel.add(searchButton);

        //panel adding deleting field
        mainPanel.add(deleteField);
        mainPanel.add(deleteButton);

        //panel adding updating field
        mainPanel.add(experiment);
        mainPanel.add(updatedField);
        mainPanel.add(updatedInfo);
        mainPanel.add(updateButton);

        //panel add table
        mainPanel.add(displayTable);

        //frame adding
        frame.add(mainPanel);
        frame.setVisible(true);

        longTermButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(longTermButton)){
                    list.add(new Long_term(longTermName.getText(), longTermDescription.getText(), longTermMaterials.getText()));
                    database.add(list);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                database.getDetail(searchField.getText());
            }

        });

        shortTermButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(shortTermButton)) {
                    list.add(new Short_term(shortTermName.getText(), shortTermDescription.getText(), shortTermMaterials.getText()));
                    database.add(list);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(deleteButton)){
                    database.remove(deleteField.getText());
                }
            }
        });
    }
}
