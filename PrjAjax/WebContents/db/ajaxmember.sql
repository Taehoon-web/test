DROP  TABLE  AJAXMEMBER;
CREATE  TABLE  AJAXMEMBER
(
     MEMID     VARCHAR2(12)     PRIMARY KEY   
    ,MEMPASS   VARCHAR2(12)
    ,MEMNAME   VARCHAR2(30)
    ,EMAIL     VARCHAR2(100)
    ,RDATE     DATE           DEFAULT  SYSDATE
);

INSERT INTO   AJAXMEMBER  VALUES ( 'sky', '1234', '하늘', 'sky@green.com', sysdate  );
INSERT INTO   AJAXMEMBER  VALUES ( 'sea', '1234', '바다', 'sea@green.com', sysdate  );
INSERT INTO   AJAXMEMBER  VALUES ( 'sky2', '1234', '하늘2', 'sky2@green.com', sysdate  );
commit;


