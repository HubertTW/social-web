# intro 
A simple social web with backend only.  <br>
db: mariadb <br>
framework: spring boot  <br>
connector: jdbc <br>

# usage
```shell
$mvn compile
$mvn exec:java -Dexec.mainClass="com.example.social_web.SocialWebApplication"
```
or use IDE to run 


# api test

## Users

* POST: http://127.0.0.1:8080/register
```
{
  
  "userId": "0952602199",
  "userName": "josh",
  "password": "123",
  "email":"yyyy@gmail.com",
  "biography":"hello"

}

```
* POST: http://127.0.0.1:8080/login
```
{
"userId": "0952602119",
"password": "123"
}

```

* GET: http://127.0.0.1:8080/logout


## Posts
* POST:http://127.0.0.1:8080/post
```
{

"content":"my fist post"

}

```

* GET:http://127.0.0.1:8080/post
* PUT:http://127.0.0.1:8080/post/{postid}
```
{

"content":"my modified post"

}


```

* DELETE:http://127.0.0.1:8080/post/{postid}
## Comments

* GET:http://127.0.0.1:8080/comment
* PUT::http://127.0.0.1:8080/comment/{commentid}
```
{
"content":"best comment"
}

```
