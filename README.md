DigitalChangeView
====
### 简介:
  这是一个用于实现像支付宝数字动画控件；

### Gradle: 
  compile 'net.kornan.digitalchange:digitalchange:0.0.1'
  
### 使用方法:
```
  <net.kornan.view.DigitalChangeView
        android:id="@+id/text_number"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:defaultValue="100" />
```
```
//支持小数和整数
textNumber.setNumber(100);
textNumber.setNumber(100, 3);

textNumber.setDuration(500);
//开始动画
textNumber.start();
```
  PS：app:defaultValue是用来设置默认值。
