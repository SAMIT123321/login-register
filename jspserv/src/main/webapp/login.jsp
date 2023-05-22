<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>login</h3>
 <form action="<%=request.getContextPath()%>/logincontroler" method="post">
            name:<input type="text" name="name"><br><br>
            password:<input type="password" name="password">
            
            <input type="submit" value="submit">
                        
        </form>
        <a href="register.jsp">create account</a>

</body>
</html>