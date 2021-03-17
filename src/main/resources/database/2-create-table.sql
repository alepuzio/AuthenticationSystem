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

COMMIT;

