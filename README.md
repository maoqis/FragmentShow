# FragmentShow
Fragment cache ，show and hide.
基于android v4 Fragment 扩展一个缓存CacheFragment。
基于CacheFragment 提供 showFragment（），和hideFragment（）方法。
大家都知道ViewPager 切换Fragment 会创建当前选择posion 和posion左右两边的Fragment，相应的OnResume和onPause 方法也会相继调用。

demo简单的扩展了一个showFragment 和 hideFragment 方法，当ViewPager 切换的时候，只有新的当前posion的Fragment 会调用showFragment（），上一个posion对应的
Fragment 会调用hideFragment（）方法。


showFragment（）; 第一次进入或者切换到这个Fragment 时候会调用。
hideFragment（）; 从当前Fragment离开时候会调用该方法。

showFragment中可以做些当前Fragment 显示的时候需要做的操作，可能是判断是否刷新界面等等。


