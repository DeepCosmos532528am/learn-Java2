<%--
  Created by IntelliJ IDEA.
  User: LOQ
  Date: 12-04-2026
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Here in the we will see the demostration of EL Expression languaage to get the values from the request Object directly  --%>
<%--We can use Operators as w--%>

   <%

       request.setAttribute("interest", "problem solving"); //we can use ${requestScope.interest} with '$ {...}' El language.
       String name = request.getParameter("name"); //For this we can use ${param.name}

   %>
<p>Using normal getParameter to get the interest paramter value from the form: My Interest is: <%=name%></p>
<h1>My interest is ${requestScope.interest}</h1> <!--This i s our requestScope object which is a way to take out the values of the attributes , See above-->

<%--   You know is servlets, the same this is done by the String interest = request.getAttribute("interest") --%>

   <h1>I got my values out from the learnJSP2.jsp , ${param.name}</h1> <!--Using param object to get the parameter value out og the request obj. "param" is the object used to get out the parameters, from the request object, like fromm the Form from the learnJSP2.jsp the input parameters comes into this jsp file, comes loaded on the request object from the client,
  Now we usually do String name = request.getPrameter("name") and then using this variable into the '$ {...}' EL(expression lang)tag or the '< %=%>' tag, but param."paramterName" is a shorthand way in the jsp to access the parameter from the request object> -->

</body>
</html>


<%--The Expression Language (EL), commonly used in JSP and JSF (Java EE/Jakarta EE), supports a variety of operators for evaluating expressions, performing arithmetic, logical comparisons, and accessing data.
Here is a short note on the operators supported by EL:


1. Variable and Property Access
. (Dot): Accesses a JavaBean property or Map entry (e.g., ${user.name}).
[] (Bracket): Accesses an array/List element by index or a Map key dynamically (e.g., ${items[0]} or ${map['key']}).


2. Arithmetic Operators
Used for mathematical computations. EL treats null as zero in these operations.
+ (Addition): ${1 + 2}
- (Subtraction/Unary Minus): ${5 - 2}, ${-3}
* (Multiplication): ${2 * 3}
/ or div (Division): ${10 / 2} or ${10 div 2}
% or mod (Modulo): ${10 % 3} or ${10 mod 3}


3. Relational Operators
Compare two values and return a boolean. Both symbols and keywords are supported.
== or eq (Equal): ${'a' eq 'a'}
!= or ne (Not equal): ${5 ne 3}
< or lt (Less than): ${1 lt 2}
> or gt (Greater than): ${5 gt 3}
<= or le (Less or equal): ${3 le 3}
>= or ge (Greater or equal): ${4 ge 2}


4. Logical Operators
Work on boolean operands.
&& or and (Logical AND): ${true and false}
|| or or (Logical OR): ${true or false}
! or not (Logical NOT): ${not true}


5. Empty Operator
empty: A prefix operator that checks if a variable is null or empty (string, collection, or map). Example: ${empty userList}.


6. Conditional Operator
A ? B : C (Ternary): Evaluates B if A is true, otherwise evaluates C. Example: ${age > 18 ? 'Adult' : 'Minor'}.
7. EL 3.0 Special/New Operators
+= (String Concatenation): ${'Hello' += ' World'}.
= (Assignment): Used to assign values to variables.
; (Semi-colon): Used to chain multiple expressions.

--%>