# SDP-Main
Senior Design Project Main

-Project consists of 3 parts - EMS, Accounting, CRM

-All of them uses different PostgreSQL databases;

-Please see application.properties files inside resources for configuration

-credentials for crm:
          USERNAME 					PASSWORD		ROLE
	
	  user					        password		USER
	  togrul					password		USER
	  admin					        password		ADMIN
	
for ems:
	
	  shuseynova@email.com 				123456			MANAGER
	
-credentials can be changed through config files

-dbscript.sql files need to be executed before testing

29.04.2021 notes:

1. Edit user page on EMS part does not work, because its commented out, as it is negotiable to give maanager such ability / it can be turned on from manager controller

2. Add Invoice page on accounting part will give an error because of the forgotten duplicate attributes on same tag "required" on line 111~112 / once deleted, it is good to go

3. We added this part as notes instead of repository update,  because it could create a problem for us about post-deadline period
