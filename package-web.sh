#!/bin/bash

basepath=`pwd`


cd $basepath/ruoyi-ui && npm install && npm run build:prod && mv dist docker/

