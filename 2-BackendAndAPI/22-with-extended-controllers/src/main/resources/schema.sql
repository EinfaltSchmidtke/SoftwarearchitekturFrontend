create table T_CUSTOMER (
    ID integer identity primary key, 
    PASSWORD varchar(32) not null,
    PRENAME varchar(100) not null,
    SURNAME varchar(100) not null,
    BIRTHDATE date not null,
    STREET varchar(100) not null,
    STREETNO varchar(10) not null,
    ZIPCODE varchar(20) not null,
    CITY varchar(30) not null,
    COUNTRY varchar(30) not null,
    IBAN varchar(22) not null,
    ACTIVE integer not null
);

create table T_PRODUCT (
    ID integer identity primary key, 
    NAME varchar(100) not null,
    SHORT_DESCRIPTION varchar(50) not null,
    LONG_DESCRIPTION varchar(255),
    PRODUCT_IMAGE varchar(255),
    PRICE decimal not null,
    VAT integer not null,
    ACTIVE integer not null
);

create table T_EMPLOYEE (
    ID integer identity primary key, 
    PASSWORD varchar(32) not null,
    PRENAME varchar(100) not null,
    SURNAME varchar(100) not null,
    ACTIVE integer not null
);

create table T_SHOP (
    ID integer identity primary key,
    NAME varchar(100) not null,
    DESCRIPTION varchar(255) not null,
    SHOP_IMAGE varchar(255)
);

create table T_ORDER (
    ID integer identity primary key, 
    CUSTOMER_ID integer not null,
    ORDER_DATE date not null,
    ORDER_STATUS int not null,
    IBAN varchar(22) not null
);

create table T_ORDER_ITEM (
    ID integer identity primary key, 
    ORDER_ID integer not null,
    PRODUCT_ID integer not null,
    AMOUNT integer not null,
    PRICE decimal not null,
    VAT integer not null
);

alter table T_ORDER add foreign key (CUSTOMER_ID) references T_CUSTOMER(id);
alter table T_ORDER_ITEM add foreign key (ORDER_ID) references T_ORDER(id);
alter table T_ORDER_ITEM add foreign key (PRODUCT_ID) references T_PRODUCT(id);