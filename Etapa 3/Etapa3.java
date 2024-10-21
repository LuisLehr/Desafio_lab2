import java.util.Stack;

public class Etapa3 {

    // Verifica se uma expressão matemática tem os parênteses agrupados de forma correta.
    public boolean verificarParenteses(Stack<Character> pilha) {
        Stack<Character> pilhaTemp = new Stack<>();
        
        while (!pilha.isEmpty()) {
            char ch = pilha.pop();
            if (ch == ')') {
                pilhaTemp.push(ch);
            } else if (ch == '(') {
                if (pilhaTemp.isEmpty()) {
                    return false;
                }
                pilhaTemp.pop();
            }
        }

        return pilhaTemp.isEmpty();
    }

    public static void main(String[] args) {
        Etapa3 etapa3 = new Etapa3();
        
        Stack<Character> pilha1 = new Stack<>();
        pilha1.push('(');
        pilha1.push('A');
        pilha1.push('+');
        pilha1.push('B');
        pilha1.push(')');
        
        System.out.println(etapa3.verificarParenteses(pilha1)); // Saída: true
        
        Stack<Character> pilha2 = new Stack<>();
        pilha2.push('A');
        pilha2.push('+');
        pilha2.push('B');
        pilha2.push('(');
        
        System.out.println(etapa3.verificarParenteses(pilha2)); // Saída: false
    }
}
