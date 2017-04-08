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

