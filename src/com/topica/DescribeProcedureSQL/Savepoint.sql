CREATE DEFINER=`root`@`localhost` PROCEDURE `Savepoint_Rollback`()
BEGIN
	SET AUTOCOMMIT = 0;
	SAVEPOINT VT1;
    	DELETE FROM employees WHERE id = 4;
    	SAVEPOINT VT2;
    	DELETE FROM employees WHERE id = 5;
    	SAVEPOINT VT3;
    	DELETE FROM employees WHERE id = 6;
    
    	ROLLBACK TO VT2;
    	COMMIT;
    	SELECT * FROM employees;
END