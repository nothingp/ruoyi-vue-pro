#!/bin/bash

basepath=`pwd`


cd $basepath/yudao-ui-admin && npm install && npm run build:prod && mv dist docker/

