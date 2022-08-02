# RedisCache
How to Use Redis Server as a Cache for your App


# application.properties

spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379
spring.cache.redis.cache-null-values=true
spring.cache.redis.time-to-live=40000


## start redis-server.exe before executing
