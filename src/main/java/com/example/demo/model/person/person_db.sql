create table PERSON_TB_PERSON(
    person_id number,
    first_name varchar2(1000),
    last_name varchar2(1000)
);

drop table PERSON_TB_PERSON;
truncate table PERSON_TB_PERSON;

select * from PERSON_TB_PERSON;

INSERT INTO PERSON_TB_PERSON VALUES (1, 'Bhavik', 'Vashi');
INSERT INTO PERSON_TB_PERSON VALUES (2, 'Raj', 'Patel');
INSERT INTO PERSON_TB_PERSON VALUES (3, 'Yash', 'Patel');
commit;

select * from PERSON_TB_PERSON;