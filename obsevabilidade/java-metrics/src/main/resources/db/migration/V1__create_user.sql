create table users(
	id varchar(12) not null primary key,
	username varchar(255) not null unique,
	password varchar(255) not null
);

create table access_profiles(
	id varchar(12) not null primary key,
	name varchar(30) not null unique
);

create table users_access_profiles(
	user_id varchar (12) not null,
	access_profile_id varchar (12) not null,
	constraint fk_users foreign key (user_id) references users(id),
	constraint fk_access_profiles foreign key (access_profile_id) references access_profiles(id)
);