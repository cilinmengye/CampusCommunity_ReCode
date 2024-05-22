# 接口文档

## 1. 用户模块

### 1.1 注册：

接口功能：

> 本接口用于注册

接口请求地址：

```javascript
/user/register
```

**请求头 :**

| 请求头       | 请求内容         | 说明 |
| :----------- | :--------------- | :--- |
| Content-Type | application/json |      |

**请求方式:  POST**

**参数类型** ：**JSON**

##### 请求示例：

```javascript
{
    "account": "202126202206",
    "password": "834430027"
}
```

##### 请求参数说明

| 字段名   | 字段说明                | 字段类型    | 是否必填 |
| :------- | :---------------------- | :---------- | :------- |
| account  | 学号,  5~20位纯数字     | varchar(20) | 是       |
| password | 密码,5~20位的数字或字母 | varchar(20) | 是       |

请求成功：

```json
{
    "success": true,
    "code": 200,
    "errorMsg": null,
    "data": null,
    "total": null
}
```

请求失败：

```json
{
    "success": false,
    "code": 400,
    "errorMsg": "用户名已经存在!",
    "data": null,
    "total": null
}
```

## 2. 帖子

### 2.1 创建帖子

接口请求地址：

```javascript
/blog/create
```

**请求方式:  POST**

**参数类型** ：**JSON**

##### 请求示例：

绝大多数为json，格式自定

```json
{
    "title": "无名",
    "content": "花有重开日，人无再少年",
    "images": "/images/blogs/default.jpg",
    "tags": ["风景", "美丽"]
}
```

##### 响应示例

成功响应编码：

```json
{
    "success": true,
    "code": 200,
    "errorMsg": null,
    "data": id,
    "total": null
}
```

##### 响应参数说明

| 接口返回码 | 接口返回描述 |
| :--------- | :----------- |
| 200        | 成功         |
| 400        | 请求参数异常 |
| 500        | 系统异常     |

### 2.2 查询帖子

接口功能：

> 本接口用于返回所有的帖子

接口请求地址：

```javascript
/blog?pageNo={页码}&size={一页的大小}&tab={查询类型} 
tab = last / hot
```

**请求头 :**

| 请求头        | 请求内容        | 说明 |
| :------------ | :-------------- | :--- |
| Authorization | Basic secretKey |      |

**请求方式:  GET**

##### 响应示例

成功响应编码：

```
{
    "success": true,
    "code": 200,
    "errorMsg": null,
    "data": [
        {
            "id": 531,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "一剪梅·雨打梨花深闭门",
            "images": "/images/blogs/default.jpg",
            "content": "解释：深闭闺门，隔窗只听雨打梨花的声音，就这样辜负了青春年华，虚度了青春年华。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:09",
            "updateTime": "2023-04-25T16:41:09"
        },
        {
            "id": 532,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "〔明代〕",
            "images": "/images/blogs/default.jpg",
            "content": "风波世路信多艰，千里羁危未得还。慈母倚门垂白发，故园回首隔青山。交游半达云霄上，弟妹相亲梦寐间。寂莫空斋谁顾问，只将诗句慰愁颜。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:10",
            "updateTime": "2023-04-25T16:41:10"
        },
        {
            "id": 533,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "春宵",
            "images": "/images/blogs/default.jpg",
            "content": "解释：春天的夜晚，即便是极短的时间也十分珍贵。花儿散发着淡淡的清香，月光在花下投射出朦胧的阴影。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:10",
            "updateTime": "2023-04-25T16:41:10"
        },
        {
            "id": 534,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "〔宋代〕",
            "images": "/images/blogs/default.jpg",
            "content": "十月九日，孟亨之置酒秋香亭。有双拒霜，独向君猷而开，坐客喜笑，以为非使君莫可当此花，故作是篇。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:11",
            "updateTime": "2023-04-25T16:41:11"
        },
        {
            "id": 535,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "题都城南庄",
            "images": "/images/blogs/default.jpg",
            "content": "解释：今日再来此地，那佳人已不知所踪，只有桃花依旧，含笑怒放春风之中。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:11",
            "updateTime": "2023-04-25T16:41:11"
        },
        {
            "id": 536,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "〔唐代〕",
            "images": "/images/blogs/default.jpg",
            "content": "去年今日此门中，人面桃花相映红。人面不知何处去，桃花依旧笑春风。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:12",
            "updateTime": "2023-04-25T16:41:12"
        },
        {
            "id": 537,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "绝句",
            "images": "/images/blogs/default.jpg",
            "content": "解释：杏花时节的蒙蒙细雨，像故意要沾湿我的衣裳似的下个不停；吹拂着脸庞的微风已感觉不到寒意，嫩绿的柳条随风舞动，格外轻飏。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:12",
            "updateTime": "2023-04-25T16:41:12"
        },
        {
            "id": 538,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "〔宋代〕",
            "images": "/images/blogs/default.jpg",
            "content": "None",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:13",
            "updateTime": "2023-04-25T16:41:13"
        },
        {
            "id": 539,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "八六子·倚危亭",
            "images": "/images/blogs/default.jpg",
            "content": "解释：当年在夜月里，我们共同醉入一帘幽梦，温柔的春风吹拂着你我。",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:13",
            "updateTime": "2023-04-25T16:41:13"
        },
        {
            "id": 540,
            "userId": 1637365529700831234,
            "nickName": "菠萝",
            "icon": "/user/default.jpg",
            "title": "〔宋代〕",
            "images": "/images/blogs/default.jpg",
            "content": "None",
            "liked": 0,
            "comments": 0,
            "type": 1,
            "createTime": "2023-04-25T16:41:14",
            "updateTime": "2023-04-25T16:41:14"
        }
    ],
    "total": 10
}
```

## 3. 文件模块

### 3.1 上传

接口功能：

> 本接口用于上传文件

接口请求地址：

```javascript
/common/upload/{type}
```

**请求头 :**

| 请求头        | 请求内容                                                     | 说明           |
| :------------ | :----------------------------------------------------------- | :------------- |
| Authorization | Basic secretKey                                              | 访问token      |
| Content-Type  | multipart/form-data; boundary=<calculated when request is sent> | 请求体中的内容 |

**请求方式:  POST**

**参数类型** ：**文件**

##### 请求示例：

绝大多数为json，格式自定

```json
http://localhost:9090/common/upload/blogs
```

##### 请求参数说明

| 字段名 | 字段说明                            | 字段类型    | 是否必填 |
| :----- | :---------------------------------- | :---------- | :------- |
| type   | 传入图片属于哪个模块（users,blogs） | varchar(50) | 是       |

##### 响应示例

成功响应编码：

```json
{
    "success": true,
    "code": 200,
    "errorMsg": null,
    "data": "https://intelligent-campus-community.oss-cn-beijing.aliyuncs.com/blogs/4d75cd24-980e-449d-b365-9d004630f7f8.jpg",
    "total": null
}
```



# 数据库建表

## User

```sql
create table users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    account varchar(20) UNIQUE,
    password VARCHAR(512),
    nickName varchar(50),
    personalizedSignature TEXT,
    bgImage varchar(512),
    identity varchar(20),
    name varchar(20),
    grade INT,
    major varchar(20),
    icon varchar(512),
    honor TEXT
);
alter table users add column introduce text;
alter table users add column fans INT default 0;
alter table users add column goods INT default 0;
alter table users add column email varchar(32);
```

## BlogPost

```sql
create table blogPost(
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         userId INT,
                         title TEXT,
                         images varchar(512),
                         content Text,
                         liked INT,
                         comments INT,
                         tags Text,
                         createTime DATE,
                         updateTime DATE,
                         FOREIGN KEY (userId) REFERENCES users(id)
);
ALTER table blogpost CHANGE COLUMN tags tagsStr TEXT;
```

## Follow

````sql
create table follow(
    userId INT,
    beFollowId INT,
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (beFollowId) REFERENCES users(id)
);
````

## Comment

```sql
create table comment(
    id INT AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    blogId INT,
    comment TEXT
);
alter table comment add column createTime DATE;
```

