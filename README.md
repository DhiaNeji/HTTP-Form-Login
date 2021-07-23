# HTTP-Form-Login.
A simple HTTP-Form-Login application using Spring Boot.
#Components description : 
The custom authentication provider implements the authentication logic.This implementation defines the authentication logic.
The AuthenticationProvider uses a UserDetailsService implementation and two PasswordEncoder implementations (BCRYPT and SCRYPT)
The UserDetailsService implementation, called UserService, uses Spring Data and JPA to connect to the database and get the user’s details.

#Routes description : 
/login : contains the login form.
/hello : contains a hello message plus the logged user details. after logging, you'll be redirected to this page.

#Tools : 

Eclipse.
PostgreSQL.

#Note : this application is only for educational purposes.
