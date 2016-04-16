<!DOCTYPE html>
<html>
<head>
    <title>Search Users</title>
    <link rel="stylesheet" href="css/main.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.js"></script>
    <script type="text/javascript">
        function doSearch(){
            $.getJSON("search/data.do",
                    {searchKey: $('#searchBox').val()},
                    function(data){
                        $('#results').text('');
                        if ($('#searchBox').val().length>0){
                            if (data.length>0){
                                for (var index in data){
                                    $('#results').append("<p>" + data[index] + "</p>");
                                }
                            }
                            else $('#results').append("<h2>" + "No results" + "</h2>");
                        }
                        else $('#results').append("<h2>" + "..." + "</h2>");
                    })
        }
    </script>
</head>
<body>
    <div id="main">
        <h1>Search</h1>
        <input type="text" name="searchKey" id="searchBox" onKeyUp="doSearch();"/>
        <div id="results" style="margin-top: 25px;">
            <h2>...</h2>
        </div>
        <p>
            <input type="button" value="Add User" onclick="window.location='insert'"/>
            <input type="button" value="Refresh Table" onClick="window.location='getter'"/>
            <input type="button" value="Search User" onClick="window.location='search'"/>
        </p>
    </div>
</body>
</html>