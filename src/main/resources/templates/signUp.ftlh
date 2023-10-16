<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>

</head>
<body>

<#if error??>
    <div class="form-style-2-heading" role="alert" style="color: crimson " >
        <h2>Error of registration. Try one more time!</h2>
    </div>
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Registration
    </div>
    <form  method="post" action="/signUp">

        <label  for="login">Login
            <input  class="input-field" type="text" id="login"  name="login">
        </label>

        <label  for="first_name">First Name
            <input  class="input-field" type="text" id="first_name"  name="firstName">
        </label>

        <label  for="last_name">Last Name
            <input  class="input-field" type="text" id="last_name"  name="lastName">
        </label>

        <label class="input-field" for="password">PSW
            <input class="input-field" type="password" id="password"  name="password">
        </label>

        <input type="submit"  value="Login">
    </form>
</div>

</body>
</html>






