create table company_user (
    company_id varchar(255) not null,
    user_id varchar(255) not null
) engine=InnoDB;
alter table company_user add constraint FK41rvbqysbnk2nbmfrg2ut1rj3 foreign key (user_id) references UserDetail (id);
alter table company_user add constraint FKptbb8xpt9w0vfd4ahwdyek6ik foreign key (company_id) references CompanyDetail (id);

