CREATE TABLE `user` (
	`name` VARCHAR(50)  NOT NULL  DEFAULT '' COLLATE 'latin1_swedish_ci' ,
	`surname` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`vatin` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`username` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`password` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	    primary key(vatin)

)
COMMENT='Table of the recorded users'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

--spring JPA
CREATE TABLE `user_anagraphic` (
	`name` VARCHAR(50)  NOT NULL  DEFAULT '' COLLATE 'latin1_swedish_ci' ,
	`surname` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`vatin` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	    primary key(vatin)

)
COMMENT='Table of the anagraphic data of the recorded users'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
CREATE TABLE `user_security` (
	`vatin` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`username` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`password` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	    primary key(vatin),
	    CONSTRAINT `fk_vatin`
	    FOREIGN KEY (vatin) REFERENCES user_anagraphic (vatin)
	    ON DELETE CASCADE
		ON UPDATE RESTRICT
)
COMMENT='Table of the security data of the recorded users'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;



COMMIT;


