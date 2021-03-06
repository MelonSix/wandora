/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2016 Wandora Team
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

package org.wandora.application.gui.topicpanels.queryeditorpanel;

import org.wandora.query2.DirectiveUIHints.Parameter;

/**
 *
 * @author olli
 */


public class IntegerParameterPanel extends AbstractTypePanel {

    /**
     * Creates new form StringParameterPanel
     */
    public IntegerParameterPanel(Parameter parameter,DirectivePanel panel) {
        super(parameter,panel);
        initComponents();
    }

    @Override
    public void setLabel(String label){
        parameterLabel.setText(label);
    }
    
    @Override
    public void setValue(Object o){
        valueSpinner.setValue(o);
    }
    
    @Override
    public Object getValue(){
        return valueSpinner.getValue();
    }
    @Override
    public String getValueScript(){
        return getValue().toString();
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

        parameterLabel = new javax.swing.JLabel();
        valueSpinner = new javax.swing.JSpinner();

        setLayout(new java.awt.GridBagLayout());

        parameterLabel.setText("Label");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(parameterLabel, gridBagConstraints);

        valueSpinner.setPreferredSize(new java.awt.Dimension(100, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(valueSpinner, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel parameterLabel;
    private javax.swing.JSpinner valueSpinner;
    // End of variables declaration//GEN-END:variables
}
