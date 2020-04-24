/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import function.ControlComplexity;
import function.FileAnalyzer;
import function.MethodComplexity;
import function.SizeComplexityMeasuring;
import function.VariableComplexity;
import static UI.MainUI.filepath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nuwan
 */
public class AnalyzerForm extends javax.swing.JFrame {

    /**
     * Creates new form AnalyzerForm
     */
    SizeComplexityMeasuring scm = new SizeComplexityMeasuring();
    MethodComplexity mcm = new MethodComplexity();
    VariableComplexity vcm = new VariableComplexity();
    ControlComplexity Ccm = new ControlComplexity();

    ArrayList<String> SizeComplexityList = new ArrayList<>();
    ArrayList<String> MethodComplexityList = new ArrayList<>();
    ArrayList<String> VariableComplexityList = new ArrayList<>();
    ArrayList<String> ControlComplexityLst = new ArrayList<>();

    int Cs, Wkw, Nkw, Wid, Nid, Wop, Nop, Wnv, Nnv, Wsl, Nsl;
    int Cm, Wmrt, Wpdtp, Npdtp, Wcdtp, Ncdtp;
    int Cv, Wvs, Wpdtv, Npdtv, Wcdtv, Ncdtv;
    int Ccs, Wtcs, NC, Ccspps;
    
    

    public AnalyzerForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        WmrtLabel.setVisible(false);
        WpdtpLabel.setVisible(false);
        NpdtpLabel.setVisible(false);
        WcdtpLabel.setVisible(false);
        NcdtpLabel.setVisible(false);
        CmLabel.setVisible(false);
        
        WvsLabel.setVisible(false);
        WpdtvLabel.setVisible(false);
        NpdtvLabel.setVisible(false);
        WcdtvLabel.setVisible(false);
        NcdtvLabel.setVisible(false);
        WtcsLabel.setVisible(false);
        NCLabel.setVisible(false);
        CcsppsLabel.setVisible(false);
        CcsLabel.setVisible(false);
        CsLabelValue.setVisible(false);
        WkwLabel.setVisible(false);
        NkwLabel.setVisible(false);
        WidLabel.setVisible(false);
        NidLabel.setVisible(false);
        WopLabel.setVisible(false);
        NopLabel.setVisible(false);
        WnvLabel.setVisible(false);
        NnvLabel.setVisible(false);
        WslLabel.setVisible(false);
        NslLabel.setVisible(false);
        CvLabel.setVisible(false);
        
        KeyWordAnalyzerLabel.setVisible(false);
        SizeLabel.setVisible(false);
      
        
        
    }

    public void getDetails(int value) {
        ComplexityLabel.setText(Integer.toString(value));
    }

    public void getCodeText(String filepath) throws IOException {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        //sizeTextView.read(br, null);
        //sizeTextView.requestFocus();
    }

    public void getSizeComplexity(String filepath) throws Exception {
        //SizeLabel.setText(Integer.toString(scm.SizeComplexityInitializer(br)));
        SizeComplexityList = scm.SizeComplexityInitializer(filepath);

        Wkw = Integer.parseInt(SizeComplexityList.get(0));
        Nkw = Integer.parseInt(SizeComplexityList.get(1));
        Wid = Integer.parseInt(SizeComplexityList.get(2));
        Nid = Integer.parseInt(SizeComplexityList.get(3));
        Wop = Integer.parseInt(SizeComplexityList.get(4));
        Nop = Integer.parseInt(SizeComplexityList.get(5));
        Wnv = Integer.parseInt(SizeComplexityList.get(6));
        Nnv = Integer.parseInt(SizeComplexityList.get(7));
        Wsl = Integer.parseInt(SizeComplexityList.get(8));
        Nsl = Integer.parseInt(SizeComplexityList.get(9));

        WkwLabel.setText(Integer.toString(Wkw));
        NkwLabel.setText(Integer.toString(Nkw));
        WidLabel.setText(Integer.toString(Wid));
        NidLabel.setText(Integer.toString(Nid));
        WopLabel.setText(Integer.toString(Wop));
        NopLabel.setText(Integer.toString(Nop));
        WnvLabel.setText(Integer.toString(Wnv));
        NnvLabel.setText(Integer.toString(Nnv));
        WslLabel.setText(Integer.toString(Wsl));
        NslLabel.setText(Integer.toString(Nsl));

        Cs = (Wkw * Nkw) + (Wid * Nid) + (Wop * Nop) + (Wnv * Nnv) + (Wsl * Nsl);
        CsLabelValue.setText(Integer.toString(Cs));
        SizeLabel.setText(Integer.toString(Cs));
    }

    public void getVariableAnalyze(int value) {
        KeyWordAnalyzerLabel.setText(Integer.toString(value));
    }

    public void getInheritanceAnalyzer(int value) {
        InheritanceLabel.setText(Integer.toString(value));
    }

    public void getMethodComplexity(String filepath) throws FileNotFoundException, IOException {
        MethodComplexityList = mcm.MethodComplexityInitializer(filepath);

        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
//        CsMethodsTextView.read(br, null);
//        CsMethodsTextView.requestFocus();

        Wmrt = Integer.parseInt(MethodComplexityList.get(0));
        Wpdtp = Integer.parseInt(MethodComplexityList.get(1));
        Npdtp = Integer.parseInt(MethodComplexityList.get(2));
        Wcdtp = Integer.parseInt(MethodComplexityList.get(3));
        Ncdtp = Integer.parseInt(MethodComplexityList.get(4));

        WmrtLabel.setText(Integer.toString(Wmrt));
        WpdtpLabel.setText(Integer.toString(Wpdtp));
        NpdtpLabel.setText(Integer.toString(Npdtp));
        WcdtpLabel.setText(Integer.toString(Wcdtp));
        NcdtpLabel.setText(Integer.toString(Ncdtp));

        Cm = Wmrt + (Wpdtp * Npdtp) + (Wcdtp * Ncdtp);
        CmLabel.setText(Integer.toString(Cm));

    }

    public void getVariableComplexity(String[] str, String filepath) throws FileNotFoundException, IOException {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        //CsVariableView.read(br, null);
        //CsVariableView.requestFocus();

        VariableComplexityList = vcm.VariableComplexityInitializer(str);

        Wvs = Integer.parseInt(VariableComplexityList.get(0));
        Wpdtv = Integer.parseInt(VariableComplexityList.get(1));
        Npdtv = Integer.parseInt(VariableComplexityList.get(2));
        Wcdtv = Integer.parseInt(VariableComplexityList.get(3));
        Ncdtv = Integer.parseInt(VariableComplexityList.get(4));

        WvsLabel.setText(Integer.toString(Wvs));
        WpdtvLabel.setText(Integer.toString(Wpdtv));
        NpdtvLabel.setText(Integer.toString(Npdtv));
        WcdtvLabel.setText(Integer.toString(Wcdtv));
        NcdtvLabel.setText(Integer.toString(Ncdtv));

        Cv = Wvs * ((Wpdtv * Npdtv) + (Wcdtv * Ncdtv));
        CvLabel.setText(Integer.toString(Cv));
    }

    public void getControlStructureConplexity(String filepath) throws FileNotFoundException, IOException {
        FileReader read = new FileReader(filepath);
        BufferedReader br = new BufferedReader(read);
        //CcSVariableView.read(br, null);
        //CcSVariableView.requestFocus();

        ControlComplexityLst = Ccm.ControlComplexityInitializer(filepath);

        Wtcs = Integer.parseInt(ControlComplexityLst.get(0));
        NC = Integer.parseInt(ControlComplexityLst.get(1));
        Ccspps = Integer.parseInt(ControlComplexityLst.get(2));

        WtcsLabel.setText(Integer.toString(Wtcs));
        NCLabel.setText(Integer.toString(NC));
        CcsppsLabel.setText(Integer.toString(Ccspps));

        Ccs = (Wtcs * NC) + Ccspps;
        CcsLabel.setText(Integer.toString(Ccs));
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ComplexityLabel = new javax.swing.JLabel();
        KeyWordAnalyzerLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        InheritanceLabel = new javax.swing.JLabel();
        SizeLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        WmrtLabel = new javax.swing.JLabel();
        WpdtpLabel = new javax.swing.JLabel();
        NpdtpLabel = new javax.swing.JLabel();
        WcdtpLabel = new javax.swing.JLabel();
        NcdtpLabel = new javax.swing.JLabel();
        CmLabel = new javax.swing.JLabel();
        WvsLabel = new javax.swing.JLabel();
        WpdtvLabel = new javax.swing.JLabel();
        NpdtvLabel = new javax.swing.JLabel();
        WcdtvLabel = new javax.swing.JLabel();
        NcdtvLabel = new javax.swing.JLabel();
        CvLabel = new javax.swing.JLabel();
        WtcsLabel = new javax.swing.JLabel();
        NCLabel = new javax.swing.JLabel();
        CcsppsLabel = new javax.swing.JLabel();
        CcsLabel = new javax.swing.JLabel();
        WkwLabel = new javax.swing.JLabel();
        NkwLabel = new javax.swing.JLabel();
        WidLabel = new javax.swing.JLabel();
        NidLabel = new javax.swing.JLabel();
        WopLabel = new javax.swing.JLabel();
        NopLabel = new javax.swing.JLabel();
        WnvLabel = new javax.swing.JLabel();
        NnvLabel = new javax.swing.JLabel();
        WslLabel = new javax.swing.JLabel();
        NslLabel = new javax.swing.JLabel();
        CsLabelValue = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Number of Inheritance :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        ComplexityLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ComplexityLabel.setText("--");
        getContentPane().add(ComplexityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, -1, -1));

        KeyWordAnalyzerLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        KeyWordAnalyzerLabel.setText("--");
        getContentPane().add(KeyWordAnalyzerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Code Complexity :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, 30));

        InheritanceLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        InheritanceLabel.setText("--");
        getContentPane().add(InheritanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        SizeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SizeLabel.setText("--");
        getContentPane().add(SizeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTabbedPane1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Wvs", "Wpdtv", "Npdtv", "Wcdtv", "Ncdtv", "=CV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane1.addTab("Variables", jScrollPane3);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Wtcs", "NC", "Ccspps", "=Ccs"
            }
        ));
        jTable3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane6.setViewportView(jTable3);

        jTabbedPane1.addTab("Control Stuctures", jScrollPane6);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Wkw", "Nkw", "Wid", "Nid", "Wop", "Nop", "Wnv", "Nnv", "Wsl", "Nsl", "=Cs"
            }
        ));
        jTable4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable4AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane7.setViewportView(jTable4);

        jTabbedPane1.addTab("Size", jScrollPane7);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}
            },
            new String [] {
                "Nr", "Nmcms", "Nmcmd", "Nmcrms", "Nmcrmd", "Nrmcrms", "Nrmcrmd", "Nrmcms", "Nrmcmd", "Nmrgvs", "Nmrgvd", "Nrmrgvs", "Nrmrgvd", "=Ccp"
            }
        ));
        jScrollPane8.setViewportView(jTable5);

        jTabbedPane1.addTab("Couplings", jScrollPane8);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Wmrt", "Wpdtp", "Npdtp", "Wcdtp", "Ncdtp", "=CM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Methods", jScrollPane1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 740, 120));

        WmrtLabel.setText("--");
        getContentPane().add(WmrtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        WpdtpLabel.setText("--");
        getContentPane().add(WpdtpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        NpdtpLabel.setText("--");
        getContentPane().add(NpdtpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        WcdtpLabel.setText("--");
        getContentPane().add(WcdtpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        NcdtpLabel.setText("--");
        getContentPane().add(NcdtpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        CmLabel.setText("--");
        getContentPane().add(CmLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        WvsLabel.setText("--");
        getContentPane().add(WvsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        WpdtvLabel.setText("--");
        getContentPane().add(WpdtvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        NpdtvLabel.setText("--");
        getContentPane().add(NpdtvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        WcdtvLabel.setText("--");
        getContentPane().add(WcdtvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        NcdtvLabel.setText("--");
        getContentPane().add(NcdtvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        CvLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CvLabel.setText("--");
        getContentPane().add(CvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        WtcsLabel.setText("--");
        getContentPane().add(WtcsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        NCLabel.setText("--");
        getContentPane().add(NCLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        CcsppsLabel.setText("--");
        getContentPane().add(CcsppsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        CcsLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CcsLabel.setText("--");
        getContentPane().add(CcsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        WkwLabel.setText("--");
        getContentPane().add(WkwLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        NkwLabel.setText("--");
        getContentPane().add(NkwLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        WidLabel.setText("--");
        getContentPane().add(WidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        NidLabel.setText("--");
        getContentPane().add(NidLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        WopLabel.setText("--");
        getContentPane().add(WopLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        NopLabel.setText("--");
        getContentPane().add(NopLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        WnvLabel.setText("--");
        getContentPane().add(WnvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        NnvLabel.setText("--");
        getContentPane().add(NnvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        WslLabel.setText("--");
        getContentPane().add(WslLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        NslLabel.setText("--");
        getContentPane().add(NslLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        CsLabelValue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        CsLabelValue.setText("--");
        getContentPane().add(CsLabelValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 150, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 490, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane1AncestorAdded
        int data1 = Integer.parseInt(WmrtLabel.getText());
        int data2 = Integer.parseInt(WpdtpLabel.getText());
        int data3 = Integer.parseInt(NpdtpLabel.getText());
        int data4 = Integer.parseInt(WcdtpLabel.getText());
        int data5 = Integer.parseInt(NcdtpLabel.getText());
        int data6 = Integer.parseInt(CmLabel.getText());

        Object[] row = {data1, data2, data3, data4, data5, data6};

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.addRow(row);
    }//GEN-LAST:event_jTabbedPane1AncestorAdded

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable2AncestorAdded
        int data1 = Integer.parseInt(WvsLabel.getText());
        int data2 = Integer.parseInt(WpdtvLabel.getText());
        int data3 = Integer.parseInt(NpdtvLabel.getText());
        int data4 = Integer.parseInt(WcdtvLabel.getText());
        int data5 = Integer.parseInt(NcdtvLabel.getText());
        int data6 = Integer.parseInt(CvLabel.getText());

        Object[] row = {data1, data2, data3, data4, data5, data6};

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.addRow(row);
    }//GEN-LAST:event_jTable2AncestorAdded

    private void jTable3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable3AncestorAdded
          int data1 = Integer.parseInt(WtcsLabel.getText());
        int data2 = Integer.parseInt(NCLabel.getText());
        int data3 = Integer.parseInt(CcsppsLabel.getText());
        int data4 = Integer.parseInt(CcsLabel.getText());
   

        Object[] row = {data1, data2, data3, data4};

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();

        model.addRow(row);
    }//GEN-LAST:event_jTable3AncestorAdded

    private void jTable4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable4AncestorAdded
        int data1 = Integer.parseInt(WkwLabel.getText());
        int data2 = Integer.parseInt(NkwLabel.getText());
        int data3 = Integer.parseInt(WidLabel.getText());
        int data4 = Integer.parseInt(NidLabel.getText());
        int data5 = Integer.parseInt(WopLabel.getText());
        int data6 = Integer.parseInt(NopLabel.getText());
        int data7 = Integer.parseInt(WnvLabel.getText());
        int data8 = Integer.parseInt(NnvLabel.getText());
        int data9 = Integer.parseInt(WslLabel.getText());
        int data10 = Integer.parseInt(NslLabel.getText());
        int data11 = Integer.parseInt(CsLabelValue.getText());
   

        Object[] row = {data1, data2, data3, data4, data5, data6, data7, data8, data9, data10, data11};

        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

        model.addRow(row);
    }//GEN-LAST:event_jTable4AncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.toBack();
       setVisible (false);
       new MainUI().toFront();
       new MainUI().setState(java.awt.Frame.NORMAL);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalyzerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalyzerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CcsLabel;
    private javax.swing.JLabel CcsppsLabel;
    private javax.swing.JLabel CmLabel;
    private javax.swing.JLabel ComplexityLabel;
    private javax.swing.JLabel CsLabelValue;
    private javax.swing.JLabel CvLabel;
    private javax.swing.JLabel InheritanceLabel;
    private javax.swing.JLabel KeyWordAnalyzerLabel;
    private javax.swing.JLabel NCLabel;
    private javax.swing.JLabel NcdtpLabel;
    private javax.swing.JLabel NcdtvLabel;
    private javax.swing.JLabel NidLabel;
    private javax.swing.JLabel NkwLabel;
    private javax.swing.JLabel NnvLabel;
    private javax.swing.JLabel NopLabel;
    private javax.swing.JLabel NpdtpLabel;
    private javax.swing.JLabel NpdtvLabel;
    private javax.swing.JLabel NslLabel;
    private javax.swing.JLabel SizeLabel;
    private javax.swing.JLabel WcdtpLabel;
    private javax.swing.JLabel WcdtvLabel;
    private javax.swing.JLabel WidLabel;
    private javax.swing.JLabel WkwLabel;
    private javax.swing.JLabel WmrtLabel;
    private javax.swing.JLabel WnvLabel;
    private javax.swing.JLabel WopLabel;
    private javax.swing.JLabel WpdtpLabel;
    private javax.swing.JLabel WpdtvLabel;
    private javax.swing.JLabel WslLabel;
    private javax.swing.JLabel WtcsLabel;
    private javax.swing.JLabel WvsLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
