create table directory (
  id number not null,
  created_date timestamp not null,
  directory_path varchar2(255) not null,
  primary key (id)
);

create table files (
  id number not null,
  file_size long,
  file_name varchar2(255) not null,
  directory_id number not null,
  primary key(id),
  constraint fk_file_dir foreign key (directory_id) references directory(id)
);

CREATE SEQUENCE directory_id_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

CREATE SEQUENCE file_id_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

create or replace TRIGGER directory_id_seq_trigger
  BEFORE INSERT 
  ON directory
  FOR EACH ROW
  WHEN (new.id is null)
DECLARE
  v_id directory.id%TYPE;
BEGIN
  SELECT directory_id_seq.nextval INTO v_id FROM DUAL;
  :new.id := v_id;
END directory_id_seq_trigger;

create or replace TRIGGER file_id_seq_trigger
  BEFORE INSERT 
  ON files
  FOR EACH ROW
  WHEN (new.id is null)
DECLARE
  v_id files.id%TYPE;
BEGIN
  SELECT file_id_seq.nextval INTO v_id FROM DUAL;
  :new.id := v_id;
END file_id_seq_trigger;