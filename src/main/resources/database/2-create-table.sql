CREATE TABLE `user` (
	`name` VARCHAR(20)  NOT NULL  DEFAULT '' COLLATE 'latin1_swedish_ci' ,
	`surname` VARCHAR(20) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`vatin` VARCHAR(20) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`username` VARCHAR(20) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	`password` VARCHAR(20) NOT NULL DEFAULT '' COLLATE 'latin1_swedish_ci',
	    primary key(vatin)

)
COMMENT='Table of the recorded users'
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;

COMMIT;

