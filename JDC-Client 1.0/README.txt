前提要求
因为整合了jpcap，但是jpcap依赖于pcap，所以需要先安装:

Windows用户：winpcap(4.1.1版本或更高)
下载地址：http://www.winpcap.org/install/default.htm或直接从dependencies文件夹里找到并安装.
Linux用户：libpcap(1.1.1版本或更高)
下载地址：http://www.tcpdump.org/
(小提示：libpcap需要用gcc编译器make安装，如果闲麻烦或不会，可以直接将bin下面已经编译好的动静态链接库复制到/usr/lib/下)
libjpcap.so
libpcap.a
libpcap.so
libpcap.so.1
libpcap.so.1.1.1


使用方法
建议在Java虚拟机版本1.6或更高下运行：
Windows下：打开命令提示符cmd,cd 到JDC-Client.jar文件目录下：
执行java -jar JDC-Client.jar
根据运行提示信息首先输入网卡号 (注：您的电脑可能有多个网卡，并确保输入的一定是数字)
根据提示输入认证帐号
根据提示输入认证密码
认证成功或失败

Linux下：打开终端,cd 到JDC-Client.jar文件目录下：
执行java -jar JDC-Client.jar
根据运行提示信息首先输入网卡号 (注：您的电脑可能有多个网卡，并确保输入的一定是数字)
根据提示输入认证帐号
根据提示输入认证密码
认证成功或失败