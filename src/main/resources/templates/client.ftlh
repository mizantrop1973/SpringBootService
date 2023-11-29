<html>
<head>
    <title>Client</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>

</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please add contacts!
    </div>
    <form  method="post" action="/client">

        <label  for="phoneNumber"> phone
            <input  class="input-field" type="text" id="phoneNumber"  name="phoneNumber">
        </label>
        <label  for="email"> e-mail
            <input  class="input-field" type="text" id="email"  name="email">
        </label>

        <input type="submit"  value="Add contacts">
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Client's details
    </div>
    <table class="form-style-2">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phones</th>
            <th>Emails</th>
        </tr>

        <#list clientFromServer as client>
            <tr>
                <td>${client.clientId}</td>
                <td>${client.clientName}</td>
                <td>
                    <ul class="form-style-2">
                        <#list client.phones as  phones>
                            <li>
                                ${phones}
                            </li>
                        </#list>
                    </ul>
                </td>
                <td>
                    <ul class="form-style-2">
                        <#list client.emails as  emails>
                            <li>
                                ${emails}
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






