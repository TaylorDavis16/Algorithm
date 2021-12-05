package com.taylor.Stack.application;


import com.taylor.Stack.stack.NumberStack;

public class Calculator {
    private NumberStack numberStack;
    private NumberStack optStack;
    private String expression;

    public Calculator(String expression) {
        this.expression=expression;
        int size=this.expression.length();
        numberStack=new NumberStack(size);
        optStack=new NumberStack(size);
    }

    public int getResult(){
        return getResult(this.expression);
    }

    public int getResult(String expression){
        expression=expression.trim();
        int index=0;
        StringBuilder number= new StringBuilder();
        while(index<expression.length()){
            char c=expression.charAt(index);
            if (isOperator(c)){
                if (optStack.isEmpty()){
                    optStack.push((int) c);
                    index++;
                }
                else {
                    switch (priority(optStack.peek(),c)){
                        case '<':
                            optStack.push((int)c);
                            index++;
                            break;
                        case '=':
                            optStack.pop();
                            index++;
                            break;
                        case '>':
                            int b=numberStack.pop();
                            int a=numberStack.pop();
                            int result=operate(a,b,optStack.pop());
                            numberStack.push(result);
                            break;
                        default: throw new RuntimeException("Error at finding priority!");
                    }
                }
            }
            else {
                number.append(c);
                if (index!=expression.length()-1){
                    if (!isOperator(expression.charAt(index+1))){
                        index++;
                        continue;
                    }
                }
                numberStack.push(Integer.parseInt(number.toString()));
                number=new StringBuilder();
                index++;
            }
        }
        while (!optStack.isEmpty()){
            int number2=numberStack.pop();
            int number1=numberStack.pop();
            int result=operate(number1,number2,optStack.pop());
            numberStack.push(result);
        }
        return numberStack.pop();

    }

    private boolean isOperator(char c){
        return c=='+' || c=='-' || c=='*' || c=='/' || c=='(' || c==')';
    }

    private int priority(int opt1,int opt2){
        if (opt1=='+' || opt1=='-'){
            if (opt2=='+' || opt2=='-' || opt2==')')
                return '>';
            else return '<';
        }
        if (opt1=='*' || opt1=='/'){
            if (opt2=='(')
                return '<';
            else return '>';
        }
        if (opt1=='('){
            if (opt2==')')
                return '=';
            else return '<';
        }
        return -1;
    }

    private int operate(int number1,int number2,int opt){
        switch (opt){
            case '+': return number1+number2;
            case '-': return number1-number2;
            case '*': return number1*number2;
            case '/': return number1/number2;
            default: throw new RuntimeException("Error at operation!");
        }
    }

}
