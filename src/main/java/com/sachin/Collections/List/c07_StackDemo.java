package com.sachin.Collections.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class c07_StackDemo {
    static void main() {

//        Inherits vectors so it's also synchronized
        Stack<Integer> stack = new Stack<>();

        stack.add(2);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack);

        stack.remove(Integer.valueOf(3));
        System.out.println(stack.size());
        System.out.println(stack);

        stack.removeFirst();
        System.out.println(stack.size());
        System.out.println(stack);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println(stack.capacity());

        //In stack the add() and remove() works but should not use, it breaks the Stack() concept, Only the methods below should be used

        /*👉 “This code works because Java Stack extends Vector, so it inherits list-like methods such as add() and remove().
         However, only push() and pop() follow the true LIFO stack behavior. Methods like add(), remove(), and capacity() are inherited
          from Vector and can break stack semantics, which is why Stack is considered a legacy and not recommended for modern use.”
          */
//Below methods should be used with stack, not add() and remove()
// push -> insert element
        stack.push(10);
        stack.push(20);

// pop -> remove top element
        int top = stack.pop(); // 20

// peek -> view top element without removing
        int peek = stack.peek(); // 10

// empty check
        boolean isEmpty = stack.empty();

// search (returns position from top, 1-based index)
        int pos = stack.search(10);

    }
}

/*🧠 STACK IN JAVA – INTERVIEW NOTES (CHEAT SHEET)

📌 What is Stack?
Stack is a linear data structure
Follows LIFO (Last In First Out) principle
Last inserted element is removed first
Real-life examples: stack of plates, undo/redo operations, browser history, function call stack

📌 Stack in Java (Implementations)
1. Legacy Stack Class (java.util.Stack)
Built-in class in Java
Supports push, pop, peek operations
Extends Vector (so it is synchronized)

⚠️ Disadvantages:

Slower due to synchronization
Considered legacy
Not recommended for modern development
2. Recommended Way: ArrayDeque
Best practice for stack implementation in Java
Faster and more efficient than Stack class
Not synchronized (better performance)
Preferred by Java documentation

📌 Core Stack Operations
Push → Insert element at top
Pop → Remove top element
Peek → View top element without removing
isEmpty → Check if stack is empty
⏱ Time Complexity
Push → O(1)
Pop → O(1)
Peek → O(1)
All stack operations are constant time

📌 Important Stack Concepts for Interviews
1. Balanced Parentheses Problem
Use stack to check matching brackets
Push opening brackets
Pop when closing bracket is found
Used to validate expressions
2. Reverse String Using Stack
Push all characters into stack
Pop characters to reverse order
Demonstrates LIFO behavior
3. Next Greater Element
Uses monotonic stack
Helps find next greater element efficiently
Very common interview pattern
4. Expression Evaluation
Used in postfix/prefix evaluation
Push operands
Pop when operators are encountered
5. Stock Span Problem
Uses stack to store indices
Helps find previous greater elements
Optimizes brute-force solution

📌 Monotonic Stack (Very Important)
Stack that maintains sorted order (increasing or decreasing)
Increasing stack → used for next smaller element
Decreasing stack → used for next greater element
Common in advanced DSA problems

📌 Real-world Applications
Undo/Redo functionality in editors
Function call management (recursion stack)
Browser back/forward history
Expression parsing and evaluation
Syntax parsing in compilers

📌 Common Mistakes in Interviews
Using Stack class instead of ArrayDeque
Not checking for empty stack before pop/peek
Confusing pop vs peek
Ignoring edge cases (empty input, single element)
Incorrect handling of indices in stack-based problems

📌 Quick Revision Summary
Stack = LIFO structure
Best implementation = ArrayDeque
All operations run in O(1)
Extremely important for recursion and expression problems
Key patterns: balanced brackets, next greater element, monotonic stack*/