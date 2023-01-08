<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Book</title>
</head>

<body>
    <c:if test="${msg == 'Update'}">
        <form:form modelAttribute="book" action="../books/${book.id}" method="post">
            <form:errors path="*" element="div" style="color: red;"/>
            <table>
                <tr>
                    <td>Title:</td>
                    <td><form:input type="text" name="title" path="title" value="${book.title}" /> </td>
                    <td><form:errors path="title" style="color: red;"/> </td>
                </tr>
                <tr>
                    <td>ISBN:</td>
                    <td><form:input type="text" name="ISBN" path="ISBN" value="${book.ISBN}" /> </td>
                    <td><form:errors path="ISBN" style="color: red;"/> </td>
                </tr>
                <tr>
                    <td>Author:</td>
                    <td><form:input type="text" name="author" path="author" value="${book.author}" /> </td>
                    <td><form:errors path="author" style="color: red;"/> </td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input type="number" name="price" path="price" value="${book.price}" /> </td>
                    <td><form:errors path="price" style="color: red;"/> </td>
                </tr>
            </table>
            <input type="submit" value="${msg}"/>
        </form:form>
    </c:if>
    <c:if test="${msg == 'Add'}">
        <form:form modelAttribute="book" action="../books" method="post">
            <form:errors path="*" element="div" style="color: red;"/>
            <table>
                <tr>
                    <td>Title:</td>
                    <td><form:input type="text" name="title" path="title" value="${book.title}" /> </td>
                    <td><form:errors path="title" style="color: red;"/> </td>
                </tr>
                <tr>
                    <td>ISBN:</td>
                    <td><form:input type="text" name="ISBN" path="ISBN" value="${book.ISBN}" /> </td>
                    <td><form:errors path="ISBN" style="color: red;"/> </td>
                </tr>
                <tr>
                    <td>Author:</td>
                    <td><form:input type="text" name="author" path="author" value="${book.author}" /> </td>
                    <td><form:errors path="author" style="color: red;"/> </td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input type="number" name="price" path="price" value="${book.price}" /> </td>
                    <td><form:errors path="price" style="color: red;"/> </td>
                </tr>
            </table>
            <input type="submit" value="${msg}"/>
        </form:form>
    </c:if>
            
    <c:if test="${msg == 'Update'}">
    <form:form action="delete?id=${book.id}" method="post">
        <button type="submit">Delete</button>
    </form:form>
    </c:if>
</body>

</html>