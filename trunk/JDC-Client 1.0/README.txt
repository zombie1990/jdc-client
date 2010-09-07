前提条件：
Windows用户需要安装WinPcap
可以从官网下载最新版本：http://www.winpcap.org/install/default.htm
或从dependencies文件夹里找到WinPcap_4_1_2.7z
解压后安装 WinPcap-4.1.2

Linux用户需要安装libpcap
可以从官网下载最新版本：http://www.tcpdump.org/
或从dependencies文件夹里找到libpcap-1.1.1.tar.gz 
解压后
./configure
make
makeinstall

没有gcc，yacc，flex的Linux用户有一个简便的方法，直接把bin目录下的找到下面5个文件
libjpcap.so
libpcap.a
libpcap.so
libpcap.so.1
libpcap.so.1.1.1
运行命令
chmod 755 lib*
cp lib* /usr/lib/

项目结构：
bin\JDC-Client.jar
bin\Jpcap.dll
bin\libjpcap.so
src\
dependencies\

使用方法：
cmd下或终端下进入bin目录
java -jar JDC-Client.jar

Java虚拟机版本：
jdk1.6.0_21

--by xiyu(细雨)