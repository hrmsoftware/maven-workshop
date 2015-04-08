<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <title>Hello World</title>
    </head>
    <body>

        <c:if test="${!empty requestScope.greeting}">
            <h3><c:out value="${greeting}"/></h3>
        </c:if>

        <form action="" method="POST">
            <label for="name-field">Vad heter du?</label>
            <input type="text" name="name-field"></input>
            <input type="submit" value="OK" />
        </form>

    </body>
</html>
