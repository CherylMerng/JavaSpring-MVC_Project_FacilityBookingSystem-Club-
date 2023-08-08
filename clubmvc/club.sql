CREATE SCHEMA club;
USE club;



CREATE TABLE club.member (
      member_number int AUTO_INCREMENT NOT NULL,
      first_name varchar(255),
      second_name varchar(255),
      last_name varchar(255),
PRIMARY KEY(member_number),
INDEX member_member_number_INDEX (member_number));

CREATE TABLE club.facility (
      name varchar(255) NOT NULL,
      description varchar(255),
      PRIMARY KEY(name),
      INDEX facility_name_INDEX (name));

INSERT INTO `member` (`first_name`, `last_name`) VALUES ('Albert', 'Einstien');
INSERT INTO `member` (`first_name`, `last_name`) VALUES ('Isaac', 'Newton');
INSERT INTO `member` (`first_name`, `last_name`) VALUES ('Galiloe', 'Galiliei');
INSERT INTO `member` (`first_name`, `last_name`) VALUES ('Charles', 'Darwin');
INSERT INTO `member` (`first_name`, `second_name`, `last_name`) VALUES ('Thomas', 'Alva', 'Edision');
INSERT INTO `member` (`first_name`, `second_name`, `last_name`) VALUES ('Alexandar', 'Graham', 'Bell');
INSERT INTO `member` (`first_name`, `second_name`, `last_name`) VALUES ('Ludwig', 'Van', 'Beethoven');
INSERT INTO `member` (`first_name`, `last_name`) VALUES ('John', 'Lennon');
INSERT INTO `member` (`first_name`, `second_name`, `last_name`) VALUES ('Leonardo', 'Da', 'Vinci');
INSERT INTO `member` (`first_name`, `second_name`, `last_name`) VALUES ('Vincent', 'Van', 'Gogh');
INSERT INTO `member` (`first_name`, `last_name`) VALUES ('Pablo', 'Picasso');

INSERT INTO `facility` (`name`, `description`) VALUES ('Room1', 'Meeting Room in 2-1');
INSERT INTO `facility` (`name`, `description`) VALUES ('Room2', 'Meeting Room in 3-2');
INSERT INTO `facility` (`name`, `description`) VALUES ('Room3', 'Meeting Room 4-3');
INSERT INTO `facility` (`name`, `description`) VALUES ('Room4', 'Meeting Room 4-5');
INSERT INTO `facility` (`name`, `description`) VALUES ('Room5', 'Board Room in 4-3');



