## dowc是什么?

是一个可以帮你快速完成开发文档的工具

## dowc有哪些功能？

* 功能一 
* 生成一个包下所有的开发文档
* ClassGet cn=new ClassGet();
* String packages = "com.bs.work.model";//要生成文档的包名
* String prefix="src.main.java";
* String path="D:/wordTest/";//要生成位置的本地路径
* boolean classInfo = cn.classInfo(packages, prefix,path);
* ------------------------------------------
* 功能二
* 生成指定的类开发文档
* ClassGet cn=new ClassGet();
* String path="D:/wordTest/";
* Boolean classInfo=cn.classInfo("com.bs.work.controller.UserController", path);//第一个参数需要填写制定的类的全路径
* ------------------------------------------
* 功能三
* 根据word的模板生成一个包下的所有类的开发文档
* 假如我的word模板路径为"src/createdoc/test.ftl"
* String ftlName="test";//word模板名称
* String ftlPath="/createdoc";//word模板的路径
* String packages = "Test";
* String prefix="src";
* String path="D:/test/";
* boolean classInfo = cn.classInfo(packages, prefix,path,ftlName,ftlPath);
* ------------------------------------------
* 功能四
* 根据word的模板生成指定的类开发文档
* String ftlName="test";//word模板名称
* String ftlPath="/createdoc";//word模板的路径
* String path="D:/wordTest/";//本地保存的路径
* boolean classInfo = cn.classInfo("com.bs.work.controller.ExcelController", path,ftlName,ftlPath);
* 功能五
* 根据注解自动生成功能说明（根据实际情况选择用不用）
* 在方法上面添加注解：
* @Fc("功能说明")
* 即可对应到文档的功能说明中
	

## 有问题反馈

* 在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件(625073235#qq.com)
* QQ: 625073235


## 支持开发者

在兴趣的驱动下,写一个`免费`的东西，有欣喜，也还有汗水，希望你喜欢我的作品，同时也能支持一下。


## 关于作者

```javascript
  var people = {
    nickName  : "wei.ding"
  }
```
