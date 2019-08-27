

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;


CREATE TABLE robot (
    nom text,
    couleur text,
    poids text,
    technologie text,
    id integer NOT NULL
);


ALTER TABLE robot OWNER TO postgres;

--
-- Name: robot_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE robot_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE robot_id_seq OWNER TO postgres;

--
-- Name: robot_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE robot_id_seq OWNED BY robot.id;



ALTER TABLE ONLY robot ALTER COLUMN id SET DEFAULT nextval('robot_id_seq'::regclass);


--
-- PostgreSQL database dump complete
--


CREATE TABLE public.concepteur
(
    id integer NOT NULL DEFAULT nextval('concepteur_id_seq'::regclass),
    nom text COLLATE pg_catalog."default",
    surnom text COLLATE pg_catalog."default",
    specialite text COLLATE pg_catalog."default",
    courriel text COLLATE pg_catalog."default",
    CONSTRAINT concepteur_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.concepteur
    OWNER to postgres;
    
    
-- SEQUENCE: public.concepteur_id_seq

-- DROP SEQUENCE public.concepteur_id_seq;

CREATE SEQUENCE public.concepteur_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.concepteur_id_seq
    OWNER TO postgres;