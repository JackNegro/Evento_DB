PGDMP  6                    |        
   Eventos_BD     15.7 (Ubuntu 15.7-1.pgdg23.10+1)     16.3 (Ubuntu 16.3-1.pgdg23.10+1) ;    x           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            y           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            z           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            {           1262    24589 
   Eventos_BD    DATABASE     x   CREATE DATABASE "Eventos_BD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';
    DROP DATABASE "Eventos_BD";
                chris    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            |           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    24755    cliente    TABLE     T  CREATE TABLE public.cliente (
    idcliente integer NOT NULL,
    nombre character varying[],
    primerapellido character varying[],
    segundoapelllido character varying[],
    direccion character varying[],
    telefono character varying[],
    email character varying[],
    tratopreferencial boolean,
    eventosanteriores integer
);
    DROP TABLE public.cliente;
       public         heap    chris    false    4            �            1259    24754    cliente_idcliente_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.cliente_idcliente_seq;
       public          chris    false    219    4            }           0    0    cliente_idcliente_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.cliente_idcliente_seq OWNED BY public.cliente.idcliente;
          public          chris    false    218            �            1259    24815    contrato    TABLE     �   CREATE TABLE public.contrato (
    codevento integer,
    codservicio integer,
    pago double precision,
    cronogramapago date,
    condiciones character varying[],
    codempresa integer
);
    DROP TABLE public.contrato;
       public         heap    chris    false    4            �            1259    24690    empleado    TABLE     V  CREATE TABLE public.empleado (
    idempleado integer NOT NULL,
    codempresa integer,
    nombre character varying[],
    primerapellido character varying[],
    segundoapelllido character varying[],
    direccion character varying[],
    telefono character varying[],
    cargo character varying[],
    departamento character varying[]
);
    DROP TABLE public.empleado;
       public         heap    chris    false    4            �            1259    24689    empleado_idempleado_seq    SEQUENCE     �   CREATE SEQUENCE public.empleado_idempleado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.empleado_idempleado_seq;
       public          chris    false    4    217            ~           0    0    empleado_idempleado_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.empleado_idempleado_seq OWNED BY public.empleado.idempleado;
          public          chris    false    216            �            1259    24681    empresa    TABLE     m  CREATE TABLE public.empresa (
    codempresa integer NOT NULL,
    direccionpostal character varying[] NOT NULL,
    nombre character varying[] NOT NULL,
    telefono character varying[],
    directorgeneral character varying[],
    gerenterecursos character varying[],
    responsablecontailidad character varying[],
    secretariosindicato character varying[]
);
    DROP TABLE public.empresa;
       public         heap    chris    false    4            �            1259    24680    empresa_codempresa_seq    SEQUENCE     �   CREATE SEQUENCE public.empresa_codempresa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.empresa_codempresa_seq;
       public          chris    false    4    215                       0    0    empresa_codempresa_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.empresa_codempresa_seq OWNED BY public.empresa.codempresa;
          public          chris    false    214            �            1259    24764    evento    TABLE     g  CREATE TABLE public.evento (
    codevento integer NOT NULL,
    nombre character varying[],
    tipo character varying[],
    fecha date,
    horainicio time without time zone,
    horafin time without time zone,
    ubicacion character varying[],
    numinvitados integer,
    concepto character varying[],
    responsable integer,
    idcliente integer
);
    DROP TABLE public.evento;
       public         heap    chris    false    4            �            1259    24763    evento_codevento_seq    SEQUENCE     �   CREATE SEQUENCE public.evento_codevento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.evento_codevento_seq;
       public          chris    false    221    4            �           0    0    evento_codevento_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.evento_codevento_seq OWNED BY public.evento.codevento;
          public          chris    false    220            �            1259    24797 	   proveedor    TABLE     3  CREATE TABLE public.proveedor (
    idproveedor integer NOT NULL,
    nombre character varying[],
    primerapellido character varying[],
    segundoapelllido character varying[],
    direccion character varying[],
    telefono character varying[],
    email character varying[],
    codservicio integer
);
    DROP TABLE public.proveedor;
       public         heap    chris    false    4            �            1259    24796    proveedor_idproveedor_seq    SEQUENCE     �   CREATE SEQUENCE public.proveedor_idproveedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.proveedor_idproveedor_seq;
       public          chris    false    225    4            �           0    0    proveedor_idproveedor_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.proveedor_idproveedor_seq OWNED BY public.proveedor.idproveedor;
          public          chris    false    224            �            1259    24788    servicio    TABLE       CREATE TABLE public.servicio (
    codservicio integer NOT NULL,
    nombre character varying[],
    descripcion character varying[],
    categoria character varying[],
    precio double precision,
    tiposervicio character varying[],
    idproveedor integer
);
    DROP TABLE public.servicio;
       public         heap    chris    false    4            �            1259    24787    servicio_codservicio_seq    SEQUENCE     �   CREATE SEQUENCE public.servicio_codservicio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.servicio_codservicio_seq;
       public          chris    false    4    223            �           0    0    servicio_codservicio_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.servicio_codservicio_seq OWNED BY public.servicio.codservicio;
          public          chris    false    222            �           2604    24758    cliente idcliente    DEFAULT     v   ALTER TABLE ONLY public.cliente ALTER COLUMN idcliente SET DEFAULT nextval('public.cliente_idcliente_seq'::regclass);
 @   ALTER TABLE public.cliente ALTER COLUMN idcliente DROP DEFAULT;
       public          chris    false    219    218    219            �           2604    24693    empleado idempleado    DEFAULT     z   ALTER TABLE ONLY public.empleado ALTER COLUMN idempleado SET DEFAULT nextval('public.empleado_idempleado_seq'::regclass);
 B   ALTER TABLE public.empleado ALTER COLUMN idempleado DROP DEFAULT;
       public          chris    false    217    216    217            �           2604    24684    empresa codempresa    DEFAULT     x   ALTER TABLE ONLY public.empresa ALTER COLUMN codempresa SET DEFAULT nextval('public.empresa_codempresa_seq'::regclass);
 A   ALTER TABLE public.empresa ALTER COLUMN codempresa DROP DEFAULT;
       public          chris    false    215    214    215            �           2604    24767    evento codevento    DEFAULT     t   ALTER TABLE ONLY public.evento ALTER COLUMN codevento SET DEFAULT nextval('public.evento_codevento_seq'::regclass);
 ?   ALTER TABLE public.evento ALTER COLUMN codevento DROP DEFAULT;
       public          chris    false    220    221    221            �           2604    24800    proveedor idproveedor    DEFAULT     ~   ALTER TABLE ONLY public.proveedor ALTER COLUMN idproveedor SET DEFAULT nextval('public.proveedor_idproveedor_seq'::regclass);
 D   ALTER TABLE public.proveedor ALTER COLUMN idproveedor DROP DEFAULT;
       public          chris    false    224    225    225            �           2604    24791    servicio codservicio    DEFAULT     |   ALTER TABLE ONLY public.servicio ALTER COLUMN codservicio SET DEFAULT nextval('public.servicio_codservicio_seq'::regclass);
 C   ALTER TABLE public.servicio ALTER COLUMN codservicio DROP DEFAULT;
       public          chris    false    222    223    223            n          0    24755    cliente 
   TABLE DATA           �   COPY public.cliente (idcliente, nombre, primerapellido, segundoapelllido, direccion, telefono, email, tratopreferencial, eventosanteriores) FROM stdin;
    public          chris    false    219   �H       u          0    24815    contrato 
   TABLE DATA           i   COPY public.contrato (codevento, codservicio, pago, cronogramapago, condiciones, codempresa) FROM stdin;
    public          chris    false    226   �H       l          0    24690    empleado 
   TABLE DATA           �   COPY public.empleado (idempleado, codempresa, nombre, primerapellido, segundoapelllido, direccion, telefono, cargo, departamento) FROM stdin;
    public          chris    false    217   I       j          0    24681    empresa 
   TABLE DATA           �   COPY public.empresa (codempresa, direccionpostal, nombre, telefono, directorgeneral, gerenterecursos, responsablecontailidad, secretariosindicato) FROM stdin;
    public          chris    false    215   .I       p          0    24764    evento 
   TABLE DATA           �   COPY public.evento (codevento, nombre, tipo, fecha, horainicio, horafin, ubicacion, numinvitados, concepto, responsable, idcliente) FROM stdin;
    public          chris    false    221   KI       t          0    24797 	   proveedor 
   TABLE DATA           �   COPY public.proveedor (idproveedor, nombre, primerapellido, segundoapelllido, direccion, telefono, email, codservicio) FROM stdin;
    public          chris    false    225   hI       r          0    24788    servicio 
   TABLE DATA           r   COPY public.servicio (codservicio, nombre, descripcion, categoria, precio, tiposervicio, idproveedor) FROM stdin;
    public          chris    false    223   �I       �           0    0    cliente_idcliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_idcliente_seq', 1, false);
          public          chris    false    218            �           0    0    empleado_idempleado_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.empleado_idempleado_seq', 1, false);
          public          chris    false    216            �           0    0    empresa_codempresa_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.empresa_codempresa_seq', 1, false);
          public          chris    false    214            �           0    0    evento_codevento_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.evento_codevento_seq', 1, false);
          public          chris    false    220            �           0    0    proveedor_idproveedor_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.proveedor_idproveedor_seq', 1, false);
          public          chris    false    224            �           0    0    servicio_codservicio_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.servicio_codservicio_seq', 1, false);
          public          chris    false    222            �           2606    24762    cliente cliente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            chris    false    219            �           2606    24697    empleado empleado_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (idempleado);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public            chris    false    217            �           2606    24688    empresa empresa_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (codempresa);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            chris    false    215            �           2606    24771    evento evento_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT evento_pkey PRIMARY KEY (codevento);
 <   ALTER TABLE ONLY public.evento DROP CONSTRAINT evento_pkey;
       public            chris    false    221            �           2606    24804    proveedor proveedor_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT proveedor_pkey PRIMARY KEY (idproveedor);
 B   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT proveedor_pkey;
       public            chris    false    225            �           2606    24795    servicio servicio_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT servicio_pkey PRIMARY KEY (codservicio);
 @   ALTER TABLE ONLY public.servicio DROP CONSTRAINT servicio_pkey;
       public            chris    false    223            �           2606    24698    empleado codempresa    FK CONSTRAINT     �   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT codempresa FOREIGN KEY (codempresa) REFERENCES public.empresa(codempresa) ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.empleado DROP CONSTRAINT codempresa;
       public          chris    false    3271    215    217            �           2606    24830    contrato codempresa    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT codempresa FOREIGN KEY (codempresa) REFERENCES public.empresa(codempresa) ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.contrato DROP CONSTRAINT codempresa;
       public          chris    false    3271    226    215            �           2606    24820    contrato codevento    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT codevento FOREIGN KEY (codevento) REFERENCES public.evento(codevento) ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.contrato DROP CONSTRAINT codevento;
       public          chris    false    3277    226    221            �           2606    24805    proveedor codservicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT codservicio FOREIGN KEY (codservicio) REFERENCES public.servicio(codservicio) ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT codservicio;
       public          chris    false    3279    225    223            �           2606    24825    contrato codservicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT codservicio FOREIGN KEY (codservicio) REFERENCES public.servicio(codservicio) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.contrato DROP CONSTRAINT codservicio;
       public          chris    false    3279    223    226            �           2606    24782    cliente eventosanteriores    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT eventosanteriores FOREIGN KEY (eventosanteriores) REFERENCES public.evento(codevento) ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.cliente DROP CONSTRAINT eventosanteriores;
       public          chris    false    221    219    3277            �           2606    24777    evento idcliente    FK CONSTRAINT     �   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT idcliente FOREIGN KEY (idcliente) REFERENCES public.cliente(idcliente) ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.evento DROP CONSTRAINT idcliente;
       public          chris    false    221    3275    219            �           2606    24810    servicio idproveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT idproveedor FOREIGN KEY (idproveedor) REFERENCES public.proveedor(idproveedor) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.servicio DROP CONSTRAINT idproveedor;
       public          chris    false    225    223    3281            �           2606    24772    evento responsable    FK CONSTRAINT     �   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT responsable FOREIGN KEY (responsable) REFERENCES public.empleado(idempleado) ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.evento DROP CONSTRAINT responsable;
       public          chris    false    217    3273    221            n      x������ � �      u      x������ � �      l      x������ � �      j      x������ � �      p      x������ � �      t      x������ � �      r      x������ � �     