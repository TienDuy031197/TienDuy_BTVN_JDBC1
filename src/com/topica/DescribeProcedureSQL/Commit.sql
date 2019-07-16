CREATE DEFINER=`root`@`localhost` PROCEDURE `Commit`(IN _id INTEGER,IN _name VARCHAR(50),IN _address VARCHAR(50),IN _phone VARCHAR(10))
BEGIN
	SET AUTOCOMMIT = 0;
	INSERT INTO employees VALUES(_id,_name,_address,_phone);
	COMMIT;
	SELECT * FROM employees;
END