package slr.project;

import com.sun.org.apache.bcel.internal.classfile.Utility;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFileChooser;


public class GUI extends javax.swing.JFrame {
    
    public char [] Grammer;        
    public String c;
     String temp[];
    public String[]  Grammer_lines;
    public String[][] rules;
    int line_Count;
    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        FileAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BrowseGrammer = new javax.swing.JButton();
        Parse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        First = new javax.swing.JButton();
        Follow = new javax.swing.JButton();
        ParseTableShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("خواندن فایل");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("File Address");

        BrowseGrammer.setText("Browse Grammer");
        BrowseGrammer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseGrammerActionPerformed(evt);
            }
        });

        Parse.setText("Parse Grammer");
        Parse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParseActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        First.setText("First");
        First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstActionPerformed(evt);
            }
        });

        Follow.setText("Follow");
        Follow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FollowActionPerformed(evt);
            }
        });

        ParseTableShow.setText("parse table show");
        ParseTableShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParseTableShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Parse)
                            .addComponent(BrowseGrammer))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(FileAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(First)
                .addGap(27, 27, 27)
                .addComponent(Follow)
                .addGap(37, 37, 37)
                .addComponent(ParseTableShow)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))
                        .addGap(4, 4, 4)
                        .addComponent(FileAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BrowseGrammer)
                        .addGap(27, 27, 27)
                        .addComponent(Parse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(First)
                            .addComponent(Follow)
                            .addComponent(ParseTableShow))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        line_Count=jTextArea1.getLineCount();
        temp=new String[line_Count+1];
        String GrammerArray=jTextArea1.getText();
        //System.out.println(GrammerArray);
        //GrammerArray.indexOf("\n");
        
        GrammerArray=GrammerArray+""+"\n";
        for(int Line=1;Line<line_Count+1;Line++){
       temp[Line]=GrammerArray.substring(0, GrammerArray.indexOf("\n"))+" ";
       GrammerArray=GrammerArray.substring(GrammerArray.indexOf("\n")+1);
        System.out.println(temp[Line]);        
        }
        
         temp[0]="Z --> "+temp[1].substring(0, 1)+" ";
        System.out.print(temp[0]);
            
      

//        
//        for (int i = 0; i < line_Count+1; i++) {            
//           System.out.println();
//             System.out.print(temp[i].length());
//       
//        }
//        
//        
//        for(int i=0;i<line_Count+1;i++){
//            int k=0;
//        for(int j=0;j<temp[i].length();j++){
//        rules[i]=new String[temp[i].length()];
//        rules[i][j]=temp[i].substring(k, k+1);                
//        k++;
//        
//        }
//        
//        }
        
//        for (int i = 0; i < line_Count+1; i++) {            
//            System.out.println();
//       for(int p=0;p<rules[i].length;p++){
//             System.out.print(rules[i][p]);
//       }
//        }
        
//        //Grammer=new char[GrammerArray.length()+1];
//        //Grammer_lines=new String[line_Count+1];
//       //  GrammerArray=Utility.replace(GrammerArray, " ", ".");
//        
//        //Grammer= GrammerArray.toCharArray();
//        
//        //System.out.print(GrammerArray);
//        //System.out.print(Grammer[15]);
//        
//               //System.out.print(Grammer.length);
//        //Grammer[GrammerArray.length()]='\n';
////               Scanner obj=new Scanner();
////              obj.Scan_Grammer();
//
//        rules=new String[line_Count+1][20] ;
//          //ezafe karfane ebarate Z --> S be avvale grammer
//         rules[0][0]="Z";
//         rules[0][1]=" ";
//         rules[0][2]="-";
//         rules[0][3]="-";
//         rules[0][4]=">";
//         rules[0][5]=" ";
//         rules[0][6]=Character.toString(Grammer[0]);
//         rules[0][7]=" ";
//        for (int i = 0; i < line_Count+1; i++) {            
//        for(int p=0;p<rules[i].length;p++)
//             rules[i][p]="0";
//        }
//        
//// araye temp har khat az Grammer ra dar khod zakhire mikoonad.
//// l ro az 1 shoro kardim ta betoonim S --> S' $ ro dar satre avval add konim.
//             int l=1,j=0;
//            
//         for (int i = 0; i < Grammer.length; i++) {          
//           if(Grammer[i]=='\n'){
//               System.out.println("new line");
//               rules[l][j]=" ";
//               l++;
//               j=0;
//            }
//           else{ 
//               if(Grammer[i]=='i') {
//                if(Grammer[i+1]=='d'){
//               rules[l][j]=Character.toString(Grammer[i])+Character.toString(Grammer[i+1]);
//               j++;
//               i++;               
//               }
//                else{}
//                rules[l][j]=Character.toString(Grammer[i]);
//                j++;
//                i++;
//               }                              
//               else{
//                rules[l][j]=Character.toString(Grammer[i]);   
//                j++;
//           }
//          }
//         }
//         rules[l][j-1]=" ";
//      String s=String.valueOf(rules[1]);
//      System.out.println(s);
////         for(int k=0;k<rules[1].length;k++){
////             if(rules[1][k]!="0"){
////             
////             }
////             
////         
////         }
//         
//        //String k=jTextArea1;
////         for (int i = 0; i < line_Count+1; i++) {
////              System.out.println();
////        for(int p=0;p<rules[i].length;p++)
////             System.out.print(rules[i][p]);
////        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

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
       int line_Count=20;
        try{
           c=FileAddress.getText();
           InputStream is = new FileInputStream(c);
           int size = is.available();
           Grammer=new char[size];
           
           for(int i=0;i<size;i++){
               Grammer[i]=(char) is.read();
           }
            is.close();
           }
       catch(IOException e){
           System.out.print("Exception");}
            
        System.out.print(Grammer);   
        Scanner obj=new Scanner();
              obj.Scan_Grammer();
//        
//              temp=new char[line_Count][40] ;
//             int l=0,j=0;
//             
//         for (int i = 0; i < Grammer.length; i++) {          
//           if(Grammer[i]=='\n'){
//               System.out.println("new line");
//               l++;
//               j=0;
//            }
//            else{
//                temp[l][j]=Grammer[i];   
//                j++;
//           }
//          }
//         System.out.println(temp[0]);
//         System.out.println(temp[1]);
         //System.out.println(temp[2]);
    }//GEN-LAST:event_ParseActionPerformed

    private void FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstActionPerformed
        FirstFollow obj=new FirstFollow();
        obj.Calculate_First(temp);
    }//GEN-LAST:event_FirstActionPerformed

    private void FollowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FollowActionPerformed
        FirstFollow obj=new FirstFollow();
        obj.Calculate_Follow();
    }//GEN-LAST:event_FollowActionPerformed

    private void ParseTableShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParseTableShowActionPerformed
        ParseTable obj =new ParseTable();
        
        obj.Point(temp);
        
        
    }//GEN-LAST:event_ParseTableShowActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseGrammer;
    private javax.swing.JTextField FileAddress;
    private javax.swing.JButton First;
    private javax.swing.JButton Follow;
    private javax.swing.JButton Parse;
    private javax.swing.JButton ParseTableShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
