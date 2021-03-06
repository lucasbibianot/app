CREATE DATABASE ROOT;
USE ROOT;

/**Tabelas de infraestrutura**/

CREATE TABLE TB_PERFIL(
ID_PERFIL smallint unsigned not null auto_increment, 
NM_PERFIL VARCHAR(30) NOT NULL,
IN_ATIVO varchar(1) not null default 'S', 
CONSTRAINT PK_PERFIL primary key (ID_PERFIL));

CREATE INDEX IN_TB_PERFIL_01 ON TB_PERFIL(ID_PERFIL);

CREATE TABLE TB_USUARIO(
ID_USUARIO smallint unsigned not null auto_increment, 
NM_USUARIO VARCHAR(200) not null, 
DS_SENHA VARCHAR(200) NOT NULL,
MAIL_USUARIO VARCHAR(200) not null,
IN_ATIVO varchar(1) not null default 'S', 
ID_PERFIL smallint unsigned NOT NULL,
DS_TOKEN VARCHAR(200) not null, 
DS_SALT VARCHAR(200) not null, 
CONSTRAINT PK_USUARIO primary key (ID_USUARIO),
CONSTRAINT FK_TB_PERFIL FOREIGN KEY (ID_PERFIL) REFERENCES TB_PERFIL(ID_PERFIL));

DROP TABLE TB_PARAMETRO;
CREATE TABLE TB_PARAMETRO(
ID_PARAMETRO smallint unsigned not null auto_increment, 
NM_PARAMETRO VARCHAR(200) not null, 
VAL_PARAMETRO VARCHAR(200) not null, 
TP_PARAMETRO VARCHAR(1) NOT NULL, /**S - Texto, N - Numero, D - Data **/
IN_ATIVO varchar(1) not null default 'S', 
CONSTRAINT PK_PARAMETRO PRIMARY KEY (ID_PARAMETRO));

CREATE TABLE TB_TOKEN_SEGURANCA(
ID_TOKEN_SEGURANCA smallint unsigned not null auto_increment, 
NM_TOKEN VARCHAR(30) NOT NULL,
DS_SECRET_KEY VARCHAR(200) NOT NULL,
IN_ATIVO varchar(1) not null default 'S', 
CONSTRAINT PK_TOKEN_SEGURANCA primary key(ID_TOKEN_SEGURANCA));

/**Tabelas de negócio**/

DROP TABLE TB_FORNECEDOR;
CREATE TABLE TB_FORNECEDOR (
ID_FORNECEDOR smallint unsigned NOT NULL AUTO_INCREMENT,
NM_FORNECEDOR VARCHAR(400) NOT NULL,
DS_REFERENCIA VARCHAR(400) NULL,
NM_IDENTIFICADOR VARCHAR(1000) NOT NULL,
NM_RUA VARCHAR(1000) NOT NULL,
NUM_LOGRADOURO smallint NOT NULL,
DS_COMPLEMENTO VARCHAR(1000) NULL,
NM_BAIRRO VARCHAR(1000) NOT NULL,
NM_CIDADE VARCHAR(1000) NOT NULL,
DS_UF VARCHAR(1000) NOT NULL,
DS_ENDERECO VARCHAR(1000) NOT NULL,
PLACE_ID VARCHAR(300) NULL,
NUM_LATITUDE decimal NULL,
NUM_LONGITUDE decimal NULL,
DS_TELEFONE VARCHAR(50) NULL,
DS_WEBSIT VARCHAR(400) NULL,
NUM_CEP bigint NULL,
NM_CONTATO_TEL VARCHAR(1000) NULL,
NM_CONTATO_MAIL VARCHAR(1000) NULL,
DS_MAIL VARCHAR(1000) NULL,
IN_ATIVO varchar(1) not null default 'S', 
CONSTRAINT PK_FORNECEDOR primary key(ID_FORNECEDOR)
);


CREATE TABLE TB_RECIPIENTE (
ID_RECIPIENTE smallint unsigned NOT NULL AUTO_INCREMENT,
NM_RECIPIENTE VARCHAR(50) NOT NULL,
VAL_VOLUME NUMERIC(5,3) NOT NULL,
IN_ATIVO varchar(1) not null default 'S', 
constraint PK_RECIPIENTE primary key(ID_RECIPIENTE));

CREATE TABLE TB_FABRICANTE(
ID_FABRICANTE smallint unsigned NOT NULL AUTO_INCREMENT,
NM_FABRICANTE VARCHAR(50) NOT NULL,
IN_ATIVO varchar(1) not null default 'S', 
CONSTRAINT PK_FABRICANTE primary key(ID_FABRICANTE));

DROP TABLE TB_PRODUTO;
CREATE TABLE TB_PRODUTO (
ID_PRODUTO smallint unsigned NOT NULL AUTO_INCREMENT,
NM_PRODUTO VARCHAR(300) NOT NULL,
URL_IMAGEM VARCHAR(400) NULL,
ID_FABRICANTE smallint unsigned NULL,
ID_RECIPIENTE smallint unsigned NOT NULL,
IN_ATIVO varchar(1) not null default 'S', 
constraint PK_PRODUTO primary key(ID_PRODUTO),
constraint FK_FABRICANTE foreign key (ID_FABRICANTE) references TB_FABRICANTE(ID_FABRICANTE),
constraint FK_RECIPIENTE foreign key (ID_RECIPIENTE) references TB_RECIPIENTE(ID_RECIPIENTE));

DROP TABLE TB_COTACAO_PRODUTO;
CREATE TABLE TB_COTACAO_PRODUTO(
ID_COTACAO_PRODUTO smallint unsigned NOT NULL auto_increment,
DT_COTACAO TIMESTAMP NOT NULL,
ID_PRODUTO smallint unsigned NOT NULL,
ID_FORNECEDOR SMALLINT unsigned NOT NULL,
VAL_PRODUTO NUMERIC(5,2) NOT NULL,
DT_VALIDADE TIMESTAMP NOT NULL default now(),
DS_OBSERVAO VARCHAR(1000) NULL,
IN_ATIVO varchar(1) not null default 'S', 
CONSTRAINT PK_COTACAO_PRODUTO primary key(ID_COTACAO_PRODUTO),
CONSTRAINT FK_PRODUTO foreign key (ID_PRODUTO) REFERENCES TB_PRODUTO(ID_PRODUTO),
CONSTRAINT FP_FORNECEDOR foreign key (ID_FORNECEDOR) REFERENCES TB_FORNECEDOR(ID_FORNECEDOR));