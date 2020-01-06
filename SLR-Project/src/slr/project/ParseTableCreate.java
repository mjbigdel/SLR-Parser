
package slr.project;


public class ParseTableCreate {
  ClusureCreate obj=new ClusureCreate();
  FirstFollow obj2=new FirstFollow();
  String Clusure[][];
  String Table[][];
  String TableHead[];
  public void Create(String node [][],String Nonterminals[],String Terminals[],String First[][],String Follow[][],String rules[],boolean InputT){
      int I=0;
      //System.out.println(node[0][0]);
     
      for(int i=0;i<node.length;i++)
          for(int j=i+1;j<node.length;j++){
              if(node[i][0] == null ? node[j][0] == null : node[i][0].equals(node[j][0])){
                  node[j][0]="% ";                  
              }                                  
      }
      
      for(int i=0;i<node.length;i++){
          if(!"% ".equals(node[i][0])){              
              System.out.println(node[i][0]);
           //System.out.println("okay");
          I++;
          }
          }
      System.out.println(I);
      Clusure=new String[I][node[I].length];
      
      for(int i=0;i<I;i++)
          for(int j=0;j<node[i].length;j++){                       
             Clusure[i][j]=node[i][j]+"  ";
          }
       
      for(int i=0;i<I;i++){
          System.out.println();
          for(int j=0;j<node[i].length;j++){                       
              Clusure[i][j]=Clusure[i][j].substring(0,Clusure[i][j].lastIndexOf(" "));
             System.out.print(Clusure[i][j]+" ");
          }
      }
      int count=0;
      Table=new String[I+1][2+Nonterminals.length+Terminals.length];
      TableHead=new String[2+Nonterminals.length+Terminals.length];
      for (int i = 0; i < Table.length; i++) {
          for(int u=0;u<Table[0].length;u++){
              Table[i][u]="  ";
          }              
      }
      System.out.println(TableHead.length);
      TableHead[count]="I";
      count++;
      for(int i=0;i<Terminals.length;i++){
          TableHead[count]=Terminals[i];
          count++;
      }
      TableHead[count]="$";
      count++;
      TableHead[count]="&";
      count++;
      
        for(int i=1;i<Nonterminals.length;i++){
          TableHead[count]=Nonterminals[i];
          count++;
      }
        
        System.out.println();
        for(int i=0;i<TableHead.length;i++){
           System.out.print(TableHead[i]+" ");
        }
        
        System.out.println();
        for (int i = 0; i < Table.length; i++) {
          Table[i][0]=String.valueOf(i);
        //  System.out.println(Table[i][0]);
      }
        
        
//        System.out.println("Action Goto : ==");
//        for (int i = 1; i < ActionGoto.length; i++) {
//        System.out.println(ActionGoto[i]);
//        }
        String temp;
        String temp2;
        String MovState;
        String rulString;
        String rulString1;
        int p=0;
        
        for(int i=0;i<I;i++){
          System.out.println();
          for(int j=0;j<node[i].length;j++){                       
              Clusure[i][j]=Clusure[i][j].substring(0,Clusure[i][j].lastIndexOf(" "));
             System.out.println(Clusure[i][j]);
          }
      }
String SRGOTO="";
        String ValueGOTO="";
        String End;
        for(int i=0;i<Clusure.length;i++){            
           // SRGOTO="";
        for(int j=0;j<Clusure[i].length;j++){
             String SGnumHistory=" ";
            if(!Clusure[i][j].contains("%")){
                if(Clusure[i][j].endsWith(".  ") || Clusure[i][j].endsWith(". ") || Clusure[i][j].endsWith(".   "))
                {
                    System.out.println(" =================== "+Clusure[i][j]);
                   End=Clusure[i][j].substring(0, 1);
                   for(int u=0;u<Nonterminals.length;u++){
                       if(Nonterminals[u] == null ? End == null : Nonterminals[u].equals(End))
                           p=u;                       
                       
                   }
                  
                   System.out.println("# NT " + p);
                   
                   if("Z".equals(End)){
                       int acc=1+Terminals.length;
                  // Table[i][1+Terminals.length]="acc";
                        SRGOTO=SRGOTO+i+" "+acc+"-";
                        ValueGOTO=ValueGOTO+"acc"+"-";
                   }
                   else
                   {                      
                   for(int y=0;y<Follow[p].length;y++){
                       for(int q=0;q<Table[i].length;q++){
                           if(Follow[p][y] == null ? TableHead[q] == null : Follow[p][y].equals(TableHead[q])){
                              System.out.println("okay  ===  "+Follow[p][y]);  
                               //Table[i][q]=Follow[p][y];
                            rulString= Clusure[i][j];
                            rulString=rulString.replace(".", "");
                            rulString=rulString.replace(" ", "");
                            //System.out.println(rulString);
                            for(int h=0;h<rules.length;h++){
                                rulString1=rules[h];
                                rulString1=rulString1.replace(".", "");
                                rulString1=rulString1.replace(" ", "");
                                //System.out.println(rulString1);
                                if(rulString1 == null ? rulString == null : rulString1.equals(rulString))
                                {
                                //    Table[i][q]="R"+h;
                                    SRGOTO=SRGOTO+i+" "+q+"-";
                                    ValueGOTO=ValueGOTO+"R"+h+"-";
                                     System.out.println("yeeees");
                                }
                            }
                                    
                           }
                       }
                       
                   }
                   }
                }
                else{
                    int SGnum=0;
                   
             // temp2=Clusure[i][j].substring(1);
             temp=Clusure[i][j].substring(Clusure[i][j].indexOf(".")+1,Clusure[i][j].indexOf(".")+2 );
            System.out.println(temp);
            MovState=Clusure[i][j];
            
            MovState=Clusure[i][j].replace(".", " ");
            MovState=MovState.substring( 0,MovState.indexOf(" ") )+MovState.substring(MovState.indexOf(" ")+1);
            temp2=MovState.substring(1);
            temp2=temp2.substring(0, temp2.indexOf(" "))+"."+temp2.substring(temp2.indexOf(" ")+1);
            MovState=Clusure[i][j].substring(0,1)+temp2;
            //System.out.println(temp2);
            MovState=MovState.replace(" ","");
            System.out.println(MovState);
            String ClusureTemp;
            
            
            
            System.out.println("teeemppp  ===== "+temp);
            //System.out.println("okay");
           for(int f=0;f<Clusure.length;f++){
               for(int e=0;e<Clusure[i].length;e++){
                   ClusureTemp=Clusure[f][e];
                   ClusureTemp=ClusureTemp.replace(" ","");
                   //System.out.println(ClusureTemp);
                  
                   if(ClusureTemp == null ? MovState == null : ClusureTemp.equals(MovState))
                   {
                       if(!SGnumHistory.contains(temp)){
                            SGnumHistory=SGnumHistory+temp;
                         System.out.println("okay");
                       SGnum=f;
                       System.out.println("SGnumn + "+SGnum);  
                       }                                              
                       
                   }else{}
                }
            }
           
           
                 for(int k=0;k<Terminals.length;k++)
                  if(Terminals[k] == null ? temp == null : Terminals[k].equals(temp))
                  {
                    for(int g=0;g<Table[i].length;g++){
                    if(TableHead[g] == null ? temp == null : TableHead[g].equals(temp))
                    {
                          //Table[i][g]="S"+SGnum;
                        SRGOTO=SRGOTO+i+" "+g+"-";
                        ValueGOTO=ValueGOTO+"S"+SGnum+"-";
                    }
                }
                
                
            }
                  for(int r=1;r<Nonterminals.length;r++){
                    if(Nonterminals[r] == null ? temp == null : Nonterminals[r].equals(temp))
                    {
                       for(int g=0;g<Table[i].length;g++){
                        if(TableHead[g] == null ? temp == null : TableHead[g].equals(temp))
                        {
                        //Table[i][g]=String.valueOf(SGnum);
                            SRGOTO=SRGOTO+i+" "+g+"-";
                            ValueGOTO=ValueGOTO+SGnum +"-";
                    }
                    } 
                    }
                
            }
           
            
            }
            }
        }                                
  }
        System.out.println(" SRGOTO = "+SRGOTO);
        System.out.println(" ValueGOTO = "+ValueGOTO);
        
// SRGOTO Tamame khanehayii ke GOTO & shift & REduce darand ra darast. table[ , ]=--       
// method split bar asase yek reshte manand "-" anasore reshte ra be soorate yek araye dar miavarad.
// in method anasoore dakhel ra sort ham mikoonad. va be tartib da khanehaye 0 ...n qarar midahad.        
        String SH_RE_GOTO[];
        String ValGOTO[];
        SH_RE_GOTO=SRGOTO.split("-");
        ValGOTO=ValueGOTO.split("-");
         for(int w=0;w<SH_RE_GOTO.length;w++){
            System.out.print(SH_RE_GOTO[w]+ValGOTO[w]+" | ");
        }
         
         
// be jaye anasoore tekrarii % migozariim.          
       for(int q=0;q<SH_RE_GOTO.length;q++){
             String t=SH_RE_GOTO[q];           
             String v=ValGOTO[q];
             for(int a=q+1;a<SH_RE_GOTO.length;a++){
                 if(t.compareTo(SH_RE_GOTO[a])==0 ){
                SH_RE_GOTO[a]="%";
                 }                     
             }
         }
// baraye halle moshkele Goto table ke anasoore badi roye anasoore qabli copy nashan.
     
       
       
//// be jaye anasoore tekrarii % migozariim.                  
// SGRGOTO tamame anasoore jadvale parse Table ra darad.

//  SH_RE_GOTO arayeyis ke charakterhaye an dara ye ettelaati rajebe jadvale parse mibashand.
// har khane an be in sorat ast masalan 15S5  --> Table[1][5]=S5
        
       
        for(int d=0;d<SH_RE_GOTO.length-1;d++){
            if(SH_RE_GOTO[d] == null ? SH_RE_GOTO[d+1] == null : SH_RE_GOTO[d].equals(SH_RE_GOTO[d+1])){
                //SH_RE_GOTO[d+1]="%";
                ValGOTO[d+1]="%";                    
                SH_RE_GOTO[d+1]="%";
                }                        
        }
        
         System.out.println("==================");
         System.out.println("Not Acceptable: ");
        for(int q=0;q<SH_RE_GOTO.length;q++){
                     System.out.print(SH_RE_GOTO[q]+ValGOTO[q]+" | ");
                     
        }
        
        for(int t=0;t<SH_RE_GOTO.length;t++)
        for(int q=0;q<SH_RE_GOTO.length;q++){
             if(SH_RE_GOTO[q].compareTo("%")==0){
                 for(int ss=q;ss<SH_RE_GOTO.length-1;ss++){
                     SH_RE_GOTO[ss]=SH_RE_GOTO[ss+1];
                     ValGOTO[ss]=ValGOTO[ss+1];
                     
                 }
             }
         }
        
        
        System.out.println("==================");
         System.out.println("Acceptable: ");
        for(int q=0;q<SH_RE_GOTO.length;q++){
                     System.out.print(SH_RE_GOTO[q]+ValGOTO[q]+" | ");
                     
        }
        
        int state;
        String stateString;
        String headstrString;
        int head;
        String value;
        
        for(int sr=0;sr<SH_RE_GOTO.length;sr++){
            stateString=SH_RE_GOTO[sr].substring(0,SH_RE_GOTO[sr].indexOf(" "));
           state=Integer.parseInt(stateString);
            headstrString=SH_RE_GOTO[sr].substring(SH_RE_GOTO[sr].indexOf(" ")+1) ;
           head= Integer.parseInt(headstrString );
           
           value=ValGOTO[sr];
           Table[state][head]=value;
        }
                                         
                                  
        
//        for(int w=0;w<TableHead.length;w++){
          
//        }

        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for(int w=0;w<Table.length;w++){
            System.out.println();
        for(int v=0;v<Table[w].length;v++){
            System.out.print(Table[w][v]+" | ");
        }
        }
//        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
       // FirstFollow objFirstFollow=new FirstFollow();
        for (int i = 0; i < Nonterminals.length; i++) {
        System.out.print(i+" "+Nonterminals[i]+"     ");
          
      }
              for (int i = 0; i < node.length; i++) {
        System.out.print(i+" "+ node[i][0]+"     ");
          
      }
        System.out.println();
        
         System.out.print(SH_RE_GOTO.length+"   "+ Table.length+"   "+I+ "   "+ node.length);
        Input objInput=new Input(InputT,Table,TableHead,Nonterminals,Follow,rules);
      
  }
                          
}
