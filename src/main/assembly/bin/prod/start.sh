#!/bin/bash

SpringBootJarCount=`find ../apps/*.jar|wc -l`

server=`find ../apps/*.jar`

if [ "$SpringBootJarCount" -gt 1 ];
then
echo -e "检测到重复的应用\n $server"
    exit 1
fi

if [ "$server" = "" ];
then
    echo -e "未检测到可启动的应用"
    exit 1
fi
JAVA_OPTS=" -server -Xmx6g -Xms6g -Xmn768m -XX:PermSize=768m -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70"

count=`ps -ef |grep java|grep $server|grep -v grep|wc -l`
if [ $count != 0 ];then
        echo "$server is running..."
else
        echo "Start $server success..."
        nohup java $JAVA_OPTS -jar $server > server.log 2>&1 &
fi

rm server.log
