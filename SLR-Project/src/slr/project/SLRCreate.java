package slr.project;

import java.util.StringTokenizer;

public class SLRCreate {

    FirstFollow objFirstFollow = new FirstFollow();
//    String Table[][];
//    String TableHead[];
//    boolean InputT;

    String Input[];
    String[] NoTRemovedInput;// baqimande input dar har marhale.
    Stack objStack = new Stack();
    String actioString[];// action mibashad.
    String Output[];    // output mibashad
    String Stack[];// meqdare stack dar har marhale
    int ActioCount = 0;
    int OutputCount = 0;
    String Rule[];
    String Table[][];
    String TableHead[];
    String InputString;
    String RuleTemp[];
    int InputNumber = 0;
    String ActionsTable[][];
    public SLRCreate(String Table[][], String TableHead[], String InputString, String RuleTemp[]) {
        this.Table = Table;
        this.TableHead = TableHead;
        this.InputString = InputString;
        this.RuleTemp = RuleTemp;

    }

    public void SLR_Create() {
       
        System.out.println("ookaaay SLR");
        actioString = new String[100];
        NoTRemovedInput = new String[100];
        Output = new String[100];
        actioString = new String[100];
        Stack = new String[100];
        Rule = new String[RuleTemp.length - 1];

        for (int g = 0; g < Rule.length; g++) {
            Rule[g] = RuleTemp[g + 1];
            Rule[g] = Rule[g].replace(".", "");
            Rule[g] = Rule[g].replace(" ", "");
            System.out.println(Rule[g]);
        }
             InputString = InputString + " $  ";
        NoTRemovedInput[0] = InputString;
       
        // ebteda input stram ra be sorate yek araye dar miavariim ba estefade az tkenizer;
        int p = 0;
        StringTokenizer tokens2 = new StringTokenizer(InputString);
        Input = new String[tokens2.countTokens()];

        while (tokens2.hasMoreTokens()) {
            String str = tokens2.nextToken();
            Input[p] = str;
            p++;
        }
            int Counter=0;
        int j = 0;
        int i = 0;
        int a = 0;
        System.out.println("While start");
        while (!"acc".equals(Table[i][j])) {
            // qablan 2 taya avvale Input string rada dakhele Shift hazf kardeiim
            NoTRemovedInput[Counter] = InputString;
            Stack[Counter] = objStack.serializeStack();
           
            System.out.println("Input " + Input[a]);

            j = NTerminalNumber(Input[a]);

            String t = objStack.lastChar();
            System.out.println(" top Stack = = >>" + t);
            Stack[0] = "0";
            i = Integer.parseInt(t);

            if ("S".equals(Table[i][j].substring(0, 1))) {
                System.out.println("shift: " + Table[i][j]);
                objStack.pushStack(Input[a]);
                objStack.pushStack(Table[i][j].substring(1, 2));

// input[i] ra az Input pak koon.                
                InputString=InputString.substring(2);
                actioString[Counter] = "shift " + Table[i][j].substring(1, 2);
                Output[Counter]=" ";
                a++;

            } else {
                if ("R".equals(Table[i][j].substring(0, 1))) {
                    System.out.println(Integer.parseInt(Table[i][j].substring(1, 2)));
// rule morede nazar ra ke bayad be ezaye an reduce konim dar temp qarar midahiim.                    
                    String temp = Rule[Integer.parseInt(Table[i][j].substring(1, 2)) - 1];
                    String remove = temp.substring(4);;
                    String add = temp.substring(0, 1);
// Table[i][j] agar R5 bashad angah Rule 5 ra dar Temp qarar midahad.                                    

                    objStack.popStack(remove);
                    System.out.println(" remove :" + remove);
                    String FF = objStack.lastChar();
                    System.out.println(" FF :" + FF);
                    int Statenumber = Integer.parseInt(FF);
                    System.out.println(" statenumber :" + Statenumber);
                    int NTnumber = NTerminalNumber(add);
                    System.out.println(" NTnumber :" + NTnumber);
                    String pushString = Table[Statenumber][NTnumber];
                    System.out.println(" Push 1 :" + TableHead[NTnumber]);
                    objStack.pushStack(TableHead[NTnumber]);
                    System.out.println(" pushstring :" + pushString);
                    objStack.pushStack(pushString);
                    //     System.out.println(temp);
                    System.out.println("Reduce" + Table[i][j]);
                    //InputString=InputString.substring(2);
                    Output[Counter]=TableHead[NTnumber]+" --> "+remove;
                    actioString[Counter] = "Reduce by " + Output[Counter];
                     

                } else {
                    if ("a".equals(Table[i][j].substring(0, 1))) {
                        System.out.println("Accepted");
                        actioString[Counter] = "Accepted";
                        Output[Counter]=" ";
                    }
                    if (Table[i][j] == " ") {
                        System.out.println("Error");
                        
                        // peyqame error neshan dahad
                        
                        
                    }
                }

            }
            
             Counter++; // tedade action ha ra negah midarad.
        }
        
        System.out.println("Counter = "+Counter);        
        String ActionsHead[]=new String[4];
        ActionsHead[0]="Stack";
         ActionsHead[1]="Input";
          ActionsHead[2]="Actions";
           ActionsHead[3]="Output";
        ActionsTable=new String[Counter][4];
        for(int q=0;q<Counter;q++){
            ActionsTable[q][0]=Stack[q];
            ActionsTable[q][1]=NoTRemovedInput[q];
            ActionsTable[q][2]=actioString[q];
            ActionsTable[q][3]=Output[q];            
        }
        
        RunProcess ob=new RunProcess(ActionsTable, ActionsHead);
        
    }

    // set visible Run ra true kon. va input & stack & actionha ra baraye an befrest.
    public int NTerminalNumber(String s) {
        int number = 0;
        for (int u = 0; u < TableHead.length; u++) {
            if (s == null ? TableHead[u] == null : s.equals(TableHead[u])) {
                number = u;
            }
        }

        return number;
    }
}
