create table functions(
    id varchar(13) not null primary key,
    name varchar(20) not null unique
);

create table profiles(
    id varchar(13) not null primary key,
    name varchar(20) not null unique
);

create table profile_functions(
    id_profile varchar(13) not null,
    id_function varchar(13) not null,
    constraint fk_profile_functions foreign key (id_profile) references profiles (id),
    constraint fk_function_profiles foreign key (id_function) references functions (id)
);

create table employees(
	id varchar(13) not null primary key,
	name varchar(255) not null,
	document varchar(11) not null unique,
	email varchar(255) not null unique,
	phones text[2] not null,
	address text[2] not null,
	birth_date date not null,
	role varchar(100) not null,
	access_code varchar(10) not null unique,
	password varchar(10) not null
);

create table employee_profiles(
    id_employee varchar(13) not null,
    id_profile varchar(13) not null,
    constraint fk_employee_profile foreign key (id_employee) references employees (id),
    constraint fk_profile_employee foreign key (id_profile) references profiles (id)
);

create table candidates(
	id varchar(13) not null primary key,
    name varchar(255) not null,
    document varchar(11) not null unique,
    email varchar(255) not null unique,
    phones text[2] not null,
    address text[2] not null,
    birth_date date not null,
	access_code varchar(10) not null unique,
    password varchar(10) not null
);

create table candidate_profiles(
    id_candidate varchar(13) not null,
    id_profile varchar(13) not null,
    constraint fk_candidate_profile foreign key (id_candidate) references candidates (id),
    constraint fk_profile_candidate foreign key (id_profile) references profiles (id)
);

create table selection_processes(
	id varchar(13) not null primary key,
	title varchar(255) not null,
	description text not null,
	desired_position varchar(100) not null,
	responsibilities text[] not null,
	requirements text[] not null,
	additional_informations text[] null,
	status varchar(100) not null,
	constraint fk_responsible_selection_processes foreign key (id_responsible) references employees (id)
);

create table selection_processes_responsibles(
	id_selective_process varchar(13) not null,
	id_responsible varchar(13) not null,
	start_date date not null,
	end_date date null,
	constraint fk_selective_process_responsible foreign key (id_selective_process) references selection_processes (id),
	constraint fk_responsible_selective_process foreign key (id_responsible) references employees (id)
);

create table steps(
    id varchar(13) not null primary key,
    title varchar(255) not null,
    description text not null,
    type varchar(100) not null,
    infos text[] null
);

create table selection_processes_steps(
	id_selective_process varchar(13) not null,
	id_step varchar(13) not null,
	id_next_step varchar(13) null,
	deadline bigint null,
	constraint fk_selective_process_step foreign key (id_selective_process) references selection_processes (id),
	constraint fk_step_selective_process foreign key (id_step) references steps (id),
	constraint fk_next_step_selective_process foreign key (id_next_step) references steps (id)
);

create table applications(
	id varchar(13) not null primary key,
	status varchar(100) not null,
	id_candidate varchar(13) not null,
	id_selection_processes varchar(13) not null,
	constraint fk_candidate_application foreign key (id_candidate) references candidates (id),
	constraint fk_selection_processes_applications foreign key (id_selection_processes) references selection_processes (id)
);

create table steps_applications(
    id_application varchar(13) not null,
    id_step varchar(13) not null,
    id_next_step varchar(13) null,
    status varchar(100) not null,
    release_date date null,
    info_upload_files text[] null, -- arquivo e tipo do arquivo (PDF, MP4, ...)
    info_interview text[] null, -- link da entrevista e data e hora da entrevista
    info_test text[] null, -- id da questao discursiva junto com a sua resposta
    constraint fk_application_step foreign key (id_application) references applications (id),
    constraint fk_step_application foreign key (id_step) references steps (id),
    constraint fk_next_step_application foreign key (id_next_step) references steps (id)
);

create table feedback(
    id varchar(13) not null primary key,
    result varchar(100) not null,
    score decimal(3, 1) not null,
    additional_information text null,
    id_application varchar(13) not null,
    id_step varchar(13) not null,
    constraint fk_feedback_application foreign key (id_application) references id_applications (id)
    constraint fk_feedback_step foreign key (id_step) references steps (id)
);

create table questions(
    id varchar(13) not null primary key,
    description text not null,
    type varchar(100) not null -- discursiva, múltipla escolha, ...
);

create table answers(
    id varchar(13) not null primary key,
    answer text not null,
    correct boolean not null,
    id_question varchar(100) not null,
    constraint fk_question_answer foreign key (id_question) references questions (id)
);

create table steps_questions(
    id_step varchar(13) not null,
    id_question varchar(13) not null,
    constraint fk_step_questions foreign key (id_step) references steps (id),
    constraint fk_questions_step foreign key (id_question) references questions (id)
);