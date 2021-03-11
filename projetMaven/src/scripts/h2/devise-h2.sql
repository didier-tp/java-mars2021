create table Devise(code varchar(8) not null primary key,
                   monnaie varchar(128) not null,
                   d_change double);
                   
insert into devise(code,monnaie,d_change) values('EUR','euro',0.9);
insert into devise(code,monnaie,d_change) values('USD','dollar',1);
insert into devise(code,monnaie,d_change) values('JPY','yen',125);
insert into devise(code,monnaie,d_change) values('GBP','livre',0.8);

select * from devise;