package co.edu.pdam.eci.persistenceapiintegration.data.dao;

import java.util.List;

import co.edu.pdam.eci.persistenceapiintegration.data.DBException;


/**
 * @author Santiago Carrillo
 */
interface BaseDao<T, K>
{
    void create( T entity )
        throws DBException;

    /**
     * Creates or updates entry in database
     *
     * @param entity data to be added
     * @return true if new entity is inserted
     * @throws DBException in case of errors
     */
    boolean createOrUpdate( T entity )
        throws DBException;

    void delete( T entity )
        throws DBException;

    void update( T entity )
        throws DBException;

    T get( K id )
        throws DBException;

    List<T> getAll()
        throws DBException;

    long count()
        throws DBException;


    List<String[]> queryRaw( String statement, String... arguments )
        throws DBException;

    void clear()
        throws DBException;
}
