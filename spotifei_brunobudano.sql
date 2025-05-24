--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2025-05-24 10:00:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 16562)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario bigint NOT NULL,
    nome_usuario character varying(255) NOT NULL,
    email_usuario character varying(255) NOT NULL,
    senha_usuario integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16561)
-- Name: Usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.usuario ALTER COLUMN id_usuario ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Usuario_id_usuario_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 220 (class 1259 OID 32957)
-- Name: musica; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musica (
    id_musica bigint NOT NULL,
    descricao_musica character varying,
    duracao_musica time with time zone NOT NULL,
    nome_artista character varying(255) NOT NULL,
    nome_musica character varying(255) NOT NULL,
    genero_musica character varying(255)
);


ALTER TABLE public.musica OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 32956)
-- Name: musica_Id_musica_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.musica ALTER COLUMN id_musica ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."musica_Id_musica_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 49340)
-- Name: musicascurtidas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musicascurtidas (
    id_musica bigint NOT NULL,
    id_usuario bigint NOT NULL
);


ALTER TABLE public.musicascurtidas OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 49345)
-- Name: musicasplaylists; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.musicasplaylists (
    id_musica bigint NOT NULL,
    id_playlist bigint NOT NULL
);


ALTER TABLE public.musicasplaylists OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 32972)
-- Name: playlist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.playlist (
    id_playlist bigint NOT NULL,
    nome_playlist character varying(255) NOT NULL
)
INHERITS (public.usuario);


ALTER TABLE public.playlist OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 32971)
-- Name: playlist_id_playlist_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.playlist ALTER COLUMN id_playlist ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.playlist_id_playlist_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4914 (class 0 OID 32957)
-- Dependencies: 220
-- Data for Name: musica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musica (id_musica, descricao_musica, duracao_musica, nome_artista, nome_musica, genero_musica) FROM stdin;
11	Obra-prima épica do Pink Floyd	00:06:23-03	Pink Floyd	Comfortably Numb	Progressive Rock
12	Hino revolucionário dos Beatles	00:07:13-03	The Beatles	Hey Jude	Classic Rock
13	Clássico rebelde dos Rolling Stones	00:03:43-03	The Rolling Stones	Satisfaction	Classic Rock
14	Icônico solo de guitarra do Jimi Hendrix	00:04:01-03	Jimi Hendrix	Purple Haze	Psychedelic Rock
15	Anthem atemporal do The Who	00:03:21-03	The Who	My Generation	Classic Rock
16	Clássico sombrio do Black Sabbath	00:06:20-03	Black Sabbath	Paranoid	Metal
17	Hit dançante dos The Kinks	00:02:19-03	The Kinks	You Really Got Me	Classic Rock
18	Balada poderosa do Aerosmith	00:04:28-03	Aerosmith	Dream On	Hard Rock
19	Explosão punk dos Ramones	00:02:35-03	Ramones	Blitzkrieg Bop	Punk Rock
20	Energia pura do MC5	00:03:17-03	MC5	Kick Out the Jams	Proto-Punk
21	Riff hipnótico do Cream	00:04:16-03	Cream	Sunshine of Your Love	Blues Rock
22	Clássico psicadélico dos Doors	00:07:05-03	The Doors	Light My Fire	Psychedelic Rock
23	Hit rebelde do T. Rex	00:04:30-03	T. Rex	20th Century Boy	Glam Rock
24	Potência sonora do Iron Maiden	00:06:51-03	Iron Maiden	The Number of the Beast	Metal
25	Clássico country rock dos Eagles	00:06:30-03	Eagles	Hotel California	Classic Rock
26	Energia selvagem do Motörhead	00:02:49-03	Motörhead	Ace of Spades	Metal
27	Hino libertário do Lynyrd Skynyrd	00:09:07-03	Lynyrd Skynyrd	Free Bird	Southern Rock
28	Clássico melancólico do The Cure	00:05:15-03	The Cure	Close to Me	Alternative Rock
29	Explosão grunge do Pearl Jam	00:05:41-03	Pearl Jam	Alive	Grunge
30	Hino do Nirvana	00:05:01-03	Nirvana	Smells Like Teen Spirit	Grunge
31	Clássico country rock do CCR	00:02:10-03	Creedence Clearwater Revival	Proud Mary	Classic Rock
32	Energia pura do The White Stripes	00:03:51-03	The White Stripes	Seven Nation Army	Alternative Rock
33	Hit dançante do Queen	00:03:35-03	Queen	Another One Bites the Dust	Arena Rock
34	Clássico blues rock do Stevie Ray Vaughan	00:04:25-03	Stevie Ray Vaughan	Pride and Joy	Blues Rock
35	Obra épica do Rush	00:06:44-03	Rush	Tom Sawyer	Progressive Rock
36	Hino poderoso do Dio	00:05:43-03	Dio	Holy Diver	Metal
37	Clássico rebelde do Judas Priest	00:04:48-03	Judas Priest	Breaking the Law	Metal
38	Hit atemporal do Fleetwood Mac	00:03:37-03	Fleetwood Mac	Go Your Own Way	Classic Rock
39	Energia garage rock dos The Stooges	00:03:09-03	The Stooges	I Wanna Be Your Dog	Proto-Punk
40	Clássico psicodélico dos Jefferson Airplane	00:02:31-03	Jefferson Airplane	Somebody to Love	Psychedelic Rock
41	Hit dançante do David Bowie	00:04:23-03	David Bowie	Rebel Rebel	Glam Rock
42	Clássico folk rock do Bob Dylan	00:06:13-03	Bob Dylan	Like a Rolling Stone	Folk Rock
43	Energia punk do Sex Pistols	00:03:20-03	Sex Pistols	Anarchy in the U.K.	Punk Rock
44	Hino poderoso do Def Leppard	00:04:14-03	Def Leppard	Pour Some Sugar on Me	Hard Rock
45	Clássico sombrio do Alice Cooper	00:05:57-03	Alice Cooper	School's Out	Hard Rock
46	Hit revolucionário do Radiohead	00:04:21-03	Radiohead	Creep	Alternative Rock
47	Explosão grunge do Soundgarden	00:05:16-03	Soundgarden	Black Hole Sun	Grunge
48	Clássico heavy do Ozzy Osbourne	00:04:51-03	Ozzy Osbourne	Crazy Train	Metal
49	Energia punk do The Clash	00:04:04-03	The Clash	London Calling	Punk Rock
50	Hit atemporal do U2	00:04:37-03	U2	With or Without You	Alternative Rock
51	Clássico blues rock do ZZ Top	00:03:58-03	ZZ Top	La Grange	Blues Rock
52	Hino rebelde do Twisted Sister	00:05:23-03	Twisted Sister	We're Not Gonna Take It	Metal
53	Hit poderoso do Van Halen	00:01:42-03	Van Halen	Eruption	Hard Rock
54	Clássico dançante do Thin Lizzy	00:05:28-03	Thin Lizzy	The Boys Are Back in Town	Hard Rock
55	Energia pura do Rage Against the Machine	00:05:14-03	Rage Against the Machine	Killing in the Name	Alternative Metal
56	Hit atemporal do R.E.M.	00:04:27-03	R.E.M.	Losing My Religion	Alternative Rock
57	Clássico progressivo do Yes	00:08:33-03	Yes	Roundabout	Progressive Rock
58	Hino poderoso do Kiss	00:03:12-03	Kiss	Rock and Roll All Nite	Hard Rock
59	Explosão garage do Blue Cheer	00:03:42-03	Blue Cheer	Summertime Blues	Proto-Metal
60	Clássico blues rock do Cream	00:02:48-03	Cream	White Room	Blues Rock
61	Hit revolucionário do Sly & the Family Stone	00:04:12-03	Sly & the Family Stone	Thank You	Funk Rock
62	Energia selvagem do Ted Nugent	00:05:30-03	Ted Nugent	Stranglehold	Hard Rock
63	Clássico country rock dos Allman Brothers	00:07:27-03	Allman Brothers Band	Whipping Post	Southern Rock
64	Hino atemporal do Boston	00:05:05-03	Boston	More Than a Feeling	Arena Rock
65	Hit dançante do Foreigner	00:03:25-03	Foreigner	Juke Box Hero	Arena Rock
66	Clássico progressivo do King Crimson	00:06:43-03	King Crimson	21st Century Schizoid Man	Progressive Rock
67	Energia punk do Dead Kennedys	00:01:49-03	Dead Kennedys	Holiday in Cambodia	Punk Rock
68	Hit poderoso do Scorpions	00:06:14-03	Scorpions	Rock You Like a Hurricane	Hard Rock
69	Clássico sombrio do Alice in Chains	00:04:19-03	Alice in Chains	Man in the Box	Grunge
70	Hino libertário do Red Hot Chili Peppers	00:04:31-03	Red Hot Chili Peppers	Under the Bridge	Alternative Rock
71	Explosão grunge do Stone Temple Pilots	00:03:44-03	Stone Temple Pilots	Interstate Love Song	Grunge
72	Clássico heavy do Pantera	00:05:03-03	Pantera	Walk	Metal
73	Hit atemporal do Foo Fighters	00:04:07-03	Foo Fighters	Everlong	Alternative Rock
74	Energia pura do Jane's Addiction	00:04:11-03	Jane's Addiction	Jane Says	Alternative Rock
75	Clássico progressivo do Tool	00:09:13-03	Tool	Schism	Progressive Metal
76	Hino poderoso do System of a Down	00:03:36-03	System of a Down	Chop Suey!	Alternative Metal
77	Hit revolucionário do Living Colour	00:04:41-03	Living Colour	Cult of Personality	Funk Metal
78	Clássico indie do The Strokes	00:03:38-03	The Strokes	Last Nite	Indie Rock
79	Energia garage do The Hives	00:02:04-03	The Hives	Hate to Say I Told You So	Garage Rock
80	Hit atemporal do Oasis	00:04:19-03	Oasis	Wonderwall	Britpop
81	Clássico britânico do Blur	00:04:02-03	Blur	Song 2	Britpop
82	Hino poderoso do Muse	00:05:47-03	Muse	Knights of Cydonia	Alternative Rock
83	Explosão metal do Slayer	00:04:28-03	Slayer	Raining Blood	Thrash Metal
84	Clássico heavy do Megadeth	00:04:04-03	Megadeth	Peace Sells	Thrash Metal
85	Hit atemporal do Anthrax	00:04:55-03	Anthrax	Madhouse	Thrash Metal
86	Energia pura do Sepultura	00:04:32-03	Sepultura	Roots Bloody Roots	Groove Metal
87	Clássico doom do Candlemass	00:06:31-03	Candlemass	Solitude	Doom Metal
88	Hino épico do Blind Guardian	00:05:06-03	Blind Guardian	Mirror Mirror	Power Metal
89	Hit medieval do Blackmore's Night	00:03:48-03	Blackmore's Night	Ghost of a Rose	Folk Rock
90	Clássico progressivo do Dream Theater	00:11:25-03	Dream Theater	Pull Me Under	Progressive Metal
91	Energia symphonic do Within Temptation	00:04:13-03	Within Temptation	Ice Queen	Symphonic Metal
92	Hit gótico do The Sisters of Mercy	00:04:51-03	The Sisters of Mercy	Temple of Love	Gothic Rock
93	Clássico darkwave do Clan of Xymox	00:04:45-03	Clan of Xymox	Louise	Gothic Rock
94	Hino industrial do Nine Inch Nails	00:05:33-03	Nine Inch Nails	Head Like a Hole	Industrial Rock
95	Explosão stoner do Queens of the Stone Age	00:03:38-03	Queens of the Stone Age	No One Knows	Stoner Rock
96	Clássico desert rock do Kyuss	00:07:13-03	Kyuss	Green Machine	Desert Rock
97	Hit space rock do Monster Magnet	00:04:29-03	Monster Magnet	Space Lord	Stoner Rock
98	Energia sludge do Mastodon	00:05:38-03	Mastodon	Blood and Thunder	Sludge Metal
99	Clássico post-rock do Godspeed You! Black Emperor	00:16:27-03	Godspeed You! Black Emperor	Storm	Post-Rock
100	Hino final do My Chemical Romance	00:05:01-03	My Chemical Romance	Welcome to the Black Parade	Emo Rock
1	Clássico do rock dos anos 80, tema do filme Rocky III	00:04:05-03	Survivor	Eye of the Tiger	Arena Rock
2	Hino do rock clássico americano	00:04:11-03	Journey	Don't Stop Believin'	Classic Rock
3	Anthem icônico do Queen	00:02:02-03	Queen	We Will Rock You	Arena Rock
4	Clássico do rock pesado dos anos 60	00:03:30-03	Steppenwolf	Born to Be Wild	Hard Rock
5	Riff mais famoso do rock	00:05:40-03	Deep Purple	Smoke on the Water	Hard Rock
6	Sucesso do Guns N' Roses	00:05:56-03	Guns N' Roses	Sweet Child O' Mine	Hard Rock
7	Hit clássico do AC/DC	00:04:15-03	AC/DC	Back in Black	Hard Rock
8	Épico do Led Zeppelin	00:08:02-03	Led Zeppelin	Stairway to Heaven	Classic Rock
9	Rock anthem dos anos 80	00:06:46-03	Guns N' Roses	Paradise City	Hard Rock
10	Clássico do Metallica	00:05:31-03	Metallica	Enter Sandman	Metal
\.


--
-- TOC entry 4917 (class 0 OID 49340)
-- Dependencies: 223
-- Data for Name: musicascurtidas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicascurtidas (id_musica, id_usuario) FROM stdin;
8	2
8	9
16	9
15	9
13	12
14	9
\.


--
-- TOC entry 4918 (class 0 OID 49345)
-- Dependencies: 224
-- Data for Name: musicasplaylists; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.musicasplaylists (id_musica, id_playlist) FROM stdin;
1	5
1	7
7	7
2	7
10	8
10	7
1	7
42	7
19	10
22	11
5	12
25	12
14	7
\.


--
-- TOC entry 4916 (class 0 OID 32972)
-- Dependencies: 222
-- Data for Name: playlist; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.playlist (id_usuario, nome_usuario, email_usuario, senha_usuario, id_playlist, nome_playlist) FROM stdin;
9	Bruno Budano	\N	\N	4	Bruno
2	bbb	\N	\N	5	bbb
9	Bruno Budano	\N	\N	7	Rock and Roll
10	Alexandre	\N	\N	12	Alexandre
\.


--
-- TOC entry 4912 (class 0 OID 16562)
-- Dependencies: 218
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id_usuario, nome_usuario, email_usuario, senha_usuario) FROM stdin;
2	bbb	bbb	123
3	Beatriz	Beatriz@email.com	123456
4	Jorge Versilo	Jorge@email.com	1234
9	Bruno Budano	Bruno@email.com	123
10	Alexandre	Alexandre@email.com	123456
11	Guilherme	Guilherme@email.com	12345
12	Teste	teste@email.com	123
\.


--
-- TOC entry 4924 (class 0 OID 0)
-- Dependencies: 217
-- Name: Usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Usuario_id_usuario_seq"', 12, true);


--
-- TOC entry 4925 (class 0 OID 0)
-- Dependencies: 219
-- Name: musica_Id_musica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."musica_Id_musica_seq"', 100, true);


--
-- TOC entry 4926 (class 0 OID 0)
-- Dependencies: 221
-- Name: playlist_id_playlist_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.playlist_id_playlist_seq', 14, true);


--
-- TOC entry 4761 (class 2606 OID 16568)
-- Name: usuario Usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY (id_usuario);


--
-- TOC entry 4763 (class 2606 OID 32963)
-- Name: musica musica_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.musica
    ADD CONSTRAINT musica_pkey PRIMARY KEY (id_musica);


--
-- TOC entry 4765 (class 2606 OID 32978)
-- Name: playlist playlist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.playlist
    ADD CONSTRAINT playlist_pkey PRIMARY KEY (id_playlist);


-- Completed on 2025-05-24 10:00:25

--
-- PostgreSQL database dump complete
--

