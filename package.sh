#!/bin/bash

basepath=`pwd`

mvn clean install -Dmaven.test.skip=true

cd $basepath/yudao-server && docker build -t ccr.ccs.tencentyun.com/chang_an/ruoyi-vue-pro:latest .