# tweetapp
App to Show twitter users according to database table, show their last five tweets and edit profile informattion.

1. Technologies used:
- VueJs 2.5.13
- Bootstrap 4
- Java Springboot
- Springdata, JPA
- twitter4j as twitter api
- Apache Maven

2. Installation:
a) Copy the folder "twitterapp-frontend" on an apache web server.
b) Open a terminal
c) navigate to "twitterapp-backend" and run the command: "java -jar twitterapp-0.0.1-SNAPSHOT -&"
d) Open a web browser and run: "http://localhost:8888/tweetapp/twitterapp-frontend/" (Replace the 8888 port for that the apache port)

Notes
- The frontend has no need to compilate.
- About the backend, the .jar file are already compilated, no need to run "mvn install".
- Need an internet connection to import vuejs libraries.
- The backend port was configured on 8080, make sure that this port is free.