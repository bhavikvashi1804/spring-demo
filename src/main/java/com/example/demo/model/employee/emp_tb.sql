create table EMP_TB_EMP(
    emp_id number,
    first_name varchar2(1000),
    last_name varchar2(1000)
);

drop table EMP_TB_EMP;
truncate table EMP_TB_EMP;

select * from EMP_TB_EMP;

INSERT INTO EMP_TB_EMP VALUES (1, 'Bhavik', 'Vashi');
INSERT INTO EMP_TB_EMP VALUES (2, 'Raj', 'Patel');
INSERT INTO EMP_TB_EMP VALUES (3, 'Yash', 'Patel');
commit;