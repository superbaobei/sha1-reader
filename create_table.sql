create database if not exists sha1_reader;
use sha1_reader;
create table  file_parsed_record(
    id int auto_increment primary key ,
    parent_file varchar(500) not null ,
    file_digest varchar(30) not null
) comment '文件解析记录表' charset utf8mb4;
