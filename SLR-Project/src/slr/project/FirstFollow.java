
package slr.project;

import java.util.StringTokenizer;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

// # haman meqdare null mibashad.
public class FirstFollow {
    
//GUI obj =new GUI();
public String []AllNonTerminals;// hame Nonterminal ha ra darad.
public String[] NonTerminals;// A , B ,C ..
public String AllTerminal[]; // hame terminal ha ra darad.
public String [] Terminals=null; //a , b , id , + ,...
String Tempcopy[];
String fir[][];
String[][] follTemp;
String foll[][];
String prod[];
int t;
  String FFhistory ="";
  int Pnum1 = 0;
  int Pnum2 = 0;
String AllTerm;
    public FirstFollow() {        
        
    }
//==============================================================    
                      //mohasebe first    
//==============================================================    
    public void Calculate_First(String temp[],int size){
        
// Calculate Nontermial And Terminal.
        prod=new String[temp.length];
        for (int c = 0; c < temp.length; c++) {
            prod[c]=temp[c];
        }
        Tempcopy=new String[temp.length];       
        NonTerminals=new String[temp.length];
// baraye jeloogiri az nullPointer Terminal hara avval hame ra ba % por mikoonim.        
        Terminals=new String[size];
        for(int i=0;i<Terminals.length;i++){
            Terminals[i]="%";
        }
         for(int i=0;i<temp.length;i++){
             NonTerminals[i]=temp[i].substring(0, 1);           
         } 
         System.out.println();
// be jaye anasoore tekrarii % migozariim.
       for(int q=0;q<NonTerminals.length;q++){
             String t=NonTerminals[q];           
             for(int a=q+1;a<NonTerminals.length;a++){
                 if(t.compareTo(NonTerminals[a])==0){
                NonTerminals[a]="%";
                 }                     
             }
         }
        System.out.println();
        for(int q=0;q<NonTerminals.length;q++){
                     System.out.println(NonTerminals[q]);
        }
         System.out.println();
          System.out.println();
           System.out.println();
// NonTerminal ha ra morattab mikoonim.
       for(int t=0;t<NonTerminals.length;t++)
        for(int q=0;q<NonTerminals.length;q++){
             if(NonTerminals[q].compareTo("%")==0){
                 for(int p=q;p<NonTerminals.length-1;p++){
                     NonTerminals[p]=NonTerminals[p+1];
                 }
             }
         } 
        for(int q=0;q<NonTerminals.length;q++){
                     System.out.println(NonTerminals[q]);
        }
         System.out.println();
          System.out.println();
           System.out.println();
           
           
// nonterminal ha ra behine mikoonim.
         String tempnoqte="";
         for(int x=0;x<NonTerminals.length;x++)
         {
             if(!tempnoqte.contains(NonTerminals[x]))
             {
             tempnoqte=tempnoqte+NonTerminals[x]+" ";
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

             StringTokenizer tokens0 = new StringTokenizer( tempnoqte );
             AllNonTerminals=new String[tokens0.countTokens()];
             int TerminalCount2=0;
             while ( tokens0.hasMoreTokens() ){                           
                             String str=tokens0.nextToken();
                            AllNonTerminals [TerminalCount2]=str;                                                         
                            TerminalCount2++;
                }
                  
         for(int i=0;i<AllNonTerminals.length;i++)
         System.out.println(AllNonTerminals[i]);
         
// MIKHAHIM HAME Terminal ha ra be dast avariim.        
// yek copy az temp ijad mikoonim.
         for(int i=0;i<Tempcopy.length;i++){
         Tempcopy[i]=temp[i];
         }
         for(int i=0;i<Tempcopy.length;i++){
             Tempcopy[i]=Tempcopy[i].substring(0, Tempcopy[i].length()-1);
         }
     

// ebteda hame tokenha ra estekhraj mikoonim.         
         int TerminalCount=0;
         for(int i=0;i<Tempcopy.length;i++){
             
             StringTokenizer tokens = new StringTokenizer( Tempcopy[i] );
             while ( tokens.hasMoreTokens() ){
                           //  System.out.println(tokens.nextToken());
                             String str=tokens.nextToken();
                             Terminals[TerminalCount]=str;
                             TerminalCount++;
                            
                }          
         }
              System.out.println();
              System.out.println();
              System.out.println();

// Token haye tekrari ra hazf mikoonim.
// be jaye anasoore tekrarii % migozariim.
              
              for(int q=0;q<Terminals.length;q++){
             String t=Terminals[q];           
             for(int a=q+1;a<Terminals.length;a++){
                 if(t.compareTo(Terminals[a])==0){
                Terminals[a]="%";
                 }                     
             }
         }
      
// Terminal ha ra morattab mikoonim.
              for(int t=0;t<Terminals.length;t++)
        for(int q=0;q<Terminals.length;q++){
             if(Terminals[q].compareTo("%")==0){
                 for(int p=q;p<Terminals.length-1;p++){
                     Terminals[p]=Terminals[p+1];
                 }
             }             
         } 
        
   
// Terminal ha ra behine mikoonim.
         String tempTerm="";
         for(int x=0;x<Terminals.length;x++){
             tempTerm=tempTerm+Terminals[x]+" ";
         } 
//  allTerminal ke Daraye hame  Terminal ha va NonTerminal hast        
         String TempTerminals[];
          tempTerm=tempTerm.substring(0,tempTerm.indexOf("%"));                          
             StringTokenizer tokens = new StringTokenizer( tempTerm );
             TempTerminals=new String[tokens.countTokens()];
             int TerminalCount1=0;
             while ( tokens.hasMoreTokens() ){                           
                             String str=tokens.nextToken();
                            TempTerminals [TerminalCount1]=str;                                                         
                            TerminalCount1++;
                }
             
             String Term="";
               for(int x=0;x<TempTerminals.length;x++){
                   if("-->".equals(TempTerminals[x]))
                   {
                   }
                   else
                   {
                       Term=Term+TempTerminals[x]+" ";
                   }
                
                 } 
                  //System.out.println(Term);
        
//           System.out.println(tempnoqte); 
               
// tempnoqte yek reshte hastt ke shamele hame Nonterminal ha mibashad.         
           AllTerminal=new String[TempTerminals.length-AllNonTerminals.length-1];

           int p=0;
          StringTokenizer tokens2 = new StringTokenizer( Term );
           while ( tokens2.hasMoreTokens() ){                           
                             String str=tokens2.nextToken();
                           //  System.out.println(str);
                            if(tempnoqte.indexOf(str)!=-1){
                                
                            }
                            else{
                                AllTerminal[p]=str;
                                p++;
                            }
                }
          for(int q=0;q<AllTerminal.length;q++){
           System.out.println(AllTerminal[q]);
       }
          
       
//--------------------------------------------------------------------------------------
                                // shoroe mohasebe First.
//======================================================================================
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println();
          
          fir=new String[AllNonTerminals.length][10*AllTerminal.length+1];          
          follTemp=new String[AllNonTerminals.length][10*AllTerminal.length+1];
          foll=new String[AllNonTerminals.length][AllTerminal.length+1];
          
            for(int q=1;q<AllNonTerminals.length;q++) {
                for(int kkk=0;kkk<foll[q].length;kkk++){
                    foll[q][kkk]=" ";
                }
            }
          
      for(int q=1;q<AllNonTerminals.length;q++)          
      first_of(AllNonTerminals[q],q,0);       
      
      
         // System.out.println(AllNonTerminals[1]);
          for(int q=1;q<AllNonTerminals.length;q++){
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println(q);

        for(int k=0;k<AllNonTerminals.length;k++){
            
                    System.out.println(fir[q][k]);                            
        }
          }
          
          
         }
// Tashkhis terminal boodan.         
    boolean Terminal(String x)
    {
    for(int i=0;i<AllTerminal.length;i++)
    if(AllTerminal[i] == null ? x == null : AllTerminal[i].equals(x))
    return(true);
    return(false); 
    }
//tashkhise Non Terminal boodan.
    boolean NonTerminal(String x)
    {
    for(int i=0;i<AllNonTerminals.length;i++)
    if(AllNonTerminals[i]==x)
    return(true);
    return(false);
    }
    //=====================================
    //======================================
    void first_of(String s, int q,int number) {
        int t2 = number;
        int i;
        String x,n;
        n=s;
// first [0] khalii mibashad.================================
        for (i = 1; i < prod.length; i++) {
            if (prod[i].substring(0, 1).contains(n))
            {
                StringTokenizer tokens0 = new StringTokenizer( prod[i] );
                tokens0.nextToken();
                tokens0.nextToken();
               x=tokens0.nextToken();
               // System.out.println(x);
                if(x == null ? n == null : x.equals(n)){}
                else{
                  //   System.out.println(x);
                if (Terminal(x)) {
                    System.out.println(x);
                    fir[q][t2] = x;
                    t2++;
                    //break;
                }
                else {
                   // System.out.println(x);
                    first_of(x, q,t2);
                }
            }
               
               
            }
            else{}
           // System.out.println(i);
        }
        System.out.println();
        System.out.println();
        
    }
    
    public void Calculate_Follow(String FolWTemp[],int size,boolean InputT){
        
        Calculate_First( FolWTemp,size );
        
        for(int u=0;u<AllTerminal.length;u++)
        AllTerm=AllTerm+AllTerminal[u];
//        System.out.println(AllNonTerminals[0]);
//        System.out.println(AllTerminal[0]);
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
              follTemp[1][0]="$";
              
         for(int q=1;q<AllNonTerminals.length;q++) {         
               t=0;
      follow_of(AllNonTerminals[q],q,t);
    }
                   
                    String folq[];
                    String folq1[];
                    
//  az Follow ha eshterak migirim o anasoore tekrariii ra hazf mikoonim
                    for(int i=1;i<follTemp.length;i++){
                        int a=0;
                        String f="";
                   for(int j=0;j<follTemp[0].length;j++){                       
                         f=f+follTemp[i][j];                                            
                   }                   
                   //System.out.println(f);
                   folq1=f.split(" ");
                   String folstr="";
                   for(int k=0;k<AllTerminal.length;k++){
                    //System.out.print(AllTerminal[k]);
                    folstr=folstr+AllTerminal[k]+" ";
                    // if(AllTerminal[k])
                     // folstr=folstr+ f.substring(f.indexOf(AllTerminal[k]) , f.indexOf(AllTerminal[k])+1);
                   }
                   folstr=folstr+"$";
                    //System.out.println(folstr);
                   folq=folstr.split(" ");
                   for(int l=0;l<folq.length;l++){
                       //System.out.println(folq[l]);
                   }
                   for(int h=0;h<folq.length;h++){
                       if(f.contains(folq[h])){
                           //System.out.print(a+" "+folq[h]+" ");
                           foll[i][a]=folq[h];
                           a++;
                       }
                   }                  
                  //System.out.println();
                    }                    
                    
                    for(int k=1;k<AllNonTerminals.length;k++){
                        System.out.println();
                   for(int i=0;i<foll[1].length;i++){
                       System.out.print(foll[k][i]);
                   }
                    }
  
               ClusureCreate obj2=new ClusureCreate();
         obj2.Point(prod,AllNonTerminals,AllTerminal,fir,foll,InputT);
               
    }
    void follow_of(String s, int q,int number)
        { 
            System.out.println(" Folow("+NonTerminals[q]+") = ");
          
            String addFollowHistory="";
            String prodtemp[]=new String[prod.length];
           for(int i=1;i<prod.length;i++){
               prodtemp[i]=prod[i].substring(2)+"@";
          // System.out.println(prodtemp[i]);
           }
           System.out.println();
           System.out.println();
            String n=s;
           // int t2=number;
            String x;
           
             
    // choon baraye Z Follow be dast nemiavariiim pas Follow[0] ra khalii migozariim                       
    // baraye avvali $ ra add mikooniim
          if(n == null ? AllNonTerminals[1] == null : n.equals(AllNonTerminals[1]))
          {
          foll[1][0]="$";
          t++;
          }
          else
            {
            }
                //System.out.println(n);
              for(int i=1;i<prod.length;i++)
              {
                      
                          StringTokenizer tokens0 = new StringTokenizer( prodtemp[i] );
                         //tokens0.nextToken();
                         tokens0.nextToken();
                         while(tokens0.hasMoreTokens())
                         {
                         x=tokens0.nextToken();
                        // System.out.println(x);
                         if(x.contains(n))
                        { 
                        // System.out.println(x);
                        String p; 
// string bad az NonTerminali ke mikhahim Follow an ra be dast biavariim ra zakhire mikoonad.
                        p=prod[i].substring(prod[i].indexOf(x), prod[i].indexOf(x)+1);
                        
                       if(x == null ? p == null : x.equals(p)){
                        System.out.println("okay");
                        String addFollow=prodtemp[i].substring(prodtemp[i].indexOf(p)+2, prodtemp[i].indexOf(p)+3);
                                System.out.println(addFollow);
                                if("i".equals(addFollow)){
                                    addFollow="id";}
                               
                                else{}
                                 addFollowHistory=addFollowHistory+addFollow;
                                 
                                if(Terminal(addFollow))
                                {
                                    follTemp[q][t]=addFollow;
                                    t++;
                                }
                                else
                                {
                                    //System.out.println(p);  
                                    if(NonTerminal(addFollow))
                                    {
            
                                        
                                        for(int z=0;z<AllNonTerminals.length;z++)
                                        {
                                     if(addFollow == null ? AllNonTerminals[z] == null : addFollow.equals(AllNonTerminals[z]))
                                        {
                                      Pnum1=z;
                                        }   
                                        }
                                        for(int k=0;k<fir[Pnum1].length;k++)
                                        {
                                              String Nonull=fir[Pnum1][k];
                                              
                                              if(!"null".equals(Nonull))
                                              {
                                                follTemp[q][t]=Nonull;
                                                t++;
                                                }
                                        }
                                    }
                                    
                            else
                            {                                
                                if("@".equals(addFollow))
                                {
                                 // System.out.println(prod[i]);
                                  String FF=prod[i].substring(0, 1);
                                
                                 
                                  if(FFhistory.contains(FF)){}
                                  else{
                                       FFhistory=FFhistory+FF;
                                     System.out.println("-----------------");  
                                    System.out.println("FFHistory:  "+FFhistory);   
                                    System.out.println("-------------------");
                                    
                                     for(int z=0;z<AllNonTerminals.length;z++)
                                        {
                                     if(FF == null ? AllNonTerminals[z] == null : FF.equals(AllNonTerminals[z]))
                                        {
                                      Pnum2=z;
                                        }   
                                        }
                                     System.out.println(" pnum2 = "+Pnum2);
                                    // int temp=t;
                                      // System.out.println("===================");                                      
                                      System.out.println("t qabl az seda zadane follow "+t);
                                      //System.out.println(Pnum1);
                                      
                                     //  System.out.println("===================");
                                      
                                    
                                     //t=temp;
                                      //System.out.println("=============================");                                      
                                      System.out.println("t ====== "+t);
                                     //System.out.println(Pnum1);

                                       //System.out.println("=============================");
                                      for(int k=0;k<follTemp[Pnum2].length;k++)
                                        {
                                              String Nonull=follTemp[Pnum2][k];
                                              //System.out.println(Nonull);
                                              
                                              if(null!=Nonull )
                                              {                                                  
                                                 System.out.println("like");
                                                   System.out.println("Folow pnum ke qarar ast add konim "+ Nonull);
                                               // follow=  
                                                follTemp[q][t]=Nonull;
                                                t++;
                                                }
                                        }
                                      
                                       //System.out.println("===================");                                      
                                      System.out.println("t bad az add kardane follow "+t);
                                       follow_of(FF, Pnum2, t);
                                  }
                                    
                                }                                
                            }
                                }                                
                       }
                        }
                         }
                        
                        
              }
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println();
                           
//              for(int h=0;h<foll[Pnum].length;h++)
//                  System.out.println(foll[Pnum][h]);
             }
         
}
