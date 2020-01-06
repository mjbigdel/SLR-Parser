package slr.project;

import com.sun.org.apache.bcel.internal.classfile.Utility;
import java.util.StringTokenizer;


public class ClusureCreate {
    String [] ruleTemp;  
    String Noqte_Posht[];
     String [][] node;
     int nod=1;
     int h=0;
     String tempNonTerminal[];
      char [] NonTerm;
       String node0[];
       int All;
       String movePoint="";
       int noP=0;
       String coreTemp="";
        String coreTemp1[];
       // char [] movechar;
          String NTerminal[];  
     public void Point(String rules[],String Nonterminal[],String Terminals[],String First[][],String Follow[][],boolean InputT){               
         Noqte_Posht=new String[30];
         tempNonTerminal=new String[rules.length];
         for (int i = 0; i < rules.length; i++) {
            tempNonTerminal[i]=rules[i].substring(0, 1);
         }
         System.out.println();
         // be jaye anasoore tekrarii % migozariim.
       for(int q=0;q<tempNonTerminal.length;q++){
             String t=tempNonTerminal[q];           
             for(int a=q+1;a<tempNonTerminal.length;a++){
                 if(t.compareTo(tempNonTerminal[a])==0){
                tempNonTerminal[a]="%";
                 }                     
             }
         }
        System.out.println();
        for(int q=0;q<tempNonTerminal.length;q++){
                    // System.out.println(tempNonTerminal[q]);
        }
         System.out.println();
          System.out.println();
           System.out.println();
// NonTerminal ha ra morattab mikoonim.
       for(int t=0;t<tempNonTerminal.length;t++)
        for(int q=0;q<tempNonTerminal.length;q++){
             if(tempNonTerminal[q].compareTo("%")==0){
                 for(int p=q;p<tempNonTerminal.length-1;p++){
                     tempNonTerminal[p]=tempNonTerminal[p+1];
                 }
             }
         } 
        for(int q=0;q<tempNonTerminal.length;q++){
                  //   System.out.println(tempNonTerminal[q]);
        }
         System.out.println();
          System.out.println();
           System.out.println();
           
           
// nonterminal ha ra behine mikoonim.
         String tempnoqte="";
         for(int x=0;x<tempNonTerminal.length;x++)
         {
             if(!tempnoqte.contains(tempNonTerminal[x]))
             {
             tempnoqte=tempnoqte+tempNonTerminal[x]+" ";
             } 
             else
             {                 
             }
         }
         if(!tempnoqte.contains("%"))
         { 
         }
         else
         {
             tempnoqte=tempnoqte.substring(0,tempnoqte.indexOf("%"));
         }
         System.out.println(tempnoqte);
          System.out.println();
           System.out.println();
            System.out.println();
//  AllNonTerminal ke Daraye hame  NonTerminal ha mibashad.
          //tempnoqte=tempnoqte.substring(0,tempnoqte.indexOf("%"));                          
             StringTokenizer tokens0 = new StringTokenizer( tempnoqte );
             NTerminal=new String[tokens0.countTokens()];
             int TerminalCount2=0;
             while ( tokens0.hasMoreTokens() ){                           
                             String str=tokens0.nextToken();
                            NTerminal [TerminalCount2]=str;                                                         
                            TerminalCount2++;
                }
                  
         for(int i=0;i<NTerminal.length;i++)
         System.out.print(NTerminal[i]);
         
//System.out.println(tempNonTerminal);
         //NonTerm=tempNonTerminal.toCharArray();
         node0=new String[rules.length];
         for(int j=0;j<rules.length;j++)
         node0[j]="% ";
         
//ruleTemp yek copy az rules mibashad har vaqt behahim noqte ra jelo bebariim az ruleTemp estefade mikooni
// va har vaqt bekhahim meqdar avvalie yek rule ra jagozarii konim az rules estefade mikoonim.
         ruleTemp=rules;
         for(int i=0;i<rules.length;i++){
         node=new String[100][2*rules[i].length()];
         }
// node0 ke dar an . darebteda qarar darad ra ttashkil midahiiim.         
        
         for (int i = 0; i < 100; i++) {
             for (int j = 0; j < node[i].length; j++) {
                 node[i][j]="% ";
             }
         }
         System.out.println();
         System.out.println();
// farz mikoonim ke bish az 60 ta I nemitavanim dashte bashiim.
         
// fasele tarefe chap ra hazf mikoonim.         
         for(int i=0;i<ruleTemp.length;i++){
         ruleTemp[i]=ruleTemp[i].substring(0, ruleTemp[i].indexOf(" "))+ruleTemp[i].substring( ruleTemp[i].indexOf(" ")+1);
        // System.out.println(ruleTemp[i]);         
         }
                System.out.println();
                
         // I0 ra tashkil midahim.
         for(int i=0;i<ruleTemp.length;i++){                
             ruleTemp[i]=ruleTemp[i].substring(0, ruleTemp[i].indexOf(" "))+"."+ruleTemp[i].substring( ruleTemp[i].indexOf(" ")+1);
        // System.out.println(ruleTemp[i]);         
         }
         
         // an ra dar node0 add mikoonim.
         for (int i = 0; i < ruleTemp.length; i++) {
             node0[i]=ruleTemp[i];             
            // System.out.println(node0[i]);
         }                    
               
        String s="";
        String temps=rules[0];
        s=temps.substring(temps.indexOf(".")+1, temps.indexOf(".")+2); 
                // System.out.println(s);                 
        node[0][0]=rules[0];
         
        System.out.println();                 
        System.out.println();
            
        Nonterminal(s, 0, 1);
        
            nodeBase( node, 0, nod);

          for(int g=0;g<node.length;g++){
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
              if("%".equals(node[g][0]) || node[g][0]==null)
              {
              } 
              else 
              {
                  for(int q=0;q<node[0].length;q++){
                      
                      System.out.println(node[g][q]);
                  }
              }
          }
          System.out.println(All);
          
          ParseTableCreate obj2=new ParseTableCreate();
         obj2.Create(node,Nonterminal,Terminals,First,Follow,rules,InputT);
          
    }
// ==========================================================================================
//------------------------------------------------------------------------------------------------
     
          public void nodeBase(String node[][],int u ,int n){
              if(u>10){
                  return;
              }
              else{
          //alan ma node[0] ra varede tabee kardeyiim...............          
         //I haye badii ra bayad tashkil bedahiim.
        //in for baraye tamame rule hayeman noqte gozarii ra anjam midahad.
          String noqte[]=new String[node[u].length];
          
          for(int q=0;q<node[u].length;q++){
              if(node[u][q].endsWith(".")){
                  noqte[q]="%";
              }
              else{
              noqte[q]=node[u][q].substring(node[u][q].indexOf(".")+1, node[u][q].indexOf(".")+3);              
          }
          }
         for(int q=0;q<noqte.length;q++){
             String temp=noqte[q];          
             for(int a=q+1;a<noqte.length;a++){
                 if(temp.compareTo(noqte[a])==0){
                noqte[a]="%";
                 }                     
             }
         }
// morattab kardan  --------------------------- .       
          for(int t=0;t<noqte.length;t++)
         for(int q=0;q<noqte.length;q++){
             if(noqte[q].compareTo("%")==0){
                 for(int p=q;p<noqte.length-1;p++){
                     noqte[p]=noqte[p+1];
                 }
             }
         }
//---------------------------------------------         
         String tempnoqte="";
         for(int x=0;x<noqte.length;x++){
             tempnoqte=tempnoqte+noqte[x];
         }         
         tempnoqte=tempnoqte.substring(0,tempnoqte.indexOf("%"));
         tempnoqte=tempnoqte+" ";
         System.out.println(tempnoqte);
         String Movestr[];
           StringTokenizer tokens0 = new StringTokenizer( tempnoqte );
             Movestr=new String[tokens0.countTokens()];
             
             int move=0;
             while ( tokens0.hasMoreTokens() ){                           
                             String str=tokens0.nextToken();
                            Movestr [move]=str;                                                         
                            move++;
                }                          
             for(int t=0;t<Movestr.length;t++){
             nodeCreate(node,u,Movestr[t], n);                        
                n=nod;
             }                                      
             h=0;                
               
             
             while(true)
             {  
                    System.out.println("coreTemp While  "+coreTemp);
                    StringTokenizer tokens2 = new StringTokenizer( coreTemp,"%" );
                    coreTemp="";
                    
                 coreTemp1=new String[tokens2.countTokens()];
                 int ww=0;
                 while (tokens2.hasMoreTokens()) {
                     
                     String qq=tokens2.nextToken();
                     qq=qq.substring(0,qq.lastIndexOf(" "));
                     coreTemp1[ww]=qq;                    
                //     System.out.println(coreTemp1[ww]);
//                     System.out.println(ww);
                     ww++;
                 }
// Noqte ra dar CoreTemp jeloo mibariim.
               for(int aa=0;aa<coreTemp1.length;aa++){
                 coreTemp1[aa]=coreTemp1[aa].substring(0,coreTemp1[aa].indexOf(".")) + coreTemp1[aa].substring(coreTemp1[aa].indexOf(".")+1);
                 coreTemp1[aa]=coreTemp1[aa].substring(0,coreTemp1[aa].indexOf(" ") )+"."+coreTemp1[aa].substring(coreTemp1[aa].indexOf(" ")+1 );
                  System.out.println(coreTemp1[aa]);
                 
             }
               
               String MovepointArray[]=new String[movePoint.length()/3+1]; 
              StringTokenizer tokens3 = new StringTokenizer( movePoint);
              int aaa=0;
               while(tokens3.hasMoreTokens()){
                   MovepointArray[aaa]=tokens3.nextToken();
                   aaa++;
                   
               }
               MovepointArray[movePoint.length()/3]=" ";
//               System.out.println("=----------------------------------------------------");
//               System.out.println(MovepointArray.length);
               //System.out.println(movePoint.length());
               for(int yy=0;yy<MovepointArray.length-1;yy++){
                   for (int i = yy+1; i < MovepointArray.length-1; i++) {
                       if(MovepointArray[yy] == null ? MovepointArray[i] == null : MovepointArray[yy].equals(MovepointArray[i])){
                           MovepointArray[i]=MovepointArray[i+1];
                       }
                   }
                  
               }
                for(int yy=0;yy<MovepointArray.length;yy++){
////                System.out.println(MovepointArray[yy]);
                }
//               System.out.println("=----------------------------------------------------");
               
               if(MovepointArray.length<2)
               {
                   break;
               }
               else
               {
                String movepointTemp=movePoint;
                movePoint="";
              
                if(!"".equals(movepointTemp)){
                   String Movestr2[];
           StringTokenizer tokens1 = new StringTokenizer( movepointTemp );
             Movestr2=new String[tokens1.countTokens()];
             int I[]=new int[tokens1.countTokens()];
             int move1=0;
             while ( tokens1.hasMoreTokens() ){                           
                 
                             String str=tokens1.nextToken();
                             
                           //  int t=Integer.parseInt(tokens1.nextToken());
                            Movestr2 [move1]=str;                                                         
                           // I[move1]=t;
                            move1++;
                }
             
             String Movestr1[]=new String[Movestr2.length];
             
             for(int f=0;f<Movestr1.length;f++){
                 char [] v=new char[2];
                 v=Movestr2[f].toCharArray();
                 Movestr1[f]=Movestr2[f].substring(0, 1);
                 I[f]=Integer.parseInt(Movestr2[f].substring(1));
            System.out.println(Movestr1[f]+ "  movestr "+I[f]);
             }


              
                 boolean newState=true; 
              for(int c=0;c<Movestr1.length;c++){
                   
                  for(int y=0;y<I.length;y++){                      
                   for(int k=0 ;k<node[0].length ;k++ ){                      
                           if(node[y][k].contains(coreTemp1[c]))
                           {
                               // I jadidi tolid nakoom
                               newState=false;
                               System.out.println(" NaaaaaaaaaaaDaaaaaaaaaaaaaaaaariiiiiiiiiiiiim");
                                       
                           }
                           else
                           {
                              
                           }
                       }
                   }
                  if(newState && !" ".equals(Movestr1[c])){
                      System.out.println("core = "+ coreTemp1[c]);
                      System.out.println("#nod = "+nod);                                     
                     
                      nodeCreate(node,I[c],Movestr1[c], nod);             
                       //node[nod][0]=coreTemp1[c];
                            n=nod;
                            
                            
                             System.out.println("after core nod: "+ nod);
                  }                  
              }              
//                 System.out.println("=============");
//                 System.out.println(movePoint);
//                 System.out.println("============");
                 
             }
            
            }
             
             } 
     }  
          }
          
          
// ====================================================================================
// ------------------------------------------------------------------------------------          
     public void nodeCreate(String node[][],int u,String noqte,int no){
         All++;         
         int k=0;
         noP=0;
          String Stemp=""; 
          
           for(int a=0;a<node[u].length;a++){
                if(node[u][a].endsWith("."))
                {
                    
                }
                else
                {                    
             String t=node[u][a].substring(node[u][a].indexOf(".")+1, node[u][a].indexOf(" "));  
             String n=noqte;
//             System.out.println("t : "+t);
//             System.out.println("n : "+n);
               if(t.compareTo(n)==0){
         String temporary=node[u][a];
         temporary=temporary.substring(0, temporary.indexOf("."))+temporary.substring(temporary.indexOf(".")+1);
         temporary=temporary.substring(0, temporary.indexOf(" "))+"."+temporary.substring(temporary.indexOf(" ")+1);
         temporary=temporary+" ";      
             node[no][k]=temporary ;
               k++;
                          
                   if(temporary.endsWith(".")){}
                else{
                      String dd=temporary.substring(temporary.indexOf(".")+1, temporary.indexOf(".")+2); 
                 Stemp =Stemp+ dd;               
                 String q=Stemp.substring(Stemp.lastIndexOf("")-1,Stemp.lastIndexOf("") );

                   if(Stemp.startsWith("%")){                       
                   }
                   else{
                       
                       if(!" ".equals(q)){
                       Noqte_Posht[noP]=q;
                       noP++;                       
// move point noqat va shomare I ra baraye I haye badi be ma midahad.                       
                       movePoint=movePoint+q+String.valueOf(no)+" ";                                                                  
                       coreTemp=coreTemp+temporary+"%";
                       }
                       else{}
                   }                             
                 for(int w=0;w<NTerminal.length;w++){
                 if(NTerminal[w].contains(q)) {                    
                     Nonterminal(q , no, k);
                 } else {                  
                 }                  
              }
                   }
             // } 
            
               }
               
               
           }
                
                
     }         
           System.out.print("movepoint ==== "+movePoint);
            System.out.println("     coretemp nowwww ==== "+coreTemp);
           
         nod++;
         System.out.println(nod);
     }
     public void Nonterminal(String s,int no,int k){       
        for (String item : node0) {
            if (s == null ? item.substring(0, 1) == null : s.equals(item.substring(0, 1))) {
                if (s == null ? node0[0] == null : s.equals(node0[0].substring(0,1))) {
                } else {
                    node[no][k] = item;
                    k++;
                    String str = item.substring(item.indexOf(".") + 1, item.indexOf(".") + 2);
                    if(s == null ? str == null : s.equals(str)){
                    }
                    else{
                        //char schar[]=str.toCharArray();
                        for(int w=0;w<NTerminal.length;w++){
                            if(NTerminal[w].contains(str)) {
                                Nonterminal(str, no, k);                  
                            }
                            else {
                            }
                        }
                    }
                }
            }
        }
     }
}
