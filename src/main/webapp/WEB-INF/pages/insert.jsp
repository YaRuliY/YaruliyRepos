<!doctype html>
<html>
  <head>
    <title>insert user</title>
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="css/http_code.jquery.com_jquery-1.11.3.js"></script>
    <script type="text/javascript">
      function doInsert(){
        $.post("/insert/user.do",
                {
                  name: $('#name').val(),
                  lastName: $('#lastName').val(),
                  gender: $('#gender').val(),
                  city: $('#city').val()
                },
                function(data){
                  alert(data);
                })
      }
    </script>
  </head>
  <body>
    <div id="main">
      <h1>Insert User</h1>
      <p>Name:</p>
      <input id="name" type="text" size="40"/>
      <p>Last Name:</p>
      <input id="lastName" type="text" size="40"/>
      <p>Gender:</p>
      <select id="gender">
        <option value="man">Man</option>
        <option value="female">Female</option>
      </select>
      <p>City:</p>
      <input id="city" type="text" size="40"/>
      <p>
        <input type="button" value="Add User" onclick="doInsert();"/>
        <input type="button" value="Show Users" onClick="window.location='getter'"/>
        <input type="button" value="Search User" onClick="window.location='search'"/>
      </p>
    </div>
  </body>
</html>