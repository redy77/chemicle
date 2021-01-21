CREATE ROLE mick WITH LOGIN PASSWORD 'mick'; -- 'WITH LOGIN' необходимо добавлять, чтобы пользователь мог залогиниться в бд;
CREATE DATABASE theory OWNER mick;