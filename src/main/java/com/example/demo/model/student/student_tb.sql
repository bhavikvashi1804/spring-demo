create table STUDENT_TB_STUDENT(
    student_id number,
    first_name varchar2(1000),
    last_name varchar2(1000)
);

drop table STUDENT_TB_STUDENT;

select * from STUDENT_TB_STUDENT;

INSERT INTO STUDENT_TB_STUDENT VALUES (1, 'Bhavik', 'Vashi');
INSERT INTO STUDENT_TB_STUDENT VALUES (2, 'Raj', 'Patel');
INSERT INTO STUDENT_TB_STUDENT VALUES (3, 'Yash', 'Patel');
commit;

select * from STUDENT_TB_STUDENT;