前提条件：
Windows用户需要安装WinPcap
可以从官网下载最新版本：http://www.winpcap.org/install/default.htm
或从仓库中checkout下来：svn checkout http://jdc-client.googlecode.com/svn/trunk/Dependencies/ lib-read-only

Linux用户需要安装libpcap
可以从官网下载最新版本：http://www.tcpdump.org/
或从仓库中checkout下来：svn checkout http://jdc-client.googlecode.com/svn/trunk/Dependencies/ lib-read-only

项目结构：
bin\JDC-Client.jar
src\
Jpcap.dll
libjpcap.so
dependencies
dependencies\

使用方法：
cmd下或终端下进入bin目录
java -jar JDC-Client.jar

Java虚拟机版本：
jdk1.6.0_21