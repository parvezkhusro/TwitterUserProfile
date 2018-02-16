<html>
<head>
	<style>
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
		.box{
			box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2);
			border-radius:10px;
			padding-top:50px;
			padding-left:100px;
			padding-right:100px;
 			height:71%;
			}
		.button{
			box-shadow:0 4px 8px 0 rgba(0, 0, 0, 0.2);
			position:absolute;
			top:30%;
			left:42%;
			padding: 16px 32px;
    			border-radius: 20px;
   		    	text-align: center;
    			text-decoration: none;
   		    	display: inline-block;
   		    	font-size: 16px;
    	    		margin: 4px 2px;
           		cursor: pointer;
			background-color: white; 
  			color: black; 
    			border: 2px solid #008CBA;
			
		}
		.footer{
			box-shadow:0 4px 8px 0 rgba(0.2, 0, 0, 0);
    			background-color: DodgerBlue;
   			border:8px white;
   			border-radius:10px;
			height:30px;
			position: absolute;
  			right: 8;
  			bottom: 3;
  			left: 8;
			}
		body {
   			 background-color: lightblue;
		}
		.button:hover{
			background-color: #008CBA;
   		 	color: white;
		}
	</style>
    <title>Twitter Profile</title>
</head>
<body>
	<div class="header">Welcome to Twitter Profile</div>
	<div class="box">
		<input type="button" class="button"onclick="onSuccess();" value="Get User Profile Data"/>
		<script>
			function onSuccess(){
			window.location="http://localhost:8080/RESTfulExample/service/signin";
			}
		</script>
	</div>
	<div class="footer"></div>
</body>
</html>
