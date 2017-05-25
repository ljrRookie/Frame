# 常用App框架(Fragment+RadioGroup)

# 启动页+主页面
![img](https://github.com/ljrRookie/Frame/blob/master/Frame/GIF.gif)<br>
## 启动页：
1. 延迟两秒跳转主页面: <br>
new Handler().postDelayed(new Runnable() {<br>
        @Override<br>
        public void run() {<br>
          //在主线程中执行<br>
           startActivity(new Intent(LauncherActivity.this,MainActivity.class));<br>
            finish();<br>
         }<br>
        },2000);<br>
2. 底部更新当前日期。<br>
## 主页面：
#### 线性布局：   titlebar(高度50dp)+FrameLayout(设置权重为1)+RadioGroup(实现底部导航栏)
#### 遇到的问题：
### 1. 切换Fragment导致重新创建Fragment问题（切换Fragment导致重新初始化）
![img](https://github.com/ljrRookie/Frame/blob/master/Frame/%E9%87%8D%E5%A4%8D%E5%88%9D%E5%A7%8B%E5%8C%96.JPG)<br>
### 原因：
在项目中切换Fragment，一直都是用replace()方法来替换Fragment。<br>
但是这样做有一个问题，每次切换的时候Fragment都会重新实列化，重新加载一次数据，这样做会非常消耗性能用用户的流量。<br>
官方文档解释说：replace()这个方法只是在上一个Fragment不再需要时采用的简便方法。<br>

### 解决方法：
正确的切换方式是add()，切换时hide()，add()另一个Fragment；<br>
再次切换时，只需hide()当前，show()另一个。<br>
这样就能做到多个Fragment切换不重新实例化。<br>
### 2. 横竖屏切换导致的Fragment内容重叠
![img](https://github.com/ljrRookie/Frame/blob/master/Frame/%E6%A8%AA%E7%AB%96%E5%B1%8F%E5%88%87%E6%8D%A2%E9%94%99%E8%AF%AF.JPG)<br>
### 原因:
当系统配置发生改变后，Activity会重新创建。

### 解决方法：
![img](https://github.com/ljrRookie/Frame/blob/master/Frame/%E8%A7%A3%E5%86%B3%E6%A8%AA%E7%AB%96%E5%B1%8F%E5%88%87%E6%8D%A2%E5%AF%BC%E8%87%B4%E9%87%8D%E6%96%B0%E5%88%9D%E5%A7%8B%E5%8C%96%E9%97%AE%E9%A2%98.JPG)<br>
如果当某项内容发生改变后，我们不想系统重新创建Activity，就可以给Activity指定configChanges属性。<br>
##### configChanges属性总结： [http://blog.csdn.net/zhaokaiqiang1992/article/details/19921703](http://blog.csdn.net/zhaokaiqiang1992/article/details/19921703).

# OkHttp
##### OkHttpUtils：[https://github.com/ljrRookie/okhttputils]
![img](https://github.com/ljrRookie/Frame/blob/master/Frame/okhttp.gif)<br>
##### OkHttpUtils的优势
###### 优势一：
性能高，专注于简单易用的网络请求，使用主流的okhttp进行封装，对于okhttp大家都知道，在Android4.4的源码中可以看到HttpURLConnection已经替换成OkHttp实现了，并且支持HTTP2/SPDY黑科技，支持socket自动选择最好路线，并支持自动重连，拥有自动维护的socket连接池，减少握手次数，拥有队列线程池，轻松写并发。<br>
###### 优势二：
特有的网络缓存模式，是大多数网络框架所不具备的，说一个应用场景，老板说我们的app不仅需要在有网的情况下展示最新的网络数据，还要在没网的情况下使用缓存数据，这时候是不是项目中出现了大量的代码判断当前网络状况，根据不同的状态保存不同的数据，然后决定是否使用缓存。细想一下，这是个通用的写法，于是OkHttpUtils提供了四种缓存模式，让你不用关心缓存的实现，而专注于数据的处理。<br>
###### 优势三：
方便易用的扩展接口，可以添加全局的公共参数，全局拦截器，全局超时时间，更可以对单个请求定制拦截器，超时时间，请求参数修改等等，在使用上更是方便，原生支持的链式调用让你的请求更加清晰。<br>
###### 优势四：
强大的Cookie保持策略，我们知道在客户端对cookie的获取是个不太简单的事情，特别是还要处理cookie的过期时间，持久化策略等等，OkHttpUtils帮你彻底解决Cookie的难题，默认拥有内存存储和持久化存储两种实现，cookie全程自动管理，并且提供了额外的addCookie方式，允许介入到自动管理的过程中，添加你想创建的任何cookie。<br>
