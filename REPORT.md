# 软件工程实训任务一

## 1.阅读和描述样例工程

#### （1）fork样例工程并clone到本地

下载Git并登录，然后进入实训的Github网站，将仓库链接复制，选择想要clone到的文件夹地址，右键点击任意处，点击Git Bash，进入后输入git clone +粘贴+回车即可将样例工程clone到本地。

但是由于某些不知名的原因，git clone迟迟未能成功，最终选择在gitee上执行相同操作克隆成功

#### （2）对样例工程的类间关系的理解

运行游戏的主类是Game类，所以整个类图是在Game类的周围展开的。

~~~mermaid
classDiagram
CommandWords --> Command
Parser ..> Command
Parser --o Game
Room --o Game
Command --o Game
~~~



Game类提供了整个游戏主要流程的一些方法，创建所有房间，并将它们连接成迷宫，创建解析器，接收用户输入，并将用户输入转换成命令后开始运行游戏。同时将命令对应的操作也写在Game类中。

Room类是对游戏开始前对房间的操作，如创建房间、设置出口、设置房间关系等。

Command类和CommandWords类共同完成对命令词汇的说明。

Parser类是解析器类，用来对用户输入的命令进行解析。Parser类中的getCommand（）是接受用户所输入的命令，对用户输入的信息进行解析，初步检测用户命令是否属于有效的命令。showCommands（）是用于Game中的help功能。

## 2.标注样例工程中的代码

#### （1）基于javadoc规范标注代码

在查阅了一些javadoc的相关资料后，开始在idea上进行对样例工程中的代码的标注。但是实操过程中发现对刚查阅的内容基本没什么印象，还好在idea中输入/**点击回车就会直接出现注释格式，并且符合javadoc规范。

#### （2）注释后的代码提交到本地仓库，同步推送到远程仓库

在idea中有git的插件，直接下载到idea中并安装，然后commit到本地仓库即可。gitee的idea插件在官网上已经很久没有发布新版本了，但是在idea的Marketplace中找到了合适的版本。安装成功后，在设置中搜索gitee，在其中添加账号信息，就可以进行上传了。右键点击项目，Git，add，将项目缓冲，然后点击Push将其上传到远程仓库中，URL填写在gitee仓库网站上复制的URL。

## 3.扩展和维护样例工程

#### （1）对样例代码中多重if-else结构的改良

根据Readme文件中给出的提示，发现Game类的processCommand（）方法中存在多重if-else结构，这个解决方案不太好。因为这种解决方案如果要再添加新的命令需要在ifelse结构下面继续增加分支，会让整个代码十分臃肿。通过上网搜查信息，发现这种面向实现的变成方法可以通过策略模式转变为面向对象的方法。

策略模式：该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。即分别封装行为接口，实现算法族，超类里放行为接口对象，在子类里具体设定行为对象。

所以就将Game类中的processCommand（）方法应用策略模式改良。定义一个接口类Action，然后在接口的基础上创建一个枚举类，在枚举类中构造原代码中的三个动作：do、help、quit。然后在更改processCommand（）方法中的环境，调用枚举类的函数，最终实现目标。类间关系如下。

~~~mermaid
classDiagram
ProbableAct ..|> Action
class Action{
+boolean actions(Game game, Command command)
}
class ProbableAct{
stop=0
go
help
quit
}
~~~

#### （2）借助checkstyle工具对代码规范进行审查、改进

在idea自带的Marketplace中下载checkstyle插件并开启Sun check模式进行规则检查。根据checkstyle的提示对“{”、空格、ifelse的位置等等进行了修改，将其中方法携带的参数修改为了final格式。根据Suncheck的审查模式，在文件夹中增加了package-info.java文件。

