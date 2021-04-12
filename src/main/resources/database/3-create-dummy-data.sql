/*
 * the decrypted data are
 * "alessandro"
 * "puzielli"
 * "PZLSSNN"
 * "alex"
 * "io"
 * */
INSERT INTO `user` (`name`, `surname`, `vatin`, `username`, `password`) VALUES
	('X3uX/Zv+ic759LEjXLp8Lg==', '8LDGA+D4NISJJSpQl9fUJg==', '55rRxPs69z0=', 'wQNoUUT6TjI=', 'UBWYNFPNYYY=');


--spring JPA
INSERT INTO `user_anagraphic` (`name`, `surname`, `vatin`) VALUES ('X3uX/Zv+ic759LEjXLp8Lg==', '8LDGA+D4NISJJSpQl9fUJg==', '55rRxPs69z0=');
INSERT INTO `user_security` (`vatin`, `username`, `password`) VALUES ('55rRxPs69z0=', 'wQNoUUT6TjI=', 'UBWYNFPNYYY=');

commit;
