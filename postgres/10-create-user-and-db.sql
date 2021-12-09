-- file: 10-create-user-and-db.sql
CREATE DATABASE rss;
CREATE ROLE program WITH PASSWORD 'test';
GRANT ALL PRIVILEGES ON DATABASE rss TO program;
ALTER ROLE program WITH LOGIN;