<html>
<head>
	<style>
		.box{
			box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2);
			border-radius:10px;
			padding-top:50px;
			padding-left:100px;
			padding-right:100px;
			padding-bottom:228px;
 			
			}
		.header {
			box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2);
    			background-color: DodgerBlue;
    			text-align: center;
    			color:white;
    			font-size:50px;
   			border:8px white;
   			border-radius:10px;
			width:100%;
			height:100px;
		}
		.footer{
			box-shadow:0 4px 8px 0 rgba(, 0, 0, 0.2);
    			background-color: DodgerBlue;
   			border:8px white;
   			border-radius:10px;
			height:30px;
			position: absolute;
  			right: 8;
  			bottom: 3;
  			left: 8;
			}
		img{
			box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2);
			border-radius:50%;
			float:left;
		}
		.profiledata{
	 		font-size:18px;
			color:blue;
			text-align: center;
			font-family: arial;
		}
		body {
   			 background-color: lightblue;
		}
	</style>
    <title>Twitter Profile</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<body>
	<div class="header">Welcome to Twitter Profile</div>
	<div class="box">
		<img src=${profilepiclink} alt="Profile Pic" width="400" height="400">
		<div class="profiledata">
			<h3>${name}</h3>
			<h3>${location}</h3>
			<h3>${status}</h3>
			<h3>I am having ${followersCount} followers,${friendsCount} friends and ${tweetsCount} tweets</h3>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>
