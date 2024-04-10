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