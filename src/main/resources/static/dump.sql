--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: expense_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.expense_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.expense_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: expense; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expense (
    id bigint DEFAULT nextval('public.expense_seq'::regclass) NOT NULL,
    amount double precision NOT NULL,
    created_at timestamp without time zone,
    name character varying(255),
    type_expense character varying(255),
    updated_at timestamp without time zone,
    period_id bigint
);


ALTER TABLE public.expense OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: income_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.income_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.income_seq OWNER TO postgres;

--
-- Name: income; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.income (
    id bigint DEFAULT nextval('public.income_seq'::regclass) NOT NULL,
    amount double precision NOT NULL,
    created_at timestamp without time zone,
    name character varying(255),
    updated_at timestamp without time zone,
    period_id bigint
);


ALTER TABLE public.income OWNER TO postgres;

--
-- Name: period_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.period_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.period_seq OWNER TO postgres;

--
-- Name: period; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.period (
    id bigint DEFAULT nextval('public.period_seq'::regclass) NOT NULL,
    end_date timestamp without time zone,
    name character varying(255),
    start_date timestamp without time zone,
    status character varying(255)
);


ALTER TABLE public.period OWNER TO postgres;

--
-- Name: savings_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.savings_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.savings_seq OWNER TO postgres;

--
-- Name: savings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.savings (
    id bigint DEFAULT nextval('public.savings_seq'::regclass) NOT NULL,
    amount double precision NOT NULL,
    created_at timestamp without time zone,
    type_savings character varying(255),
    updated_at timestamp without time zone,
    period_id bigint
);


ALTER TABLE public.savings OWNER TO postgres;

--
-- Data for Name: expense; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.expense (id, amount, created_at, name, type_expense, updated_at, period_id) FROM stdin;
14	150.5	2020-06-12 16:10:19.343538	TestAssert2	NEEDS	2020-06-12 16:10:19.343596	\N
15	123.5	2020-06-12 16:38:40.151997	TestAssert	NEEDS	2020-06-12 16:38:40.152086	\N
16	150.5	2020-06-12 16:38:40.203397	TestAssert2	NEEDS	2020-06-12 16:38:40.203451	\N
17	123.5	2020-06-12 16:53:13.977958	TestAssert	NEEDS	2020-06-12 16:53:13.978141	\N
18	150.5	2020-06-12 16:53:14.053187	TestAssert2	NEEDS	2020-06-12 16:53:14.053234	\N
19	123.5	2020-06-15 17:25:29.821065	TestAssert	NEEDS	2020-06-15 17:25:29.821165	\N
20	150.5	2020-06-15 17:25:29.883595	TestAssert2	NEEDS	2020-06-15 17:25:29.883648	\N
21	123.5	2020-06-15 17:27:24.088484	TestAssert	NEEDS	2020-06-15 17:27:24.088599	\N
22	150.5	2020-06-15 17:27:24.124884	TestAssert2	NEEDS	2020-06-15 17:27:24.12494	\N
23	123.5	2020-06-16 08:57:12.921071	TestAssert	NEEDS	2020-06-16 08:57:12.92116	\N
24	150.5	2020-06-16 08:57:12.991233	TestAssert2	NEEDS	2020-06-16 08:57:12.991291	\N
11	123.5	2020-06-12 16:06:48.004972	TestAssert	NEEDS	2020-06-18 20:47:55.306969	2
12	150.5	2020-06-12 16:06:48.057376	TestAssert2	NEEDS	2020-06-18 20:47:55.343109	2
13	123.5	2020-06-12 16:10:19.29739	TestAssert	NEEDS	2020-06-18 20:47:55.350967	2
\.


--
-- Data for Name: income; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.income (id, amount, created_at, name, updated_at, period_id) FROM stdin;
1	6330	2020-06-18 00:00:00	Salary	2020-06-18 20:47:55.410133	2
\.


--
-- Data for Name: period; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.period (id, end_date, name, start_date, status) FROM stdin;
2	2020-06-30 00:00:00	JUNE	2020-06-01 00:00:00	ACTIVE
\.


--
-- Data for Name: savings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.savings (id, amount, created_at, type_savings, updated_at, period_id) FROM stdin;
3	100	2020-06-18 00:00:00	LIFEINSURANCE	2020-06-18 20:47:55.394641	2
1	1000	2020-06-18 00:00:00	FAMILYSAVINGS	2020-06-18 20:47:55.403219	2
\.


--
-- Name: expense_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.expense_seq', 24, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);


--
-- Name: income_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.income_seq', 1, false);


--
-- Name: period_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.period_seq', 2, true);


--
-- Name: savings_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.savings_seq', 3, true);


--
-- Name: expense expense_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense
    ADD CONSTRAINT expense_pkey PRIMARY KEY (id);


--
-- Name: income income_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.income
    ADD CONSTRAINT income_pkey PRIMARY KEY (id);


--
-- Name: period period_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.period
    ADD CONSTRAINT period_pkey PRIMARY KEY (id);


--
-- Name: savings savings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savings
    ADD CONSTRAINT savings_pkey PRIMARY KEY (id);


--
-- Name: expense fk6pb6a7ei18qehncq1jqs6f07d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense
    ADD CONSTRAINT fk6pb6a7ei18qehncq1jqs6f07d FOREIGN KEY (period_id) REFERENCES public.period(id);


--
-- Name: income fkek4evfeh0xnp4q7xnn35svwg1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.income
    ADD CONSTRAINT fkek4evfeh0xnp4q7xnn35svwg1 FOREIGN KEY (period_id) REFERENCES public.period(id);


--
-- Name: savings fkn106d50hiko39deibvn1ikkq4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savings
    ADD CONSTRAINT fkn106d50hiko39deibvn1ikkq4 FOREIGN KEY (period_id) REFERENCES public.period(id);


--
-- PostgreSQL database dump complete
--

