package slr.project;

import com.sun.org.apache.bcel.internal.classfile.Utility;


public class ParseTable {
    String [] ruleTemp;
     String [][] node;
     public void add(){
         
         
     }
     public void Point(String rules[]){
         //ruleTemp yek copy az rules mibashad har vaqt behahim noqte ra jelo bebariim az ruleTemp estefade mikoonim
         // va har vaqt bekhahim meqdar avvalie yek rule ra jagozarii konim az rules estefade mikoonim.
         ruleTemp=rules;
         for(int i=0;i<rules.length;i++){
         node=new String[60][2*rules[i].length()];
         }
         System.out.println();
         System.out.println();
         // farz mikoonim ke bish az 60 ta I nemitavanim dashte bashiim.
         // fasele tarefe chap ra hazf mikoonim.

          
         for(int i=0;i<ruleTemp.length;i++){
         ruleTemp[i]=ruleTemp[i].substring(0, ruleTemp[i].indexOf(" "))+ruleTemp[i].substring( ruleTemp[i].indexOf(" ")+1);
         System.out.println(ruleTemp[i]);         
         }
                System.out.println();
                
         // I0 ra tashkil midahim.
         for(int i=0;i<ruleTemp.length;i++){
         String r=ruleTemp[0].substring(ruleTemp[0].indexOf(".")+1, ruleTemp[0].indexOf(".")+2);
         node[0][0]="0";         
             ruleTemp[i]=ruleTemp[i].substring(0, ruleTemp[i].indexOf(" "))+"."+ruleTemp[i].substring( ruleTemp[i].indexOf(" ")+1);
         System.out.println(ruleTemp[i]);         
         }
         
         // I0 ra dar node[0][] add mikoonim.
         for (int i = 2; i < ruleTemp.length+2; i++) {
             node[0][i]=ruleTemp[i-2];             
         }
         
          System.out.println();
         for (int i = 0; i < ruleTemp.length+2; i++) {
             System.out.println(node[0][i]);             
         }            
          System.out.println();
          
          
          
         //I haye badii ra bayad tashkil bedahiim.
        //in for baraye tamame rule hayeman noqte gozarii ra anjam midahad.
          int nod=1;
          int i=0;
        //  for(int i=0;i<ruleTemp.length;i++){
          // s daraye terminal ya nonterminalist ke bad az . qarar darad.
              String s=ruleTemp[i].substring(ruleTemp[i].indexOf(".")+1, ruleTemp[i].indexOf(".")+2);
         System.out.println(s);
         System.out.println();
         int k=0;
         String temporary=ruleTemp[i];
         temporary=temporary.substring(0, temporary.indexOf("."))+temporary.substring(temporary.indexOf(".")+1);
         temporary=temporary.substring(0, temporary.indexOf(" "))+"."+temporary.substring(temporary.indexOf(" ")); 
         System.out.println(temporary);
         node[nod][k]=String.valueOf(nod);
         k++;
         node[nod][k]=s;
         k++;
         node[nod][k]=temporary;
         k++;
         // in for agar noqte poshte yek NonTerminal bashad moshtaqate an ra dar I jarii add mikoonad.
        for(int j=0;j<ruleTemp.length;j++ )            
            //in shart check mikoonad ke s ba tarafe raste kodam yek az rule ha barabar ast.
         if(s == null ? node[0][j].substring(0, 1) == null : s.equals(node[0][j].substring(0, 1))){
             
         node[nod][k]=node[0][j];
         k++;
         // in tabe 3 argoman darad avvali haman nonterminalist ke noqte poshte an asat
         // 2omi shomare I an hast. va 3omi shomare         
          Nonterminal(s,nod,k);
         
//             String temporary=ruleTemp[j];
//         temporary=temporary.substring(0, temporary.indexOf("."))+temporary.substring(temporary.indexOf(".")+1);
//         temporary=temporary.substring(0, temporary.indexOf(" "))+"."+temporary.substring(temporary.indexOf(" "));         
//         
         
         }
        System.out.println(node[nod][0]+"  "+node[nod][1]+"  "+node[nod][2]);
     //   }                                            
      
}

   
     public void Nonterminal(String s,int i,int k){
         
         for(int j=0;j<ruleTemp.length;j++){
         if(s == null ? node[0][j].substring(0, 1) == null : s.equals(node[0][j].substring(0, 1)))
         {
              node[i][k]=node[0][j];
              k++;
              String str=node[0][j].substring(node[0][j].indexOf(".")+1,node[0][j].indexOf(".") +2);
              if(s==str){              
              }
              else{
                  Nonterminal(str, i, k);
              }
            
                 
        
//         temporary=temporary.substring(0, temporary.indexOf("."))+temporary.substring(temporary.indexOf(".")+1);
//         temporary=temporary.substring(0, temporary.indexOf(" "))+"."+temporary.substring(temporary.indexOf(" ")); 
              
         }
     }
     }
}
