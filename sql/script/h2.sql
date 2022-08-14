-- 将该建表 SQL 语句，添加到 yudao-module-mall-biz 模块的 test/resources/sql/create_tables.sql 文件里
CREATE TABLE IF NOT EXISTS "mall_lowcode_project" (
    "id" varchar NOT NULL,
    "userid" bigint,
    "name" varchar,
    "type" varchar,
    "industry" varchar,
    "config" varchar,
    "logo" varchar,
    "cover" varchar,
    "pages" varchar,
    PRIMARY KEY ("id")
) COMMENT '商城项目配置表';

-- 将该删表 SQL 语句，添加到 yudao-module-mall-biz 模块的 test/resources/sql/clean.sql 文件里
DELETE FROM "mall_lowcode_project";
