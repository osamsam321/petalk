DO $$
BEGIN
    IF NOT EXISTS (
        SELECT FROM pg_database WHERE datname = 'ptdb_deb'
    )
    THEN
        CREATE DATABASE your_db_name;
    END IF;
END
$$;
