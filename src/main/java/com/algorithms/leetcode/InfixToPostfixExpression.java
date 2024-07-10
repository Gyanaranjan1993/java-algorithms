package com.algorithms.leetcode;

import java.util.Stack;

//TODO: Complete it

/*
 * Write a program to convert an Infix expression to Postfix form.
 *
 * Infix expression:
 * The expression of the form “a operator b” (a + b) i.e., when an operator is in-between every pair of operands.
 *
 * Postfix expression:
 * The expression of the form “a b operator” (ab+) i.e., When every pair of operands is followed by an operator.
 *
 * The compiler scans the expression either from left to right or from right to left.

  Consider the expression: a + b * c + d

  The compiler first scans the expression to evaluate the expression b * c,
  then again scans the expression to add a to it.
  The result is then added to d after another scan.
  The repeated scanning makes it very inefficient.

  Infix expressions are easily readable and solvable by humans whereas the computer cannot differentiate the operators and parenthesis easily so, it is better to convert the expression to postfix(or prefix) form before evaluation.

  The corresponding expression in postfix form is abc*+d+.
  The postfix expressions can be evaluated easily using a stack.
 */
public class InfixToPostfixExpression {

    private int determinePrecedence(char operator){

        switch (operator){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }

    }

    private static String getPostFixedExpression(String prefixExp){

       StringBuilder res = new StringBuilder();

       Stack<Character> stack = new Stack<>();

       for(int i = 0; i< prefixExp.length(); i++){

           char ch = prefixExp.charAt(i);

           if(Character.isLetterOrDigit(ch)){
               res.append(ch);
           } else if(ch == '('){
               stack.push(ch);
           } else if(ch == ')'){
               while (!stack.isEmpty() && stack.peek() != '(' ){
                   res.append(stack.peek());
                   stack.pop();
               }

           }




       }










        return "";
    }

}
