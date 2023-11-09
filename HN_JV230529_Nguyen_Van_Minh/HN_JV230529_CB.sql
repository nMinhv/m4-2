-- Bài 1: Tạo CSDL
DROP DATABASE IF EXISTS QUANLYDIEMTHI;
CREATE DATABASE QUANLYDIEMTHI;
USE QUANLYDIEMTHI;
CREATE TABLE STUDENT
(
    studentId   VARCHAR(4) PRIMARY KEY NOT NULL,
    studentName VARCHAR(100)           NOT NULL,
    birthday    DATE                   NOT NULL,
    gender      BIT(1)                 NOT NULL,
    address     TEXT                   NOT NULL,
    phoneNumber VARCHAR(45) UNIQUE
);
CREATE TABLE _SUBJECT
(
    subjectId   VARCHAR(4) PRIMARY KEY NOT NULL,
    subjectName VARCHAR(45)            NOT NULL,
    priority    INT(11)                NOT NULL
);
CREATE TABLE MARK
(
    subjectId VARCHAR(4) NOT NULL,
    studentId VARCHAR(4) NOT NULL,
    points    FLOAT      NOT NULL,
    FOREIGN KEY studentId (studentId) REFERENCES STUDENT (studentId),
    FOREIGN KEY subjectId (subjectId) REFERENCES _SUBJECT (subjectId)
);
ALTER TABLE MARK
    ADD CONSTRAINT PRIMARY KEY pk_subjectId_studentId (studentId, subjectId);
-- Bài 2: Thêm , sửa , xoá dữ liệu
-- 1 Thêm
INSERT INTO STUDENT
VALUES ('S001', 'Nguyễn Thế Anh', '1999-11-01', 1, 'Hà Nội', '984678082'),
       ('S002', 'Đặng Bảo Trâm', '1998/12/22', 0, 'Lào Cai', '904982654'),
       ('S003', 'Trần Hà Phương', '2000/05/05', 0, 'Nghệ An', '947645363'),
       ('S004', 'Đỗ Tiến Mạnh', '1999/03/26', 1, 'Hà Nội', '983665353'),
       ('S005', 'Phạm Duy Nhất', '1998/10/04', 1, 'Tuyên Quang', '987242678'),
       ('S006', 'Mai Văn Thái', '2002/06/22', 1, 'Nam Định', '982654268'),
       ('S007', 'Giang Gia Hân', '1996/10/11', 0, 'Phú Thọ', '982364753'),
       ('S008', 'Nguyễn Ngọc Bảo My', '1999/01/22', 0, 'Hà Nam', '927867453'),
       ('S009', 'Nguyễn Tiến Đạt', '1998/08/07', 1, 'Tuyên Quang', '989274673'),
       ('S010', 'Nguyễn Thiều Quang', '2000/09/18', 1, 'Hà Nội', '984378291');
INSERT INTO _SUBJECT
VALUES ('MH01', 'Toán', 2),
       ('MH02', 'Vật Lý', 2),
       ('MH03', 'Hoá Học', 1),
       ('MH04', 'Ngữ Văn', 1),
       ('MH05', 'Tiếng Anh', 2);

INSERT INTO MARK
VALUES ('MH01', 'S001', 8.5),
       ('MH02', 'S001', 7),
       ('MH03', 'S001', 9),
       ('MH04', 'S001', 9),
       ('MH05', 'S001', 5),
       ('MH01', 'S002', 9),
       ('MH02', 'S002', 8),
       ('MH03', 'S002', 6.5),
       ('MH04', 'S002', 8),
       ('MH05', 'S002', 6),
       ('MH01', 'S003', 7.5),
       ('MH02', 'S003', 6.5),
       ('MH03', 'S003', 8),
       ('MH04', 'S003', 7),
       ('MH05', 'S003', 7),
       ('MH01', 'S004', 6),
       ('MH02', 'S004', 7),
       ('MH03', 'S004', 5),
       ('MH04', 'S004', 6.5),
       ('MH05', 'S004', 8),
       ('MH01', 'S005', 5.5),
       ('MH02', 'S005', 8),
       ('MH03', 'S005', 7.5),
       ('MH04', 'S005', 8.5),
       ('MH05', 'S005', 9),
       ('MH01', 'S006', 8),
       ('MH02', 'S006', 10),
       ('MH03', 'S006', 9),
       ('MH04', 'S006', 7.5),
       ('MH05', 'S006', 6.5),
       ('MH01', 'S007', 9.5),
       ('MH02', 'S007', 9),
       ('MH03', 'S007', 6),
       ('MH04', 'S007', 9),
       ('MH05', 'S007', 4),
       ('MH01', 'S008', 10),
       ('MH02', 'S008', 8.5),
       ('MH03', 'S008', 8.5),
       ('MH04', 'S008', 6),
       ('MH05', 'S008', 9.5),
       ('MH01', 'S009', 7.5),
       ('MH02', 'S009', 7),
       ('MH03', 'S009', 9),
       ('MH04', 'S009', 5),
       ('MH05', 'S009', 10),
       ('MH01', 'S010', 6.5),
       ('MH02', 'S010', 8),
       ('MH03', 'S010', 5.5),
       ('MH04', 'S010', 4),
       ('MH05', 'S010', 7);
-- sửa
UPDATE STUDENT
SET studentName = 'Đỗ Đức Mạnh'
WHERE studentId = 'S004';
-- diem
UPDATE _SUBJECT
SET subjectName = 'Ngoại Ngữ'
WHERE subjectId = 'MH05';
UPDATE MARK
SET points = (CASE (subjectId)
                  WHEN 'MH01' THEN 8.5
                  WHEN 'MH02' THEN 7
                  WHEN 'MH03' THEN 5.5
                  WHEN 'MH04' THEN 6
                  WHEN 'MH05' THEN 9 END)
WHERE studentId = 'S009';
SELECT *
from MARK;

-- xoá
DELETE
FROM MARK
WHERE studentId = 'S010';
DELETE
FROM STUDENT
WHERE studentId = 'S010';
-- Bài 3: Truy vấn dữ liệu [25 điểm]:
-- 1
SELECT *
FROM STUDENT;
-- 2
SELECT subjectId as 'Mã môn học', subjectName AS 'Tên Môn Học'
FROM _SUBJECT
WHERE priority = 1;
-- 3
SELECT studentId                                              AS 'Mã',
       studentName                                            AS 'Tên',
       TIMESTAMPDIFF(YEAR, birthday, CURDATE())               AS 'Tuổi',
       (CASE (gender) WHEN 1 THEN 'Nam' WHEN 0 THEN 'Nữ' END) AS 'Giới tính',
       address                                                AS 'quê quán'
FROM STUDENT;
-- 4
SELECT st.studentName as 'Tên học sinh', S.subjectName AS 'Môn học', m.points AS 'Điểm'
FROM MARK AS m
         JOIN _SUBJECT AS S ON m.subjectId = S.subjectId
         JOIN STUDENT st on m.studentId = st.studentId
WHERE m.subjectId = 'MH01'
ORDER BY m.points DESC;
-- 5
SELECT SUM(CASE (gender) WHEN TRUE THEN 1 WHEN FALSE THEN 0 END)        AS 'Nam',
       SUM(CASE (gender) WHEN FALSE THEN 1 WHEN TRUE THEN 0 ELSE 0 END) AS 'Nữ'
FROM STUDENT;
-- 6
SELECT s.studentId, s.studentName, SUM(m.points) AS 'Tổng Điểm', AVG(m.points) AS 'Điểm trung bình'
FROM STUDENT AS s
         JOIN MARK m ON s.studentId = m.studentId
         JOIN _SUBJECT s2 on m.subjectId = s2.subjectId
GROUP BY m.studentId;
-- Bài 4: Tạo View, Index, Procedure [20 điểm]:
-- 1
CREATE VIEW STUDENT_VIEW AS
SELECT studentId                                              AS 'Mã',
       studentName                                            AS 'Tên',
       TIMESTAMPDIFF(YEAR, birthday, CURDATE())               AS 'Tuổi',
       (CASE (gender) WHEN 1 THEN 'Nam' WHEN 0 THEN 'Nữ' END) AS 'Giới tính',
       address                                                AS 'quê quán'
FROM STUDENT;
SELECT *
FROM STUDENT_VIEW;

-- 2
CREATE VIEW AVERAGE_MARK_VIEW AS
SELECT s.studentId, s.studentName, AVG(m.points) AS 'Điểm trung bình'
FROM STUDENT AS s
         JOIN MARK m ON s.studentId = m.studentId
         JOIN _SUBJECT s2 on m.subjectId = s2.subjectId
GROUP BY m.studentId;

SELECT *
FROM AVERAGE_MARK_VIEW;
-- 3
CREATE UNIQUE INDEX i_phoneNumber ON Student (phoneNumber);
-- 4
-- 4.1
DELIMITER && CREATE PROCEDURE PROC_INSERTSTUDENT(IN id VARCHAR(4), IN sName VARCHAR(100), IN dob DATETIME,
                                                 IN sex BIT(1), IN sAdd TEXT, IN pNum VARCHAR(45))
BEGIN
    INSERT INTO STUDENT VALUE (id, sName, dob, sex, sAdd, pNum);
END && DELIMITER ;
# CALL PROC_INSERTSTUDENT('S011', 'Hà Viết Tiến', 1999 / 12 / 12, 1, 'Bắc Ninh', '0987654321');
-- 4.2
DELIMITER && CREATE PROCEDURE PROC_UPDATESUBJECT(IN id VARCHAR(4), IN newName VARCHAR(45))
BEGIN
    UPDATE _SUBJECT SET subjectName = newName WHERE subjectId = id;
END && DELIMITER ;

# CALL PROC_UPDATESUBJECT('MH5','Tiếng Anh');
-- 4.3
DELIMITER && CREATE PROCEDURE PROC_DELETEMARK(IN id VARCHAR(4), OUT c INT)
BEGIN
    DELETE FROM MARK WHERE studentId = id;
    SET c = ROW_COUNT();
END && DELIMITER ;
CALL PROC_DELETEMARK('S001',@c);
select @c AS 'Số bản ghi đã xóa';
