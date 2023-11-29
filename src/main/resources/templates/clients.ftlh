<html>
<head>
    <title>Clients</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>

</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please add client!
    </div>
    <form  method="post" action="/clients">

        <label  for="clientName"> Name
            <input  class="input-field" type="text" id="clientName"  name="clientName">
        </label>

        <input type="submit"  value="Add client">
    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered:
    </div>
    <table class="form-style-2">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phones</th>
            <th>Emails</th>
        </tr>

        <#list clientsFromServer as client>
            <tr>
                <td><a href="/client?client_id=${client.clientId}" >${client.clientId}</a></td>
                <td><a href="/client?client_id=${client.clientId}">${client.clientName}</a></td>

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






