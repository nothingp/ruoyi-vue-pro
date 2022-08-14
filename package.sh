#!/bin/bash

basepath=`pwd`

mvn clean install -Dmaven.test.skip=true

cd $basepath/yudao-server && docker build -t registry.cn-hangzhou.aliyuncs.com/nothing/ruoyi-vue-pro:test .

