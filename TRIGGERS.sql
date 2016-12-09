--------------------------------------------------------
--  DDL for Trigger ASSIGNMENT_SEQ_TR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."ASSIGNMENT_SEQ_TR" 
 BEFORE INSERT ON ASSIGNMENT FOR EACH ROW
  WHEN (NEW.ID IS NULL) BEGIN
 SELECT ASSIGNMENT_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "SGRS"."ASSIGNMENT_SEQ_TR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ASSIGNMENT_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."ASSIGNMENT_TRIGGER" BEFORE INSERT ON ASSIGNMENT FOR EACH ROW
BEGIN
  SELECT ASSIGNMENT_SEQ.nextval INTO :new.ID FROM dual;
END;
/
ALTER TRIGGER "SGRS"."ASSIGNMENT_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger COURSE_SEQ_TR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."COURSE_SEQ_TR" 
 BEFORE INSERT ON COURSE FOR EACH ROW
  WHEN (NEW.ID IS NULL) BEGIN
 SELECT COURSE_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "SGRS"."COURSE_SEQ_TR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger COURSE_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."COURSE_TRIGGER" BEFORE INSERT ON COURSE FOR EACH ROW
BEGIN
  SELECT COURSE_SEQ.nextval INTO :new.ID FROM dual;
END;
/
ALTER TRIGGER "SGRS"."COURSE_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger GRADE_SEQ_TR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."GRADE_SEQ_TR" 
 BEFORE INSERT ON GRADE FOR EACH ROW
  WHEN (NEW.ID IS NULL) BEGIN
 SELECT GRADE_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "SGRS"."GRADE_SEQ_TR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger LOGIN_SEQ_TR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."LOGIN_SEQ_TR" 
 BEFORE INSERT ON LOGIN FOR EACH ROW
  WHEN (NEW.ID IS NULL) BEGIN
 SELECT LOGIN_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "SGRS"."LOGIN_SEQ_TR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger STAFF_SEQ_TR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."STAFF_SEQ_TR" 
 BEFORE INSERT ON STAFF FOR EACH ROW
  WHEN (NEW.ID IS NULL) BEGIN
 SELECT STAFF_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "SGRS"."STAFF_SEQ_TR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger STUDENT_BOOK_SEQ_TR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."STUDENT_BOOK_SEQ_TR" 
 BEFORE INSERT ON STUDENT_BOOK FOR EACH ROW
  WHEN (NEW.ID IS NULL) BEGIN
 SELECT STUDENT_BOOK_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "SGRS"."STUDENT_BOOK_SEQ_TR" ENABLE;
--------------------------------------------------------
--  DDL for Trigger STUDENT_SEQ_TR
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SGRS"."STUDENT_SEQ_TR" 
 BEFORE INSERT ON STUDENT FOR EACH ROW
  WHEN (NEW.ID IS NULL) BEGIN
 SELECT STUDENT_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "SGRS"."STUDENT_SEQ_TR" ENABLE;
