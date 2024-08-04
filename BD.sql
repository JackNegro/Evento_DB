PGDMP      2                |        
   Eventos_BD     15.7 (Ubuntu 15.7-1.pgdg23.10+1)     16.3 (Ubuntu 16.3-1.pgdg23.10+1) ?    {           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            |           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            }           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ~           1262    24589 
   Eventos_BD    DATABASE     x   CREATE DATABASE "Eventos_BD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';
    DROP DATABASE "Eventos_BD";
                chris    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1259    33060    cliente    TABLE     �  CREATE TABLE public.cliente (
    nocliente integer NOT NULL,
    idcliente character varying[] NOT NULL,
    nombre character varying[],
    primerapellido character varying[],
    segundoapelllido character varying[],
    direccion character varying[],
    telefono character varying[],
    email character varying[],
    tratopreferencial boolean,
    eventosanteriores character varying[]
);
    DROP TABLE public.cliente;
       public         heap    chris    false    4            �            1259    33059    cliente_nocliente_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_nocliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.cliente_nocliente_seq;
       public          chris    false    219    4            �           0    0    cliente_nocliente_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.cliente_nocliente_seq OWNED BY public.cliente.nocliente;
          public          chris    false    218            �            1259    33145    contrato    TABLE       CREATE TABLE public.contrato (
    nocontrato integer NOT NULL,
    codevento character varying[],
    codservicio character varying[],
    pago double precision,
    cronogramapago date,
    condiciones character varying[],
    codempresa character varying[]
);
    DROP TABLE public.contrato;
       public         heap    chris    false    4            �            1259    33144    contrato_nocontrato_seq    SEQUENCE     �   CREATE SEQUENCE public.contrato_nocontrato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.contrato_nocontrato_seq;
       public          chris    false    4    227            �           0    0    contrato_nocontrato_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.contrato_nocontrato_seq OWNED BY public.contrato.nocontrato;
          public          chris    false    226            �            1259    33046    empleado    TABLE     �  CREATE TABLE public.empleado (
    noempleado integer NOT NULL,
    idempleado character varying[] NOT NULL,
    codempresa character varying[],
    nombre character varying[],
    primerapellido character varying[],
    segundoapelllido character varying[],
    direccion character varying[],
    telefono character varying[],
    cargo character varying[],
    departamento character varying[]
);
    DROP TABLE public.empleado;
       public         heap    chris    false    4            �            1259    33045    empleado_noempleado_seq    SEQUENCE     �   CREATE SEQUENCE public.empleado_noempleado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.empleado_noempleado_seq;
       public          chris    false    4    217            �           0    0    empleado_noempleado_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.empleado_noempleado_seq OWNED BY public.empleado.noempleado;
          public          chris    false    216            �            1259    33028    empresa    TABLE     �  CREATE TABLE public.empresa (
    noempresa integer NOT NULL,
    codempresa character varying[] NOT NULL,
    direccionpostal character varying[] NOT NULL,
    nombre character varying[] NOT NULL,
    telefono character varying[],
    directorgeneral character varying[],
    gerenterecursos character varying[],
    responsablecontailidad character varying[],
    secretariosindicato character varying[]
);
    DROP TABLE public.empresa;
       public         heap    chris    false    4            �            1259    33027    empresa_noempresa_seq    SEQUENCE     �   CREATE SEQUENCE public.empresa_noempresa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.empresa_noempresa_seq;
       public          chris    false    4    215            �           0    0    empresa_noempresa_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.empresa_noempresa_seq OWNED BY public.empresa.noempresa;
          public          chris    false    214            �            1259    33092    evento    TABLE     �  CREATE TABLE public.evento (
    noevento integer NOT NULL,
    codevento character varying[] NOT NULL,
    nombre character varying[],
    tipo character varying[],
    fecha date,
    horainicio time without time zone,
    horafin time without time zone,
    ubicacion character varying[],
    numinvitados integer,
    concepto character varying[],
    responsable character varying[],
    idcliente character varying[]
);
    DROP TABLE public.evento;
       public         heap    chris    false    4            �            1259    33091    evento_noevento_seq    SEQUENCE     �   CREATE SEQUENCE public.evento_noevento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.evento_noevento_seq;
       public          chris    false    4    221            �           0    0    evento_noevento_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.evento_noevento_seq OWNED BY public.evento.noevento;
          public          chris    false    220            �            1259    33126 	   proveedor    TABLE     m  CREATE TABLE public.proveedor (
    noproveedor integer NOT NULL,
    idproveedor character varying[] NOT NULL,
    nombre character varying[],
    primerapellido character varying[],
    segundoapelllido character varying[],
    direccion character varying[],
    telefono character varying[],
    email character varying[],
    codservicio character varying[]
);
    DROP TABLE public.proveedor;
       public         heap    chris    false    4            �            1259    33125    proveedor_noproveedor_seq    SEQUENCE     �   CREATE SEQUENCE public.proveedor_noproveedor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.proveedor_noproveedor_seq;
       public          chris    false    225    4            �           0    0    proveedor_noproveedor_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.proveedor_noproveedor_seq OWNED BY public.proveedor.noproveedor;
          public          chris    false    224            �            1259    33117    servicio    TABLE     @  CREATE TABLE public.servicio (
    noservicio integer NOT NULL,
    codservicio character varying[] NOT NULL,
    nombre character varying[],
    descripcion character varying[],
    categoria character varying[],
    precio double precision,
    tiposervicio character varying[],
    idproveedor character varying[]
);
    DROP TABLE public.servicio;
       public         heap    chris    false    4            �            1259    33116    servicio_noservicio_seq    SEQUENCE     �   CREATE SEQUENCE public.servicio_noservicio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.servicio_noservicio_seq;
       public          chris    false    4    223            �           0    0    servicio_noservicio_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.servicio_noservicio_seq OWNED BY public.servicio.noservicio;
          public          chris    false    222            �           2604    33063    cliente nocliente    DEFAULT     v   ALTER TABLE ONLY public.cliente ALTER COLUMN nocliente SET DEFAULT nextval('public.cliente_nocliente_seq'::regclass);
 @   ALTER TABLE public.cliente ALTER COLUMN nocliente DROP DEFAULT;
       public          chris    false    219    218    219            �           2604    33148    contrato nocontrato    DEFAULT     z   ALTER TABLE ONLY public.contrato ALTER COLUMN nocontrato SET DEFAULT nextval('public.contrato_nocontrato_seq'::regclass);
 B   ALTER TABLE public.contrato ALTER COLUMN nocontrato DROP DEFAULT;
       public          chris    false    226    227    227            �           2604    33049    empleado noempleado    DEFAULT     z   ALTER TABLE ONLY public.empleado ALTER COLUMN noempleado SET DEFAULT nextval('public.empleado_noempleado_seq'::regclass);
 B   ALTER TABLE public.empleado ALTER COLUMN noempleado DROP DEFAULT;
       public          chris    false    217    216    217            �           2604    33031    empresa noempresa    DEFAULT     v   ALTER TABLE ONLY public.empresa ALTER COLUMN noempresa SET DEFAULT nextval('public.empresa_noempresa_seq'::regclass);
 @   ALTER TABLE public.empresa ALTER COLUMN noempresa DROP DEFAULT;
       public          chris    false    215    214    215            �           2604    33095    evento noevento    DEFAULT     r   ALTER TABLE ONLY public.evento ALTER COLUMN noevento SET DEFAULT nextval('public.evento_noevento_seq'::regclass);
 >   ALTER TABLE public.evento ALTER COLUMN noevento DROP DEFAULT;
       public          chris    false    220    221    221            �           2604    33129    proveedor noproveedor    DEFAULT     ~   ALTER TABLE ONLY public.proveedor ALTER COLUMN noproveedor SET DEFAULT nextval('public.proveedor_noproveedor_seq'::regclass);
 D   ALTER TABLE public.proveedor ALTER COLUMN noproveedor DROP DEFAULT;
       public          chris    false    224    225    225            �           2604    33120    servicio noservicio    DEFAULT     z   ALTER TABLE ONLY public.servicio ALTER COLUMN noservicio SET DEFAULT nextval('public.servicio_noservicio_seq'::regclass);
 B   ALTER TABLE public.servicio ALTER COLUMN noservicio DROP DEFAULT;
       public          chris    false    223    222    223            p          0    33060    cliente 
   TABLE DATA           �   COPY public.cliente (nocliente, idcliente, nombre, primerapellido, segundoapelllido, direccion, telefono, email, tratopreferencial, eventosanteriores) FROM stdin;
    public          chris    false    219   "O       x          0    33145    contrato 
   TABLE DATA           u   COPY public.contrato (nocontrato, codevento, codservicio, pago, cronogramapago, condiciones, codempresa) FROM stdin;
    public          chris    false    227   ?O       n          0    33046    empleado 
   TABLE DATA           �   COPY public.empleado (noempleado, idempleado, codempresa, nombre, primerapellido, segundoapelllido, direccion, telefono, cargo, departamento) FROM stdin;
    public          chris    false    217   \O       l          0    33028    empresa 
   TABLE DATA           �   COPY public.empresa (noempresa, codempresa, direccionpostal, nombre, telefono, directorgeneral, gerenterecursos, responsablecontailidad, secretariosindicato) FROM stdin;
    public          chris    false    215   yO       r          0    33092    evento 
   TABLE DATA           �   COPY public.evento (noevento, codevento, nombre, tipo, fecha, horainicio, horafin, ubicacion, numinvitados, concepto, responsable, idcliente) FROM stdin;
    public          chris    false    221   �O       v          0    33126 	   proveedor 
   TABLE DATA           �   COPY public.proveedor (noproveedor, idproveedor, nombre, primerapellido, segundoapelllido, direccion, telefono, email, codservicio) FROM stdin;
    public          chris    false    225   �O       t          0    33117    servicio 
   TABLE DATA           ~   COPY public.servicio (noservicio, codservicio, nombre, descripcion, categoria, precio, tiposervicio, idproveedor) FROM stdin;
    public          chris    false    223   �O       �           0    0    cliente_nocliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_nocliente_seq', 1, false);
          public          chris    false    218            �           0    0    contrato_nocontrato_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.contrato_nocontrato_seq', 1, false);
          public          chris    false    226            �           0    0    empleado_noempleado_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.empleado_noempleado_seq', 1, false);
          public          chris    false    216            �           0    0    empresa_noempresa_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.empresa_noempresa_seq', 1, false);
          public          chris    false    214            �           0    0    evento_noevento_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.evento_noevento_seq', 1, false);
          public          chris    false    220            �           0    0    proveedor_noproveedor_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.proveedor_noproveedor_seq', 1, false);
          public          chris    false    224            �           0    0    servicio_noservicio_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.servicio_noservicio_seq', 1, false);
          public          chris    false    222            �           2606    33067    cliente cliente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (idcliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            chris    false    219            �           2606    33053    empleado empleado_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (idempleado);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public            chris    false    217            �           2606    33035    empresa empresa_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (codempresa);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            chris    false    215            �           2606    33099    evento evento_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT evento_pkey PRIMARY KEY (codevento);
 <   ALTER TABLE ONLY public.evento DROP CONSTRAINT evento_pkey;
       public            chris    false    221            �           2606    33133    proveedor proveedor_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT proveedor_pkey PRIMARY KEY (idproveedor);
 B   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT proveedor_pkey;
       public            chris    false    225            �           2606    33124    servicio servicio_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT servicio_pkey PRIMARY KEY (codservicio);
 @   ALTER TABLE ONLY public.servicio DROP CONSTRAINT servicio_pkey;
       public            chris    false    223            �           2606    33054    empleado codempresa    FK CONSTRAINT     �   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT codempresa FOREIGN KEY (codempresa) REFERENCES public.empresa(codempresa) ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.empleado DROP CONSTRAINT codempresa;
       public          chris    false    3273    217    215            �           2606    33161    contrato codempresa    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT codempresa FOREIGN KEY (codempresa) REFERENCES public.empresa(codempresa) ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.contrato DROP CONSTRAINT codempresa;
       public          chris    false    3273    227    215            �           2606    33151    contrato codevento    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT codevento FOREIGN KEY (codevento) REFERENCES public.evento(codevento) ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.contrato DROP CONSTRAINT codevento;
       public          chris    false    3279    221    227            �           2606    33134    proveedor codservicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.proveedor
    ADD CONSTRAINT codservicio FOREIGN KEY (codservicio) REFERENCES public.servicio(codservicio) ON DELETE CASCADE;
 ?   ALTER TABLE ONLY public.proveedor DROP CONSTRAINT codservicio;
       public          chris    false    225    3281    223            �           2606    33156    contrato codservicio    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato
    ADD CONSTRAINT codservicio FOREIGN KEY (codservicio) REFERENCES public.servicio(codservicio) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.contrato DROP CONSTRAINT codservicio;
       public          chris    false    223    227    3281            �           2606    33111    cliente eventosanteriores    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT eventosanteriores FOREIGN KEY (eventosanteriores) REFERENCES public.evento(codevento) ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.cliente DROP CONSTRAINT eventosanteriores;
       public          chris    false    221    3279    219            �           2606    33105    evento idcliente    FK CONSTRAINT     �   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT idcliente FOREIGN KEY (idcliente) REFERENCES public.cliente(idcliente) ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.evento DROP CONSTRAINT idcliente;
       public          chris    false    3277    219    221            �           2606    33139    servicio idproveedor    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT idproveedor FOREIGN KEY (idproveedor) REFERENCES public.proveedor(idproveedor) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.servicio DROP CONSTRAINT idproveedor;
       public          chris    false    225    223    3283            �           2606    33100    evento responsable    FK CONSTRAINT     �   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT responsable FOREIGN KEY (responsable) REFERENCES public.empleado(idempleado) ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.evento DROP CONSTRAINT responsable;
       public          chris    false    221    3275    217            p      x������ � �      x      x������ � �      n      x������ � �      l      x������ � �      r      x������ � �      v      x������ � �      t      x������ � �     