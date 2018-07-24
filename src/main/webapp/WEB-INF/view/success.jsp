<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Spring MVC上传文件示例</title>
</head>
<body>
    文件名称 :
    <b> ${fileName} </b> - 上传成功！
    
    <h2>提交的logo信息如下 - </h2>
   <table>
    <tr>
        <td>图片地址：</td>
        <td>${imagepath}</td>
    </tr>
    <tr>
        <td>标题：</td>
        <td>${title}</td>
    </tr>
    <tr>
        <td>时间：</td>
        <td>${cTime}</td>
    </tr>
    <tr>
        <td>id号：</td>
        <td>${id}</td>
    </tr>
</table>  
</body>
</html>