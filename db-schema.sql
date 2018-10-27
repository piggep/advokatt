
    create table client (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        account varchar(255),
        adress varchar(255),
        city varchar(255),
        email varchar(255),
        id_number varchar(255),
        mobile varchar(255),
        name varchar(255),
        not_wanted bit,
        note varchar(255),
        payment_days integer,
        payment_note varchar(255),
        phone varchar(255),
        site varchar(255),
        vat varchar(255),
        zip varchar(255),
        client_type bigint,
        primary key (id)
    );

    create table client_type (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        name varchar(255),
        primary key (id)
    );

    create table errand (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        active bit,
        archive_nr varchar(255),
        billable bit,
        end_date datetime,
        end_note varchar(255),
        errand_note varchar(255),
        errand_nr varchar(255),
        internal bit,
        objective_nr varchar(255),
        reference varchar(255),
        start_date datetime,
        client_id bigint,
        errand_group bigint,
        primary key (id)
    );

    create table errand_group (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        name varchar(255),
        primary key (id)
    );

    create table expense (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        date datetime,
        description varchar(255),
        is_billable bit,
        price integer,
        errand_id bigint,
        primary key (id)
    );

    create table part (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        account varchar(255),
        adress varchar(255),
        city varchar(255),
        email varchar(255),
        id_number varchar(255),
        mobile varchar(255),
        name varchar(255),
        not_wanted bit,
        note varchar(255),
        payment_days varchar(255),
        payment_note varchar(255),
        phone varchar(255),
        site varchar(255),
        vat varchar(255),
        zip varchar(255),
        errand_id bigint,
        part_role bigint,
        primary key (id)
    );

    create table part_role (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        name varchar(255),
        primary key (id)
    );

    create table time_entry (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        date datetime,
        description varchar(255),
        is_billable bit,
        price double precision,
        quantity integer,
        errand_id bigint,
        primary key (id)
    );

    alter table client 
        add constraint FKj6sgv8lg86scd7hcsm6bons28 
        foreign key (client_type) 
        references client_type (id);

    alter table errand 
        add constraint FKjdkoqv386i9fle4r7sqq7lk0y 
        foreign key (client_id) 
        references client (id);

    alter table errand 
        add constraint FKj4np7yphirhl3060rj3id3ktr 
        foreign key (errand_group) 
        references errand_group (id);

    alter table expense 
        add constraint FKgncw4tuhpow1son2gmuhc5iuw 
        foreign key (errand_id) 
        references errand (id);

    alter table part 
        add constraint FKhxtxwh3oej55h1n0ceit5qfrk 
        foreign key (errand_id) 
        references errand (id);

    alter table part 
        add constraint FKo30sv0d4gjsu15u8iki3d09ya 
        foreign key (part_role) 
        references part_role (id);

    alter table time_entry 
        add constraint FKspt5a4gbhtmtsgkek9swv7xsr 
        foreign key (errand_id) 
        references errand (id);
