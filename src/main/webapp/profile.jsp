<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/styles.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    ${sessionScope.get("firstAd")}
    <div class="container">
        <h1>Viewing your profile.</h1>
    </div>

</body>
</html>
