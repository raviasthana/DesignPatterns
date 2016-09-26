package com.indefsystems.dp.dao;

public class BaseDaoImpl {

	/** Statement separator to get around HSQLDB's semicolon statement delimiter in procedures. */
    protected static final String STATEMENT_SEPARATOR = ";;";

    /** Name of file containing SQL statements to initialise the database. */
    protected static final String INIT_DB_FILE_NAME = "daoTest.sql";
    
    
    
}
