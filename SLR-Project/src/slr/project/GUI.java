package slr.project;

import com.sun.org.apache.bcel.internal.classfile.Utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class GUI extends javax.swing.JFrame {
    
    String InputsString;
    int size;
    public char [] Grammer;        
    public String c;
     String temp[];
    public String[]  Grammer_lines;
    public String[][] rules;
    int line_Count;
    boolean InputT;
    public GUI(boolean InputT) {
        this.InputT=InputT;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        ReadGrammer = new javax.swing.JButton();
        FileAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BrowseGrammer = new javax.swing.JButton();
        Parse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        ReadGrammer.setFont(new java.awt.Font("MV Boli", 1, 10)); // NOI18N
        ReadGrammer.setForeground(new java.awt.Color(255, 0, 51));
        ReadGrammer.setText("Read Grammer");
        ReadGrammer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadGrammerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("File Address");

        BrowseGrammer.setText("Browse Grammer");
        BrowseGrammer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseGrammerActionPerformed(evt);
            }
        });

        Parse.setFont(new java.awt.Font("MV Boli", 1, 10)); // NOI18N
        Parse.setForeground(new java.awt.Color(255, 0, 51));
        Parse.setText("Parse Grammer");
        Parse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("Enter Your Grammer!");

        jLabel4.setFont(new java.awt.Font("Plantagenet Cherokee", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 255));
        jLabel4.setText("SLR(1) Parser");

        jButton1.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 204));
        jButton1.setText("Input For parse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ReadGrammer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(FileAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Parse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(jLabel4)))
                        .addGap(64, 64, 64)
                        .addComponent(BrowseGrammer)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FileAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BrowseGrammer)
                        .addGap(38, 38, 38)
                        .addComponent(ReadGrammer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parse, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReadGrammerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadGrammerActionPerformed
        
        line_Count=jTextArea1.getLineCount();
        temp=new String[line_Count+1];
        String GrammerArray=jTextArea1.getText();
        int sizTemp=GrammerArray.length();
        
       
        size=sizTemp;
        
        GrammerArray=GrammerArray+""+"\n";
        for(int Line=1;Line<line_Count+1;Line++){
       temp[Line]=GrammerArray.substring(0, GrammerArray.indexOf("\n"))+" ";
       GrammerArray=GrammerArray.substring(GrammerArray.indexOf("\n")+1);
        System.out.println(temp[Line]);        
        }
        
         temp[0]="Z --> "+temp[1].substring(0, 1)+" ";
        System.out.print(temp[0]);
         line_Count=line_Count+1;  
      
    }//GEN-LAST:event_ReadGrammerActionPerformed

    private void BrowseGrammerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseGrammerActionPerformed
         
        JFileChooser filechooser=new JFileChooser();
        String selectedFilePatch="";
        int result=filechooser.showOpenDialog(this);
        if(result==JFileChooser.CANCEL_OPTION){
            //nothing            
        }
        else{
        selectedFilePatch=filechooser.getSelectedFile().getPath();
        }
    FileAddress.setText(selectedFilePatch);
    }//GEN-LAST:event_BrowseGrammerActionPerformed
   
    private void ParseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParseActionPerformed
                
        FirstFollow obj=new FirstFollow();
        obj.Calculate_Follow(temp,size,InputT);
       int  size1=0;
       int line_Count=20;
      
//        try{
//           c=FileAddress.getText();
//           InputStream is = new FileInputStream(c);
//             
//            Scanner input = new Scanner(System.in);
//            
//           
////           for(int i=0;i<size;i++){
////               Grammer[i]= is.;
////           }
//            is.close();
//           }
//       catch(IOException e){
//           System.out.print("Exception");}
//        
//        
//            
//        System.out.print(size1);   
////        
////              temp=new String[line_Count] ;
//             int l=0,j=0;
//             
//         for (int i = 0; i < Grammer.length; i++) {          
//           if(Grammer[i]=='\n'){
//               System.out.println("new line");
//               l++;
//               j=0;
//            }
//            else{
//                temp[l]=temp[l]+Grammer[i];   
//                j++;
//           }
//          }
//         System.out.println(temp[0]);
//         System.out.println(temp[1]);
//         System.out.println(temp[2]);
    }//GEN-LAST:event_ParseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InputT=true;
         FirstFollow obj=new FirstFollow();
        obj.Calculate_Follow(temp,size,InputT);
         this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseGrammer;
    private javax.swing.JTextField FileAddress;
    private javax.swing.JButton Parse;
    private javax.swing.JButton ReadGrammer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
