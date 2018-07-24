<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>logo Information</h2>
<%-- <form:form method="POST" action="/Spring/addlogo">
   <table>
    <tr>
        <td><form:label path="imagepath">图片地址：</form:label></td>
        <td><form:input path="imagepath" /></td>
    </tr>
    <tr>
        <td><form:label path="title">标题：</form:label></td>
        <td><form:input path="title" /></td>
    </tr>
    
    <tr>
        <td><form:label path="cTime">时间：</form:label></td>
        <td><form:input path="cTime" /></td>
    </tr>
    <tr>
        <td><form:label path="id">id号：</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交表单"/>
        </td>
    </tr>
</table>  
</form:form> --%>

<form:form method="POST" modelAttribute="fileUpload"
        enctype="multipart/form-data">
      请选择一个文件上传 : 
      <input type="file" name="file" />
      标题： <input type="text" name="title" />
     时间： <input type="text" name="cTime" />
      id号： <input type="text" name="id" />
        
        <input type="submit" value="提交上传" />
    </form:form>
</body>
</html>