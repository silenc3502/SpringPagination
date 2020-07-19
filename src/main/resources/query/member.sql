create table member (
    user_no bigint not null auto_increment,
    coin integer not null,
    job varchar(3) not null,
    reg_date datetime,
    upd_date datetime,
    user_id varchar(50) not null,
    user_name varchar(100) not null,
    user_pw varchar(200) not null,
    primary key (user_no)
) engine=InnoDB;

create table member_auth(
    user_auth_no bigint not null auto_increment,
    auth varchar(50),
    reg_date datetime,
    upd_date datetime,
    user_no bigint,
    primary key (user_auth_no)
) engine=InnoDB;

alter table member_auth add constraint mlink foreign key (user_no) references member (user_no);