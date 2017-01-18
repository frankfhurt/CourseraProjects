INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (1, 'AVENTURA', 75, 'João e o Pé de Feijão');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (2, 'FICCAO_CIENTIFICA', 950, 'Biblia Sagrada');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (3, 'AVENTURA', 750, 'O Senhor Dos Anéis');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (4, 'ROMANCE', 283, 'Marley e Eu');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (5, 'AVENTURA', 63, 'O Diário de Um Banana');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (6, 'QUADRINHOS', 35, 'Turma da Mônica');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (7, 'FICCAO_CIENTIFICA', 260, 'Ponto de Impacto');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (8, 'ROMANCE', 482, 'O Código Da Vinci');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (9, 'ESPIRITA', 180, 'As Valquirias');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (10, 'ROMANCE', 75, 'Cinquenta Tons de Cinza');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (11, 'AVENTURA', 180, 'Alice no Pais das Maravilhas');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (12, 'AVENTURA', 330, 'As Aventuras de Sherlock Holmes');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (13, 'AVENTURA', 130, 'Robin Hood');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (14, 'AVENTURA', 83, 'Diário de Aventuras da Ellie');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (15, 'AVENTURA', 321, 'As Aventuras de Pi');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (16, 'ROMANCE', 263, 'A Cabana');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (17, 'ROMANCE', 193, 'P.S Eu te Amo');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (18, 'ROMANCE', 165, 'Belo Desastre');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (19, 'ROMANCE', 185, 'Toda Sua');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (20, 'ROMANCE', 245, 'Orgulho e Preconceito');
INSERT INTO livro(id, estilo, qtdpaginas, titulo) VALUES (21, 'ROMANCE', 253, 'Cinquenta Tons Mais Escuros');

truncate table livro cascade;
select * from usuario;

select
  *
from
  usuario u
inner join
  usuario_livro ul
  on u.email = ul.usuario_email
inner join
  livro l
  on ul.livros_id = l.id;

select * from usuario_trofel;