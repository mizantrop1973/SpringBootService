<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>

</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered:
    </div>
    <table class="form-style-2" border="2px">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Cars</th>
        </tr>

        <#list usersFromServer as user>
            <tr>
                <td>${user.userId}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>
                    <ul class="form-style-2">
                        <#list user.cars as  cars>
                            <li>
                                ${cars}
                            </li>
                        </#list>
                     </ul>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>






