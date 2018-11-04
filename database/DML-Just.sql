use root;

/** cadatro de parâmetros da aplicação **/
insert into TB_PARAMETRO(NM_PARAMETRO, VAL_PARAMETRO, TP_PARAMETRO) values ('timeoutToken','600000000', 'N');
insert into TB_PARAMETRO(NM_PARAMETRO, VAL_PARAMETRO, TP_PARAMETRO) values ('idPerfilPadrao', '2', 'N');
insert into TB_PARAMETRO(NM_PARAMETRO, VAL_PARAMETRO, TP_PARAMETRO) values ('token','mobile-token', 'S');

/** cadastro do token de segurança **/
insert into TB_TOKEN_SEGURANCA(NM_TOKEN, DS_SECRET_KEY, IN_ATIVO) values ('mobile-token', 'TGlsaWFueUZvdG9ncmFmaWE=', 'S');

/** Cadastro de recipientes **/
insert into TB_RECIPIENTE(NM_RECIPIENTE, VAL_VOLUME, IN_ATIVO) values('Latão', 0.473, 'S');
insert into TB_RECIPIENTE(NM_RECIPIENTE, VAL_VOLUME, IN_ATIVO) values('Lata', 0.350, 'S');
insert into TB_RECIPIENTE(NM_RECIPIENTE, VAL_VOLUME, IN_ATIVO) values('Mega-Latão', 0.550, 'S');
insert into TB_RECIPIENTE(NM_RECIPIENTE, VAL_VOLUME, IN_ATIVO) values('Latinha', 0.310, 'S');
insert into TB_RECIPIENTE(NM_RECIPIENTE, VAL_VOLUME, IN_ATIVO) values('Garrafa', 0.600, 'S');
insert into TB_RECIPIENTE(NM_RECIPIENTE, VAL_VOLUME, IN_ATIVO) values('Longneck', 0.355, 'S');
insert into TB_RECIPIENTE(NM_RECIPIENTE, VAL_VOLUME, IN_ATIVO) values('Litro', 1.0, 'S');

insert into TB_PERFIL(NM_PERFIL, IN_ATIVO) values ('Administrador', 'S');
insert into TB_PERFIL(NM_PERFIL, IN_ATIVO) values ('Usuario', 'S');


select * from TB_TOKEN_SEGURANCA;

truncate table TB_TOKEN_SEGURANCA;






