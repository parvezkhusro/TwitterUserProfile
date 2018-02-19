<html>
	<head>
		<title>Twitter Profile</title>
		<style>
			.box{
				box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2);
				border-radius:10px;
				padding-top:50px;
				padding-left:100px;
				padding-right:100px;
				padding-bottom:240px;
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
	</head>
	<body>
		<div class="header">Welcome to Twitter Profile</div>
		<div class="box">
			<img src=${profilepiclink} alt="Profile Pic" width="400" height="400">
			<div class="profiledata">
				<h1>${name}</h1>
				<h2>${location}</h2>
				<h3>${status}</h3>
				<p>I am having ${followersCount} followers,${friendsCount} friends and ${tweetsCount} tweets</p>
			</div>
		</div>
		<div class="footer"></div>
	</body>
</html>
