# 项目
## sky-common-公共类
- constant-定义了一些常量
- context-线程中存取数据方法
- enumeration
- exception
- json
- properties-springBoot中的配置属性类
- result
  - 这里有泛型限制返回的数据
- util

## sky-pojo
- dto
  - 数据传输对象，用于接收前端数据（精确封装）
- entity
- vo-视图对象给前端展示对象

## sky-server
- config
  - 配置swagger生成接口文档与测试页面
  - 有APi开头的注解都是它的，主要进行说明
  - 在全局参数设置里面设置token 
- controller.admin
- handler
  -处理各种类型的异常
- interceptor
  -认证不通过返回401状态码
  -认证通过存储信息到当前线程
- mapper
- service
  - md5密码加密
  - 从线程中取出来操作人员的id
- AppAplication
- pom文件
  - swagger使用坐标

## Nginx
- 能够对数据进行缓存
- 能对后端进行均衡
- 保证后端安全
- 在conf文件里配置反向代理与负载均衡

## 请求
- 管理端请求与用户端请求不一样
- 管理端以/admin为前缀，用户端以/user作为前缀

## 线程
- 每一次请求都是一个单独的线程
- ThreadLoacal可以为每一个线程提供单独一份存储空间

## 新增员工
- 使用BeanUtils拷贝两个Bean中的数据

## 分页查询员工
- pageHelper更加方便的使用:mapper接口中
- 对于时间转换格式统一处理：config包下的WebMvcConfiguration中

##  启用/禁用员工
- 在服务层使用Builder构造对象

## 修改员工
- 返回数据，在服务层隐藏密码

## 自动添加设置时间的代码
- 在mapper的特定方法上加上自定义的注解
- 在service层的insert和update方法中都不需要修改时间了（这个数据库中的时间真的是必要的吗）

## 添加菜品
- 使用配置类配置应该使用的Bean（AliOssUtils）

## 删除菜品
## 修改菜品

## 添加删除修改套餐

## Redis
- 基于内存的key-value结构数据库，适合存储热点数据（短时间内大量数据）来提高读写性能
- 可在配置中设置密码：requirepass 123456
- 用配置文件启动：redis-server.exe redis.windows.conf
- 详细客户端登录：redis-cli.exe -h localhost -p 6379 -a 123456
- keys * 验证是否可用

## Redis五种常用的value
- String hash（适于存储对象）
- list（类似LinkedList） 
- set（无序集合，不允许重复，类似HashSet） 
- zset/sorted set（每个元素关联一个分数，根据分数高低排序，如视频播放排行榜）

## Redis常用命令
### 字符串
- set key value
- get key
- setex key seconds value 指定时间设置（短信验证码）
- setnx key value  只有key不存在时才设置key

### hash
- hset key field value
- hget key field
- hdel key field
- hkeys key 获取hash表中所有字段（field）
- hvals key 获取hash表中所有值（value）

### list
- lpush key value... 将一个/多个值插入列表头部（LPUSH mylist a b c）
- lrange key begin end 获取列表指定范围内元素
- rpop key 移除并获取列表最后一个元素
- llen key 获取列表长度

### set
- sadd key member...
- smembers key
- scard key 返回数量
- sinter key1 key2
- sunion key1 key2 交并集运算
- srem key member..  删除

### zset 
- zadd key score1 member1 score2 member2...(分数是float)
- zrange key begin end （加withscores返回分数） 0 2 表示排名为1 2 3的成员（从小到大）
- zincrby key increment member 
- zrem key member...

### 通用命令
- keys * 所有key
- keys set* 所有set类型的key
- exists key
- type key
- del key

### java使用SpringDataRedis
- pom文件-配置文件配置
- 在configuration中加配置类
- 在测试包中测试

## 设置营业状态
- 新增两个shopController，需要给两个同名bean设置不同名

## 使用HttpClient构造与发送请求
- 阿里云oss-sdk的依赖中使用到了
- 在测试类中测试
- 在common包下的Util包中有工具类

## 微信小程序的使用
- 密钥：aeacd9bf2b513ef312bf7011c88605ee
- 小程序不使用模板开始！
- 右上角-详情-本地设置-不校验合法域名
- 在配置文件中配置微信数据与配置用户端的token
- 写微信登录：三层，再加拦截器，到配置类配置拦截器
- 加入微信请求返回需要的三层

## Day8
- 通过redis来缓存查询的数据：用户查询则读取缓存，没有就去找数据库
- 商家跟新时需要及时修改缓存:清理缓存，全清理，或者插入操作单独清理

## springcache:实现了基于注解的缓存功能
- 使用需要导入maven坐标，详情见springcache-demo，看启动类与控制类
- @EnableCache:开启注解缓存功能，一般用于启动类
- @cacheable：方法执行前先查询缓存中数据，查到直接返回，没有则调用方法，并将返回值放到缓存中
- @CachePut：将方法返回值放到缓存中
- @CacheEvict：将一条或者多条数据从缓存中删除

## 在项目中使用SpringCache
- 导入坐标spring-boot-starter-cache
- 在启动类上开启缓存注解功能
- 在用户端查setMeal列表的时候加上cacheable注解
- 在管理端改数据库库的时候加上CacheEvict注解

## 购物车开发
- 在设计数据库时，冗余数据可以提高数据库访问速度
- 购物车ShoppingCart开发,再次使用到了动态sql，BeanUtils，通过线程获取用户ID

## 地址模块功能开发
- 订单表分为订单表与订单明细表
- 在controller为用户端指定Bean名字，防止与客户端重复名字

## 微信支付模块
- 安装内网穿透软件cpolar
- cpolar.exe authtoken OWY1MjVmMjYtMWQ4Ni00ZGIxLWEwYTItNmZlOTQ4NTkyMjIz
- 再使用xxx.exe http 8080 获取临时域名，生成的域名就能访问到电脑端口
- 在订单功能中完善微信支付，这一块没看，跳过，且无法使用

## 超时订单处理，订单完成处理，来单提醒与催单提醒

### cron表达式：和linux中的很像，分为6/7个域，秒分时日月周年
- 2024-05-20 14：50  就是0 50 14 20 5 ？ 2024 日和周往往只能定义一个
- 每秒用*表达
- 每隔五秒触发一次：0/5
- 每月10日最近工作日：10W
- 本月最后一天：L
- 本月最后一个周一：1L
- 指定某几个值用逗号
### SpringTask是用于定时自动处理任务的工具
- 使用：1.在启动类上加注解开启任务调度@EnableScheduling
- 2.自定义定时任务类

### task包中
- 超时订单处理：每分钟检查一次超时订单
- 派送订单处理：凌晨一点检查，存在则修改成已完成

## websocket
- 一种基于TCP的网络协议，一次握手即可使得浏览器与服务器实现全双工通信，并进行双向数据传输，类比通话
- 比如网页聊天与视频弹幕(我之前写聊天室的有点白学了....)
- 导入WebSocket坐标
- 在task（用于测试），websocket与配置包中都有websockt相关的类，启动html页面实验即可
- 在ngix中配置了反向代理：websockt请求ngix能转发到后端
- 在完成支付之后建立长连接，再发送信息，完成提醒订单功能