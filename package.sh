#!/bin/bash

basepath=`pwd`

mvn clean install -Dmaven.test.skip=true

cd $basepath/yudao-server && docker build -t ccr.ccs.tencentyun.com/yi_qi_hui_zhan/ruoyi-vue-pro:latest .