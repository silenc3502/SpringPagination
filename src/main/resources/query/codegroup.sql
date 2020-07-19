create table code_group (
    group_code varchar(3) not null,
    group_name varchar(30) not null,
    reg_date dateitme,
    upd_date datetime,
    use_yn varchar(1),
    primary key (group_code)
) engine=InnoDB;

create table code_detail (
    code_value varchar(3) not null,
    group_code varchar(3) not null,
    code_name varchar(30) not null,
    reg_date datetime,
    sort_seq integer not null,
    upd_date datetime,
    use_yn varchar(1),
    primary key (code_value, group_code)
) engine=InnoDB;

alter table code_detail add constraint cglink foreign key (group_code) references code_group (group_code);