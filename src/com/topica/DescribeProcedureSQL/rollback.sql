CREATE DEFINER=`root`@`localhost` PROCEDURE `rollback`(IN _id INTEGER)
BEGIN
	SET AUTOCOMMIT = 0;
	DELETE FROM employees
	WHERE id = _id;
	ROLLBACK;
    	COMMIT;
    	SELECT * FROM employees;
END