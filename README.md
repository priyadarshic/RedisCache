# RedisCache
How to Use Redis Server as a Cache for your App


## application.properties
<br>spring.cache.type=redis
<br>spring.redis.host=localhost
<br>spring.redis.port=6379
<br>spring.cache.redis.cache-null-values=true
<br>spring.cache.redis.time-to-live=40000


## start redis-server.exe before executing
