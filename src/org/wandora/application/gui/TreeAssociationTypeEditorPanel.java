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
 * 
 * TreeAssociationTypePanel.java
 *
 * Created on 13. helmikuuta 2006, 12:03
 */




package org.wandora.application.gui;



import org.wandora.application.gui.tree.TopicTree;
import javax.swing.ImageIcon;
import java.util.*;
import java.net.*;
import org.wandora.topicmap.TopicMapException;
import org.wandora.application.gui.simple.*;
import org.wandora.application.Wandora;
import org.wandora.utils.IObox;



/**
 *
 * @author  olli
 */
public class TreeAssociationTypeEditorPanel extends javax.swing.JPanel {
    
    private TreeAssociationTypesEditor parent;
    private static Vector<IconWrapper> icons;
    private HashMap<String,Integer> iconIndex;
    private Wandora admin;




    private static void readIcons(){
        try{
            icons=new Vector<IconWrapper>();
            Enumeration<URL> toolResources = ClassLoader.getSystemResources("gui/icons/topictree");
            while(toolResources.hasMoreElements()){
                URL baseUrl=toolResources.nextElement();
                if(baseUrl.toExternalForm().startsWith("file:")) {
                    String baseDir = IObox.getFileFromURL(baseUrl);
                    //String baseDir = URLDecoder.decode(baseUrl.toExternalForm().substring(6), "UTF-8");
                    //System.out.println("Basedir: " + baseDir);
                    HashSet<String> fileNames = IObox.getFilesAsHash(baseDir, ".*\\.png", 10, 1000);
                    for(String f : fileNames) {
                        int ind=f.lastIndexOf("/");
                        int ind2=f.lastIndexOf("\\");
                        if(ind2>ind) ind=ind2;
                        icons.add(new IconWrapper("gui/icons/topictree/"+f.substring(ind+1)));
                    }
                }
                    
            }
        }
        catch(java.io.IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /** Creates new form TreeAssociationTypePanel */
    public TreeAssociationTypeEditorPanel(String name,String subRole,String assocType,String superRole,String icon,TreeAssociationTypesEditor parent,Wandora admin) throws TopicMapException {
        this.admin=admin;

        subButton = new GetTopicButton(admin);
        assocTypeButton = new GetTopicButton(admin);
        superButton = new GetTopicButton(admin);        
        
        initComponents();
        if(icons==null) readIcons();
/*        icons=GripCollections.newVector(
            new IconWrapper("gui/icons/testicon1.png"),
            new IconWrapper("gui/icons/testicon2.png"),
            new IconWrapper("gui/icons/testicon3.png"),
            new IconWrapper("gui/icons/testicon4.png")
        );*/
        iconIndex=new HashMap<String,Integer>();
        for(int i=0;i<icons.size();i++){
            iconIndex.put(icons.get(i).resource,i);
            iconComboBox.addItem(icons.get(i));
        }
        this.parent=parent;
        nameTextField.setText(name);
//        subRoleTextField.setText(subRole);
//        associationTypeTextField.setText(assocType);
//        superRoleTextField.setText(superRole);
        ((GetTopicButton)subButton).setTopic(subRole);
        ((GetTopicButton)assocTypeButton).setTopic(assocType);
        ((GetTopicButton)superButton).setTopic(superRole);
        if(icon==null) icon=icons.firstElement().resource;
        if(!iconIndex.containsKey(icon)) {
            icons.add(new IconWrapper(icon));
            iconComboBox.addItem(icons.get(icons.size()-1));
            iconIndex.put(icon,icons.size()-1);
        }
        iconComboBox.setSelectedIndex(iconIndex.get(icon));        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        superRoleTextField = new org.wandora.application.gui.simple.SimpleField();
        associationTypeTextField = new org.wandora.application.gui.simple.SimpleField();
        subRoleTextField = new org.wandora.application.gui.simple.SimpleField();
        iconComboBox = new org.wandora.application.gui.simple.SimpleComboBox();iconComboBox.setEditable(false);
        deleteButton = new org.wandora.application.gui.simple.SimpleButton();
        nameTextField = new SimpleField();
        subButton = subButton; // These buttons initialized in constructor because of possible TopicMapException;
        assocTypeButton = assocTypeButton;
        superButton = superButton;

        superRoleTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        associationTypeTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        subRoleTextField.setPreferredSize(new java.awt.Dimension(100, 20));

        setLayout(new java.awt.GridBagLayout());

        iconComboBox.setMinimumSize(new java.awt.Dimension(30, 20));
        iconComboBox.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        add(iconComboBox, gridBagConstraints);

        deleteButton.setText("Delete");
        deleteButton.setMargin(new java.awt.Insets(2, 6, 2, 6));
        deleteButton.setMaximumSize(new java.awt.Dimension(65, 20));
        deleteButton.setMinimumSize(new java.awt.Dimension(65, 20));
        deleteButton.setPreferredSize(new java.awt.Dimension(50, 20));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(deleteButton, gridBagConstraints);

        nameTextField.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(nameTextField, gridBagConstraints);

        subButton.setMaximumSize(new java.awt.Dimension(300, 20));
        subButton.setMinimumSize(new java.awt.Dimension(30, 20));
        subButton.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        add(subButton, gridBagConstraints);

        assocTypeButton.setMaximumSize(new java.awt.Dimension(300, 20));
        assocTypeButton.setMinimumSize(new java.awt.Dimension(30, 20));
        assocTypeButton.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        add(assocTypeButton, gridBagConstraints);

        superButton.setMaximumSize(new java.awt.Dimension(300, 20));
        superButton.setMinimumSize(new java.awt.Dimension(30, 20));
        superButton.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        add(superButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        parent.deleted(this);
    }//GEN-LAST:event_deleteButtonActionPerformed



    
    public TopicTree.TreeAssociation getAssociation() throws TopicMapException {
        return new TopicTree.TreeAssociation(
                nameTextField.getText(),
                ((GetTopicButton)subButton).getTopicSI(),
                ((GetTopicButton)assocTypeButton).getTopicSI(),
                ((GetTopicButton)superButton).getTopicSI(),
                icons.get(iconComboBox.getSelectedIndex()).resource);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assocTypeButton;
    private javax.swing.JTextField associationTypeTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox iconComboBox;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton subButton;
    private javax.swing.JTextField subRoleTextField;
    private javax.swing.JButton superButton;
    private javax.swing.JTextField superRoleTextField;
    // End of variables declaration//GEN-END:variables

    public static class IconWrapper extends ImageIcon {
        
        public String resource;
    
        public IconWrapper(String resource){
            super(TreeAssociationsPanel.class.getClassLoader().getResource(resource));
            this.resource=resource;
        }
    }
    
}