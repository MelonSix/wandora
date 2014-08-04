/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2014 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */



package org.wandora.application.tools.extractors.excel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.wandora.application.Wandora;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleComboBox;
import org.wandora.application.gui.simple.SimpleLabel;

/**
 *
 * @author akivela
 */


public class ExcelExtractorUI extends javax.swing.JPanel {

    private JDialog myDialog = null;
    private boolean accepted = false;
    private ArrayList<JComboBox> comboboxes = null;
            
    
    /**
     * Creates new form ExcelExtractorUI
     */
    public ExcelExtractorUI() {
        initComponents();
    }
    
    
    
    public void open(Collection<String> sheets, Collection<String> extractors) {
        JPanel sheetSelectors = new JPanel();
        sheetSelectors.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        
        comboboxes = new ArrayList();
        
        for(String sheet : sheets) {
            JLabel label = new SimpleLabel(sheet);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 0.0;
            gridBagConstraints.insets = new Insets(6,6,6,6);
            sheetSelectors.add(label, gridBagConstraints);
            JComboBox combobox = new SimpleComboBox(extractors);
            combobox.setEditable(false);
            gridBagConstraints.gridx = 1;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.weightx = 1.0;
            gridBagConstraints.insets = new Insets(6,0,6,6);
            sheetSelectors.add(combobox, gridBagConstraints);
            comboboxes.add(combobox);
        }
        scrollPane.setViewportView(sheetSelectors);
        
        Wandora wandora = Wandora.getWandora();
        myDialog = new JDialog(wandora, true);
        myDialog.setTitle("Select extractor for each Excel sheet");
        myDialog.setSize(500, 300);
        myDialog.add(this);
        wandora.centerWindow(myDialog);
        myDialog.setVisible(true);
    }
    

    
    public String[] getExtractors() {
        ArrayList<String> extractors = new ArrayList();
        for(JComboBox combobox : comboboxes) {
            if(combobox != null) {
                Object extractor = combobox.getSelectedItem();
                extractors.add(extractor.toString());
            }
        }
        return extractors.toArray( new String[] {} );
    }
    
    
    

    public boolean wasAccepted() {
        return accepted;
    }
    public void setAccepted(boolean b) {
        accepted = b;
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        selectorPanel = new javax.swing.JPanel();
        infoLabel = new SimpleLabel();
        scrollPane = new javax.swing.JScrollPane();
        buttonPanel = new javax.swing.JPanel();
        fillerPanel = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        selectorPanel.setLayout(new java.awt.GridBagLayout());

        infoLabel.setText("Select extractor for each Excel sheet.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        selectorPanel.add(infoLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        selectorPanel.add(scrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(selectorPanel, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        fillerPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(fillerPanel, gridBagConstraints);

        okButton.setText("Extract");
        okButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        okButton.setMaximumSize(new java.awt.Dimension(70, 23));
        okButton.setMinimumSize(new java.awt.Dimension(70, 23));
        okButton.setPreferredSize(new java.awt.Dimension(70, 23));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        buttonPanel.add(okButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        cancelButton.setMaximumSize(new java.awt.Dimension(70, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(70, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(70, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 2);
        buttonPanel.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(buttonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setAccepted(false);
        if(myDialog != null) myDialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setAccepted(true);
        if(myDialog != null) myDialog.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel fillerPanel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel selectorPanel;
    // End of variables declaration//GEN-END:variables
}