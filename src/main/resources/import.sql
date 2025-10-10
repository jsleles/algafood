insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values (2,'Indiana');

insert into restaurante (nome, taxa_frete,cozinha_id) values ('O melhor da Tailandia', 5,1);
insert into restaurante (nome, taxa_frete,cozinha_id) values ('Comida Indiana', 8,2);
insert into restaurante (nome, taxa_frete,cozinha_id) values ('Comida Indiana xpto', 3,2);

insert into forma_pagamento(descricao) values ('Dinheiro');
insert into forma_pagamento(descricao) values ('Cartão de Débito');
insert into forma_pagamento(descricao) values ('Cartão de Crédito');
insert into forma_pagamento(descricao) values ('Pix');
insert into forma_pagamento(descricao) values ('Boleto');

insert into permissao (nome, descricao) values ('ADM','Administrador');
insert into permissao (nome, descricao) values ('CON','Somente consulta');
insert into permissao (nome, descricao) values ('NOR','Usuário normal');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1),(1,2),(1,3),(2,3),(3,2),(3,3);

insert into estado (nome) values ('SP');
insert into estado (nome) values ('RJ');
insert into estado (nome) values ('RS');
insert into estado (nome) values ('MG');

insert into cidade (estado_id, nome) values (1,'São Bernardo do Campo');
insert into cidade (estado_id, nome) values (1,'São Paulo');
insert into cidade (estado_id, nome) values (1,'São Caetano');
insert into cidade (estado_id, nome) values (1,'Santo André');

insert into cidade (estado_id, nome) values (2,'Rio de Janeiro');
insert into cidade (estado_id, nome) values (2,'Copacabana');
insert into cidade (estado_id, nome) values (2,'Niteroi');

insert into cidade (estado_id, nome) values (3,'Porto Alegre');
insert into cidade (estado_id, nome) values (3,'Charqueada');



