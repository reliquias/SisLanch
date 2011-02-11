insert into cidade (estado_enum, nome)
values             ('SP', 'Birigui');

insert into cidade (estado_enum, nome)
values             ('SP', 'São Paulo');

insert into cidade (estado_enum, nome)
values             ('SP', 'São Bernardo do Campo');

insert into cidade (estado_enum, nome)
values             ('SP', 'Bilac');

insert into cidade (estado_enum, nome)
values             ('SP', 'Osasco');

insert into cidade (estado_enum, nome)
values             ('SP', 'Santos');

insert into cidade (estado_enum, nome)
values             ('SP', 'Araçatuba');

insert into cidade (estado_enum, nome)
values             ('PR', 'Londrina');

insert into cidade (estado_enum, nome)
values             ('PR', 'Foz do Iguaçu');

insert into cidade (estado_enum, nome)
values             ('PR', 'Maringa');

insert into cidade (estado_enum, nome)
values             ('PR', 'Curitiba');

insert into cidade (estado_enum, nome)
values             ('SP', 'Santo Andre');

insert into cidade (estado_enum, nome)
values             ('SP', 'Coroados');

insert into cidade (estado_enum, nome)
values             ('SP', 'Buritama');

insert into cidade (estado_enum, nome)
values             ('SP', 'São Caetano do Sul');

insert into cidade (estado_enum, nome)
values             ('SP', 'Maua');

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Wanderson Reliquias', 'Programador Java', '11 8883-4468', 2);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Mauricio Frizon', 'Analista', '11 4444-8888', 2);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Paulo Granja', 'Analista Suporte', '11 5555-6666', 2);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Roberto Nogueira', 'Programador Delphi', '11 4425-5698', 2);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Gilmar Junior', 'Programador Delphi', '11 8754-5687', 2);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Alan Morgon', 'Suporte', '11 4512-9856', 3);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Sandra', 'Contabilidade', '11 7854-9652', 2);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Maria Fernanda', 'Estagiaria', '11 4125-9874', 2);

insert into funcionario (nome, cargo, telefone, cidade_id_cidade)
values             ('Fernando Guillermo', 'Vendas', '11 4521-6587', 2);

insert into restaurante (nome, bairro, telefone, endereco, numero, cidade_id_cidade)
values ('Prato do Dia', 'Mooca', '11 2062-2254', 'Rua Dona Maira', 65, 2);

insert into restaurante (nome, bairro, telefone, endereco, numero, cidade_id_cidade)
values ('Prato de Ontem', 'Mooca', '11 2222-2254', 'Rua Dolores', 69, 2);

insert into restaurante (nome, bairro, telefone, endereco, numero, cidade_id_cidade)
values ('CC - Comeu, KGO', 'Praça da Sé', '11 2365-9658', 'Rua Chicago', 1234, 2);

insert into restaurante (nome, bairro, telefone, endereco, numero, cidade_id_cidade)
values ('Espeto de Gato', 'Pinheiros', '11 1234-5678', 'Rua Felino', 852, 2);

insert into prato (numero, nome, descricao, valor_unitario, dia_semana_enum, restaurante_id)
values ('1', 'Bifé a Rolê', 'Arroz e Fritas', 7.00, 'Domingo', 1);

insert into prato (numero, nome, descricao, valor_unitario, dia_semana_enum, restaurante_id)
values ('2', 'Filé de Frango', 'Arroz, Bacon e Fritas', 7.00, 'Segunda', 1);

insert into prato (numero, nome, descricao, valor_unitario, dia_semana_enum, restaurante_id)
values ('3', 'Mineirice', 'Arroz e Fritas', 7.00, 'Terça', 1);

insert into prato (numero, nome, descricao, valor_unitario, dia_semana_enum, restaurante_id)
values ('1', 'Bifé a Cavalo', 'Arroz e Fritas/Salada', 7.00, 'Segunda', 2);

insert into prato (numero, nome, descricao, valor_unitario, dia_semana_enum, restaurante_id)
values ('2', 'Filé de Frango', 'Arroz, Bacon e Fritas', 7.00, 'Segunda', 2);

insert into prato (numero, nome, descricao, valor_unitario, dia_semana_enum, restaurante_id)
values ('3', 'Arroz Doce', 'Arroz e Leite', 7.00, 'Terça', 2);

insert into prato (numero, nome, descricao, valor_unitario, dia_semana_enum, restaurante_id)
values ('1', 'Canjica', 'Arroz e Leite', 7.00, 'Terça', 3);

insert into pedido (data_pedido, restaurante_id)
values ('2011-01-01', 1);

insert into pedido (data_pedido, restaurante_id)
values ('2011-01-11', 2);

insert into pedido (data_pedido, restaurante_id)
values ('2011-01-13', 1);

insert into funcionario_pedido (pedido_id, funcionario_id, prato_id, dinheiro, quantidade)
values (1, 1, 1, 10.00, 1);

insert into funcionario_pedido (pedido_id, funcionario_id, prato_id, dinheiro, quantidade)
values (1, 2, 2, 10.00, 1);

insert into funcionario_pedido (pedido_id, funcionario_id, prato_id, dinheiro, quantidade)
values (1, 3, 1, 15.00, 2);

insert into funcionario_pedido (pedido_id, funcionario_id, prato_id, dinheiro, quantidade)
values (2, 4, 1, 10.00, 1);

insert into funcionario_pedido (pedido_id, funcionario_id, prato_id, dinheiro, quantidade)
values (2, 1, 1, 10.00, 1);