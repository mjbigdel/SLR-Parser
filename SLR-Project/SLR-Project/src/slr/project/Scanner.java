
package slr.project;


public class Scanner {
  GUI obj=new GUI();
  
  int line_Count=40;
  public char[][] temp;
  public Scanner(){
  
  }
  public void Scan_Grammer(){
      
        temp=new char[line_Count][40] ;
             int l=0,j=0;
             
         for (int i = 0; i < obj.Grammer.length; i++) {          
           if(obj.Grammer[i]=='\n'){
               System.out.println("new line");
               l++;
               j=0;
            }
            else{
                temp[l][j]=obj.Grammer[i];   
                j++;
           }
          }
        // System.out.println(temp[0]);
         System.out.println(temp[1]);
         //System.odut.println(temp[2]);
  
  }

    
}
