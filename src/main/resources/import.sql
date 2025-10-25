insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values (2,'Indiana');

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

insert into restaurante (nome, taxa_frete,cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_bairro, endereco_cep,endereco_complemento, endereco_logradouro, endereco_numero) values ('O melhor da Tailandia', 5,1, utc_timestamp, utc_timestamp, 1,'Centro', '09750-225','apto 193C','Rua Dr Marcel Preotesco','134');
insert into restaurante (nome, taxa_frete,cozinha_id, data_cadastro, data_atualizacao) values ('Comida Indiana', 8,2, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete,cozinha_id, data_cadastro, data_atualizacao) values ('Comida Indiana xpto', 3,2, utc_timestamp, utc_timestamp);

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (1,'Produto 1 do restaurante 1','Produto 1 do restaurante 1', 121.33, 1, 1 );
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (2,'Produto 2 do restaurante 1','Produto 2 do restaurante 1', 221.33, 1, 1 );
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (3,'Produto 3 do restaurante 1','Produto 3 do restaurante 1', 321.33, 1, 1 );
	
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (4,'Produto 4 do restaurante 2','Produto 4 do restaurante 2', 121.22, 1, 2 );
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (5,'Produto 5 do restaurante 2','Produto 5 do restaurante 2', 221.22, 1, 2 );
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (6,'Produto 6 do restaurante 2','Produto 6 do restaurante 2', 321.22, 1, 2 );

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (7,'Produto 7 do restaurante 3','Produto 7 do restaurante 3', 131.22, 1, 3 );
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (8,'Produto 8 do restaurante 3','Produto 8 do restaurante 3', 231.22, 1, 3 );
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (9,'Produto 9 do restaurante 3','Produto 9 do restaurante 3', 331.22, 1, 3 );

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (10,'Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, 1, 1);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (11,'Camarão tailandês', '16 camarões grandes ao molho picante', 110, 1, 1);

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (12,'Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, 1, 2);

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (13,'Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, 1, 3);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (14,'Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, 1, 3);

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (15,'Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, 1, 1);
insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (16,'T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, 1, 2);

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (17,'Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, 1, 3);

insert into produto (id, nome, descricao, preco, ativo, restaurante_id) values (18,'Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, 1, 1);

insert into forma_pagamento(descricao) values ('Dinheiro');
insert into forma_pagamento(descricao) values ('Cartão de Débito');
insert into forma_pagamento(descricao) values ('Cartão de Crédito');
insert into forma_pagamento(descricao) values ('Pix');
insert into forma_pagamento(descricao) values ('Boleto');

insert into permissao (nome, descricao) values ('ADM','Administrador');
insert into permissao (nome, descricao) values ('CON','Somente consulta');
insert into permissao (nome, descricao) values ('NOR','Usuário normal');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1),(1,2),(1,3),(2,3),(3,2),(3,3);

insert into grupo (id, nome) values (1,'TI');
insert into grupo (id, nome) values (2,'Diretoria');
insert into grupo (id, nome) values (3,'Telemarketing');

insert into grupo_permissao (grupo_id, permissao_id) values (1,1), (1,2),(1,3);
insert into grupo_permissao (grupo_id, permissao_id) values (2,1),(2,2),(2,3);
insert into grupo_permissao (grupo_id, permissao_id) values (3,2),(3,3);

insert into usuario (id, nome, email, senha, data_cadastro) values (1,'Joni', 'jsleles@gmail.com', 'joni123', utc_timestamp);
insert into usuario (id, nome, email, senha, data_cadastro) values (2,'Simone', 'simone.gutileles@gmail.com', 'sim123', utc_timestamp);
insert into usuario (id, nome, email, senha, data_cadastro) values (3,'Matheus', 'matheus.guti@gmail.com', 'mat123', utc_timestamp);

insert into usuario_grupo (usuario_id, grupo_id) values (1,1),(1,2),(1,3);
insert into usuario_grupo (usuario_id, grupo_id) values (2,1),(2,3);
insert into usuario_grupo (usuario_id, grupo_id) values (3,1),(3,2);

