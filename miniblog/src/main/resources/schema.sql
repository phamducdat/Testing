DROP TABLE IF EXISTS AUTHOR;
DROP TABLE IF EXISTS BLOG;
DROP TABLE IF EXISTS CONTACT;

CREATE TABLE AUTHOR (
    AUTHOR_ID VARCHAR(45) primary key,
    AUTHOR_NAME VARCHAR(45) NOT NULL,
    AUTHOR_EMAIL VARCHAR(45) NOT NULL,
    AUTHOR_DESCRIPTION VARCHAR(45) NOT NULL,
    AUTHOR_AVATAR VARCHAR(45) NOT NULL
);

CREATE TABLE BLOG (
    BLOG_ID VARCHAR(45) PRIMARY KEY,
    BLOG_NAME VARCHAR(45) NOT NULL,
    BLOG_INTRODUCTION VARCHAR(45) NOT NULL,
    BLOG_CONTENT VARCHAR(45) NOT NULL,
    BLOG_PICTURE VARCHAR(45) NOT NULL,
    BLOG_TYPE VARCHAR(45) NOT NULL,
    BLOG_DATE DATE NOT NULL,
    AUTHOR_ID VARCHAR(45),
        FOREIGN KEY (AUTHOR_ID)
            REFERENCES AUTHOR (AUTHOR_ID)

);

CREATE TABLE CONTACT (
    CONTACT_ID VARCHAR(45) PRIMARY KEY,
    CONTACT_NAME VARCHAR(45) NOT NULL,
    CONTACT_EMAIL_TO VARCHAR(45) NOT NULL,
    CONTACT_EMAIL_FROM VARCHAR(45) NOT NULL,
    CONTACT_MESSAGE VARCHAR(45) NOT NULL,
    AUTHOR_ID VARCHAR(45) NOT NULL,
        FOREIGN KEY (AUTHOR_ID)
            REFERENCES AUTHOR (AUTHOR_ID)
)
