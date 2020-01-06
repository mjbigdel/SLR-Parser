package slr.project;


public class Stack {

    private java.util.Stack stack;

    public Stack() {
        stack = new java.util.Stack();
        stack.add("0");
    }

       
     void popStack(String removeString) {
        int stackPointer = stack.size() - 1;
        for (int i = 0; i < removeString.length(); i++) {
            char letter = removeString.charAt(removeString.length() - 1 - i);
            for (; stackPointer >= 0; stackPointer--) {
                if (((String) (stack.get(stackPointer))).compareTo(String.valueOf(letter)) == 0) {
                    break;
                }
            }
        }
        for (int i = stack.size() - 1; i >= stackPointer; i--) {
            stack.pop();
        }
    }
               

    public String lastChar() {
        return (String)stack.get(stack.size() - 1);
    }
    
    public void pushStack(String ob){
        stack.add(ob);
    }
    
     public boolean checkForLast() {
        String theLastOne = ((String) (stack.get(stack.size() - 1)));
        try {
            int i = Integer.valueOf(theLastOne);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

      public String serializeStack() {
        String string = "";
        for (int i = 0; i < stack.size(); i++) {
            string += " " + stack.get(i);
        }
        return string;
    }
}

