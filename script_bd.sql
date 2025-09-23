CREATE TABLE IF NOT EXISTS mt_usuarios
(
    id_usuario bigint NOT NULL,
    data_criacao timestamp(6) without time zone,
    email character varying(150) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(150) COLLATE pg_catalog."default" NOT NULL,
    perfil character varying(20) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(150) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT mt_usuarios_pkey PRIMARY KEY (id_usuario),
    CONSTRAINT ukd4xeuudi3oeqd52fly1dvjty7 UNIQUE (email),
    CONSTRAINT mt_usuarios_perfil_check CHECK (perfil::text = ANY (ARRAY['ADMIN'::character varying, 'COMUM'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS mt_usuarios
    OWNER to adminuser;



CREATE TABLE IF NOT EXISTS mt_motos
(
    id_moto bigint NOT NULL,
    chassi character varying(17) COLLATE pg_catalog."default" NOT NULL,
    modelo character varying(11) COLLATE pg_catalog."default" NOT NULL,
    placa character varying(7) COLLATE pg_catalog."default" NOT NULL,
    status character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT mt_motos_pkey PRIMARY KEY (id_moto),
    CONSTRAINT uknh09db472p0kkmsulxrvbnepo UNIQUE (placa),
    CONSTRAINT ukq182tt9t24equelgkds0059wo UNIQUE (chassi),
    CONSTRAINT mt_motos_modelo_check CHECK (modelo::text = ANY (ARRAY['MOTTU_POP'::character varying, 'MOTTU_SPORT'::character varying, 'MOTTU_E'::character varying]::text[])),
    CONSTRAINT mt_motos_status_check CHECK (status::text = ANY (ARRAY['MANUTENCAO'::character varying, 'DISPONIVEL'::character varying, 'AVALIACAO'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS mt_motos
    OWNER to adminuser;

	

CREATE TABLE IF NOT EXISTS mt_departamentos
(
    id_departamento bigint NOT NULL,
    descricao character varying(100) COLLATE pg_catalog."default" NOT NULL,
    tipo character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT mt_departamentos_pkey PRIMARY KEY (id_departamento),
    CONSTRAINT mt_departamentos_tipo_check CHECK (tipo::text = ANY (ARRAY['ENTRADA'::character varying, 'AVALIACAO'::character varying, 'MANUTENCAO'::character varying, 'PRONTA_PARA_USO'::character varying, 'SAIDA'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS mt_departamentos
    OWNER to adminuser;



	CREATE TABLE IF NOT EXISTS mt_alertas
(
    id_alerta bigint NOT NULL,
    data_alerta timestamp(6) without time zone NOT NULL,
    gravidade character varying(255) COLLATE pg_catalog."default" NOT NULL,
    mensagem character varying(200) COLLATE pg_catalog."default" NOT NULL,
    moto_id bigint,
    CONSTRAINT mt_alertas_pkey PRIMARY KEY (id_alerta),
    CONSTRAINT fk3rer8nn5svjf9ubso5suu6yiq FOREIGN KEY (moto_id)
        REFERENCES mt_motos (id_moto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT mt_alertas_gravidade_check CHECK (gravidade::text = ANY (ARRAY['ALTA'::character varying, 'MEDIA'::character varying, 'BAIXA'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS mt_alertas
    OWNER to adminuser;



	CREATE TABLE IF NOT EXISTS mt_movimentacoes
(
    id_movimentacao bigint NOT NULL,
    data_movimentacao timestamp(6) without time zone,
    departamento_id bigint,
    moto_id bigint,
    CONSTRAINT mt_movimentacoes_pkey PRIMARY KEY (id_movimentacao),
    CONSTRAINT fkb1t3frrnni0fmjfsw1epgfk3 FOREIGN KEY (moto_id)
        REFERENCES mt_motos (id_moto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkfjddvsc52o8hgvhdunbei824y FOREIGN KEY (departamento_id)
        REFERENCES mt_departamentos (id_departamento) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS mt_movimentacoes
    OWNER to adminuser;


	CREATE SEQUENCE IF NOT EXISTS seq_mt_usuarios
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE seq_mt_usuarios
    OWNER TO adminuser;
	
CREATE SEQUENCE IF NOT EXISTS seq_mt_motos
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE seq_mt_motos
    OWNER TO adminuser;

CREATE SEQUENCE IF NOT EXISTS seq_mt_movimentacoes
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE seq_mt_movimentacoes
    OWNER TO adminuser;
	
CREATE SEQUENCE IF NOT EXISTS seq_mt_departamentos
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE seq_mt_departamentos
    OWNER TO adminuser;
	
CREATE SEQUENCE IF NOT EXISTS seq_mt_alertas
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE seq_mt_alertas
    OWNER TO adminuser;


INSERT INTO MT_DEPARTAMENTOS (ID_DEPARTAMENTO, DESCRICAO, TIPO)
VALUES (NEXTVAL('SEQ_MT_DEPARTAMENTOS'), 'Entrada do pátio', 'ENTRADA');

INSERT INTO MT_DEPARTAMENTOS (ID_DEPARTAMENTO, DESCRICAO, TIPO)
VALUES (NEXTVAL('SEQ_MT_DEPARTAMENTOS'), 'Departamento de Avaliação', 'AVALIACAO');

INSERT INTO MT_DEPARTAMENTOS (ID_DEPARTAMENTO, DESCRICAO, TIPO)
VALUES (NEXTVAL('SEQ_MT_DEPARTAMENTOS'), 'Departamento de Manutenção', 'MANUTENCAO');

INSERT INTO MT_DEPARTAMENTOS (ID_DEPARTAMENTO, DESCRICAO, TIPO)
VALUES (NEXTVAL('SEQ_MT_DEPARTAMENTOS'), 'Departamento Pronto para Uso', 'PRONTA_PARA_USO');

INSERT INTO MT_DEPARTAMENTOS (ID_DEPARTAMENTO, DESCRICAO, TIPO)
VALUES (NEXTVAL('SEQ_MT_DEPARTAMENTOS'), 'Saída do pátio', 'SAIDA');