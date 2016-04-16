<!doctype html>
<html>
  <head>
    <title>edit user</title>
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.js"></script>
    <script type="text/javascript">
      function editUser(){
        $.post("/edit/user.do",
                {
                  name: $('#name').val(),
                  lastName: $('#lastName').val(),
                  gender: $('#gender').val(),
                  city: $('#city').val(),
                  id: ${id}
                },
                function(data){alert(data);}
        )
      }
    </script>
  </head>
  <body>
    <div id="main">
      <h1>Edit User</h1>
      <p>Name:</p>
      <input id="name" type="text" size="40" value=${name} />
      <p>Last Name:</p>
      <input id="lastName" type="text" size="40" value=${lastName} />
      <p>Gender:</p>
      <select id="gender">
        <option value="man">Man</option>
        <option value="female">Female</option>
      </select>
      <p>City:</p>
      <input id="city" type="text" size="40" value=${city} />
      <p>
        <input type="button" value="Save Changes" onclick="editUser();"/>
        <input type="button" value="Show Users" onClick="window.location='getter'"/>
      </p>
    </div>
  </body>
</html>