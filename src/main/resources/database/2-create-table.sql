CREATE TABLE `anagraphical_user` (
	`name` VARCHAR(50)  NOT NULL  DEFAULT '' COLLATE 'latin1_swedish_ci' ,
	`surname` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`secure_vatin` VARCHAR(50) 	 NOT NULL      DEFAULT '' COLLATE 'latin1_swedish_ci',
	primary KEY (secure_vatin)
)
COMMENT='Table of the anagraphical data of the recorded users'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

COMMIT;



CREATE TABLE `anagraphical_user` (
	`name` VARCHAR(50)  NOT NULL  DEFAULT '' COLLATE 'latin1_swedish_ci' ,
	`surname` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`vatin` VARCHAR(50) 	 NOT NULL      DEFAULT '' COLLATE 'latin1_swedish_ci',
	primary KEY (vatin)
)
COMMENT='Table of the anagraphical data of the recorded users'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

COMMIT;


CREATE TABLE `security_user` (
	`secure_vatin` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`username` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`password` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	primary key(username, PASSWORD),
		CONSTRAINT `fk_vatin`
	FOREIGN KEY (secure_vatin) REFERENCES anagraphical_user(vatin)  	
		ON DELETE CASCADE
		ON UPDATE RESTRICT

)
COMMENT='Table of the security data of the recorded users'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

COMMIT;





INSERT INTO `anagraphical_user` (`name`, `surname`, `vatin`) VALUES
	('X3uX/Zv+ic759LEjXLp8Lg==', '8LDGA+D4NISJJSpQl9fUJg==');
INSERT INTO `security_user` (`vatin`, `username`, `password`) VALUES
	('55rRxPs69z0=', 'wQNoUUT6TjI=', 'UBWYNFPNYYY=');

COMMIT;