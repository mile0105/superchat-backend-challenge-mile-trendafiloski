create table if not exists contact(
    id identity primary key,
    email varchar(255) not null,
    name varchar(255) not null
);

create table if not exists message(
    id identity primary key,
    content varchar(255) not null,
    channel varchar(255) not null,
    sender_id int not null,
    recipient_id int not null,
    time timestamp not null,
    constraint sender_id_constraint foreign key(sender_id) references contact(id),
    constraint recipient_id_constraint foreign key (recipient_id) references contact(id)
);

create table if not exists placeholder (
   editor_id int not null,
   placeholder varchar(255) not null,
   target_id int not null,
   constraint editor_id_constraint foreign key(editor_id) references contact(id),
   constraint target_id_constraint foreign key(target_id) references contact(id)
);

