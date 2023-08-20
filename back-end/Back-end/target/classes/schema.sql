CREATE TABLE task(
                        id INT PRIMARY KEY AUTO_INCREMENT ,
                        description VARCHAR(100) NOT NULL ,
                        status ENUM ('COMPLETED','NOT_COMPLETED') NOT NULL

);
