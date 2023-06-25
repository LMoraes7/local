create table student(
  id varchar(13) primary key,
  name varchar(255) not null,
  document_type char not null,
  document_value varchar(14) unique not null,
  email varchar(255) unique not null,
  phones varchar(12) []
);