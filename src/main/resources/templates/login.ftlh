<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>

</head>
<body>

<#if error??>
    <div class="form-style-2-heading" role="alert" style="color: crimson " >
        <h2>Login and/or password are incorrect</h2>
    </div>
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        LogIn!
    </div>
    <form  method="post" action="/login">

        <label  for="login">Login
            <input  class="input-field" type="text" id="login"  name="login">
        </label>

        <label class="input-field" for="password">PSW
            <input class="input-field" type="password" id="password"  name="password">
        </label>

        <input type="submit"  value="Login">
    </form>
</div>

</body>
</html>






