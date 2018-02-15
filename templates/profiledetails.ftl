<html>
<head>
	<style>
		.header {
    		background-color: DodgerBlue;
    		text-align: center;
    		color:white;
    		font-size:50px;
   			border:8px white;
   			border-radius:5px;
			width:100%;
			height:100px;
		}
		img{
			padding-top:60px;
			padding-left:300px;
			float:left;
		}
		.profiledata{
	    border: 1px solid lightblue;
    	font-size:18px;
		color:blue;
		padding-left:55%;
		padding-top:70px;
		}
		body {
   			 background-color: lightblue;
		}
	</style>
    <title>Twitter Profile</title>
</head>
<body>
	<div class="header">Welcome to Twitter Profile</div>
	<img src=${profilepiclink} alt="Profile Pic" width="500" height="600">
	<div class="profiledata">
	<h3>Name :           ${name}</h3>
	<h3>Id :             ${id}</h3>
	<h3>Status :         ${status}</h3>
	<h3>Language :       ${language}</h3>
	<h3>Location :       ${location}</h3>
	<h3>FollowersCount : ${followersCount}</h3>
	<h3>FriendsCount :   ${friendsCount}</h3>
	<h3>TweetsCount :    ${tweetsCount}</h3>
	</div>
</body>
</html>
