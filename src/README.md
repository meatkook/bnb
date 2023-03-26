# SQL to create database "bankData"
-- Database: bankData

-- DROP DATABASE IF EXISTS "bankData";

CREATE DATABASE "bankData"
WITH
OWNER = postgres
ENCODING = 'UTF8'
LC_COLLATE = 'Russian_Russia.1251'
LC_CTYPE = 'Russian_Russia.1251'
TABLESPACE = pg_default
CONNECTION LIMIT = -1
IS_TEMPLATE = False;

# SQL to create table "currency"
-- Table: public.currency

-- DROP TABLE IF EXISTS public.currency;

CREATE TABLE IF NOT EXISTS public.currency
(
id serial NOT NULL DEFAULT 0,
parent_id integer NOT NULL DEFAULT 0,
code character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
abbreviation character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
name character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
name_bel character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
name_eng character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
quot_name character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
quot_name_bel character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
quot_name_eng character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
name_multi character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
name_bel_multi character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
name_eng_multi character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
scale integer NOT NULL DEFAULT 0,
periodicity integer NOT NULL DEFAULT 0,
date_start character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
date_end character varying COLLATE pg_catalog."default" DEFAULT ' '::character varying,
CONSTRAINT currency_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.currency
OWNER to postgres;